package fi.syk.chess.tools;

import fi.syk.chess.pieces.ChessPiece;

public class Move {
    public Pair from, to;

    public Move(Pair from, Pair to) {
        this.from = from;
        this.to = to;
    }

    public String toString() {
        return "Move from " + from + " to " + to;
    }
}
