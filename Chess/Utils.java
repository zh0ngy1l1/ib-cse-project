import java.util.ArrayList;

public class Utils {
    /**
     * Takes the FEN notation and makes it an array with 
     * the row representing the rank and the column 
     * representing the file (1 = a, etc)
     */
    public static ChessPiece[][] fenToBoard(String FEN_board) {
        ChessPiece[][] board = new ChessPiece[9][9];
        String[] rows = FEN_board.split("/");
        for (int row = 0; row < 8; row++) {
            char[] rowCArr = rows[7 - row].toCharArray();
            int fenCol = 0;

            for (int boardCol = 0; boardCol < 8; boardCol++) {
                char current = rowCArr[fenCol];

                if (Character.isDigit(current)) {
                    for (int q = 1; 
                        q < Integer.parseInt(String.valueOf(current)); 
                        q++) {

                        board[row + 1][boardCol + 1] = null;
                        boardCol++;
                    }
                    board[row + 1][boardCol + 1] = null;

                } else {
                    board[row + 1][boardCol + 1] = ChessPiece.charToPiece(
                        current, 
                        new Pair(row + 1, boardCol + 1)
                        );
                }

                fenCol++;
            }
        }
        return board;
    }

    
    /**
     * Is square within the 8x8 chessboard?
     */
    public static boolean isValidSquare(Pair square) {
        return (
            !(square.getFirst() < 1 || square.getFirst() > 8 || 
            square.getSecond() < 1 || square.getSecond() > 8
        ));
    }
    
    
    /**
     * get only the targeted squares from a list of moves.
     */
    public static ArrayList<Pair> getTargetedSquares(ArrayList<Move> moves) {
        ArrayList<Pair> squares = new ArrayList<>();
        for (Move move : moves) {
            squares.add(move.to);
        }
        return squares;
    }
    

    /**
     * get the direction of the pawn based on its color.
     */
    public static int getPawnDirection(boolean isWhite) {
        return isWhite ? 1 : -1;
    }
    
    /**
     * Takes a 9x9 array of ChessPiece and who's turn it is
     * and returns a string of what the board looks like.
     */
    @Deprecated
    public static String displayBoard(ChessPiece[][] board, boolean whitesTurn) {
        String boardString = "  a b c d e f g h  \n";

        for (int row = 8; row >= 1; row--) {
            ChessPiece[] r = board[row];

            boardString += row + " ";
            for(int col = 1; col <= 8; col++){
                ChessPiece c = r[col];
                String squareColor = ((row + col) & 1) == 1 ? Settings.ws : Settings.bs;
                // if the sum of row + col is odd, the square is white.

                boardString += (c == null ? squareColor : c) + " ";
            }
            boardString += row;
            boardString += "\n";
        }
        boardString += "  a b c d e f g h  ";
        
        if (whitesTurn) return boardString;
        else return new StringBuilder(boardString).reverse().toString();

    }

    public static int getPawnStartingRow(boolean isWhite) {
        return isWhite ? 2 : 7;
    }

    @Deprecated
    public static String displayMoves(ArrayList<Pair> moves, boolean whitesTurn) {
        
        boolean[][] board = new boolean[9][9];
        for (Pair move : moves) {
            board[move.getFirst()][move.getSecond()] = true;
        }

        String boardString = "  a b c d e f g h  \n";

        for (int row = 8; row >= 1; row--) {
            boolean[] r = board[row];

            boardString += row + " ";
            for(int col = 1; col <= 8; col++){
                boolean c = r[col];
                String squareColor = ((row + col) & 1) == 1 ? Settings.ws : Settings.bs;
                // if the sum of row + col is odd, the square is white.

                boardString += (c == false ? squareColor : "#") + " ";
            }
            boardString += row;
            boardString += "\n";
        }
        boardString += "  a b c d e f g h  ";
        
        if (whitesTurn) return boardString;
        else return new StringBuilder(boardString).reverse().toString();
    
    }



}