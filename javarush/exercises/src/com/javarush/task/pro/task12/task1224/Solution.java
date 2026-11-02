package com.javarush.task.pro.task12.task1224;

/* 
Подключение к системе
*/

import java.util.Arrays;

public class Solution {
    public final static Planet LULG;

    static {
        LULG = new Planet("Лулг");
        LULG.stations = new Planet.OrbitalStation[]{new Planet.OrbitalStation("Большое Орбитальное Кольцо")};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getConnection(LULG)));
    }

    public static int[] getConnection(Planet planet) {
        int[] result = new int[2];
        int counterGoodAnswers = 0;
        System.out.println(planet.stations.length);
        for (int i = 0; i < planet.stations.length; i++) {
            int numOfInterfaces = planet.stations[i].controlSystem.getInterfacesNumber();
            System.out.println(numOfInterfaces);
            for (int j = 0; j < numOfInterfaces; j++) {
                Boolean answer = planet.stations[i].controlSystem.connect(j);
                if(answer == Boolean.TRUE){
                    result[0] = i;
                    result[1] = j;
                    counterGoodAnswers++;
                }

            }
        }
        System.out.println(counterGoodAnswers);
        if(counterGoodAnswers==0){
            return null;
        }
        return result;
    }
}
