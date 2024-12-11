package org.lect05_multithreading;

public class MyThread extends Thread{


    @Override
    public void run() {
        System.out.println("Hello from MyThread: " + Thread.currentThread());
    }
}
