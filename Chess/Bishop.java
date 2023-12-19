public class Bishop extends ChessPiece {
    public Bishop(boolean isWhite, Pair<Integer, Integer> position) {
        super(isWhite, position);
    }

    public String toString() {
        return (
            (isWhite ^ Settings.lightMode) ? "♝" : "♗"
        );
    }
}
