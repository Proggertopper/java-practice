package com.javarush.task.pro.task15.task1504;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            InputStream stream = Files.newInputStream(Path.of(bufferedReader.readLine()));
            OutputStream stream1 = Files.newOutputStream(Path.of(bufferedReader.readLine()));
           byte[] bytes = stream.readAllBytes();
           byte[] bytes1 = new byte[bytes.length];
           byte v = bytes[bytes.length-1];
            while (stream.available() > 0){
                for (int i = 1; i < bytes.length; i+=2) {
                    byte b = bytes[i-1];
                    bytes[i-1] = bytes[i];
                    bytes[i] = b;
                    if(!(bytes[bytes.length -1]%2==0)){
                        bytes[bytes.length - 1] = v ;
                    }
                }
            }
            stream1.write(bytes);
            stream1.close();
            stream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

