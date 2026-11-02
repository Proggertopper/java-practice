package com.javarush.task.pro.task05.task0524;

/* 
Взлом Кибердракона
*/

public class Solution {
    public static int[] coordinates;

    public static void main(String[] args) {
        coordinates = new int[200];
        //coordinates[0] = 0;
        //coordinates[1] = 1;
        //coordinates[2] = 10;
       // coordinates[3] = 11;
        //coordinates[4] = 20;
        int j =5;
        int y = 8;
        int t = 1;
        for (int i = 0; i < coordinates.length; i++) {
                if(i%2==0 && i !=0){
                    coordinates[i] = j * i;
                }
                else if(i!=0 && i!=1) {
                    coordinates[i] = i + (y*t);
                    t++;
                }
                else
                    coordinates[i] = i;// i = 3 i = 5 i = 7 8 16 24
        }
        for (int num : coordinates){
            System.out.println(num);
        }
    }
}