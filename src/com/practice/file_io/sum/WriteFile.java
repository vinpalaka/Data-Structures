package com.practice.file_io.sum;

import java.io.*;

public class WriteFile {

    /**
     * Makes 10 files with million digits each
     */
    public static void writeToFile() {
        for(int i = 0; i < 20; i++) {
            try {
                FileWriter outputStream = new FileWriter("text" + i + ".txt");

                BufferedWriter writer = new BufferedWriter(outputStream);
                for(int j = 0; j < 10000000; j++) {
                    writer.write("" + j + " ");
                }
                writer.close();
                outputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
