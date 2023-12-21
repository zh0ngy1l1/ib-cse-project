public class Pawn extends ChessPiece {
    public Pawn(boolean isWhite, Pair position) {
        super(isWhite, position);
    }

    public String toString() {
        return (
            (isWhite ^ Settings.lightMode) ? "♟︎" : "♙"
        );
    }
}