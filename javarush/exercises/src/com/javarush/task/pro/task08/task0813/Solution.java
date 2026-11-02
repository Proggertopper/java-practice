package com.javarush.task.pro.task08.task0813;

/* 
Степень двойки
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(getPowerOfTwo(4));// 0b11  0b0010 0b1000
    }

    public static int getPowerOfTwo(int power) {
        //

        //for(int i = 0; i < power - 1; i++) {
         //   result *= 2;
       // }
        return 2 << power-1;
    }
}
