package org.less05.task02;

public class ThreadA implements Runnable{
    private volatile Boolean switcher = false;

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                switcher = !switcher;
                System.out.println(switcher);
            } catch (InterruptedException e) {
                System.out.println("Program finished work");
                break;
            }
        }
    }

    public boolean isSwitcher() {
        return switcher;
    }
}
