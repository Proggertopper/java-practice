import java.util.*;

public class Solution {
    public static void main(String[] args) {
       // String[] memory = {"object15", null, null, "object2", null, null, null, "object32", null, "object4"};// 0 9 1 8 2 7 3 6 4 5
        //executeDefragmentation2(memory);
       // System.out.println(Arrays.toString(memory));
        //Class a = void.class;
        //System.out.println(a);
       Car bugatti = new Car( 234 , 1990 , "Bugatti");
       Car lambo = new Car(300 , 1965 , "Lamborgini");
       Car ferrari = new Car(400 , 1900 , "Ferrari" );
        List<Car> list = new ArrayList<>();
        list.add(bugatti);
        list.add(lambo);
        list.add(ferrari);
        String text = "123";
        int num = Integer.parseInt(text);
        System.out.println(num);


        MaxSpeedCarComparator carComparator = new MaxSpeedCarComparator();

        list.sort(carComparator);
        //for (Car car : list){
        //    System.out.println(car);
       // }
    }

    public static void executeDefragmentation(String[] array) {
        int iterator = 0;
        int iteratorTwo = 1;
        while (iterator<array.length && iteratorTwo<array.length ){
            String s = array[iteratorTwo];
            String s1 = array[iterator];
            if (s1 == null) {
                array[iteratorTwo ] = array[iterator];
                array[iterator] = s;
                iteratorTwo++;
            }
            else
                iterator++;
        }
    }
    public static void executeDefragmentation2(String[] array) {
        int iterator = 0;
        int iteratorTwo = 0;
        while (iterator<array.length/2 && iteratorTwo<array.length/2 ){
            String s = array[array.length - 1 - iteratorTwo];
            String s1 = array[iterator];
            if (s1 == null) {
                array[array.length - 1 - iteratorTwo ] = array[iterator];
                array[iterator] = s;
                iteratorTwo++;
            }
            else
                iterator++;
        }
    }

    public static void executeDefragmentation3(String[] array) {
        String[] temp = new String[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                temp[j] = array[i];
                j++;
            }
        }
       for (int i = 0; i < array.length; i++) {
            array[i] = temp[i];
       }
    }
}
