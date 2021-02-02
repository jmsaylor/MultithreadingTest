package com.johnsaylor.csv;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BatchReader {

    private final RandomAccessFile randomAccessFile;
    private final List<RunnableReader> readers = new ArrayList<>();


    public BatchReader(String sourcePath, Queue<String> destination, int threadCount) throws IOException {
        this.randomAccessFile = new RandomAccessFile(sourcePath, "r");
        List<Long> bounds = FindSplitPoints.find(randomAccessFile, 4);
        for (int i = 0; i < threadCount; i++) {
            this.readers.add(new RunnableReader(randomAccessFile, bounds.get(i), bounds.get(i + 1), destination));
        }
    }

    public void startAll(){
        for (RunnableReader reader : readers) {
            new Thread(reader).start();
        }
    }

}
