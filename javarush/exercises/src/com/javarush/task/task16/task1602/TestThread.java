package com.javarush.task.task16.task1602;

public class TestThread extends Thread {

    static {
        System.out.println("it is static block inside TestThread");
    }
    @Override
    public void run() {
        System.out.println("int 10");
    }
}
