package com.javarush.task.pro.task09.task0921;

/* 
Пиратский разворот
*/

import java.util.Arrays;

public class NimrodAi {
    
    public static void main(String[] args) {
        PastryLoader[] pastryLoaders = new PastryLoader[]{new PastryLoader(), new PastryLoader(), new PastryLoader()};

        scanMemory(pastryLoaders);
        replaceTarget(pastryLoaders);
        scanMemory(pastryLoaders);
    }

    public static void scanMemory(PastryLoader[] pastryLoaders) {
        System.out.println();
        for (PastryLoader pastryLoader : pastryLoaders) {
            System.out.println(Arrays.deepToString(pastryLoader.memory));
        }
    }

    public static void replaceTarget(PastryLoader[] pastryLoaders) {
        System.out.println();
        for (int i = 0; i < pastryLoaders.length; i++) {
            String tr = Arrays.deepToString(pastryLoaders[i].memory);
            String str = tr.toLowerCase();
            if(str.contains("nimrod")){
                str = str.replaceAll("nimrod" , "pirate ship");
            }
            System.out.println(str);
        }

    }
}
