package com.noah.smarttravel;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class FileHelper {

    public static void appendToFile(Context context, String filename, String text) {
        try {
            FileOutputStream fos = context.openFileOutput(filename, Context.MODE_APPEND);
            fos.write(text.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String readFile(Context context, String filename) {
        try {
            FileInputStream fis = context.openFileInput(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            StringBuilder builder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }

            reader.close();
            return builder.toString();

        } catch (Exception e) {
            return "No history yet.";
        }
    }
}
