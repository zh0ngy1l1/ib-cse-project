public class Queen extends ChessPiece {
    public Queen(boolean isWhite, Pair<Integer, Integer> position) {
        super(isWhite, position);
    }

    public String toString() {
        return (
            (isWhite ^ Utils.lightMode) ? "♛" : "♕"
        );
    }
}