package fi.syk.chess.tools;

import java.util.ArrayList;
import fi.syk.chess.pieces.*;
//import fi.syk.chess.Board;
import fi.syk.chess.Settings;


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
     * get the turn's name
     * ex: whitesTurn == true -> "white"
     */
    public static String getTurnName(boolean whitesTurn) {
        return whitesTurn ? "white" : "black";
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
     * we want to do something Pair constructor can't do:
     * null if given "-".
     */
    public static Pair getEnPassantTarget(String chessSquare) {
        if (chessSquare.equals("-")) return null; 
        return new Pair(chessSquare);
    }

    /**
     * returns an array of 4 booleans.
     * where the first entry tells if kingside castle is possible for white
     * and the second bit tells if queenside is for white
     * third: king black. fourth: queen black.
     */
    public static boolean[] getCastleArray(String FEN_castle, boolean whitesTurn) {
        boolean[] castleArray = new boolean[4];
        castleArray[0] = FEN_castle.contains("K");
        castleArray[1] = FEN_castle.contains("Q");
        castleArray[3] = FEN_castle.contains("q");
        castleArray[2] = FEN_castle.contains("k");
        return castleArray;
    }
    
    /**
     * What's this pawn's starting row?
     */
    public static int getPawnStartingRow(boolean isWhite) {
        return isWhite ? 2 : 7;
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