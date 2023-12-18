package Chess;
public class Utils {
    /**
     * Takes the FEN notation and makes it an array with 
     * the row representing the rank and the column 
     * representing the file (1 = a, etc)
     */
    public static char[][] fenToArray(String FEN) {
        char[][] board = new char[8][8];
        String[] rows = FEN.split(" ")[0].split("/");
        for (int row = 0; row < 8; row++) {
            char[] rowCArr = rows[7 - row].toCharArray();
            int fenCol = 0;

            for (int boardCol = 0; boardCol < 8; boardCol++) {
                char current = rowCArr[fenCol];

                if (Character.isDigit(current)) {
                    for (int q = 1; 
                        q < Integer.parseInt(String.valueOf(current)); 
                        q++) {

                        board[row][boardCol] = ' ';
                        boardCol++;
                    }
                    board[row][boardCol] = ' ';

                } else {
                    board[row][boardCol] = current;
                }

                fenCol++;
            }
        }
        return board;
    }
}