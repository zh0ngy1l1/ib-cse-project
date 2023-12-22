import java.util.ArrayList;

public class Rook extends ChessPiece {
    
    public Rook(boolean isWhite, Pair position) {
        super(isWhite, position);
    }

    public Pair[] getMoves() {
        ArrayList<Pair> moves = new ArrayList<>();

        int curRow = this.position.getFirst(), 
            curCol = this.position.getSecond();
        
        for (int newRow = 1; newRow <= 8; newRow++) {
            if (newRow == curRow) continue;

            moves.add(new Pair(newRow, curCol));
        }

        for (int newCol = 1; newCol <= 8; newCol++) {
            if (newCol == curCol) continue;

            moves.add(new Pair(curRow, newCol));
        }

        return moves.toArray(new Pair[0]);
    
    }

    public String toString() {
        return (
            (isWhite ^ Settings.lightMode) ? "♜" : "♖"
        );
    }
}