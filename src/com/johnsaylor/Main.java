package com.johnsaylor;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Counter counter1 = new Counter(5);
        Counter counter2 = new Counter(150);
        Counter counter3 = new Counter(75);

        Thread t1 = new Thread(counter1);
        Thread t2 = new Thread(counter2);
        Thread t3 = new Thread(counter3);

        try {
            t1.start();
            Thread.sleep(100);
            t2.start();
            Thread.sleep(100);
            t3.start();
            Thread.sleep(100);

        } catch (Exception ignored){}
    }
}
