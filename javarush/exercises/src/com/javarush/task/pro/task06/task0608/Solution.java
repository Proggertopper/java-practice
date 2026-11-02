package com.javarush.task.pro.task06.task0608;

/* 
Кубический калькулятор
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(cube(5));
    }

    static long cube(long num){
        return num * num * num;
    }
}
