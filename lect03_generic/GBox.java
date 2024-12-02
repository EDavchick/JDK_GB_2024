package org.lect03_generic;

public class GBox<T> {
    private T value;

    public GBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    public void showType() {
        System.out.printf("Type is %s, with value %s\n",
                value.getClass().getName(), getValue());
    }
    public static  <T> void setIfNull(GBox<T> box, T t) {
        if (box.getValue() == null) {
            box.setValue(t);
        }
    }

    public void methodOne() {
//        T data = new T(); // нельзя создавать объект через Т
    }
}
