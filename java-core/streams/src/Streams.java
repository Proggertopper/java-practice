import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
    Order order = new Order(Arrays.asList(new Item("food" , 123 , "meat") , new Item("food2" , 123 , "meat2") ,
            new Item("food3" , 123 , "meat3")));
        Order order2 = new Order(Arrays.asList(new Item("food" , 123 , "milk") , new Item("food2" , 123 , "bread") ,
                new Item("food3" , 123 , "chips")));

    List<Order> list = new ArrayList<>(Arrays.asList(order , order2));

   List<String> names =  list.stream().flatMap(order3 -> order3.getItems().stream().map(Item::getName)).map(String::toUpperCase).collect(Collectors.toList());
   names.forEach(System.out::println);
    }
}
