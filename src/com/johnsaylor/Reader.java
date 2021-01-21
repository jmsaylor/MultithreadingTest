package com.johnsaylor;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

public class Reader implements Runnable{
//    BufferedReader reader = new BufferedReader();
    RandomAccessFile randomAccessFile;
    ToSendQueue destination;
    long start;
    long end;

    public Reader(String source, long[] params, ToSendQueue destination) throws FileNotFoundException {
        this.randomAccessFile = new RandomAccessFile(source, "r");
        this.destination = destination;
        this.start = params[0];
        this.end = params[1];
    }

    @Override
    public void run() {
        try {
            randomAccessFile.seek(start);

            while (randomAccessFile.getFilePointer() != end) {
                String newLine = randomAccessFile.readLine();
                destination.add(newLine.split(",")); //separate concern
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
