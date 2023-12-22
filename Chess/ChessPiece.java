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

    public Pair[] getMoves(Board board) {
        // getMoves should be done with an existing piece, so it's implemented in the child class.
        throw new UnsupportedOperationException("There's a bug if this happens.");
    }

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
     * todo finish docstring
     */
    public ArrayList<Pair> stepForMoves(Board board, int dRow, int dCol) {
        ArrayList<Pair> moves = new ArrayList<>();

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
                    moves.add(newPosition);
                }
                break;
            }
            moves.add(newPosition);
        }
        return moves;
    }

}









