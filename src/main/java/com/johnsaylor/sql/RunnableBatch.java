package com.johnsaylor.sql;

import java.sql.SQLException;
import java.util.Queue;

public class RunnableBatch implements Runnable{

    private boolean started = true;
    private final Queue<String> queue;
    private final int batchLimit;

    public RunnableBatch(int batchLimit, Queue<String> queue) {
        this.batchLimit = batchLimit;
        this.queue = queue;
    }

    @Override
    public void run() {
        try (BatchInsert batchInsert = new BatchInsert(batchLimit)) {
            while (!queue.isEmpty() || started) {
                String entry = queue.poll();
                if (entry == null) {
                    //TODO: research busy/wait options
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted");
                    }
                } else {
                    batchInsert.insert(entry);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop(){
        started = false;
    }
}
