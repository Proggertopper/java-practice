import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class MultiplyMatrixOnVector {

    public static void main(String[] args)  {
        Scanner scannerConsole = new Scanner(System.in);

        System.out.println("Введіть розмір матриці : ");
        int sizeOfMatrix = scannerConsole.nextInt();
        if(sizeOfMatrix <=0) {
            return;
        }
        int[][] MatrixOfInteger = new int[sizeOfMatrix][sizeOfMatrix];

        int[] x = new int[sizeOfMatrix];
        int[] y = new int[sizeOfMatrix];

        for (int i = 0; i < sizeOfMatrix; i++) {
            x[i] = i % 10;
            for (int j = 0; j < sizeOfMatrix; j++) {
              MatrixOfInteger[i][j] = (i + j) % 10;
            }
        }


        Date startDate = new Date();
        System.out.println(startDate);
        System.out.println(MatrixOfInteger.length);

        for (int i = 0; i < MatrixOfInteger.length ; i++) {
            int sum = 0;
            for (int j = 0; j < MatrixOfInteger[i].length; j++) {
                sum += MatrixOfInteger[i][j] * x[j];
            }
            y[i] = sum;
        }

        long endTime = new Date().getTime() -  startDate.getTime();
        System.out.println("Час виконання в мс " + endTime);

        try (FileWriter writer = new FileWriter("C:\\Users\\Sasha\\OneDrive - Dnipro National University\\Рабочий стол\\results.txt")) {
            writer.write("Результат множення матриці на вектор:\n");

            for (int i = 0; i < sizeOfMatrix; i++) {
                writer.write("y[" + i + "] = " + y[i] + "\n");
            }

            writer.write("\nЧас виконання (мс): " + endTime + "\n");
            System.out.println("Результати у файл result.txt");
        } catch (IOException e) {
            System.out.println( e.getMessage());
        }


        }
}
