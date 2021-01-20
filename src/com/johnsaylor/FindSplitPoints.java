package com.johnsaylor;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class FindSplitPoints {

    public static List<Long> find(RandomAccessFile file) throws IOException {
        List<Long> result = new ArrayList<>();
        //first start point
        result.add(0L);

        long chunkSize = file.length() / 4;

        // 10 is a newline
        file.seek(chunkSize);
        while (file.readByte() != 10) { }
        result.add(file.getFilePointer());


        file.seek(chunkSize * 2);
        while (file.readByte() != 10) { }
        result.add(file.getFilePointer());

        file.seek(chunkSize * 3);
        while (file.readByte() != 10) { }
        result.add(file.getFilePointer());

        return result;

    }

}
