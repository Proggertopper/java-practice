public class Main {
    public static void main(String[] args) {
        NewThread t1 = new NewThread("Один");
        NewThread t2 = new NewThread("Два");

        try {
            Thread.sleep(1000);
            t1.mysuspend();
            System.out.println("Приостоновка потока 1");
            Thread.sleep(1000);
            t1.myresume();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
            try {
                t1.t.join();
                t2.t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        System.out.println("Главный поток завершен");
        }
    }