import java.util.ArrayList;

public class King extends ChessPiece {
    public King(boolean isWhite, Pair position) {
        super(isWhite, position);
    }

    public Pair[] getMoves() {
        ArrayList<Pair> moves = new ArrayList<>();

        int curRow = this.position.getFirst(), 
            curCol = this.position.getSecond();

        for (int dRow = -1; dRow <= 1; dRow++) {

            int newRow = curRow + dRow;
            if (newRow < 1 | newRow > 8) continue;

            for (int dCol = -1; dCol <= 1; dCol++) {

                int newCol = curCol + dCol;
                if (newCol < 1 | newCol > 8) continue;
                if (newRow == curRow & newCol == curCol) continue;

                moves.add(new Pair(newRow, newCol));
            }
        }

        return moves.toArray(new Pair[0]);
    
    }

    public String toString() {
        return (
            (isWhite ^ Settings.lightMode) ? "♚" : "♔"
        );
    }
}