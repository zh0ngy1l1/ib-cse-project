public class Board {
    private ChessPiece[][] board;
    
    public Board(String FEN) {
        this.board = Utils.fenToBoard(FEN);
    }

    public ChessPiece pieceAt(Pair position) {
        return board[position.getFirst()][position.getSecond()];
    }

    public String displayPieces(boolean whitesTurn) {
        String boardString = "  a b c d e f g h  \n";

        for (int row = 8; row >= 1; row--) {
            ChessPiece[] r = this.board[row];


            boardString += row + " ";
            for(int col = 1; col <= 8; col++){
                ChessPiece c = r[col];
                String squareColor = ((row + col) & 1) == 1 ? Settings.ws : Settings.bs;
                // if the sum of row + col is odd, the square is white.

                boardString += (c == null ? squareColor : c) + " ";
            }
            boardString += row;
            boardString += "\n";
        }
        boardString += "  a b c d e f g h  ";
        
        if (whitesTurn) return boardString;
        else return new StringBuilder(boardString).reverse().toString();

    }


}
