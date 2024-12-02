package org.lect03_generic;

public class Box {
    private Object object;

    public Box(Object object) {
        this.object = object;
    }

    public Object getObject() {return object;}
    public void setObject(Object o) {this.object = o;}
    public void printInfo() {
        System.out.printf("Box (%s): %s", object.getClass().getSimpleName(), object.toString());
    }
}
