package com.johnsaylor;


import com.johnsaylor.diagnostic.Diagnostics;
import com.johnsaylor.sql.BalanceBatch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        String path = "/home/jm/Code/CareerDevs/BigDataProject/data/PS_20174392719_1491204439457_log.csv";
        Queue<String> queue = new ConcurrentLinkedQueue<>();

        var diagnostics = new Diagnostics(queue);

        BalanceBatch balance = new BalanceBatch(4, queue);

        new Thread(diagnostics).start();

        balance.startAll();

        try (var lines = Files.lines(Path.of(path))) {
            lines.forEach(balance::send);
        } catch (Exception e) {
            e.printStackTrace();
        }

        balance.stopAll();
        diagnostics.stop();
    }
}
