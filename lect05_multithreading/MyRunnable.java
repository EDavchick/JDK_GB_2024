package org.lect05_multithreading;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello from MyRunnable " + Thread.currentThread());
    }
}
