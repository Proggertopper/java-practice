import static java.lang.System.out;
import static java.lang.Math.pow;


public class  Main  {
    static int val = 3;

    static int getVal(){
        return val--;
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass(8 , 6);
        out.println(myClass.a);
        out.println(myClass.b);
        int n;

        for (int i = 0; i < 10; i++) {
            n = getVal();

            assert n>0 ;
            //out.println("n equals "  + n);
            double num = pow(n , 3);
        }
        }
}
