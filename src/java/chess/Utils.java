package chess;

public class Utils {
    /**
     * Takes the FEN notation and makes it an array with 
     * the row representing the rank and the column 
     * representing the file (1 = a, etc)
     */
    public static String[][] fenToBoard(String FEN_board) {
        String[][] board = new String[9][9];
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

                        board[row + 1][boardCol + 1] = " ";
                        boardCol++;
                    }
                    board[row + 1][boardCol + 1] = " ";

                } else board[row + 1][boardCol + 1] = charToPiece(current);

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
     * Given the FEN character return the piece icon as string.
     */
    public static String charToPiece(char c) {
        boolean isWhite = Character.isUpperCase(c) ? true : false;
        c = Character.toLowerCase(c);

        if (c == 'p') {
            return (isWhite ^ Settings.lightMode) ? "♟︎" : "♙";
        } if (c == 'n') {
            return (isWhite ^ Settings.lightMode) ? "♞" : "♘";
        } if (c == 'b') {
            return (isWhite ^ Settings.lightMode) ? "♝" : "♗";
        } if (c == 'r') {
            return (isWhite ^ Settings.lightMode) ? "♜" : "♖";
        } if (c == 'q') {
            return (isWhite ^ Settings.lightMode) ? "♛" : "♕";
        } else {
            return (isWhite ^ Settings.lightMode) ? "♚" : "♔";
        }
    }
}