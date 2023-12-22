import java.util.ArrayList;

public class Bishop extends ChessPiece {
    public Bishop(boolean isWhite, Pair position) {
        super(isWhite, position);
    }

    public Pair[] getMoves(Board board) {
        ArrayList<Pair> moves = new ArrayList<>();

        for (int dRow : new int[] {-1, 1}) {
            for (int dCol : new int[] {-1, 1}) {
                
                moves.addAll(this.stepForMoves(board, dRow, dCol));
            }
        }
        return moves.toArray(new Pair[0]);
    
    }

    public String toString() {
        return (
            (isWhite ^ Settings.lightMode) ? "♝" : "♗"
        );
    }
}
