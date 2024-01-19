package chess;
public class Settings {
    public static final boolean lightMode = false;
    public static final String ws = " ", bs = " ";
    public static final String startingFEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
    public static final String testFEN = "r3k2r/2p1npp1/1pnpbq1p/pB2p3/P3P3/2PPbN2/1PQN1PPP/R4RK1 w kq - 0 13";
    public static final String evalUrl = "https://stockfish.online/api/stockfish.php";
    public static final int evalDepth = 13; // depth must be less than 14

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
