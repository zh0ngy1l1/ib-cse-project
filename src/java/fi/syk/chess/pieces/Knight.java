package fi.syk.chess.pieces;

import java.util.ArrayList;

import fi.syk.chess.*;
import fi.syk.chess.tools.*;

public class Knight extends ChessPiece {
    public Knight(boolean isWhite, Pair position) {
        super(isWhite, position);
    }

    /**
     * Returns an ArrayList of all the possible moves
     * may and probably return some illegal moves (put own king in check, etc.)
     */
    public ArrayList<Move> getMoves(Board board) {
        ArrayList<Move> moves = new ArrayList<>();

        for (int dRow : new int[] {-1, 1}) {
            for (int dCol : new int[] {-2, 2}) {

                Move currentMove = stepOnce(board, dRow, dCol);
                if (currentMove == null) continue; // skip if the move is not valid
                moves.add(currentMove);
            }
        }

        for (int dRow : new int[] {-2, 2}) {
            for (int dCol : new int[] {-1, 1}) {

                Move currentMove = stepOnce(board, dRow, dCol);
                if (currentMove == null) continue; // skip if the move is not valid
                moves.add(currentMove);
            }
        }
        return moves;
    }

    public String toString() {
        return (
            (isWhite ^ Settings.lightMode) ? "♞" : "♘"
        );
    }
}