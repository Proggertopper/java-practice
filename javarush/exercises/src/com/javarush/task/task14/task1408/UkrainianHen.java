package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen{
    @Override
    int getCountOfEggsPerMonth() {
        return 10;
    }

    @Override
    String getDescription() {
        return super.getDescription().concat(" Моя страна - " + Country.UKRAINE + ". Я несу " + this.getCountOfEggsPerMonth()+ " яиц в месяц.");
    }
}
