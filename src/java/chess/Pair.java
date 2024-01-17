package chess;

//this is mostly chatGPT code.
//not mine.
public class Pair {
    private int first;
    private int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Takes a chessSquare and makes it a Pair.
     * example: "f4" -> Pair(4, 6)
     */
    public Pair(String chessSquare) {
        this.first = Integer.valueOf(chessSquare.substring(1));
        this.second = (int) chessSquare.charAt(0) - (int) 'a' + 1;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }
}