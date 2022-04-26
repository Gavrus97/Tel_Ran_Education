import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private final static int SERVER_PORT = 3000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);

        // задача этого бесконечного цикла - принять соединение, открыть отдельный поток для его обработки и немедленно
        // продолжить слушать следущее входящее соединение
        ExecutorService executor = Executors.newFixedThreadPool(4);

        while (true) {
            Socket socket = serverSocket.accept();
            Runnable serverTask = new ServerTask(socket);
            executor.execute(serverTask);
        }
    }
}

