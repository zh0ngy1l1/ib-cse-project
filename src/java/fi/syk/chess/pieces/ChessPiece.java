package fi.syk.chess.pieces;

import java.util.ArrayList;

import fi.syk.chess.*;
import fi.syk.chess.tools.*;

public abstract class ChessPiece {
    // Common properties and methods for all chess pieces
    Pair position;
    boolean isWhite;
    
    public ChessPiece(boolean isWhite, Pair position) {
        this.position = position;
        this.isWhite = isWhite;
    }


    /**
     * Sets the position of this piece
     */
    public void setPosition(Pair position) {
        if (!Utils.isValidSquare(position)) {
            throw new IllegalArgumentException("Square out of bounds");
        }


        this.position = position;
    }

    /**
     * get moves
     */
    public abstract ArrayList<Move> getMoves(Board board, Pair position);

    /**
     * Given the FEN character and position of the piece, creates an object for it.
     */
    public static ChessPiece charToPiece(char c, Pair position) {
        boolean isWhite = Character.isUpperCase(c) ? true : false;
        c = Character.toLowerCase(c);

        if (c == 'p') {
            return new Pawn(isWhite, position);
        } if (c == 'n') {
            return new Knight(isWhite, position);
        } if (c == 'b') {
            return new Bishop(isWhite, position);
        } if (c == 'r') {
            return new Rook(isWhite, position);
        } if (c == 'q') {
            return new Queen(isWhite, position);
        } else {
            return new King(isWhite, position);
        }
    }

    public static boolean isEnemy(ChessPiece p1, ChessPiece p2) {
        if (p1 == null || p2 == null) return false; // if p is null, then it's not an enemy.)
        return p1.isWhite ^ p2.isWhite;
    }

    public static boolean isEnemy(ChessPiece p1, boolean p2Color) {
        if (p1 == null) return false; // if p is null, then it's not an enemy.)
        return p1.isWhite ^ p2Color;
    }

    public static boolean isEnemy(boolean p1Color, boolean p2Color) {
        return p1Color ^ p2Color;
    }

    /**
     * moves for rook, bishop, queen
     * Steps one at a time to direction determined by dRow and dCol.
     * Stops to capture or before ally piece and returns all moves in this direction.
     */
    public static ArrayList<Move> stepForMoves(Board board, Pair curPosition, int dRow, int dCol) {
        ArrayList<Move> moves = new ArrayList<>();

        int curRow = curPosition.getFirst(), 
            curCol = curPosition.getSecond();
        
        for (int steps = 1; steps <= 7; steps++) {

            Pair newPosition = new Pair(
                curRow + steps * dRow, 
                curCol + steps * dCol
            );

            if (!Utils.isValidSquare(newPosition)) break;

            if (board.pieceAt(newPosition) != null) {
                if (isEnemy(board.pieceAt(newPosition), board.pieceAt(curPosition))) {
                    moves.add(new Move(curPosition, newPosition));
                }
                break;
            }
            moves.add(new Move(curPosition, newPosition));
        }
        return moves;
    }

    /**
     * moves for king and knight
     * Steps once to direction determined by dRow and dCol.
     * Returns either null (move cannot be made) or the move.
     */
    public static Move stepOnce(Board board, Pair curPosition, int dRow, int dCol) {

        int curRow = curPosition.getFirst(), 
            curCol = curPosition.getSecond();

        Pair newPosition = new Pair(
            curRow + dRow, 
            curCol + dCol
        );

        if (!Utils.isValidSquare(newPosition)) return null;

        if (board.pieceAt(newPosition) != null) {
            if (isEnemy(board.pieceAt(newPosition), board.pieceAt(curPosition))) {
                return new Move(curPosition, newPosition);
            }
            return null;
        }
        return new Move(curPosition, newPosition);
    }

}









