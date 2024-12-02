package org.lect03_generic.animal;

public class Animal {
    protected String name;

    protected Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return STR."\{this.getClass().getSimpleName()} whit name \{name}";
    }
}
