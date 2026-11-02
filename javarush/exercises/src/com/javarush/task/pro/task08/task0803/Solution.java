package com.javarush.task.pro.task08.task0803;

import java.util.Scanner;

/* 
Минимальный элемент массива
*/

public class Solution {

    public static void main(String[] args) {
        int[] intArray = getArrayOfTenElements();// 0 1 2 3 4
        System.out.println(min(intArray));
    }

    public static int min(int[] ints) {
        int min = ints[0];
        for(int a : ints){
            min = Math.min(min , a);
        }
        return min;
    }

    public static int[] getArrayOfTenElements() {
        Scanner scanner = new Scanner(System.in);
        int[] data = new int[10];
        for (int i = 0; i < data.length ; i++) {
            data[i] = scanner.nextInt();
        }
        return data;
    }
}
