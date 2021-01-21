package com.johnsaylor;


import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        String path = "/home/jm/Code/CareerDevs/BigDataProject/data/PS_20174392719_1491204439457_log.csv";
        List<Long> bounds = FindSplitPoints.find(path);
        System.out.println(bounds);
        int threads = 4;

        ToSendQueue queue = new ToSendQueue();

// Make & Start Threads
        for (int i = 0; i < threads; i++) {
            long start = bounds.get(i);
            long end = bounds.get(i + 1);
            Reader reader = new Reader(path, new long[]{start, end}, queue);
            Thread thread = new Thread(reader);
            thread.start();
        }

        while (queue.hasNext()) {
            System.out.println(Arrays.toString(queue.get()));
        }

    }
}
