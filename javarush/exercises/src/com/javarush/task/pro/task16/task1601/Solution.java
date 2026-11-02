package com.javarush.task.pro.task16.task1601;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* 
Лишь бы не в понедельник :)
*/

public class Solution {

    static Date birthDate = new Date(2025 , 8 , 28);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        String dateDayToRussian = "";
        switch (date.getDay()) {
            case 0 -> {
                dateDayToRussian = "Понедельник";
            }
            case 1 -> {
                dateDayToRussian = "Вторник";
            }
            case 2 -> {
                dateDayToRussian = "Среда";
            }
            case 3 -> {
                dateDayToRussian = "Четверг";
            }
            case 4 -> {
                dateDayToRussian = "Пятница";
            }
            case 5 -> {
                dateDayToRussian = "Суббота";
            }
            case 6 -> {
                dateDayToRussian = "Воскресенье";
            }
        }
        return dateDayToRussian;
    }
}
