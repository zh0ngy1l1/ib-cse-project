package fi.syk.chess.tools;



//this is chatGPT code.
//not mine.
public class Pair implements Comparable<Pair> {
    private int first;
    private int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

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

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public String toBoardLocation() {
        return "" + (char) ('a' + second - 1) + (char) ('1' + first - 1);
    
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    @Override
    public int compareTo(Pair other) {
        int firstComparison = Integer.compare(this.first, other.getFirst());
        if (firstComparison != 0) {
            return firstComparison;
        }
        return Integer.compare(this.second, other.getSecond());
    }
}