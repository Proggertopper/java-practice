import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{

    /*public static void main(String[] args) {
        Jarvis jarvis = new Jarvis();
        HashMap<Integer, String> map = new HashMap<>();
        map.put(120445 , "Лидия");
        map.put(203848 , "Вася");
        map.put(300049 , "Кузя");
        for(Map.Entry entry : map.entrySet()){
            System.out.println(entry);
        }
        String valueOfNum = String.valueOf(20L);
        Integer numOfStr = Integer.parseInt(valueOfNum);
        System.out.println(valueOfNum);
        System.out.println(numOfStr);
        List<String> people = Arrays.asList(
                "Philip J. Fry",
                "Turanga Leela",
                "Bender Bending Rodriguez",
                "Hubert Farnsworth",
                "Hermes Conrad",
                "John D. Zoidberg",
                "Amy Wong"
        );
        String people2 = String.join(";" , people);
        //String[] strSplit = people2.split(";");
        String filePath = "D:\\Movies\\Futurama.mp4";
        int lastFileSeparatorIndex = filePath.lastIndexOf('\\');
       // String fileName = filePath.substring(lastFileSeparatorIndex + 1);
      //  System.out.println(fileName);
        String s = "BIGGG";
        int i = 20 ;
        //System.out.printf("This a big cook %s %d" , s , i);
    }*/
    public static void main(String[] args) {
        var list = new ArrayList<String>()
        {{
         add("hello");
         add("er");
        }};
        ArrayList<ArrayList<String>> lists = new ArrayList<>();
        lists.add(list);
        enum Day {
            Monday,
            Saturday,
            Tuesday,
            Wednesday
        }
        Day day = Day.Wednesday;
        int index = day.ordinal();
        //System.out.println(day);
        Day[] days = Day.values();
        execute();
        throw new RuntimeException();
    }

    public static void execute() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = reader.readLine();// может бросить IOException
        } catch (IOException e) {
            throw new RuntimeException(e); // заворачиваем
        }
    }
}

