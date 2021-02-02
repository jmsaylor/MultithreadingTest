package com.johnsaylor.csv;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class FindSplitPoints {

    public static List<Long> find(RandomAccessFile randomAccessFile, int count) throws IOException {
        List<Long> result = new ArrayList<>();
        RandomAccessFile file = randomAccessFile;

        result.add(0L);

        int threads = count;

        //TODO better error handling
        long chunkSize = file.length() / threads;

        // 10 is a newline
        for (int i = 1; i < threads; i++) {
            file.seek(chunkSize * i);
            while (file.readByte() != 10) { }
            result.add(file.getFilePointer());
        }

        result.add(file.length());

        return result;

    }

}
