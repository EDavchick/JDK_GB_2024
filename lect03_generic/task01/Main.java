package org.lect03_generic.task01;

import java.util.Arrays;

/*  Написать метод, который меняет два элемента массива местами
(массив может быть любого ссылочного типа);*/
public class Main {
    public static void main(String[] args) {
        Object[] array = new Object[]{23, "hello", 3.0, "hftye123", 89766540, 567f, "true", 345L};
        System.out.println(Arrays.toString(array));
        swap(array, 3, 4);

//        ArrayChange arrayChange;
//        arrayChange = new ArrayChange<>(array);
    }

    public static <T> void swap(T[] array, int i, int j) {
        // Проверка на null
        if (array == null) {
            throw new NullPointerException("Массив не должен быть null.");
        }
        // Проверка на корректность индексов
        if (i < 0 || j < 0 || i >= array.length || j >= array.length) {
            throw new IndexOutOfBoundsException("Индексы находятся вне диапазона массива.");
        }

        // Обмен элементов местами
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        System.out.println(Arrays.toString(array));
    }
}
