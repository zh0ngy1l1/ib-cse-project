import java.util.ArrayList;

public class Bishop extends ChessPiece {
    public Bishop(boolean isWhite, Pair position) {
        super(isWhite, position);
    }

    public Pair[] getMoves(ChessPiece[][] board) {
        ArrayList<Pair> moves = new ArrayList<>();

        for (int dRow : new int[] {-1, 1}) {
            for (int dCol : new int[] {-1, 1}) {
                
                moves = Utils.join(moves, this.straightMoves(board, dRow, dCol));
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
