package fi.syk.chess;

import java.util.ArrayList;

import fi.syk.chess.pieces.*;
import fi.syk.chess.players.*;
import fi.syk.chess.tools.*;

public class Game {
    
    public static void main(String[] args) {
        Board board = new Board(Testing.testFEN);

        Player[] players = new Player[2];
        players[0] = new User(true);
        players[1] = new User(false);

        boolean whitesTurn = true;
        boolean running = true;
        Move move;

        while (running) {
            move = getLegalMove(
                players[playerIndex(whitesTurn)], 
                board);
            board = board.getBoardAfterMove(move);
            System.out.println(move);

            if(isGameOver(board)) {
                running = false;
            } else {
                whitesTurn = !whitesTurn;
            }
        }

        System.out.println();
    }

    private static int playerIndex(boolean isWhite) {
        return isWhite ? 0 : 1;
    }

    private static Move getLegalMove(Player player, Board board) {
        boolean finished = false;
        Move move = null;

        while (!finished) {
            move = player.getMove(board);
            if(isMoveLegal(move, board)) finished = true;
        }
        
        return move;
    }


    /**
     * TODO: check if the move puts your own king in check
     */
    private static boolean isMoveLegal(Move move, Board board) {
        return true;
    }

    /**
     * TODO: check if the game is over (checkmate or stalemate)
     * also add other draws like repetition and 50moves
     */
    private static boolean isGameOver(Board board) {
        return false;
    }

}
