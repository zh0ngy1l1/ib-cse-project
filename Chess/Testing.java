import java.util.ArrayList;

public class Testing {
    
    static void test1(Pair location) {
        if (!Utils.isValidSquare(location)) return;

        String FEN = "r3k2r/2p1npp1/1pnpbq1p/pB2p3/P3P3/2PPbN2/1PQN1PPP/R4RK1 w kq - 0 13";
        Board board = new Board(FEN);
        System.out.println("white's pov:");
        //System.out.println("\nblack's pov:");
        //System.out.println(Utils.displayBoard(board, false));

        ChessPiece q = board.pieceAt(location);
        ArrayList<Move> moves = q.getMoves(board);

        for (Move move : moves) {
            System.out.print(move + " ");
        } System.out.println();

        System.out.println(board.displayBoard(
            Utils.getTargetedSquares(moves),
            true));
    }
    public static void main(String[] args) {
        test1(new Pair(8, 5));
        test1(new Pair(6, 6));
    }
}
