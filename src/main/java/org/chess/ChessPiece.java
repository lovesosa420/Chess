package org.chess;

public abstract class ChessPiece {
    public String color;
    public boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine == line && toColumn == column ||
                chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(color) ) {
            return false;
        }

        return toLine >= 0 && toLine <= 7 && toColumn >= 0 && toColumn <= 7;
    }

    public abstract String getSymbol();
}
