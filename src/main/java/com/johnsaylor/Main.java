package com.johnsaylor;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
//        String path = "/home/jm/Code/CareerDevs/BigDataProject/data/PS_20174392719_1491204439457_log.csv";
//        List<Long> bounds = FindSplitPoints.find(path);
//        System.out.println(bounds);
//        int threads = 8;
//
//        ToSendQueue queue = new ToSendQueue();
//
// Make & Start Threads
//        for (int i = 0; i < threads; i++) {
//            long start = bounds.get(i);
//            long end = bounds.get(i + 1);
//            Reader reader = new Reader(path, new long[]{start, end}, queue);
//            Thread thread = new Thread(reader);
//            thread.start();
//        }
//
//        while (queue.hasNext()) {
//            System.out.println(Arrays.toString(queue.get()));
//        }

        try {
            Connection db = DBConnect.connect();
            if (db == null) {
                System.out.println("DB connection failure");
                System.exit(0);
            } else {
                System.out.println("DB Connected!");
            }

            InsertSQL sql = new InsertSQL(db);

            sql.createTable();


        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error");
            System.out.println(e.getMessage());
            Arrays.stream(e.getStackTrace()).forEach(System.out::println);
        }

    }
}
