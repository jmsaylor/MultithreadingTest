package com.johnsaylor;

public class Counter implements Runnable {

    int factor;

    public Counter(int factor) {
        this.factor =factor;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i * factor);
            try { Thread.sleep(400); } catch (InterruptedException ignored) { }
        }
    }
}
