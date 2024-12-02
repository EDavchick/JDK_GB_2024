package org.lect03_generic.task01;

public class ArrayChange<T extends Object> {
    private ArrayChange[] arr;

    public ArrayChange(ArrayChange[] arr) {
        this.arr = arr;
    }

    public ArrayChange[] getArr() {
        return arr;
    }

    public void setArr(ArrayChange[] arr) {
        this.arr = arr;
    }

    public static <T> void swap(T[] arr, int i, int j) {
        if (arr == null || i < 0 || j < 0 || i >= arr.length || j >= arr.length) {
            throw new IllegalArgumentException("Array out of bound");
        }
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
