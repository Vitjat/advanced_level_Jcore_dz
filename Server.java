package dzLesson6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        Serv s = new Serv();
        s.start();
        s.catchClient();
        new Thread(() -> {
            while (true) {
                String txt = null;
                try {
                    txt = s.in.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (txt != null) {
                    try {
                        s.sendMessage(txt);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            try {
                s.writeToConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }
}

class Serv {
    BufferedReader in = null;
    PrintWriter out = null;
    ServerSocket serverSocket = null;
    Socket socket = null;
    String input;
    BufferedReader console = null;

    void start() {
        try {
            serverSocket = new ServerSocket(8085);
        } catch (IOException e) {
            System.out.println("Открыт порт 8085");
            System.exit(1);
        }
        System.out.print("Сервер запущен. Ждём клиента...");
    }

    void catchClient() throws IOException {
        try {
            socket = serverSocket.accept();
            System.out.println("Клиент запущен");
        } catch (IOException e) {
            System.out.println("Error");
            System.exit(1);
        }

        in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(),true);

        System.out.println("Ожидание сообщений...");
    }

    void sendMessage(String mes) throws IOException {
        if (mes.equalsIgnoreCase("выход")) close();
        out.println("сервер: " + mes);
        System.out.println(mes);
    }

    void close() throws IOException {
        out.close();
        in.close();
        socket.close();
        serverSocket.close();
    }

    void writeToConsole() throws IOException {
        while (true) {
            console = new BufferedReader(new InputStreamReader(System.in));
            String txt = console.readLine();
            sendMessage(txt);
        }
    }
}
