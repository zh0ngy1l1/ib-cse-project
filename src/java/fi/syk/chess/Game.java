package fi.syk.chess;

import java.util.ArrayList;

import fi.syk.chess.pieces.*;
import fi.syk.chess.players.*;
import fi.syk.chess.tools.*;

public class Game {
    public static void main(String[] args) {
        Board board = new Board(Testing.testFEN);

        Player David = new User(true);
        Move move = David.getMove(board);

        System.out.println(move);
    }
}
