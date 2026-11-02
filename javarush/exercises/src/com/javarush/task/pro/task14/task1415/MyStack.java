package com.javarush.task.pro.task14.task1415;

import java.util.LinkedList;
import java.util.List;

/* 
Стек в домашних условиях
*/

public class MyStack {

    private final List<String> storage = new LinkedList<>();

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push("Hi");
        stack.push("ПРивет");
        stack.push("Животное");
        System.out.println(stack.pop());
        System.out.println(stack.search("rrr"));
    }

    public void push(String s) {
       storage.add(0 , s);
    }

    public String pop() {
        String str = storage.get(0);
        storage.remove(storage.get(0));
        return str;
    }

    public String peek() {
        return storage.get(0);
    }

    public boolean empty() {
        return storage.isEmpty();
    }

    public int search(String s) {
        return storage.indexOf(s);
    }
}
