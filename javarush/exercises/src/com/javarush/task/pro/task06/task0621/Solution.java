package com.javarush.task.pro.task06.task0621;

/* 
Что происходит?
*/

public class Solution {
    protected static String demons;
    public static void main(String[] args) {
         demons = "демоны";
        if ("демоны".equals(demons)) {
            System.out.println("На друзей напали демоны.");
        }
        changeDemons();
        if ("погрузочные машины".equals(demons)) {
            System.out.println("Друзья превратили демонов в погрузочные машины.");
        }
    }

    public static void changeDemons() {
        demons = "погрузочные машины";
    }
}
