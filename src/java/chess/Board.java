package chess;

import java.util.ArrayList;

public class Board {
    private String[][] board;
    public boolean whitesTurn;

    public Board(String FEN) {

        String[] FEN_parts = FEN.split(" ");
        
        this.board = Utils.fenToBoard(FEN_parts[0]);
        this.whitesTurn = FEN_parts[1].equals("w");
    }

    /**
     * Display the board, with chess pieces,
     */
    public String displayBoard() {

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
            
            boardString += " ";
            boardString += row + "\n";
        }
        boardString += "  a b c d e f g h  ";
        
        if (whitesTurn) return boardString;
        else return new StringBuilder(boardString).reverse().toString();
    }

    /**
     * Display the board, with chess pieces,
     * In addition, the overlay squares are highlighted
     */
    public String displayBoard(ArrayList<Pair> overlaySquares) {

        boolean[][] overlayBoard = new boolean[9][9];

        for (Pair square : overlaySquares) {
            overlayBoard[square.getFirst()][square.getSecond()] = true;
        }

        String boardString = "  a b c d e f g h  \n";

        for (int row = 8; row >= 1; row--) {
            boardString += row;

            for (int col = 1; col <= 8; col++){
                String piece = pieceAt(new Pair(row, col));

                // if the sum of row + col is odd, the square is white.
                String squareColor = ((row + col) & 1) == 1 ? Settings.ws : Settings.bs;

                String overlaySeparator = Settings.getOverlaySeparator(overlayBoard[row][col-1], overlayBoard[row][col], whitesTurn);

                boardString += overlaySeparator + (piece == null ? squareColor : piece);
            }
            
            // now the last overlayboard separator
            boardString += Settings.getOverlaySeparator(overlayBoard[row][8], false, whitesTurn);
            boardString += row + "\n";
        }
        boardString += "  a b c d e f g h  ";
        
        if (whitesTurn) return boardString;
        else return new StringBuilder(boardString).reverse().toString();
    }

    /**
     * returns the piece at square.
     */
    public String pieceAt(Pair square) {
        if (!Utils.isValidSquare(square)) {
            throw new IllegalArgumentException("Square out of bounds");
        }

        return board[square.getFirst()][square.getSecond()];
    }
}
