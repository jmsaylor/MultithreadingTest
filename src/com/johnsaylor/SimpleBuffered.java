package com.johnsaylor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SimpleBuffered {

    public static void test() {
        try {
            File csv = new File("/home/jm/Code/CareerDevs/BigDataProject/data/PS_20174392719_1491204439457_log.csv");

            BufferedReader csvReader = new BufferedReader(new FileReader(csv));

            List<String[]> data = new ArrayList<>();

            long count = csvReader.lines().count();

            csvReader.lines().forEach(System.out::println);

            System.out.println(count);

        }catch (Exception e) {
            System.out.println("ERROR");
            System.out.println(e.getLocalizedMessage());
        }
    }
}
