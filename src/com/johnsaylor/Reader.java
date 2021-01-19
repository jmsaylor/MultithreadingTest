package com.johnsaylor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Reader implements Runnable{

    private BufferedReader reader;
    private List<List<String>> destination;

    public Reader(String source, List<List<String>> destination) throws FileNotFoundException {
        File csvFile = new File(source);
        this.reader = new BufferedReader(new FileReader(csvFile));
        this.destination = destination;
    }

    @Override
    public void run() {

    }
}
