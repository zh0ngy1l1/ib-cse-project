package chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String FEN = getFEN();

        if (!Utils.isValidFEN(FEN)) {
            System.out.println("Invalid FEN. Resorting to default FEN.");
            FEN = Settings.startingFEN;
        }

        Board board = new Board(FEN);

        double evaluation = Eval.evaluateFEN(FEN);
        String bestMove = Eval.bestMoveFEN(FEN);
        
        ArrayList<Pair> overlaySquares = new ArrayList<>(
            Arrays.asList(
                new Pair(bestMove.substring(0, 2)),
                new Pair(bestMove.substring(2, 4))
            )
        );

        System.out.println(board.displayBoard(overlaySquares));
        System.out.printf("Eval: %.2f, Best Move: %s%n", evaluation, bestMove);

    }

    private static String getFEN() {
        try (Scanner in = new Scanner(System.in)) {
            return in.nextLine();
        } catch (Exception e) {
            System.out.println("Input error: " + e.getMessage());
            return Settings.startingFEN;
        }
    }
}
