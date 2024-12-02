package org.lect04_collections.linkList;

public class ListNode {
    private int value;
    private ListNode previous, next;

    public ListNode(int value, ListNode previous, ListNode next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getPrevious() {
        return previous;
    }

    public void setPrevious(ListNode previous) {
        this.previous = previous;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
