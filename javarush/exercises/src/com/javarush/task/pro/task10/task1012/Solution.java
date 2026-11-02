package com.javarush.task.pro.task10.task1012;

import java.util.Arrays;

/* 
Дефрагментация памяти
*/

public class Solution {

    public static void main(String[] args) {
        String[] memory = {"object15", null, null, "object2", null, null, null, "object32", null, "object4"};//
        executeDefragmentation(memory);
        System.out.println(Arrays.toString(memory));
    }

    public static void executeDefragmentation(String[] array) {
        int iterator = 0;
        int iteratorTwo = 1;
        while (iterator<array.length && iteratorTwo<array.length ){
            String s = array[iteratorTwo];
            String s1 = array[iterator];
            if (s1 == null) {
                array[iteratorTwo ] = array[iterator];
                array[iterator] = s;
                iteratorTwo++;
            }
            else
                iterator++;
        }
    }
}
