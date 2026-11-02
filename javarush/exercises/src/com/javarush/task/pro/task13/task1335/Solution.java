package com.javarush.task.pro.task13.task1335;

/* 
Дорога к выходу
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        printList(clearBoard());
    }

    public static List<Board.Node> clearBoard() {
        Board board = new Board();
        List<Board.Node> list = new ArrayList<>();
        for (int i = 0; i < board.getBoardNodes().size(); i++) {
            if(board.getBoardNodes().get(i).getData().startsWith("snake")){
                board.getBoardNodes().get(i).setData("board");
            }
        }
        return board.getBoardNodes();
    }

    private static void printList(List<?> list) {
        list.forEach(element -> System.out.print(element + " "));
    }
}
