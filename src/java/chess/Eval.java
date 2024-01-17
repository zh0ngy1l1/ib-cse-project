package chess;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Eval {

    public static double evaluateFEN(String FEN) {
        URL url = null;
        HttpURLConnection connection = null;
        double evaluation = 0;

        try {
            // Specify the URL you want to send the request to
            url = new URL(
                String.format(
                    "%s?fen=%s&depth=%d&mode=eval", 
                    Settings.evalUrl, FEN, Settings.evalDepth
                )
            );

            // Open a connection to the URL
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }

        // Read the response from the server
        try (Scanner input = new Scanner(connection.getInputStream())) {
            String data = input.nextLine();
            
            // it should look like this {"success":true, "data":"Total evaluation: -1.79 (white side)"}
            evaluation = Double.valueOf(data.split(" ")[3]);

        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }


        // Close the connection
        connection.disconnect();

        return evaluation;
    }
}
