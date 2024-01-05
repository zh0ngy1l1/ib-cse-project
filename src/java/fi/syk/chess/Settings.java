package fi.syk.chess;

public class Settings {
    public static final boolean lightMode = false;
    public static final String ws = " ", bs = " ";
    public static final String startingFEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
    public static final boolean confirmUserMoves = true;

    public static String getOverlaySeparator(boolean previousOccupied, boolean currentOccupied, boolean whitesTurn) {
        // if previous is not occupied and current is not occupied, return " "
        // if previous is occupied and current is occupied, return "|"
        // if previous is not occupied and current is occupied, return "["
        // if previous is occupied and current is not occupied, return "]"
        // XOR needed because the whole string is flipped when it's black's turn.
        // so basically we print "]" if we want "[" and it's black's turn. 
        if (previousOccupied == false && currentOccupied == false)
            return " ";
        if (previousOccupied == true && currentOccupied == true)
            return "|";
        if (whitesTurn) {
            if ((previousOccupied == false && currentOccupied == true))
                return "[";
            if ((previousOccupied == true && currentOccupied == false))
                return "]";
        } 
        if ((previousOccupied == false && currentOccupied == true))
            return "]";
        else 
            return "[";
    }



}
