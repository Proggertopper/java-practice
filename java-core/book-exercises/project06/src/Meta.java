import java.lang.reflect.*;
import java.lang.annotation.*;
@MyAnno()
public class Meta {
    public static void main(String[] args) {
        /*NewThread ob = new NewThread("Один");
        NewThread ob1 = new NewThread("Два");
        NewThread ob2 = new NewThread("Три");

        System.out.println(ob1.t.isAlive());
        System.out.println(ob.t.isAlive());
        System.out.println(ob2.t.isAlive());

        try {
            System.out.println("Ожидание завершение потоков");
            ob1.t.join();
            ob.t.join();
            ob2.t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Главный поток завершен");*/
        MyMeth();
    }
    @MyAnno(value = "семь" , num = 7)
    @MyAnno()
    public static void MyMeth(){
        Class<?> c = Meta.class;
        try {
           Method m =  c.getMethod("MyMeth");
           Annotation[] annotation = m.getAnnotationsByType(MyAnno.class);
           for (Annotation annotation1 : annotation)
            System.out.println(annotation1);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}