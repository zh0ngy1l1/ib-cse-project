package fi.syk.chess.pieces;

import java.util.ArrayList;

import fi.syk.chess.*;
import fi.syk.chess.tools.*;

public class King extends ChessPiece {
    public King(boolean isWhite, Pair position) {
        super(isWhite, position);
    }

    /**
     * Returns an ArrayList of all the possible moves
     * may and probably return some illegal moves (put own king in check, etc.)
     * TODO castling
     */
    public ArrayList<Move> getMoves(Board board, Pair position) {
        ArrayList<Move> moves = new ArrayList<>();

        for (int dRow : new int[] {-1, 0, 1}) {
            for (int dCol : new int[] {-1, 0, 1}) {
                if (dRow == 0 && dCol == 0) continue; // skip the current position

                Move currentMove = stepOnce(board, position, dRow, dCol);
                if (currentMove == null) continue; // skip if the move is not valid
                moves.add(currentMove);
            }
        }
        return moves;
    }

    public String toString() {
        return (
            (isWhite ^ Settings.lightMode) ? "♚" : "♔"
        );
    }
}