package com.javarush.task.pro.task09.task0907;

import java.util.regex.Pattern;

/* 
Шестнадцатеричный конвертер
*/

public class Solution {
    private static final String HEX = "0123456789abcdef";

    public static void main(String[] args) {
        int decimalNumber = 1256;
        System.out.println("Десятичное число " + decimalNumber + " равно шестнадцатеричному числу " + toHex(decimalNumber));
        String hexNumber = "4e8";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно десятичному числу " + toDecimal(hexNumber));
    }

    public static String toHex(int decimalNumber) {
        if(decimalNumber <=0){
            return "";
        }
        String numToHex= "";
        while (decimalNumber != 0){
           numToHex = HEX.charAt(decimalNumber%16) + numToHex;
           decimalNumber /=16;
        }
        return numToHex;
    }

    public static int toDecimal(String hexNumber) {
        if(hexNumber == null || hexNumber.isEmpty()){
            return 0;
        }
        int decimalNum = 0;
        char[] array = hexNumber.toCharArray();
        for (int i = 0; i < array.length; i++) {
            decimalNum = 16 * decimalNum + Character.getNumericValue(array[i]);
        }
        return decimalNum;
    }
}
