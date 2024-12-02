package org.lect03_generic.task01;

import java.util.Arrays;

public class ArrayUtils {
    // Обобщенный метод для обмена двух элементов в массиве
    public static <T> void swap(T[] array, int i, int j) {
        // Проверка на null
        if (array == null) {
            throw new NullPointerException("Массив не должен быть null.");
        }
        // и корректность индексов
        if (i < 0 || j < 0 || i >= array.length || j >= array.length) {
            throw new IndexOutOfBoundsException("Индексы находятся вне диапазона массива.");
        }

        // Обмен элементов местами
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        // Пример использования с массивом строк
        String[] stringArray = {"apple", "banana", "cherry"};
        System.out.println("До обмена: " + Arrays.toString(stringArray));
        swap(stringArray, 0, 2);
        System.out.println("После обмена: " + Arrays.toString(stringArray));

        // Пример использования с массивом целых чисел
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("До обмена: " + Arrays.toString(intArray));
        swap(intArray, 1, 3);
        System.out.println("После обмена: " + Arrays.toString(intArray));
    }
}
