package fi.syk.chess.players;

import fi.syk.chess.tools.*;
import fi.syk.chess.*;

public abstract class Player {
    boolean isWhite;

    public Player(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public abstract Move getMove(Board board);
}
