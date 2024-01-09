package fi.syk.chess.players;

import fi.syk.chess.tools.*;
import fi.syk.chess.*;
import fi.syk.chess.pieces.ChessPiece;

import java.util.ArrayList;

import edu.princeton.cs.algs4.StdIn;

public class User extends Player {

    public User(boolean isWhite) {
        super(isWhite);
    }

    public Move getMove(Board board) {
        Pair from, to;
        ChessPiece piece;

        ArrayList<Pair> toOptions;

        // if confirmUserMoves is false, just need to run once.
        boolean finished = !Settings.confirmUserMoves;

        do {
            System.out.println("It is your turn, the current board looks like this: ");
            System.out.println(board.displayBoard(isWhite));
            
            from = getMoveFrom(board);
            piece = board.pieceAt(from);
            toOptions = Utils.getTargetedSquares(piece.getMoves(board));

            System.out.println("Piece " + piece + " at " + from + " can move to these squares: ");
            // also illegal ones putting own king in check are here.
            System.out.println(toOptions);

            highlightMoves(board, toOptions);
            
            to = getMoveTo(toOptions);

            if (Settings.confirmUserMoves) finished = userConfirmed();
        } while (!finished);
        
        return new Move(piece, from, to, !(board.pieceAt(to)==null));
    }

    /**
     * Asks user to confirm move.
     */
    private boolean userConfirmed() {
        System.out.print("Enter to confirm, anything else to go back: ");
        String s = StdIn.readLine();
        return s.equals("");
    }

    /**
     * Print these moves and the whole board
     */
    private void highlightMoves(Board board, ArrayList<Pair> moves) {
        System.out.println(
            board.displayBoard(
                isWhite, 
                moves
            )
        );
    }


    /**
     * Asks the user for a square in board that has
     * a piece you can (possibly putting own king in check) move
     */
    private Pair getMoveFrom(Board board) {
        boolean finished = false;
        Pair from;
        ChessPiece piece;

        do {
            System.out.print("Enter move starting square: ");
            from = getUserSquare();

            piece = board.pieceAt(from);

            if (piece == null) {
                System.out.println("Square " + from + " is empty.\n");
                continue;
            }

            if (piece.isEnemy(isWhite)) {
                System.out.println("Piece " + piece + " at " + from + " is not yours.\n");
                continue;
            }

            if (piece.getMoves(board).isEmpty()) {
                System.out.println("Piece " + piece + " at " + from + " has no legal moves.\n");
                continue;
            }

            finished = true;
        } while (!finished);

        return from;
    }

    /**
     * Asks the user for a square in board that your piece can 
     * move to (possibly putting own king in check)
     */
    private Pair getMoveTo(ArrayList<Pair> toOptions) {
        boolean finished = false;
        Pair to;

        do {
            System.out.print("Enter move destination: ");
            to = getUserSquare();

            if (!toOptions.contains(to)) {
                System.out.println("You cannot move to " + to + ".");
                System.out.println("The options are: " + toOptions + ".\n");
                continue;
            }

            finished = true;
        } while (!finished);

        return to;
    }

    /**
     * Take input from user until user gives a
     * valid square on the chessboard (e2, etc.).
     */
    private Pair getUserSquare() {
        Pair from = null;
        boolean finished = false;
        while (!finished) {
            try {
                from = new Pair(StdIn.readLine());
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Invalid input. Enter starting square as chess square, e2 for example.\n");
                continue;
            }

            if (!Utils.isValidSquare(from)) {
                System.out.println("Square " + from + " is out of bounds.\n");
                continue;
            }

            finished = true;
        }
        return from;
    }
}
