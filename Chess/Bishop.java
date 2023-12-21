import java.util.ArrayList;

public class Bishop extends ChessPiece {
    public Bishop(boolean isWhite, Pair<Integer, Integer> position) {
        super(isWhite, position);
    }

    public Pair<Integer, Integer>[] getMoves() {
        ArrayList<
            Pair<Integer, Integer>
        > moves = new ArrayList<>();

        for (int dRow = -7; dRow <= 7; dRow++) {
            if (dRow == 0) continue;

            int newRow = position.getFirst() + dRow;
            if (newRow < 1 | newRow > 8) continue;

            for (int dCol : new int[]{dRow, -dRow}) {

                int newCol = position.getSecond() + dCol;
                if (newCol < 1 | newCol > 8) continue;

                moves.add(new Pair<Integer,Integer>(newRow, newCol));
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
