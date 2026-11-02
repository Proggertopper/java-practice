import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamsTesting {
    public static List<Integer> nums = Arrays.asList(1, 5, 8, 12, 4, 21, 9);
    public static String testing = "Java 8 Stream API is very powerful";
    public static List<String> words= Arrays.asList("one" , "two", "three");


    public static void main(String[] args){
//        nums.stream().filter(num -> num%2==0)
//                .map(num -> num * num)
//                .forEach(System.out::println);
//        Stream.of(testing).map(line -> {
//            long count = Arrays.stream(line.split(" "))
//                    .filter(word -> word.length() > 3)
//                    .count();
//            return count;
//        }).forEach(System.out::println);
       String line =  words.stream().collect(Collectors.joining(", "));
        System.out.println(line);
    }

}
