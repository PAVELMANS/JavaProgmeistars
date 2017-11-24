import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class StoniesMultiplayerVersionPlayer {
    BufferedReader in;
    PrintWriter out;
    Scanner scanIn;

    public StoniesMultiplayerVersionPlayer() {
        scanIn = new Scanner(System.in);
    }

    private void run() throws IOException {
        System.out.print("write down the ip address: ".toUpperCase());
        String address = scanIn.nextLine();
        Socket socket = new Socket(address, 9001);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        int stones = Integer.parseInt(in.readLine());

        System.out.println(in.readLine());

        while (true) {
            String line = in.readLine();
            if (line.startsWith("ENTERNAME")) {
                System.out.print("Please enter your name: ");
                out.println(scanIn.nextLine());
            } else if (line.startsWith("ACCEPTED")) {
                System.out.println("Your username has been accepted");
            } else if (line.startsWith("START")) {
                System.out.println("From the very beginning each player has " + stones + " stones");
            } else if (line.startsWith("TURN")) {
                System.out.println("Another player has " + line.split(" ")[1] + " stones");
                System.out.print("Please, make your guess: ");
                out.println(scanIn.nextLine());
            } else if (line.startsWith("RIGHT")) {
                System.out.println("You guessed right! Cool!");
                stones--;
            } else if (line.startsWith("WRONG")) {
                System.out.println("You guessed wrong(");
                System.out.println("The right answer is " + line.split(" ")[1]);
            } else if (line.startsWith("END")) {
                System.out.println("The game has finished. Bye!");
                break;
            }
        }
    }
}
