package org.less05.task03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* 3 бегуна должны прийти к старту гонки.
Программа должна гарантировать, что гонка начнется только когда все
три участника будут на старте.
Программа должна отсчитать “На старт”, “Внимание”, “Марш”.
Программа должна завершиться когда все участники закончат гонку.
Подумайте об использовании примитива синхронизации
 */
public class Program {
    private static final int COUNT_RUNNERS = 3;

    public static void main(String[] args) {
        CountDownLatch ready = new CountDownLatch(COUNT_RUNNERS);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch finish = new CountDownLatch(COUNT_RUNNERS);

        List<Runner> runners = new ArrayList<>(Arrays.asList(
                new Runner("Vasya", ready, start, finish),
                new Runner("Kolya", ready, start, finish),
                new Runner("Masha", ready, start, finish)
        ));

        new Thread(new Race(ready, start, finish)).start();
        for (Runner runner : runners) {
            new Thread(runner).start();
        }
    }
}
