import java.util.Arrays;

public class Polinome {
    public static void main(String[] args) {
        String[] words = {"afda" , "ada" , "racecar"};
        for (int i = 0; i < words.length; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append(words[i]);
            String s = builder.reverse().toString();
            char[] a = words[i].toCharArray();
            if(Arrays.equals(a, s.toCharArray())){
                System.out.println(words[i]);
                break;
            }
        }
    }
}
