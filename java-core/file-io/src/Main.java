
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Stream;


class Main {
    public static void main(String[] args)  {
          String line1 = "Lion.avi.part37";
          String[] result = line1.split(".part");
        Stream.of(result).forEach(System.out::println);
//        HashSet<Car> autoShop = new HashSet<>();
//
//        HashMap<Integer , String> friends = new HashMap<>();
//
//        Car car1 = new Car("Nissan");
//        Car car2 = new Car("Volvo");
//        Car car3 = new Car("Niva");
//        Car car4 = new Car("Niva");
//
//        autoShop.add(car1);
//        autoShop.add(car2);
//        autoShop.add(car3);
//        autoShop.add(car4);
//
//
//        Iterator<Car> iterator = autoShop.stream().iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next().getName());
//        }
//          String line = "I love LIZA";
//          InputStream stream = new ByteArrayInputStream(line.getBytes());
//          System.setIn(stream);
//
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()){
//            System.out.println(scanner.nextLine());
//        }
    }
}