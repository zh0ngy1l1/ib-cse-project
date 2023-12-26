import java.util.ArrayList;

public class Board {
    private ChessPiece[][] board;
    
    public Board(String FEN) {
        this.board = Utils.fenToBoard(FEN);
    }
    
    public ChessPiece pieceAt(Pair position) {
        return board[position.getFirst()][position.getSecond()];
    }


    /**
     * Display the board, with chess pieces,
     * In addition, the overlay squares are highlighted
     * squares are the
     */
    public String displayBoard(ArrayList<Pair> overlaySquares, boolean whitesTurn) {

        // initially overlayboard are all 0s
        byte[][] overlayBoard = new byte[9][9];

        // positions to highlighted are marked 1
        for (Pair square : overlaySquares) {
            overlayBoard[square.getFirst()][square.getSecond()] = 1;
        }

        String boardString = "  a b c d e f g h  \n";

        for (int row = 8; row >= 1; row--) {
            boardString += row;

            for (int col = 1; col <= 8; col++){
                ChessPiece piece = pieceAt(new Pair(row, col));

                // if the sum of row + col is odd, the square is white.
                String squareColor = ((row + col) & 1) == 1 ? Settings.ws : Settings.bs;

                String overlaySeparator = Settings.getOverlaySeparator(overlayBoard[row][col-1], overlayBoard[row][col]);

                boardString += overlaySeparator + (piece == null ? squareColor : piece);
            }
            
            // now the last overlayboard separator
            boardString += Settings.getOverlaySeparator(overlayBoard[row][8], (byte)0);
            boardString += row + "\n";
        }
        boardString += "  a b c d e f g h  ";
        
        if (whitesTurn) return boardString;
        else return new StringBuilder(boardString).reverse().toString();

    }


}
