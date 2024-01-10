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
    
    public Board getBoardAfterMove(Move move) {
        try {
            Board newBoard = (Board) this.clone();
            ChessPiece piece = this.board[move.from.getFirst()][move.from.getSecond()];

            newBoard.board[move.from.getFirst()][move.from.getSecond()] = null;
            newBoard.board[move.to.getFirst()][move.to.getSecond()] = piece;
            piece.setPosition(move.to);
            newBoard.enPassantTarget = null; //FIX THIS
            newBoard.whitesTurn = !this.whitesTurn;

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
     */
    public String displayBoard(boolean whitesTurn) {

        String boardString = "  a b c d e f g h  \n";

        for (int row = 8; row >= 1; row--) {
            boardString += row;

            for (int col = 1; col <= 8; col++){
                ChessPiece piece = pieceAt(new Pair(row, col));

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

    /**
     * Display the board, with chess pieces,
     * In addition, the overlay squares are highlighted
     */
    public String displayBoard(boolean whitesTurn, ArrayList<Pair> overlaySquares) {

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

    /**
     * Return the position of the king
     */
    public Pair findKing(boolean isWhite) throws Exception {
        for (int row = 1; row <= 8; row++) {
            for (int col = 1; col <= 8; col++) {
                if (board[row][col] == null) continue;

                ChessPiece piece = board[row][col];

                if (
                    piece.getClass() == King.class &&
                    !piece.isEnemy(isWhite)
                ) return new Pair(row, col);

            }
        }
        throw new Exception("NO KING FOUND! BUG!");
    }

    /**
     * is square under attack?
     */
    public boolean isUnderAttack(Pair square, boolean whitesTurn) {
        boolean underAttack = false;
        ArrayList<Pair> moves;

        for (int row = 1; row <= 8; row++) {
            if (underAttack) break;

            for (int col = 1; col <= 8; col++) {
                if (underAttack) break;
                
                if (board[row][col] == null) continue;

                ChessPiece piece = board[row][col];

                if (!piece.isEnemy(whitesTurn)) continue;
            
                moves = Utils.getTargetedSquares(
                    piece.getMoves(this));

                for (Pair attackedSquare : moves) {
                    if (square.equals(attackedSquare)) {
                        underAttack = true;
                    }
                }
            }
        }
        return underAttack;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
