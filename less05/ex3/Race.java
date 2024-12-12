package org.less05.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Race extends Thread{
    private List<Runner> runners;
    private CountDownLatch cdl;

    public Race() {
        cdl = new CountDownLatch(3);

        runners = new ArrayList<>(3);
        runners.add(new Runner("Kolya", cdl));
        runners.add(new Runner("Petya", cdl));
        runners.add(new Runner("Vasya", cdl));
    }

    @Override
    public void run() {
        try {
            goOnStart();
            cdl.await();
            goAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void goAll() throws InterruptedException{
        sleep(1000);
        System.out.println("Ready!");
        sleep(1000);
        System.out.println("Steady!");
        sleep(1000);
        System.out.println("Goooo!");
        for (Runner runner : runners) {
            runner.go();
        }
    }

    private void goOnStart(){
        for (Runner runner : runners) {
            runner.start();
        }
    }
}
