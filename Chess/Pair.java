//this is chatGPT code.
//not mine.
public class Pair<T extends Comparable<T>, U extends Comparable<U>> implements Comparable<Pair<T, U>> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    @Override
    public int compareTo(Pair<T, U> other) {
        int firstComparison = this.first.compareTo(other.getFirst());
        if (firstComparison != 0) {
            return firstComparison;
        }
        return this.second.compareTo(other.getSecond());
    }
}
