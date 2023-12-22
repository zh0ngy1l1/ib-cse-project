import java.util.ArrayList;

public class Pawn extends ChessPiece {
    public Pawn(boolean isWhite, Pair position) {
        super(isWhite, position);
    }

    //todo all the stuff for pawns basically
    //en passant, capture, promotion, etc.
    public Pair[] getMoves() {
        ArrayList<Pair> moves = new ArrayList<>();

        int curRow = this.position.getFirst(), 
            curCol = this.position.getSecond();

        int direction = (this.isWhite ? 1 : -1);

        if (!this.hasMoved) {
            moves.add(new Pair(curRow + 2 * direction, curCol));
        }

        moves.add(new Pair(curRow + direction, curCol));

        return moves.toArray(new Pair[0]);
    }

    public String toString() {
        return (
            (isWhite ^ Settings.lightMode) ? "♟︎" : "♙"
        );
    }
}