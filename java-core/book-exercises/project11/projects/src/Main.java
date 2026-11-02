import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;


public class Main {
    public static void main(String[] args) throws Exception {
       /* Path file = Paths.get("F:/ForJavaExample1/WriteToFile.txt");
        List<String> lines = Files.readAllLines(Paths.get("F:/ForJavaExample2/весело.txt") , UTF_8);
        //Path testDirectory2 = Files.createDirectory(Paths.get("F:/testDirectory2"));
        Files.copy(file , Paths.get("F:/testDirectory2/testFile222.txt"));
        Stream<String>stream = Files.lines(Paths.get("F:/"));*/
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, "a=2", "b=3", "c=4", "d==3");

        list.stream().map(e -> e.split("=")).map(Arrays::toString).forEach(System.out::println);
        //.filter( e -> e.length == 2 )
                //.collect( Collectors.toMap(e -> e[0], e -> e[1]) );
    }
}
