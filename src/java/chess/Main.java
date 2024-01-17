package chess;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String FEN = getFEN();

        if (!Utils.isValidFEN(FEN))

        Board b = new Board(FEN);

        double evaluation = Eval.evaluateFEN(FEN);

        System.out.println(b.displayBoard());
        System.out.println("Eval: " + evaluation);

    }

    private static String getFEN() {
        try (Scanner in = new Scanner(System.in)) {
            return in.nextLine();
        } catch (Exception e) {
            System.out.println(e);
            return Settings.startingFEN;
        }
    }
}
