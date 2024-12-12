package org.less05.ex3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Runner extends Thread{
    private String name;
    private double speed;
    private Random random;
    private CountDownLatch cdl;

    public Runner(String name, CountDownLatch cdl) {
        this.name = name;
        this.cdl = cdl;
        random = new Random();
        speed = random.nextDouble(2, 7);
    }

    @Override
    public void run() {
        try {
            goOnStart();
            synchronized (this){
                wait();
            }
            goOnFinish();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void goOnStart() throws InterruptedException{
        System.out.println(name + " go to the start");
        sleep(random.nextInt(2, 5) * 1000L);
        System.out.println(name + " came to the start");
        cdl.countDown();
    }
    private void goOnFinish() throws InterruptedException{
        sleep((long) (speed * 1000));
        System.out.println(name + " run up to the finish");
    }

    public void go(){
        synchronized (this){
            notify();
        }
    }
}
