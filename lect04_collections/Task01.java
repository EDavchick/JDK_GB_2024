package org.lect04_collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Task01 {
    public static void main(String[] args) {
        Collection<Integer> collection = List.of(1, 2, 3, 4, 5);
        // 1 Iterator
        Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext()){
            System.out.print(STR."\{iterator.next()} ");
        }
        System.out.println();

        // For each
        for (Integer v : collection) {
            System.out.print(v + " ");
        }
        System.out.println();

        // Stream api
        collection.stream()
                .forEach(value -> System.out.print(value + " "));
        System.out.println();
        collection.stream().forEach(System.out::print);
    }
}
