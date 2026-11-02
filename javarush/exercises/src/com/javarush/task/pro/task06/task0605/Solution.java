package com.javarush.task.pro.task06.task0605;

/* 
Правильный порядок
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] array = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        printArray(array);
        reverseArray(array);
        printArray(array);
    }

    public static void reverseArray(int[] array) {
        for (int i = 0; i < array.length/2; i++) {
            int a = array[i];//11 22
            array[i] = array[array.length-1 - i ];//99 22
            array[array.length-1 - i ] = a;// 11
        }
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
