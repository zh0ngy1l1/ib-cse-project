
public class ChessPiece {
    // Common properties and methods for all chess pieces
    Pair<Integer, Integer> position;
    boolean isWhite;
    boolean hasMoved;
    
    public ChessPiece(boolean isWhite, Pair<Integer, Integer> position) {
        this.position = position;
        this.isWhite = isWhite;
        this.hasMoved = false;
    }

    public static ChessPiece charToPiece(char c, Pair<Integer, Integer> position) {
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

}









