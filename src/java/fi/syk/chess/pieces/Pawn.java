package fi.syk.chess.pieces;

import java.util.ArrayList;

import fi.syk.chess.*;
import fi.syk.chess.tools.*;

public class Pawn extends ChessPiece {
    public Pawn(boolean isWhite, Pair position) {
        super(isWhite, position);
    }


   /**
     * Returns an ArrayList of all the possible moves
     * may and probably return some illegal moves (put own king in check, etc.)
     * TODO en passant
     * TODO promotion
     */
    public ArrayList<Move> getMoves(Board board, Pair curPosition) {
        ArrayList<Move> moves = new ArrayList<>();

        int curRow = curPosition.getFirst(), 
            curCol = curPosition.getSecond();

        boolean isWhite = board.pieceAt(curPosition).isWhite;
        int direction = Utils.getPawnDirection(isWhite);


        Pair newPosition = new Pair(
                curRow + direction,
                curCol
            );
        
        // If we're on the last rank we should be promoted
        // once again, todo promotion
        if (!Utils.isValidSquare(newPosition)) return moves;

        // Standard move one square forward
        if (board.pieceAt(newPosition) == null) {
            moves.add(new Move(curPosition, newPosition));

            if (curRow == Utils.getPawnStartingRow(isWhite)) {
                // Move two squares forward if it's the pawn's first move
                // because it's the pawn's first move, the target square must be valid.
                newPosition = new Pair(
                    curRow + direction * 2,
                    curCol
                );

                if (board.pieceAt(newPosition) == null) {
                    moves.add(new Move(curPosition, newPosition));
                }
            }
        }

        // Captures
        for (int dCol : new int[] {-1, 1}) {

            newPosition = new Pair(
                curRow + direction,
                curCol + dCol
            );

            if (!Utils.isValidSquare(newPosition)) continue;

            if (isEnemy(board.pieceAt(newPosition), isWhite)) {
                moves.add(new Move(curPosition, newPosition));
            }
        }
        
        return moves;
    }

    public String toString() {
        return (
            (isWhite ^ Settings.lightMode) ? "♟︎" : "♙"
        );
    }
}