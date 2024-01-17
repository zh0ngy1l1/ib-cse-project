package chess;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Eval {
    public static void main(String[] args) {
        URL url = null;
        HttpURLConnection connection = null;

        try {
            // Specify the URL you want to send the request to
            url = new URL("https://stockfish.online/api/stockfish.php?fen=r2q1rk1/ppp2ppp/3bbn2/3p4/8/1B1P4/PPP2PPP/RNB1QRK1 w - - 5 11&depth=5&mode=eval");

            // Open a connection to the URL
            connection = (HttpURLConnection) url.openConnection();
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }

        try {
            // Set the request method to GET (or POST, PUT, etc. depending on your needs)
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response from the server
            try (Scanner input = new Scanner(connection.getInputStream())) {
                while (input.hasNextLine()) {
                    System.out.println(input.nextLine());
                }
            } catch (Exception e) {
                System.out.println(e);
                System.exit(1);
            }

            // Close the connection
            connection.disconnect();

        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
    }
}
