package com.javarush.task.pro.task05.task0511;

import java.util.Arrays;
import java.util.Scanner;

/* 
Создаем двумерный массив
*/

public class Solution {
    public static int[][] multiArray;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        multiArray = new int[N][];// 5
        for (int i = 0; i < N; i++) {
            multiArray[i] = new int[scanner.nextInt()];
        }
        System.out.println(Arrays.deepToString(multiArray));
    }
}
