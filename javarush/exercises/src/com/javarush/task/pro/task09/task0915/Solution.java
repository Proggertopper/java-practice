package com.javarush.task.pro.task09.task0915;

import java.util.Arrays;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {
        String packagePath = "java.util.stream";
        String[] tokens = getTokens(packagePath, ".");
        System.out.println(Arrays.toString(tokens));
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query , delimiter);
        int iterator = 0;
        String[] stringsDelim = new String[tokenizer.countTokens()];
        while (tokenizer.hasMoreTokens()){
              String token = tokenizer.nextToken();
              stringsDelim[iterator] = token;
              iterator++;
        }
        return stringsDelim;
    }
}
