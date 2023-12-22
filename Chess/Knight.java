import java.util.ArrayList;

public class Knight extends ChessPiece {
    public Knight(boolean isWhite, Pair position) {
        super(isWhite, position);
    }

    public Pair[] getMoves() {
        ArrayList<Pair> moves = new ArrayList<>();

        int curRow = this.position.getFirst(), 
            curCol = this.position.getSecond();

        for (int dRow = -2; dRow <= 2; dRow++) {
            if (dRow == 0) continue;

            int newRow = curRow + dRow;
            if (newRow < 1 | newRow > 8) continue;

            for (int dCol : new int[]{3-Math.abs(dRow), Math.abs(dRow)-3}) {

                int newCol = curCol + dCol;
                if (newCol < 1 | newCol > 8) continue;

                moves.add(new Pair(newRow, newCol));
            }
        }

        return moves.toArray(new Pair[0]);
    
    }

    public String toString() {
        return (
            (isWhite ^ Settings.lightMode) ? "♞" : "♘"
        );
    }
}