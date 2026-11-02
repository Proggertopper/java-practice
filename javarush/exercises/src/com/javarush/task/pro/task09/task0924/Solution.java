package com.javarush.task.pro.task09.task0924;

/* 
Взлом Стального Стива
*/

import java.util.Arrays;
import java.util.Locale;

public class Solution {

    public static String[][] morals = {{"iAmAKiller", "iAmAThief", "honesty", "responsibility", "iAmABully"},
            {"BuLLyIAmA", "honesty", "iamakiller", "iamathief", "responsibility"},
            {"honesty", "iamabully", "responsibility", "AthiefIAm", "ikillerAmA"},
    };

    public static void main(String[] args) {
        cleanMorals();
        for (String[] strings : morals) {
            System.out.println(Arrays.toString(strings));
        }
    }

    public static void cleanMorals() {
        for (int i = 0; i < morals.length; i++) {
            for (int j = 0; j < morals[i].length; j++) {
                morals[i][j] =  morals[i][j].toLowerCase();
                   morals[i][j] =   morals[i][j].replaceAll("killer", "compassion");
                morals[i][j] =   morals[i][j].replaceAll("thief"  , "fairness");
                morals[i][j] =   morals[i][j].replaceAll("bully"  , "respect");
            }
        }

    }
}