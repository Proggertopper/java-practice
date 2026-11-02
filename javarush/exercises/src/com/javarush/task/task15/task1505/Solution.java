package com.javarush.task.task15.task1505;

/* 
ООП - исправь ошибки в наследовании
*/

public class Solution {
    public interface HasWeight {
        int getValueWeight();
    }

    public interface HasHeight {
        int getValueHeight();
    }

    public static class Human implements HasWeight, HasHeight {
        @Override
        public int getValueWeight() {
            return 75;
        }

        @Override
        public int getValueHeight() {
            return 185;
        }
    }

    public static void main(String[] args) {
        Human human = new Human();
        System.out.println(human.getValueWeight());
        System.out.println(human.getValueHeight());
    }
}