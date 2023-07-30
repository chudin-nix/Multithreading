package org.example;

import org.example.logic.Counter;
import org.example.logic.CounterIncrementer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    public static final int INCREMENTER_NUMBER = 10;
    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(INCREMENTER_NUMBER);
        Counter counter = new Counter();
        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Thread thread = new Thread(new CounterIncrementer(counter));
            threads.add(thread);
            thread.start();
        }
        for (Thread thread: threads) {
            thread.join();
        }
//        IntStream.range(0, 10)
//                .mapToObj(thread -> new Thread(new CounterIncrementer(counter)))
//                .forEach(s -> executorService.submit(s));

        System.out.println(counter.getValue());
    }
}