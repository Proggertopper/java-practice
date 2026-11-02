package com.javarush.task.pro.task05.task0503;

/* 
Работаем с элементами массива
*/

public class Solution {
   static int n = 100;
    public static int[] array = new int[n];

    public static void main(String[] args) {

        for (int i = 0; i < array.length; i++) {
            if(array[i]%2==0){
                array[i] = -array[i];
            }
        }
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }
}
