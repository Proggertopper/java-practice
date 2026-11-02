package com.javarush.task.pro.task16.task1612;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/* 
Синтезируем LocalDateTime
*/

public class Solution {

    public static void main(String[] args) {
        Map<LocalDate, List<LocalTime>> dateMap = DateTimeGenerator.generateDateMap();
        printCollection(dateMap.entrySet());
        /*for (LocalDate key : sourceMap.keySet()) {
            for (List<LocalTime> time : sourceMap.values()) {
                for (LocalTime time1 : time){
                    sourceMap.get(key)
                }
            }
        }*/

        Set<LocalDateTime> dateSet = convert(dateMap);
        printCollection(dateSet);
    }

    static Set<LocalDateTime> convert(Map<LocalDate, List<LocalTime>> sourceMap) {
        Set<LocalDateTime> localDateTimes = new HashSet<>(sourceMap.size());
        for(LocalDate key : sourceMap.keySet()){
            List<LocalTime> localTimes = sourceMap.get(key);
            for (int i = 0; i < localTimes.size(); i++) {
                localDateTimes.add(LocalDateTime.of(key , localTimes.get(i)));
            }
        }
        return localDateTimes;
    }


    static void printCollection(Collection<?> collection) {
        System.out.println("-----------------------------------------------------");
        collection.forEach(System.out::println);
    }
}