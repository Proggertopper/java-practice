import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextInt()){
            int t = scanner.nextInt();
            while(t-- > 0){
                long x = scanner.nextLong();
                long y = scanner.nextLong();

                if(y > 2 * x ){
                    System.out.println("YES");
                }
                else
                    System.out.println("NO");
            }
        }
        }
}