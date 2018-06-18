package com.practice.file_io.sum;


import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * For these to work, make sure you run WriterFile first
 */
public class ReadFile {
    static ArrayBlockingQueue<String> q  = new ArrayBlockingQueue<>(1024);

    private static final String SPACE = " ";
    /**
     * Read numbers from a file and find sum of all.
     *
     * @return
     */
    public static long readFile(String name) {
        long sum = 0;
        try {
            FileReader reader = new FileReader(name);
            BufferedReader reader1 = new BufferedReader(reader);
            while(reader1.ready()) {
                String line = reader1.readLine();
                q.put(line);
                for(String s : q.take().split(SPACE)) {
                    sum += Integer.valueOf(s);
                }
            }
            reader1.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sum;
    }

    /**
     * This is terrible way to do this. One
     * should use multithreading to read all files
     * and create tasks. Can be used to compare.
     * @return
     */
    public static long readFiles(String name) {
        long sum = 0;
        for(int i = 0; i < 20; i++) {
            try {

                FileReader reader = new FileReader("text" + i + ".txt");
                BufferedReader reader1 = new BufferedReader(reader);
                while (reader1.ready()) {
                    String line = reader1.readLine();
                    q.put(line);
                    for(String s : q.take().split(SPACE)) {
                        sum += Integer.valueOf(s);
                    }
                }
                reader1.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return sum;
    }

}
