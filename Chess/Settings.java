public class Settings {
    public static final boolean lightMode = false;
    public static final String ws = " ", bs = " ";
    public static final String startingFEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";

    public static String getOverlaySeparator(boolean previousOccupied, boolean currentOccupied) {
        // if previous is not occupied and current is not occupied, return " "
        // if previous is occupied and current is occupied, return "|"
        // if previous is not occupied and current is occupied, return "["
        // if previous is occupied and current is not occupied, return "]"
        if (previousOccupied == false && currentOccupied == false)
            return " ";
        if (previousOccupied == false && currentOccupied == true)
            return "[";
        if (previousOccupied == true && currentOccupied == false)
            return "]";
        
        return "|";
    }



}
