package org.chess;

public class Bishop extends ChessPiece{
    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!super.canMoveToPosition(chessBoard, line, column, toLine, toColumn)) {
            return false;
        }

        boolean position = Math.abs(toLine - line) == Math.abs(toColumn - column);
        if (!position){
            return false;
        }

        int lineDiff = toLine - line;
        int columnDiff = toColumn - column;

        int j = column;
        if (lineDiff > 0) {
            for (int i = line + 1; i < toLine; i++) {
                if (columnDiff > 0) {
                    j ++ ;
                }  else {
                    j -- ;
                }
                if (chessBoard.board[i][j] != null) {
                    return false;
                }
            }
        } else {
            for (int i = line - 1; i > toLine; i--) {
                if (columnDiff > 0) {
                    j ++ ;
                }  else {
                    j -- ;
                }
                if (chessBoard.board[i][j] != null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
