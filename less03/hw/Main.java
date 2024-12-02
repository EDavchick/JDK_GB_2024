package org.less03.hw;

import static org.less03.hw.AboutArray.compareArrays;

public class Main {
    public static void main(String[] args) {
        // Task 01
        System.out.println(Calculator.sum(3, 6.0));
//        System.out.println(Calculator.divide(4.23, 0)); // На ноль делить нельзя
        System.out.println(Calculator.multiply(5, 6f));
        System.out.println(Calculator.subtract(100L, 13.13));

        // Task 02
        Integer[] intArray1 = {1, 2, 3, 4, 5};
        Integer[] intArray2 = {1, 2, 3, 4, 5};
        boolean result1 = compareArrays(intArray1, intArray2);
        System.out.println("Результат для целочисленных массивов: " + result1);

        String[] stringArray1 = {"Hello", "World"};
        String[] stringArray2 = {"Hello", "World"};
        boolean result2 = compareArrays(stringArray1, stringArray2);
        System.out.println("Результат для строковых массивов: " + result2);

        Double[] doubleArray1 = {1.5, 2.4, 3.7, 4.9, 5.5};
        Double[] doubleArray2 = {1.5, 2.4, 3.7};
        boolean result3 = compareArrays(doubleArray1, doubleArray2);
        System.out.println("Результат если массивы разной длинны: " + result3);

        Float[] floatArray1 = {1.5f, 2.4f, 3.7f, 4.9f, 5.5f};
        Float[] floatArray2 = {1.5f, 2.4f, 3.7f, 4.9f, 3.3f};
        boolean result4 = compareArrays(floatArray1, floatArray2);
        System.out.println("Результат если массивы не одинаковые: " + result4);

        // Task 03
        Pair<Integer, Integer> x = new Pair<Integer, Integer>(1, 2);
        Pair<Number, Integer> y = new Pair<Number, Integer>(10.4, 12);
        Pair<String, Integer> z = new Pair<String, Integer>("hello", 45);
        System.out.println(x.getSecond());
        System.out.println(y.getFirst());
        System.out.println(z.getFirst());
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }
}
