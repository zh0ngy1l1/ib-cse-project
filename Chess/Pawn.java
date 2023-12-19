public class Pawn extends ChessPiece {
    public Pawn(boolean isWhite, Pair<Integer, Integer> position) {
        super(isWhite, position);
    }

    public String toString() {
        return (
            (isWhite ^ Utils.lightMode) ? "♟︎" : "♙"
        );
    }
}