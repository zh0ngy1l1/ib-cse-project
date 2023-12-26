public class Move {
    public Pair from, to;
    public ChessPiece piece;
    public boolean isCapture;

    public Move(Pair from, Pair to, boolean isCapture) {
        this.from = from;
        this.to = to;
        this.isCapture = isCapture;
    }

    public String toString() {
        String moveString = piece.toString();
        if (isCapture) moveString += "x";
        moveString += to.toBoardLocation();

        return moveString;
    }


}
