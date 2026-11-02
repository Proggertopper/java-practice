package com.javarush.task.pro.task13.task1317;

public class Month1 {
    public static final Month1 JANUARY = new Month1(0);
    public static final Month1 FEBRUARY = new Month1(1);
    public static final Month1 MARCH = new Month1(2);
    public static final Month1 APRIL = new Month1(3);
    public static final Month1 MAY = new Month1(4);
    public static final Month1 JUNE = new Month1(5);
    public static final Month1 JULE = new Month1(6);

    private final int num ;

    private static final Month1[] array = {JANUARY , FEBRUARY , MARCH , MAY};

    public static Month1[] values(){
        return array;
    }

    public  int ordinal(){
        return this.num;
    }
    private Month1(int num){
        this.num = num;
    }

}
