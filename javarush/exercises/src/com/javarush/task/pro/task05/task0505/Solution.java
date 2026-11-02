package com.javarush.task.pro.task05.task0505;

import java.util.Scanner;

/* 
Reverse
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        if(N>0){
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            if(N%2==0){
                for (int i = 0; i < arr.length; i++) {
                    System.out.println(arr[i]);
                }
            }
            else
                for (int i = arr.length-1; i>=0; i--) {
                    System.out.println(arr[i]);
                }
        }

    }
}
