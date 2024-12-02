package org.lect03_generic;

public class BBox <V extends Number>{
    private V value;

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
    public static <T extends Number> void setIfNullBbox(BBox<T> box, T t) {
        if (box.getValue() == null) {
            box.setValue(t);
        }
    }
    public static <T extends  Number> boolean compare(T src, T dst) {
        return src.equals(dst);
    }
}
