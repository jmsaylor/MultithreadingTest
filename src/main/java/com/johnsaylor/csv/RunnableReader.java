package com.johnsaylor.csv;

import java.io.*;
import java.util.Queue;

public class RunnableReader implements Runnable{
    private RandomAccessFile randomAccessFile;
    private long start;
    private long end;
    private Queue<String> queue;

    public RunnableReader(RandomAccessFile randomAccessFile, long start, long end, Queue<String> queue) throws FileNotFoundException {
        this.randomAccessFile = randomAccessFile;
        this.start = start;
        this.end = end;
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            randomAccessFile.seek(start);

            while (randomAccessFile.getFilePointer() < end) {
                String newLine = randomAccessFile.readLine();
                System.out.println(newLine);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
