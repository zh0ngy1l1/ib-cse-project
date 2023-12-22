import java.util.ArrayList;

public class Queen extends ChessPiece {
    public Queen(boolean isWhite, Pair position) {
        super(isWhite, position);
    }

    public Pair[] getMoves() {
        int curRow = this.position.getFirst(), 
            curCol = this.position.getSecond();
        return null;
    }

    public String toString() {
        return (
            (isWhite ^ Settings.lightMode) ? "♛" : "♕"
        );
    }
}