public class Factorial {
    int fact(int i){
        int result;
        if(i==0) return 1;
        result = fact(i-1) *i;// fact(2) * 3
        return result;
    }
}

class Recursion{
    public static void main(String[] args) {
        Factorial factorial= new Factorial();
        //System.out.println("Факториал трьох " + factorial.fact(3));

        RecTest recTest = new RecTest(10);
        for (int i = 0; i < 10; i++) {
            recTest.values[i] = i;
        }

        recTest.printArray(10);
    }
}

class RecTest {
    int values[];

    RecTest(int i){
        values = new int[i];
    }

    void printArray(int i){
        if(i==0) return;
        else printArray(i-1);
        System.out.println("[" + (i-1) + "] " + values[i-1]);
    }
}
