package com.johnsaylor.sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BalanceBatch {
    private final List<RunnableBatch> threads = new ArrayList<>();

    private Queue<String> queue = new ConcurrentLinkedQueue<>();
    private final int BATCH_SIZE = 10_000;


    public BalanceBatch(int threadCount){
        for (int i = 0; i < threadCount; i++) {
            threads.add(new RunnableBatch(BATCH_SIZE, queue));
        }
    }

    public void send(String entry) {
        queue.add(entry);
    }

    public void startAll() {
        for (RunnableBatch thread : threads) {
            new Thread(thread).start();
        }
    }

    public void stopAll() {
        for (RunnableBatch thread : threads){
            thread.stop();
        }
    }
}
