package org.chess;

public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }


    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!super.canMoveToPosition(chessBoard, line, column, toLine, toColumn)) {
            return false;
        }
        int lineDiff = Math.abs(toLine - line);
        int columnDiff = Math.abs(toColumn - column);

        if  (lineDiff < 2 && columnDiff < 2) {
            chessBoard.oldLine = line;
            chessBoard.oldColumn = column;
            if (chessBoard.nowPlayer.equals("White")) {
                chessBoard.lineWhite = toLine;
                chessBoard.columnWhite = toColumn;
            } else {
                chessBoard.lineBlack = toLine;
                chessBoard.columnBlack = toColumn;
            }
            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}