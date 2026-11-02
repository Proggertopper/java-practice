package com.javarush.task.pro.task04.task0412;

import java.util.Scanner;

/* 
Сумма кратных чисел
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);// 1 30 3  1 2 3 4 5 6 7 8 9 10 11 12
        int start = scanner.nextInt();//1
        int end = scanner.nextInt();//30
        int multiple = scanner.nextInt();//3

        int sum = 0;
        for (int i = start; i < end; i++) {
            if(!(i%multiple==0))continue;
            sum+=i;
        }

        System.out.println(sum);
    }
}