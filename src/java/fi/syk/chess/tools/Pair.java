package fi.syk.chess.tools;

import java.util.Objects;

//this is chatGPT code.
//not mine.
public class Pair implements Comparable<Pair> {
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

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "" + (char) ('a' + second - 1) + (char) ('1' + first - 1);
    }

    @Override
    public int compareTo(Pair other) {
        int firstComparison = Integer.compare(this.first, other.getFirst());
        if (firstComparison != 0) {
            return firstComparison;
        }
        return Integer.compare(this.second, other.getSecond());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Pair other = (Pair) obj;
        return this.first == other.first && this.second == other.second;
    }

    // ChatGPT says it's good practice. Trust.
    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
