package chess;
public class Board {
    protected String[][] board;
    public boolean whitesTurn;

    public Board(String FEN) {

        String[] FEN_parts = FEN.split(" "); //"r3k2r/2p1npp1/1pnpbq1p/pB2p3/P3P3/2PPbN2/1PQN1PPP/R4RK1 w kq - 0 13"
        
        this.board = Utils.fenToBoard(FEN_parts[0]);
        this.whitesTurn = FEN_parts[1].equals("w");
    }

    /**
     * Display the board, with chess pieces,
     */
    public String displayBoard(boolean whitesTurn) {

        String boardString = "  a b c d e f g h  \n";

        for (int row = 8; row >= 1; row--) {
            boardString += row;

            for (int col = 1; col <= 8; col++){
                String piece = pieceAt(new Pair(row, col));

                // if the sum of row + col is odd, the square is white.
                String squareColor = ((row + col) & 1) == 1 ? Settings.ws : Settings.bs;

                String overlaySeparator = " ";

                boardString += overlaySeparator + (piece == null ? squareColor : piece);
            }
            
            // now the last overlayboard separator
            boardString += " ";
            boardString += row + "\n";
        }
        boardString += "  a b c d e f g h  ";
        
        if (whitesTurn) return boardString;
        else return new StringBuilder(boardString).reverse().toString();
    }

    public String pieceAt(Pair square) {
        if (!Utils.isValidSquare(square)) {
            throw new IllegalArgumentException("Square out of bounds");
        }

        return board[square.getFirst()][square.getSecond()];
    }
}
