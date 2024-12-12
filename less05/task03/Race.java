package org.less05.task03;

import java.util.concurrent.CountDownLatch;

public class Race implements Runnable{
    private CountDownLatch ready, start, finish;

    public Race(CountDownLatch ready, CountDownLatch start, CountDownLatch finish) {
        this.ready = ready;
        this.start = start;
        this.finish = finish;
    }

    @Override
    public void run() {
        try {
            ready.await();
            System.out.println("Ready!");
            Thread.sleep(100);
            System.out.println("Steady!");
            Thread.sleep(100);
            System.out.println("Go!");
            start.countDown();
            finish.await();
            System.out.println("Finish!!!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
