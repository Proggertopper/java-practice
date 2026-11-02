import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Type2<T> extends Type<T>{

    T ob2;

    Type2(T ob , T ob2){
        super(ob);
        this.ob2 = ob2;
    }

     T getOb2(){
        return this.ob2;
     }

    public static void main(String[] args) throws IOException {
        Type<Integer> type = new Type<>(23);
        type.getOb();
        Type2<Integer > u = new Type2<>(23 , 34);
        u.getOb2();
        u.getOb();
        if(u instanceof Type2<?>){
            System.out.println(true);
        }
        Scanner scanner = new Scanner(System.in);
        try(FileReader reader = new FileReader(scanner.nextLine());
            FileWriter writer = new FileWriter(scanner.nextLine()))
        {
            char[] buffer = new char[65536]; // 128Kb
            while (reader.ready())
            {
                int real = reader.read(buffer);
                writer.write(buffer, 0, real);
            }
        }
    }
}
