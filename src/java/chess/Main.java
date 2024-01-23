package chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String FEN = "";

        if (args.length > 0) {
            FEN = args[0];
        } else FEN = getFEN();

        FEN = FEN.trim();

        if (!Utils.isValidFEN(FEN)) {
            System.out.println("Invalid FEN. Resorting to starting FEN.");
            System.out.println(Settings.startingFEN);
            FEN = Settings.startingFEN;
        }

        Board board = new Board(FEN);

        String evaluation = Eval.evaluateFEN(FEN);
        String bestMove = Eval.bestMoveFEN(FEN);
        
        ArrayList<Pair> overlaySquares = new ArrayList<>(
            Arrays.asList(
                new Pair(bestMove.substring(0, 2)),
                new Pair(bestMove.substring(2, 4))
            )
        );

        System.out.println(board.displayBoard(overlaySquares));
        System.out.printf("Eval: %s, Best Move: %s%n", evaluation, bestMove);
        
    }

    private static String getFEN() {
        try (Scanner in = new Scanner(System.in)) {
            return in.nextLine();
        } catch (Exception e) {
            System.out.println("Input error: " + e.getMessage());
            return "";
        }
    }
}
