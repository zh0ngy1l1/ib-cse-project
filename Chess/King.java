public class King extends ChessPiece {
    public King(boolean isWhite, Pair<Integer, Integer> position) {
        super(isWhite, position);
    }

    public String toString() {
        return (
            (isWhite ^ Utils.lightMode) ? "♚" : "♔"
        );
    }
}