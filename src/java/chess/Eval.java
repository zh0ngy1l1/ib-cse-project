package chess;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Eval {

    /**
     * gets the stockfish eval from the FEN
     */
    public static String evaluateFEN(String FEN) {
        String evaluation = "";
        
        HttpURLConnection connection = getConnection(FEN, "eval");

        // Read the response from the server
        try (Scanner input = new Scanner(connection.getInputStream())) {
            String data = input.nextLine();
            String[] dataSplit = data.split(" ");
            
            // it should look like this {"success":true, "data":"Total evaluation: -1.79 (white side)"}
            // like this if there's forcing mate {"success":true, "data":"Total evaluation: White has mate in 2"}
            if (dataSplit.length == 6)
                evaluation = dataSplit[3];
            else
                evaluation = 
                    "M" + 
                    dataSplit[7].substring(
                        0, 
                        dataSplit[7].indexOf("\"")
                    ) + 
                    " for " + 
                    dataSplit[3];

        } catch (Exception e) {
            System.out.println("Error occurred in evaluation.");
            System.out.println(e);
        }

        // Close the connection
        connection.disconnect();

        return evaluation;
    }

    /**
     * gets the best move by stockfish from the FEN
     */
    public static String bestMoveFEN(String FEN) {
        String bestMove = "";
        
        HttpURLConnection connection = getConnection(FEN, "bestmove");

        // Read the response from the server
        try (Scanner input = new Scanner(connection.getInputStream())) {
            String data = input.nextLine();
            
            // it should look like this {"success":true, "data":"bestmove b1c3 ponder h7h6"}
            bestMove = data.split(" ")[2];

        } catch (Exception e) {
            System.out.println("Error occurred, returning \"\".");
            System.out.println(e);
        }

        // Close the connection
        connection.disconnect();

        return bestMove;
    }

    /**
     * get the connection to stockfish.online
     */
    private static HttpURLConnection getConnection(String FEN, String mode) {
        HttpURLConnection connection = null;

        try {
            // Specify the URL you want to send the request to
            URL url = new URL(
                String.format(
                    "%s?fen=%s&depth=%d&mode=%s", 
                    Settings.evalUrl, FEN, Settings.evalDepth, mode
                )
            );

            // Open a connection to the URL
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error connecting. Stop.");
            System.exit(1);
        }
        return connection;
    }
}
