public class Testing {
    public static void main(String[] args) {
        String FEN = "r3k2r/2p1npp1/1pnpbq1p/pB2p3/P3P3/2PPbN2/1PQN1PPP/R4RK1 w kq - 0 13";
        char[][] board = new char[8][8];
        board = Utils.fenToArray(FEN);
        for (char[] r : board) {
            for(char c: r)
                System.out.print(c + " ");
            System.out.println();
        }
    }
}
