package org.lect03_generic.task02;

public class Orange implements Fruit{
    public static final float WEIGHT = 1.5f;
    @Override
    public float getWeight() {
        return WEIGHT;
    }

    @Override
    public String toString() {
        return "Orange";
    }
}
