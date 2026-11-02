import java.util.Arrays;

public class Jarvis {
    Jarvis(){
        System.out.println("Привет , я джарвис!");
    }
    Jarvis(String... names){
        for(String name : names)
        System.out.println("Здрасте ," + name + " как дела?");
    }

    public void sayHello(String...names){
        System.out.println("hi" + Arrays.toString(names));
    }
}
