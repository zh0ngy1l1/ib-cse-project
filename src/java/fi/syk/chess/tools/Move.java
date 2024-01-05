package fi.syk.chess.tools;

import fi.syk.chess.pieces.ChessPiece;

public class Move {
    public Pair from, to;
    public ChessPiece piece;
    public boolean isCapture;

    public Move(ChessPiece piece, Pair from, Pair to, boolean isCapture) {
        this.piece = piece;
        this.from = from;
        this.to = to;
        this.isCapture = isCapture;
    }

    public String toString() {
        String moveString = piece.toString();
        if (isCapture) moveString += "x";
        moveString += to.toString();

        return moveString;
    }


}
