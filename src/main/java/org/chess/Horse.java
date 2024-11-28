package org.chess;

public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!super.canMoveToPosition(chessBoard, line, column, toLine, toColumn)) {
            return false;
        }

        int lineDiff = Math.abs(toLine - line);
        int columnDiff = Math.abs(toColumn - column);

        return (lineDiff == 2 && columnDiff == 1) || (lineDiff == 1 && columnDiff == 2);

    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
