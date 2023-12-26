import java.util.ArrayList;

public class ChessPiece {
    // Common properties and methods for all chess pieces
    Pair position;
    boolean isWhite;
    boolean hasMoved;
    
    public ChessPiece(boolean isWhite, Pair position) {
        this.position = position;
        this.isWhite = isWhite;
        this.hasMoved = false;
    }

    /**
     * you shouldn't ever have an object that is ChessPiece but not any specific ChessPiece.
     * So this throws an error.
     */
    public ArrayList<Move> getMoves(Board board) {
        // getMoves should be done with an existing piece, so it's implemented in the child class.
        throw new UnsupportedOperationException("There's a bug if this happens.");
    }

    /**
     * Given the FEN character and position of the piece, creates an object for it.
     */
    public static ChessPiece charToPiece(char c, Pair position) {
        boolean isWhite = Character.isUpperCase(c) ? true : false;
        c = Character.toLowerCase(c);

        if (c == 'p') {
            return new Pawn(isWhite, position);
        } if (c == 'n') {
            return new Knight(isWhite, position);
        } if (c == 'b') {
            return new Bishop(isWhite, position);
        } if (c == 'r') {
            return new Rook(isWhite, position);
        } if (c == 'q') {
            return new Queen(isWhite, position);
        } else {
            return new King(isWhite, position);
        }
    }

    
    public boolean isEnemy(ChessPiece p) {
        return this.isWhite ^ p.isWhite;
    }

    /**
     * moves for rook, bishop, queen
     * Steps one at a time to direction determined by dRow and dCol.
     * Stops to capture or before ally piece and returns all moves in this direction.
     */
    public ArrayList<Move> stepForMoves(Board board, int dRow, int dCol) {
        ArrayList<Move> moves = new ArrayList<>();

        int curRow = this.position.getFirst(), 
            curCol = this.position.getSecond();
        
        for (int steps = 1; steps <= 7; steps++) {

            int newRow = curRow + steps * dRow;
            if (newRow > 8 | newRow < 1) break;

            int newCol = curCol + steps * dCol;
            if (newCol > 8 | newCol < 1) break;

            Pair newPosition = new Pair(newRow, newCol);

            if (board.pieceAt(newPosition) != null) {
                if (isEnemy(board.pieceAt(newPosition))) {
                    moves.add(new Move(this.position, newPosition, true));
                }
                break;
            }
            moves.add(new Move(this.position, newPosition, true));
        }
        return moves;
    }

}









