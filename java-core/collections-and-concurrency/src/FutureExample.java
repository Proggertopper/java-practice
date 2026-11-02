import java.util.concurrent.CompletableFuture;

public class FutureExample {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Данные с сервера");

        System.out.println("Программа не ждёт сразу");

        String result = future.join();
        System.out.println(result);
    }
}
