public class Knight extends ChessPiece {
    public Knight(boolean isWhite, Pair position) {
        super(isWhite, position);
    }

    public String toString() {
        return (
            (isWhite ^ Settings.lightMode) ? "♞" : "♘"
        );
    }
}