package dzLesson6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {
    public static void main(String[] args) throws IOException {
        CLI cli = new CLI();
        System.out.println("Клиент запущен");

        new Thread(() -> {
            try {
                cli.readMes();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                cli.sendMes();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class CLI {
    Socket socket = null;
    BufferedReader in = null;
    PrintWriter out= null;
    BufferedReader console = null;
    String userMes, serverMes;

    public CLI() throws IOException {
        socket = new Socket("localhost",8085);
        in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(),true);
        console = new BufferedReader(new InputStreamReader(System.in));
    }

    void sendMes() throws IOException {
        while (true) {
            if ((userMes = console.readLine()) != null) {
                out.println(userMes);
                if (userMes.equalsIgnoreCase("закрыт") || userMes.equalsIgnoreCase("выход"))
                    break;
            }
        }
    }

    void readMes() throws IOException {
        while (true) {
            if ((serverMes = in.readLine()) != null){
                System.out.println(serverMes);
            }
        }
    }

    void close() throws IOException {
        out.close();
        in.close();
        console.close();
        socket.close();
    }
}