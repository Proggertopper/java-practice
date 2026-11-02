
public class Main {
    public static void main(String[] args) {
       Q q = new Q();
       new Producer(q);
       new Consumer(q);
    }
}

 class UncaughtExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Начало работы потока");
            throw new RuntimeException("Ошибка в потоке!");
        });

        thread.start();

        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("Поймано исключение в потоке: " + t.getName());
            System.out.println("Сообщение: " + e.getMessage());
        });
    }
}