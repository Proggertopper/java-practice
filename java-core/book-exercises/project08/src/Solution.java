import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution extends Thread {

    public static void main(String[] args) throws InterruptedException {
        Solution clock = new Solution();
        clock.start();

        Thread.sleep(10000);
        clock.interrupt();
    }

    public void run() {
        Thread current = Thread.currentThread();

        while (!current.isInterrupted())
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Работа потока была прервана");
                break;
            }
            System.out.println("Tik");
        }
    }
}
