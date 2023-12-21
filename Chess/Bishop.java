import java.util.ArrayList;

public class Bishop extends ChessPiece {
    public Bishop(boolean isWhite, Pair position) {
        super(isWhite, position);
    }

    public Pair[] getMoves() {
        ArrayList<
            Pair
        > moves = new ArrayList<>();

        for (int dRow = -7; dRow <= 7; dRow++) {
            if (dRow == 0) continue;

            int newRow = position.getFirst() + dRow;
            if (newRow < 1 | newRow > 8) continue;

            for (int dCol : new int[]{dRow, -dRow}) {

                int newCol = position.getSecond() + dCol;
                if (newCol < 1 | newCol > 8) continue;

                moves.add(new Pair(newRow, newCol));
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
