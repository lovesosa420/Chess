package org.chess;

public class Rook extends ChessPiece{
    public Rook(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!super.canMoveToPosition(chessBoard, line, column, toLine, toColumn)) {
            return false;
        }

        int lineDiff = toLine - line;
        int columnDiff = toColumn - column;
        boolean position = lineDiff == 0 || columnDiff == 0;
        if (!position) {
            return false;
        }

        if (columnDiff == 0) {
            if (lineDiff > 0) {
                for (int i = line + 1; i < toLine; i ++) {
                    if (chessBoard.board[i][column] != null) {
                        return false;
                    }
                }
            } else {
                for (int i = line - 1; i > toLine; i --) {
                    if (chessBoard.board[i][column] != null) {
                        return false;
                    }
                }
            }
        } else {
            if (columnDiff > 0) {
                for (int j = column + 1; j < toColumn; j ++) {
                    if (chessBoard.board[line][j] != null) {
                        return false;
                    }
                }
            } else {
                for (int j = column - 1; j > toColumn; j --) {
                    if (chessBoard.board[line][j] != null) {
                        return false;
                    }
                }
            }
        }


        return true;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
