package org.less05.hw;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class  Philosopher extends Thread{
    private String name;
    private int leftFork;
    private int rightFork;
    private int countEat;
    private Random random;
    private CountDownLatch cdl;
    private Table table;

    public Philosopher(String name, Table table, int leftFork, int rightFork, CountDownLatch cdl) {
        this.table = table;
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.cdl = cdl;
        countEat = 0;
        random = new Random();
    }

    @Override
    public void run() {
        while (countEat < 3){
            try {
                thinking();
                eating();
            } catch (InterruptedException e){
                e.fillInStackTrace();
            }
        }
        System.out.println(name + " eaten enough");
        cdl.countDown();
    }
    private void eating() throws InterruptedException{
        if (table.tryGetForks(leftFork, rightFork)) {
            System.out.println(name + " eats pasta using forks: " +
                    leftFork + " and " + rightFork);
            sleep(random.nextLong(3000, 6000));
            table.putForks(leftFork, rightFork);
            System.out.println(name + " eaten and can tinking " +
                    "but first of all gave forks back " +
                    leftFork + " and " + rightFork);
            countEat++;
        }
    }

    private void thinking() throws InterruptedException{
        sleep(random.nextLong(100, 2000));
    }
}
