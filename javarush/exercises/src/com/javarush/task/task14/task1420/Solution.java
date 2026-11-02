package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
НОД
*/
/*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        int num2 = Integer.parseInt(reader.readLine());
        if(num < 0 || num2  < 0){
        return;
        }
        int delimTwo = 0;
        int delimThree = 0;
        while (num !=1 && num2 !=1){// 5000 2500 1250 625
        if(num%2==0){
        num/=2;
        if(num2%2==0){
        num2/=2;
        delimTwo++;
        }
        }
        else if(num2%2==0){
        num2/=2;
        }
        else if(num2%3==0){
        num2/=3;
        if(num%3==0){
        num/=3;
        delimThree++;
        }
        }
        else if(num%3==0){
        num/=3;
        }
        }
        System.out.println(Math.pow(2 , delimTwo) * Math.pow(3 , delimThree));
        // num = 12 num = 36*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(reader.readLine());
        int num2 = Integer.parseInt(reader.readLine());
        int result = Integer.MIN_VALUE;
        int resultNum = 0;
        if(num2>num1){
            while (result!=0){
                result = num2%num1;
                num2 = num1;
                num1 = result;
            }
            resultNum = num2;
        }
        else if(num1>num2){
            while (result!=0){
                result = num1%num2;
                num1 = num2;
                num2 = result;
            }
            resultNum = num1;
        }

        System.out.println(resultNum);
    }
}
