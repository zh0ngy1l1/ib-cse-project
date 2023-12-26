import java.util.ArrayList;

public class Pawn extends ChessPiece {
    public Pawn(boolean isWhite, Pair position) {
        super(isWhite, position);
    }


   /**
     * Returns an ArrayList of all the possible moves
     * may and probably return some illegal moves (put own king in check, etc.)
     * TODO en passant
     * TODO promotion
     */
    public ArrayList<Move> getMoves(Board board) {
        ArrayList<Move> moves = new ArrayList<>();

        int curRow = this.position.getFirst(), 
            curCol = this.position.getSecond();

        int direction = Utils.getPawnDirection(this.isWhite);

        Pair newPosition = new Pair(
                curRow + direction,
                curCol
            );

        // Standard move one square forward
        if (board.pieceAt(newPosition) == null) {
            moves.add(new Move(this, this.position, newPosition, false));

            // Move two squares forward if it's the pawn's first move
            newPosition = new Pair(
                curRow + direction * 2,
                curCol
            );

            if (
                (!this.hasMoved) && 
                (board.pieceAt(newPosition) == null)
            ) {
                moves.add(new Move(this, this.position, newPosition, false));
            }
        }

        // Captures
        for (int dCol : new int[] {-1, 1}) {
            newPosition = new Pair(
                curRow + direction,
                curCol + dCol
            );

            if (isEnemy(board.pieceAt(newPosition))) {
                moves.add(new Move(this, this.position, newPosition, true));
            }
        }
        
        return moves;
    }

    public String toString() {
        return (
            (isWhite ^ Settings.lightMode) ? "♟︎" : "♙"
        );
    }
}