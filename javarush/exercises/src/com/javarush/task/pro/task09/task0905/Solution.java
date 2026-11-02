package com.javarush.task.pro.task09.task0905;

import java.util.regex.Pattern;

/* 
Восьмеричный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        //int decimalNumber = 21;
        //System.out.println("Десятичное число " + decimalNumber + " равно восьмеричному числу " + toOctal(decimalNumber));
       // int octalNumber = 25;
        //System.out.println("Восьмеричное число " + octalNumber + " равно десятичному числу " + toDecimal(octalNumber));
        System.out.println(toOctal(21));
    }

    public static int toOctal(int decimalNumber) {//21
        if(decimalNumber <=0){
            return 0;
        }
        int octalNumber = 0;
        int i = 0;
        while (decimalNumber != 0){
            octalNumber = (int) (octalNumber+(decimalNumber%8 ) * Math.pow(10 , i));//13 5 22 5 + 12
            decimalNumber = decimalNumber/8;//3
            i++;
        }
        return octalNumber;
    }

    public static int toDecimal(int octalNumber) {
        if(octalNumber <=0){
            return 0;
        }
        int decimalNumber = 0;
        int i = 0;
        while(octalNumber != 0){
            decimalNumber = (int) (decimalNumber + (octalNumber%10) * Math.pow(8 , i));
            octalNumber = octalNumber/10;
            i++;
        }
        return decimalNumber;
    }
}
