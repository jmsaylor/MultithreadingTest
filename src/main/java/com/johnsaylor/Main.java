package com.johnsaylor;


import com.johnsaylor.csv.FindSplitPoints;
import com.johnsaylor.csv.Reader;
import com.johnsaylor.sql.BalanceBatch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        String path = "/home/jm/Code/CareerDevs/BigDataProject/data/PS_20174392719_1491204439457_log.csv";

        BalanceBatch balance = new BalanceBatch(10);

        balance.startAll();

        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(balance::send);
        } catch (Exception e) {
            e.printStackTrace();
        }

        balance.stopAll();
    }
}
