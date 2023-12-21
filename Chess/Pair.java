//this is chatGPT code.
//not mine.
public class Pair implements Comparable<Pair> {
    private int first;
    private int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
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
