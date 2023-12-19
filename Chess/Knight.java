public class Knight extends ChessPiece {
    public Knight(boolean isWhite, Pair<Integer, Integer> position) {
        super(isWhite, position);
    }

    public String toString() {
        return (
            (isWhite ^ Settings.lightMode) ? "♞" : "♘"
        );
    }
}