package com.johnsaylor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Reader implements Runnable{

    private BufferedReader reader;

    public Reader(String source, List<List<String>> destination) throws FileNotFoundException {
        File csvFile = new File(source);

    }

    @Override
    public void run() {

    }
}
