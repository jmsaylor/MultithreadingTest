package com.johnsaylor;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        List<List<String>> finalOutput = new ArrayList<>();

        File csv = new File("/home/jm/Code/CareerDevs/BigDataProject/data/PS_20174392719_1491204439457_log.csv");

        long fileLength = csv.length(); //unsure of return value
        System.out.println(fileLength);

        var thing = Files.readAttributes(csv.toPath(), BasicFileAttributes.class);
        System.out.println(thing.size());

        var ranAccess = new RandomAccessFile(csv, "r");

        var buffer = ByteBuffer.allocate(100).array();
        var buffer2 = ByteBuffer.allocate(100).array();


        System.out.println(Arrays.toString(buffer));

        ranAccess.read(buffer, 0, 100);
//        ranAccess.skipBytes(50);
        System.out.println(ranAccess.getFilePointer());
        ranAccess.seek(123383741);
        ranAccess.read(buffer2, 0, 100);

        var string = new String(buffer, StandardCharsets.UTF_8);

        System.out.println(string);

        System.out.println(Arrays.toString(buffer));

        var string2 = new String(buffer2, StandardCharsets.UTF_8);

//        byte newLine = Byte.parseByte(System.lineSeparator());

        System.out.println(string2);
        System.out.println(Arrays.toString(buffer2));
//        var channel = ranAccess.getChannel();

        for (byte b : buffer2) {
            if (b == 10) continue;
            System.out.print((char) b);
        }
        System.out.println();

        var splitPoints = FindSplitPoints.find(ranAccess);

        System.out.println(splitPoints);;

//        System.out.println(newLine);

    }
}
