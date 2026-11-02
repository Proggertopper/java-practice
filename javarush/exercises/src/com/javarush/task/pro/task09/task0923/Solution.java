package com.javarush.task.pro.task09.task0923;

/* 
Ранг доступа — Пиратский Капитан
*/

import static com.javarush.task.pro.task09.task0923.CaptainBridge.checkAccess;
import static com.javarush.task.pro.task09.task0923.CaptainBridge.debugAccess;

public class Solution {
    public static void main(String[] args) {
        boolean a = debugAccess("Раб");
        boolean a1 = debugAccess("Гость");
        boolean a2 = debugAccess("Боец");
        boolean a3 = debugAccess("Ветеран");
        boolean a4 = debugAccess("Картографист");
        boolean a5 = debugAccess("Капитан");
        boolean a6 = debugAccess("Стив");
        if(a){
            checkAccess("Раб");
        }
        if(a1){
            checkAccess("Гость");
        }
        if(a2){
            checkAccess("Боец");
        }
        if(a3){
            checkAccess("Ветеран");
        }
        if(a4){
            checkAccess("Картографист");
        }
        if(a5){
            checkAccess("Капитан");
        }
        if(a6){
            checkAccess("Стив");
        }
    }
}
