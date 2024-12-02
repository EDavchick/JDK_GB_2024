package org.less03.hw;

import java.lang.reflect.Array;

/*
Напишите обобщенный метод compareArrays(), который принимает два массива
и возвращает true, если они одинаковые, и false в противном случае.
Массивы могут быть любого типа данных, но должны иметь одинаковую длину
и содержать элементы одного типа.
 */
public class AboutArray {
    private Array[] arr1;
    private Array[] arr2;
    static <T, V extends T> boolean compareArrays(T[] x, V[] y) {
        if (x.length != y.length) return false;
        for (int i = 0; i < x.length; i++) {
                if (x[i].getClass().getComponentType() != y[i].getClass().getComponentType() ) {
                    return false;
                }
        }
        return true;
    }
}
