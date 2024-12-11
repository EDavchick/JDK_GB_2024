package org.lect05_multithreading;

import java.util.concurrent.CountDownLatch;

public class Task2 implements Runnable{
    private int value;
    private CountDownLatch cdl;

    public Task2(int left) {
        this.value = left;
    }

//    public synchronized void inc(){
//        value++;
//    }

    public  void inc(){
        synchronized (Task2.class) {
            value++;
        }

    }
//    public void inc(){
//        value++;
//    }

    public int getValue() {
        return value;
    }

    public void setCdl(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            inc();
        }
        cdl.countDown();
    }

    @Override
    public String toString() {
        return String.format("%s", value);
    }
}
