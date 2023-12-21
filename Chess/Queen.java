public class Queen extends ChessPiece {
    public Queen(boolean isWhite, Pair position) {
        super(isWhite, position);
    }

    public String toString() {
        return (
            (isWhite ^ Settings.lightMode) ? "♛" : "♕"
        );
    }
}