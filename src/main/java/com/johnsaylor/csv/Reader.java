package com.johnsaylor.csv;

import java.io.*;

public class Reader implements Runnable{
//    BufferedReader reader = new BufferedReader();
    RandomAccessFile randomAccessFile;
    long start;
    long end;

    public Reader(String source, long[] params) throws FileNotFoundException {
        this.randomAccessFile = new RandomAccessFile(source, "r");
        this.start = params[0];
        this.end = params[1];
    }

    @Override
    public void run() {
        try {
            randomAccessFile.seek(start);

            while (randomAccessFile.getFilePointer() != end) {
                String newLine = randomAccessFile.readLine();
                System.out.println(newLine);
//                destination.add(newLine.split(",")); //separate concern
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
