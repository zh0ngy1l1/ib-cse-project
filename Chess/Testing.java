import java.util.ArrayList;

public class Testing {

    static void test0() {
        ArrayList<Pair> moves = new ArrayList<>();
        moves.add(null);
        for (Pair move : moves) {
            System.out.print(move + " ");
        } System.out.println();
    }
    
    static void test1() {
        String FEN = "r3k2r/2p1npp1/1pnpbq1p/pB2p3/P3P3/2PPbN2/1PQN1PPP/R4RK1 w kq - 0 13";
        Board board = new Board(FEN);
        System.out.println("white's pov:");
        System.out.println(board.displayPieces(true));
        //System.out.println("\nblack's pov:");
        //System.out.println(Utils.displayBoard(board, false));

        ChessPiece q = board.pieceAt(new Pair(3, 5));
        Pair[] moves = q.getMoves(board);

        for (Pair move : moves) {
            System.out.print(move + " ");
        } System.out.println();

        System.out.println(Utils.displayMoves(moves, true));
    }
    public static void main(String[] args) {
        test1();
    }
}
