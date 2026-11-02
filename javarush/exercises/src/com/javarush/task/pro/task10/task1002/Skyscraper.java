package com.javarush.task.pro.task10.task1002;

/* 
Построим новый жилой комплекс JavaRush Towers
*/

public class Skyscraper {
    public static final String SKYSCRAPER_WAS_BUILD = "Небоскреб построен.";
    public static final String SKYSCRAPER_WAS_BUILD_FLOORS_COUNT = "Небоскреб построен. Количество этажей - ";
    public static final String SKYSCRAPER_WAS_BUILD_DEVELOPER = "Небоскреб построен. Застройщик - ";

    Skyscraper(){
        System.out.printf(SKYSCRAPER_WAS_BUILD);
    }
    Skyscraper(int flours){
        System.out.println(SKYSCRAPER_WAS_BUILD_FLOORS_COUNT + flours);
    }
    Skyscraper(String s){
        System.out.println(SKYSCRAPER_WAS_BUILD_DEVELOPER + s);
    }

    public static void main(String[] args) {
        Skyscraper skyscraper = new Skyscraper();
        Skyscraper skyscraperTower = new Skyscraper(50);
        Skyscraper skyscraperSkyline = new Skyscraper("JavaRushDevelopment");
    }
}

