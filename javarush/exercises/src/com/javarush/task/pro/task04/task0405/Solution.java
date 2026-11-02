package com.javarush.task.pro.task04.task0405;

/* 
Незаполненный прямоугольник
*/

public class Solution {
    public static void main(String[] args) {
        int height=0;
        while (height<10){
            int width=0;
            while (width<20){
                if(height>=1 && height<9 && width>0 && width<19){
                    System.out.print(" ");
                }
                else {
                    System.out.print("Б");
                }
                width++;
            }
            System.out.println();
            height++;
        }
    }
}
