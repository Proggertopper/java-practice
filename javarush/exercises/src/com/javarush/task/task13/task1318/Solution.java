package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream stream = new FileInputStream(reader.readLine());
        ArrayList<Character> list = new ArrayList<>();
        while (stream.available()>0){
            char data = (char) stream.read();
            list.add(data);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
        reader.close();
        stream.close();
    }
}