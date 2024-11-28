package org.chess;

public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!super.canMoveToPosition(chessBoard, line, column, toLine, toColumn)) {
            return false;
        }

        if (this.color.equals("White")) {
            if (toLine - line == 1 && Math.abs(toColumn - column) == 1 &&
                    chessBoard.board[toLine][toColumn] != null && !chessBoard.board[toLine][toColumn].getColor().equals(color)) {
                return true;
            }

            if (toColumn != column) {
                return false;
            }
            if (line == 1) {
                return toLine - line >= 1 && toLine - line <= 2 && chessBoard.board[toLine][toColumn] == null;
            } else {
                return toLine - line == 1 && chessBoard.board[toLine][toColumn] == null;
            }
        } else {
            if (toLine - line == -1 && Math.abs(toColumn - column) == 1 &&
                    chessBoard.board[toLine][toColumn] != null && !chessBoard.board[toLine][toColumn].getColor().equals(color)) {
                return true;
            }

            if (toColumn != column) {
                return false;
            }
            if (line == 6) {
                return line - toLine >= 1 && line - toLine <= 2 && chessBoard.board[toLine][toColumn] == null;
            } else {
                return line - toLine == 1 && chessBoard.board[toLine][toColumn] == null;
            }
        }
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
