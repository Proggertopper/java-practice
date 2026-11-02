package com.javarush.task.pro.task05.task0508;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Удаляем одинаковые строки
*/

public class Solution {

    public static String[] strings = {"Hello" , "Hello" , "Hello" , "Tasks" , "World" , "ret"};// null null Hello

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /* strings = new String[6];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = scanner.nextLine();
        }*/
        for (int i = 0; i < strings.length; i++) {
            String currentString = strings[i];
            for (int j = i+1; j < 6; j++) {
                if(currentString == null){
                    break;
                }
                if (currentString.equals(strings[j])) {
                    strings[j] = null;
                    strings[i] = null;
                }
            }
        }
        for (String s : strings){
            System.out.println(s);
        }
    }
}


