package com.javarush.task.pro.task08.task0824;

/* 
Парадокс Диего
*/

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Diego[] diegos = new Diego[99];
        for (int i = 0; i < diegos.length; i++) {
            diegos[i] = new Diego();
        }

        System.out.print(diegos[0].hashSum + " ^ ");
        Nimrod[] nimrods = dealWithDuplicates(diegos);
        System.out.println(nimrods[0].password + " = " + diegos[0].hashSum);
    }

    public static Nimrod[] dealWithDuplicates(Diego[] diegos) {
        int password2 = 10;
        for (int i = 0; i < diegos.length; i++) {
            diegos[i].hashSum ^= password2;
        }

        Nimrod[]nimrods = new Nimrod[diegos.length];
        for (int i = 0; i < nimrods.length; i++) {
            nimrods[i] = new Nimrod();
            nimrods[i].password = password2;
        }

        return nimrods;
    }
}
