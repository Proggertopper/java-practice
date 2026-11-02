package com.javarush.task.pro.task15.task1523;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/* 
Получение информации по API
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://httpbin.org/post");
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);
        try (OutputStream stream = connection.getOutputStream();  PrintStream sender = new PrintStream(stream)) {
            sender.println("Привет");
        }

        try (InputStream stream1 = connection.getInputStream(); BufferedReader reader = new BufferedReader(new InputStreamReader(stream1))) {
            while (reader.ready()){
                System.out.println(reader.readLine());
            }
        }

    }
}

