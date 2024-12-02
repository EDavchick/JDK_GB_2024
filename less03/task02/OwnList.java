package org.less03.task02;

import java.util.Arrays;
import java.util.NoSuchElementException;

/*
Описать собственную коллекцию – список на основе массива. Коллекция должна иметь возможность
хранить любые типы данных, иметь методы добавления и удаления элементов.
 */
public class OwnList<T> {
    private Object [] array;
    private int size;

    public OwnList(int length) {
        this.array = new Object[length];
    }

    public void addElement(T el){
        if (size >= array.length) {
            Object [] newArr = Arrays.copyOf(array, array.length * 2);
        }
        array[size++] = el;
    }
    public void deleteElement(T el){
        if (size == 0) throw new NoSuchElementException();
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(el)) {
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                break;
            }
        }
    }
}
