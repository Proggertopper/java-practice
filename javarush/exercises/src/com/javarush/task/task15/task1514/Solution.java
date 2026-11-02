package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<>();

    static {
        labels.put(4.0 , "Hello");
        labels.put(5.0 , "hie");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
