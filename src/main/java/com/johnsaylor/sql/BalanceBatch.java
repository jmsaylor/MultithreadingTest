package com.johnsaylor.sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BalanceBatch {
    private final List<RunnableBatch> threads = new ArrayList<>();
    Queue<String> queue;
    private final int BATCH_SIZE = 20_000;


    public BalanceBatch(int threadCount, Queue<String> queue){
        this.queue = queue;
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
