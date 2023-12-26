public class Settings {
    public static final boolean lightMode = false;
    public static final String ws = " ", bs = " ";
    public static final String startingFEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";

    public static String getOverlaySeparator(byte previousMask, byte currentMask) {
        // if previous mask is 0 and current mask is 0, return " "
        // if previous mask is 1 and current mask is 1, return "|"
        // if previous mask is 0 and current mask is 1, return "["
        // if previous mask is 1 and current mask is 0, return "]"
        if (previousMask == 0 && currentMask == 0)
            return " ";
        if (previousMask == 0 && currentMask == 1)
            return "[";
        if (previousMask == 1 && currentMask == 0)
            return "]";
        
        return "|";
    }

    

}
