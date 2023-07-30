package org.example.logic;

public class Counter {

    private int value;

    public Counter() {
    }



    public int getValue() {
        return value;
    }

    public synchronized void increment() {
        this.value = value + 1;
    }
}
