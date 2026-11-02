package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        int index = url.indexOf("?");
        int index2 = url.indexOf("=");
        String substringStr = url.substring(index+1 , index2);
        String[] arrayStrings = url.substring(url.indexOf("&") , url.lastIndexOf("=")).split("&");
        System.out.print(substringStr);
        for (String stringEach : arrayStrings){
            System.out.print(stringEach + " ");
        }
        System.out.println();
        if(substringStr.equals("obj")){
            int index3= url.indexOf("=");
            int index4 = url.indexOf("&");
            String string = url.substring(index3+1 , index4);
            try {
                double doubleNum = Double.parseDouble(string);
                alert(doubleNum);
            } catch (Exception e){
                alert(string);
            }


        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
