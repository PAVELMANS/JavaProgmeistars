import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class StoniesMultiplayerVersionServer {
    private static final int PORT = 9001;
    private static HashSet<String> usernames = new HashSet<>();
    private static HashSet<PrintWriter> writers = new HashSet<>();

    public static void main(String args[]) throws Exception {
        System.out.println("the game server is currently running".toUpperCase());
        ServerSocket listener = new ServerSocket(PORT);
        try {
            while (true) {
            }
        } finally {
            listener.close();
        }
    }

    private static class Handler extends Thread {
        private String name;
        private BufferedReader in;
        private PrintWriter out;
        private Socket socket;

        public Handler(Socket socket)  {
            this.socket = socket;
        }

        public void run() {

            try {

                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                while (true) {
                    out.print("ENTERNAME");
                    name = in.readLine();
                    if (name == null) {
                        return;
                    }
                    synchronized (usernames) {
                        if (!usernames.contains(name)) {
                            usernames.add(name);
                            break;
                        }
                    }
                }

                out.println("ACCEPTED");
                System.out.println("new player: ".toUpperCase() + name);
                writers.add(out);
            } catch (IOException e) {
                System.out.println(e);
            } finally {

            }
        }
    }
}
