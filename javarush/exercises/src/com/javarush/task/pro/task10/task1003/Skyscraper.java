package com.javarush.task.pro.task10.task1003;

/* 
Построим новый бизнес-комплекс JavaRush Business Center
*/

public class Skyscraper {
    private int floorsCount;
    private String developer;

    Skyscraper( int floorsCount , String developer){
        this.floorsCount = floorsCount;
        this.developer = developer;
    }
    Skyscraper(){
        this.developer = "Pasha";
        this.floorsCount = 50;
    }

    public static void main(String[] args) {
        Skyscraper skyscraper = new Skyscraper();
        Skyscraper skyscraperUnknown = new Skyscraper(50, "Неизвестно");
    }
}
