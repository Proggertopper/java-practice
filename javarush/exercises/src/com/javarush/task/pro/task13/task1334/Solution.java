package com.javarush.task.pro.task13.task1334;

/* 
Антипирамида
*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    static Map<Voter, Map<String, String>> corporatePyramid = new HashMap<>();

    public static void main(String[] args) {
        setRewards();
        printMap(corporatePyramid);
    }

    public static void setRewards() {
        Rewards rewards = new Rewards();;
        for (int i = 0; i < Voter.generateVoters().size() ; i++) {
            if(Voter.generateVoters().get(i).getPersonalQuality().equals("Good")){
                corporatePyramid.put(Voter.generateVoters().get(i), rewards.getGoodRewardsMap() );
            }
            else if(Voter.generateVoters().get(i).getPersonalQuality().equals("Holy")){
                corporatePyramid.put(Voter.generateVoters().get(i), rewards.getHolyRewardsMap() );
            }
        }

    }

    public static void printMap(Map<?, ?> map) {
        map.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}