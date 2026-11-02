import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] str = new String[100];
            for (int i = 0; i < str.length; i++) {
                str[i] = br.readLine();
                if(str[i].equals("стоп")) break;
            }
            for (String s : str){
                if(s.equals("стоп")) break;
                System.out.println(s);
            }

        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
