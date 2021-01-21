package com.johnsaylor;

import java.util.ArrayDeque;
import java.util.Deque;

public class ToSendQueue {

    private Deque<String[]> queue = new ArrayDeque();

    public synchronized String[] get() {
        return queue.removeFirst();
    }

    public synchronized void add(String[] data) {
        queue.addLast(data);
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

}
