package org.lect03_generic;

/* Целевой тип выражения – это тип данных, который компилятор Java
ожидает в зависимости от того, в каком месте находится выражение.*/
public class TBox<T> {
    public static final TBox EMPTY_BOX = new TBox<>();
    private T value;
    public T getValue() {return value;}
    public void setValue(T value) {
        this.value = value;
    }
    static <T> TBox<T> emptyBox() {
        return (TBox<T>) EMPTY_BOX;
    }
}
