package MyPackage;

abstract public class A {
    double dim1;
    double dim2;

    A(double d , double v){
        dim1 = d;
        dim2 = v;
    }

    final void meth(){
        System.out.println("Завершенній метод");
    }
   abstract void callme();

}
class B extends A{

    B(double d , double v){
        super(d , v);
    }
    @Override
    void callme() {
        System.out.println("Реализация класса В");
    }



}
class C extends B{

    C(double d , double v){
        super(d, v);
    }
    @Override
    void callme() {

        System.out.println("Реализация класса С");
    }
}
class Dispatch{
    public static void main(String[] args) {
        C c = new C(15 , 12);
        System.out.println(c.dim1);
        System.out.println(c.dim2);
        c.callme();
        c.meth();
        
    }
}
