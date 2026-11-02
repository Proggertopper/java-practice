package com.javarush.task.pro.task08.task0818;

/* 
Путь через аномалию
*/

import java.util.Arrays;

public class Solution {
//Math.sin(10) * Math.PI + Math.cos(11) * Math.min(11 , Math.min(12 , 13))+ Math.tan(12)/Math.log(12);
    public static int[][] anomalySpace = new int[][]{
            {383, 961, 904}, {769, 887, 770}, {184, 608, 406}, {310, 821, 445}, {412, 908, 158},
            {562, 844, 573}, {260, 880, 230}, {635, 254, 756}, {816, 754, 508}, {947, 195, 379},
            {576, 678, 682}, {207, 653, 588}, {901, 315, 223}, {310, 561, 255}, {199, 356, 350},
            {971, 276, 974}, {413, 829, 494}, {344, 345, 322}, {889, 713, 222}, {628, 963, 234},
            {254, 428, 926}, {633, 762, 848}, {896, 130, 653}, {971, 636, 861}, {328, 976, 139}};

    public static double[] safeRoute = new double[100];

    public static void main(String[] args) {
        double coordinates ;
        int i2 = 0;
        for (int i = 0; i < anomalySpace.length; i++) {
            for (int j = 2; j < anomalySpace[0].length; j++) {
                coordinates = Math.sin(anomalySpace[i][j-2]) * Math.PI + Math.cos(anomalySpace[i][j-1]) * Math.min(anomalySpace[i][j-2] , Math.min(anomalySpace[i][j-1] , anomalySpace[i][j]))+ Math.tan(anomalySpace[i][j-1])/Math.log(anomalySpace[i][j]);
                if(coordinates>=100 && coordinates<=200){
                        safeRoute[i2] = coordinates;
                        i2++;
                }
            }
        }
        for(Double d : safeRoute){
            System.out.println(d);
        }

    }
}
