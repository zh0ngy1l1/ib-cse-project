public class Rook extends ChessPiece {
    public Rook(boolean isWhite, Pair position) {
        super(isWhite, position);
    }

    public String toString() {
        return (
            (isWhite ^ Settings.lightMode) ? "♜" : "♖"
        );
    }
}