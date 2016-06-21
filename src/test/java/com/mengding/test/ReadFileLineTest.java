package com.mengding.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Field;
import java.net.URL;

public class ReadFileLineTest {
    
    public static void main(String[] args) {
        fileRead();
//        asd();
    }

    private static void fileRead() {
        URL resource = ReadFileLineTest.class.getResource("/repaymentPlanDetail_20160530.txt");
        File test = new File(resource.getFile());
        long fileLength = test.length();
        LineNumberReader rf = null;
        try {
            rf = new LineNumberReader(new FileReader(test));
            if (rf != null) {
                int lines = 0;
                rf.skip(fileLength);
                lines = rf.getLineNumber();
                rf.close();
                System.out.println(lines);
            }
        } catch (IOException e) {
            if (rf != null) {
                try {
                    rf.close();
                } catch (IOException ee) {
                }
            }
        }
    }

    private static void asd() {
        try (InputStream resourceAsStream = ReadFileLineTest.class.getResourceAsStream("/repaymentPlanDetail_20160530.txt");
                ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();){
            byte[] b = new byte[1024];
            int i = 0;
            while((i = resourceAsStream.read(b)) != -1){
                arrayOutputStream.write(b, 0, i);
            }
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(resourceAsStream));
            lineNumberReader.skip(arrayOutputStream.size());
            System.out.println(lineNumberReader.getLineNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
