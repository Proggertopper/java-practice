import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class MySimpleSocket {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(81);
        System.out.println(socket.getLocalPort());
        System.out.println("Сервер запущен! Жду подключения на http://localhost:81 ...");

        while(true){
            Socket socket2 = socket.accept();
            try(
                OutputStream out = socket2.getOutputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket2.getInputStream()))){

                String requestLine = in.readLine(); // Читаем первую строку запроса (например: GET /index.html HTTP/1.1)
                System.out.println("Клиент хочет: " + requestLine);

                System.out.println("Кто-то подключился");
                String date = new Date().toString();
                String response = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/plain; charset=UTF-8\r\n" +
                        "Content-Length: " + date.length() + "\r\n" +
                        "\r\n" +
                        date;
                out.write(response.getBytes());
                out.flush();
            }
            finally {
                socket2.close();
            }
        }
    }
}

