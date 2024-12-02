package org.lect03_generic.task02;

public class Apple implements Fruit{
    public static final float WEIGHT = 1.0f;
    @Override
    public float getWeight() {
        return WEIGHT;
    }

    @Override
    public String toString() {
        return "Apple";
    }
}
