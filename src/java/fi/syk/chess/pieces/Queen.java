package fi.syk.chess.pieces;

import java.util.ArrayList;

import fi.syk.chess.*;
import fi.syk.chess.tools.*;

public class Queen extends ChessPiece {
    public Queen(boolean isWhite, Pair position) {
        super(isWhite, position);
    }

    /**
     * Returns an ArrayList of all the possible moves
     * may and probably return some illegal moves (put own king in check, etc.)
     */
    public ArrayList<Move> getMoves(Board board) {
        ArrayList<Move> moves = new ArrayList<>();

        for (int dRow : new int[] {-1, 0, 1}) {
            for (int dCol : new int[] {-1, 0, 1}) {
                if (dRow == 0 && dCol == 0) continue; // skip the current position (no move possible here)

                moves.addAll(this.stepForMoves(board, dRow, dCol));
            }
        }
        return moves;
    
    }

    public String toString() {
        return (
            (isWhite ^ Settings.lightMode) ? "♛" : "♕"
        );
    }
}