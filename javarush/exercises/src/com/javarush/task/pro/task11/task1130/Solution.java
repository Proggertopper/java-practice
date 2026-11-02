package com.javarush.task.pro.task11.task1130;

/* 
Робозомби космопорта
*/

public class Solution {

    public static final String[] lyrics = {"Du...", "Du hast...", "Du hast ultra metal"};

    public static void main(String[] args) {

        UltraMetal ultraMetal = new UltraMetal();
        ultraMetal.playUltraMetal(Solution.lyrics[0], Solution.lyrics[1], Solution.lyrics[2]);
    }
}