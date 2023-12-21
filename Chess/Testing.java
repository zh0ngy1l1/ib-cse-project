public class Testing {
    public static void main(String[] args) {
        String FEN = "r3k2r/2p1npp1/1pnpbq1p/pB2p3/P3P3/2PPbN2/1PQN1PPP/R4RK1 w kq - 0 13";
        ChessPiece[][] board = Utils.fenToBoard(FEN);
        System.out.println("white's pov:");
        System.out.println(
            Utils.displayBoard(
                board, true
                )
            );
        System.out.println("\nblack's pov:");
        System.out.println(
            Utils.displayBoard(
                board, false
                )
            );
        Bishop b = (Bishop) board[3][5];
        Pair[] moves = b.getMoves();
        for (Pair move : moves) {
            System.out.println(move);
        }
        
    }
}
