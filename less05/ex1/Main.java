package org.less05.ex1;
/* Solution the teacher
В рамках выполнения задачи необходимо:
Создать два класс ObjectA, ObjectB
Реализовать класс в котором два потока при запуске провоцируют
DeadLock для объектов ObjectA, ObjectB
 */
public class Main {
    public static void main(String[] args) {
        Friend friend1 = new Friend("Vasya");
        Friend friend2 = new Friend("Kolya");

        MyThread thread1 = new MyThread(friend1, friend2);;
        MyThread thread2 = new MyThread(friend2, friend1);

        thread1.start();
        thread2.start();

        System.out.println("End of work");
    }
}
