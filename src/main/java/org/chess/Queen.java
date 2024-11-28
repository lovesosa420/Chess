package org.chess;

public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!super.canMoveToPosition(chessBoard, line, column, toLine, toColumn)) {
            return false;
        }
        int lineDiff = toLine - line;
        int columnDiff = toColumn - column;
        boolean position = lineDiff == 0 || columnDiff == 0 || Math.abs(lineDiff) == Math.abs(columnDiff);
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
        } else if (lineDiff == 0) {
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
        } else {
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
        }
        return true;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}