package fi.syk.chess;

import java.util.ArrayList;

import fi.syk.chess.pieces.*;
import fi.syk.chess.tools.*;

public class Board implements Cloneable{
    protected ChessPiece[][] board;
    public boolean whitesTurn;
    private boolean[] castleArray;
    private Pair enPassantTarget;

    public Board(String FEN) {

        String[] FEN_parts = FEN.split(" "); //"r3k2r/2p1npp1/1pnpbq1p/pB2p3/P3P3/2PPbN2/1PQN1PPP/R4RK1 w kq - 0 13"
        
        this.board = Utils.fenToBoard(FEN_parts[0]);
        this.whitesTurn = FEN_parts[1].equals("w");
        this.castleArray = Utils.getCastleArray(FEN_parts[2], whitesTurn);
        this.enPassantTarget = Utils.getEnPassantTarget(FEN_parts[3]);
        //gotta add 50moverule and threefold repetition counters for board.
    }
    
    public static Board getBoardAfterMove(Board originalBoard, Move move) {
        try {
            Board newBoard = (Board) originalBoard.clone();
            newBoard.board[move.from.getFirst()][move.from.getSecond()] = null;
            newBoard.board[move.to.getFirst()][move.to.getSecond()] = move.piece;
            move.piece.setPosition(move.to);
            newBoard.enPassantTarget = null; //FIX THIS
            newBoard.whitesTurn = !originalBoard.whitesTurn;

            return newBoard;
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
            return null;
        }
    
    }

    public ChessPiece pieceAt(Pair square) {
        if (!Utils.isValidSquare(square)) {
            throw new IllegalArgumentException("Square out of bounds");
        }

        return board[square.getFirst()][square.getSecond()];
    }

    /**
     * Display the board, with chess pieces,
     * In addition, the overlay squares are highlighted
     */
    public String displayBoard(ArrayList<Pair> overlaySquares, boolean whitesTurn) {

        boolean[][] overlayBoard = new boolean[9][9];

        for (Pair square : overlaySquares) {
            overlayBoard[square.getFirst()][square.getSecond()] = true;
        }

        String boardString = "  a b c d e f g h  \n";

        for (int row = 8; row >= 1; row--) {
            boardString += row;

            for (int col = 1; col <= 8; col++){
                ChessPiece piece = pieceAt(new Pair(row, col));

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


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
