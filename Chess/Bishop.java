import java.util.ArrayList;

public class Bishop extends ChessPiece {
    public Bishop(boolean isWhite, Pair position) {
        super(isWhite, position);
    }

    /**
     * Returns an ArrayList of all the possible moves
     * may and probably return some illegal moves (put own king in check, etc.
     */
    public ArrayList<Move> getMoves(Board board) {
        ArrayList<Move> moves = new ArrayList<>();

        for (int dRow : new int[] {-1, 1}) {
            for (int dCol : new int[] {-1, 1}) {
                
                moves.addAll(this.stepForMoves(board, dRow, dCol));
            }
        }
        return moves;
    
    }

    public String toString() {
        return (
            (isWhite ^ Settings.lightMode) ? "♝" : "♗"
        );
    }
}
