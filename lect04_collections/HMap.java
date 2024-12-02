package org.lect04_collections;

import org.lect04_collections.linkList.LinkList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

public class HMap {
    private int capacity;
    private ArrayList<LinkedList<Integer>> map;

    public HMap() {
        capacity = 100;
        map = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            map.add(new LinkedList<>());
        }
    }

    // _ _ _ _ _ _ _ _ _ _
    public void put(Integer key, Integer value){
        int code = key.hashCode() % capacity; // вычисляем корзину куда добавить
        LinkedList<Integer> list = map.get(code);
        if (!list.contains(value)) {
            list.add(value);
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("Hello", 1, "World", 2);
        // вывод по entrySet
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // вывод по keySet()
        for (String s : map.keySet()) {
            System.out.println(s + ": " + map.get(s));
        }
        // Stream api
        map.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
