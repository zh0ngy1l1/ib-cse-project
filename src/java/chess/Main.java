package chess;

public class Main {
    public static void main(String[] args) {
        Board b = new Board(Settings.testFEN);
        System.out.println(b.displayBoard());


    }
}
