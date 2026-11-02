package com.javarush.task.pro.task04.task0410;

import java.util.Scanner;

/* 
Второе минимальное число из введенных
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//8 4 7 4 5 9 5
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            if(a < min){
               min2=min;//8
               min=a;//4
            }
            else if(a>min && a<min2){
                min2=a;//7
            }
        }
        System.out.println(min2);
    }
}