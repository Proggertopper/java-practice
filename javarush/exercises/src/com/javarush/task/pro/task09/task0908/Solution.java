package com.javarush.task.pro.task09.task0908;

import java.util.HashMap;
import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {

    public static void main(String[] args) {
        //String binaryNumber = "100111010000";
        String binaryNumber = "1001110100000101010101101010110010";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
       // String hexNumber = "9d0";
        //System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        if(binaryNumber == null || binaryNumber.isEmpty()){
            return null;
        }
        HashMap<Integer , String> map = new HashMap<>();
        map.put(9 ,"1001" );
        System.out.println(binaryNumber.length());
        String s =  binaryNumber;
        String xehNum = "";
        int i = binaryNumber.length();
        if(!(binaryNumber.contains("0") || binaryNumber.contains("1"))){
            return "";
        }
        while (!(i%4==0)){
            s = "0" + s ;
            i++;
        }
        System.out.println(s.length());
        int counterFourth = (s.length())/4;
        for (int j = 0; j <counterFourth ; j++) {
            String temp = s.substring(j * 4, j * 4 + 4 );
            if(temp.equals("1001")){
                xehNum = xehNum.concat(map.get(9));
            }

        }



        return xehNum;
    }

    public static String toBinary(String hexNumber) {

        return null;
    }
}
