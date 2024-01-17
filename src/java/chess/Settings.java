package chess;
public class Settings {
    public static final boolean lightMode = false;
    public static final String ws = " ", bs = " ";
    public static final String startingFEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
    public static final String testFEN = "r3k2r/2p1npp1/1pnpbq1p/pB2p3/P3P3/2PPbN2/1PQN1PPP/R4RK1 w kq - 0 13";
    public static final String evalUrl = "https://stockfish.online/api/stockfish.php";
    public static final int evalDepth = 8; // depth must be less than 14
}
