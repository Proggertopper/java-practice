package com.javarush.task.pro.task08.task0812;

public class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("x=%d, y=%d", x, y);
    }

    public void swap() {
        int total = this.x^this.y;// 001
         int num1 = this.x; // 100
         int num2 = this.y;// 101
         this.x =total ^ num1;
         this.y = total ^ num2;;
    }
}
