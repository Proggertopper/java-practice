package tasksForInterwiew;

import java.util.*;
import java.util.stream.Stream;

public class FindDuplicates {
    public static void main(String[] args) {
        List<String> names = List.of("Anna", "Bob", "Anna", "Alex", "Bob", "Anna");
//        System.out.println(findDuplicates(names));
        firstUnique("aabbcde");
    }

    public static Map<String, Integer> findDuplicates(List<String> names) {
        Map<String, Integer> counts = new HashMap<>();

        for(String name: names){
            counts.put(name , counts.getOrDefault(name , 0)+1);
        }

        counts.entrySet().removeIf(entry -> entry.getValue() == 1);

        return counts;
    }

    public static Character firstUnique(String str){
        Map<Character , Integer> countsOfChar = new LinkedHashMap<>();

        char[] characters = str.toCharArray();

        for(char c : characters){
            countsOfChar.put(c , countsOfChar.getOrDefault(c , 0)+1);
        }

        Character character = countsOfChar.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        return character;
    }

    public static Map<Integer , List<String>> groupByLength(List<String> words){
        Map<Integer , List<String>> result = new HashMap<>();

        for(String word : words){
            int length = word.length();

            result.computeIfAbsent(length , k -> new ArrayList<>()).add(word);
        }
        return result;
    }

    public static Set<Integer> intersection(
            List<Integer> a,
            List<Integer> b) {

        Set<Integer> result = new HashSet<>(a);
        result.retainAll(b);

        return result;
    }
}
