package org.example.logic;

public class CounterIncrementer implements Runnable {
    private final Counter counter;

    public CounterIncrementer(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.increment();
    }
}
