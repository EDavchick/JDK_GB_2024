package org.less05.task03;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Runner implements Runnable{
    private String name;
    private CountDownLatch ready, start, finish;

    public Runner(String name, CountDownLatch ready, CountDownLatch start, CountDownLatch finish) {
        this.name = name;
        this.ready = ready;
        this.start = start;
        this.finish = finish;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(1000, 3000));
            System.out.println("Participant " + this.name + " on the start");
            ready.countDown();
            start.await();
            System.out.println("Participant " + this.name + " has been run");
            Thread.sleep(new Random().nextInt(3000, 5000));
            System.out.println("Participant " + this.name + " has been finished");
            finish.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
