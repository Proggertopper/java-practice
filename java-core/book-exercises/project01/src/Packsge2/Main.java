package Packsge2;

import MyPackage.Box;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
import MyPackage.BoxWeight;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       //Box box = new Box(10 , 15 , 12);
       BoxWeight boxWeight = new BoxWeight(12 , 15 , 12 , 15);
       double vol ;
       Box box1;
       box1 = boxWeight;
       //vol = box.volume();
       // System.out.println("Объем box равен " + vol);
        vol = box1.volume();
        System.out.println("Объем box2 равен " + vol + " вес - " + boxWeight.weight);
        box1.show();
    }
}