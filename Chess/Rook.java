public class Rook extends ChessPiece {
    public Rook(boolean isWhite, Pair<Integer, Integer> position) {
        super(isWhite, position);
    }

    public String toString() {
        return (
            (isWhite ^ Utils.lightMode) ? "♜" : "♖"
        );
    }
}