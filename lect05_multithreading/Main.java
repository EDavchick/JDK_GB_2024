package org.lect05_multithreading;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println(Thread.currentThread().getName()); // main

//        for (int i = 0; i < 3; i++) {
//            new MyThread().start();
            /*
            // join упорядочивает потоки
//            MyThread thread = new MyThread();
//            thread.start();
//            thread.join();
             */

//        }

//        for (int i = 0; i < 5; i++) {
//            new Thread(new MyRunnable()).start();
        /*
//            Thread thread = new Thread(new MyRunnable());
//            thread.start();
//            thread.join();
         */
//        }
//
//        for (int i = 0; i < 3; i++) {
//            new Thread(() -> {
//                System.out.println("Hello from 3 thread: " + Thread.currentThread());
//            }).start();
//        }

        Thread tic = new Thread(new TicTac("["));
        Thread tac = new Thread(new TicTac("]"));
//        tic.setDaemon(true);
//        tac.setDaemon(true);
        tic.start();
        tac.start();

//        long start = System.currentTimeMillis();
//        Task2 task2 = new Task2(0);
//        CountDownLatch cdl = new CountDownLatch(3);
//        task2.setCdl(cdl);
//        for (int i = 0; i < 3; i++) {
//            Thread thread = new Thread(task2);
//            thread.start();
////            thread.join();
//        }
//        cdl.await();
//        System.out.println(task2.getValue());
//        long end = System.currentTimeMillis();
//        System.out.println("Time: " + (end - start)); // 22
    }
}
