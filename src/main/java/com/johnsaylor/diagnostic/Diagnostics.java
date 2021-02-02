package com.johnsaylor.diagnostic;

import java.util.Queue;

public class Diagnostics implements Runnable {

    private final Queue<String> queue;
    private final Timer timer;
    private boolean isRunning;

    public Diagnostics(Queue<String> queue) {
        this.queue = queue;
        this.timer = new Timer();
        this.isRunning = true;
    }


    @Override
    public void run() {
        while (isRunning) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("--Diagnostics--");
            System.out.println("Elapsed Time: " + timer.getElapsedTime());
            System.out.println("Queue Size: " + queue.size());
        }
    }

    public void stop(){
        isRunning = false;
        System.out.println("--Diagnostics--");
        System.out.println("Elapsed Time: " + timer.getElapsedTime());
        System.out.println("Queue Size: " + queue.size());
        System.out.println("---------------");
    }
}