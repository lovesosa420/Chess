package org.chess;

public class ChessBoard {
    public ChessPiece[][] board = new ChessPiece[8][8]; // creating a field for game
    int lineWhite;
    int columnWhite;
    int lineBlack;
    int columnBlack;
    int oldLine = -1;
    int oldColumn = -1;
    String nowPlayer;

    public ChessBoard(String nowPlayer, int lineWhite, int columnWhite, int lineBlack, int columnBlack) {
        this.nowPlayer = nowPlayer;
        this.lineWhite = lineWhite;
        this.columnWhite = columnWhite;
        this.lineBlack = lineBlack;
        this.columnBlack = columnBlack;
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        if (checkPos(startLine) && checkPos(startColumn)) {

            if (!nowPlayer.equals(board[startLine][startColumn].getColor())) return false;

            if (board[startLine][startColumn].canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {
                ChessPiece attackedFigure = board[endLine][endColumn];
                board[endLine][endColumn] = board[startLine][startColumn]; // if piece can move, we moved a piece
                board[startLine][startColumn] = null; // set null to previous cell

                if (!isKingUnderAttack()) {
                    board[startLine][startColumn] = board[endLine][endColumn];
                    board[endLine][endColumn] = attackedFigure;
                    if (oldLine != -1 && oldColumn != -1) {
                        if (this.nowPlayer.equals("White")) {
                            this.lineWhite = oldLine;
                            this.columnWhite = oldColumn;
                        } else {
                            this.lineBlack = oldLine;
                            this.columnBlack = oldColumn;
                        }
                        oldLine = -1;
                        oldColumn = -1;
                    }
                    return false;
                }
                if (board[endLine][endColumn].getSymbol().equals("K") || board[endLine][endColumn].getSymbol().equals("R")) {
                    board[endLine][endColumn].check = false;
                }
                this.nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";

                return true;
            } else return false;
        } else return false;
    }

    public boolean isKingUnderAttack() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    continue;
                }
                if (nowPlayer.equals(board[i][j].getColor())) {
                    continue;
                }
                if (nowPlayer.equals("White")) {
                    if (board[i][j].canMoveToPosition(this, i, j, lineWhite, columnWhite))  {
                        return false;
                    }
                } else {
                    if (board[i][j].canMoveToPosition(this, i, j, lineBlack, columnBlack)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean castling0() {
        if (this.nowPlayer.equals("White")) {
            if (board[0][0].getSymbol().equals("R") && board[0][0].check && board[0][4].getSymbol().equals("K") && board[0][4].check) {
                for (int j = 1; j < 4; j++) {
                    if (board[0][j] != null) {
                        return false;
                    }
                }
                board[0][3] = board[0][0];
                board[0][2] = board[0][4];
                board[0][0] = null;
                board[0][4] = null;
                lineWhite = 0;
                columnWhite = 2;
                if (!isKingUnderAttack()) {
                    board[0][0] = board[0][3];
                    board[0][4] = board[0][2];
                    board[0][3] = null;
                    board[0][2] = null;
                    lineWhite = 0;
                    columnWhite = 4;
                    return false;
                }
            } else {
                return false;
            }
        } else {
            if (board[7][0].getSymbol().equals("R") && board[7][0].check && board[7][4].getSymbol().equals("K") && board[7][4].check) {
                for (int j = 1; j < 4; j++) {
                    if (board[7][j] != null) {
                        return false;
                    }
                }
                board[7][3] = board[7][0];
                board[7][2] = board[7][4];
                board[7][0] = null;
                board[7][4] = null;
                lineBlack = 7;
                columnBlack = 2;
                if (!isKingUnderAttack()) {
                    board[7][0] = board[7][3];
                    board[7][4] = board[7][2];
                    board[7][3] = null;
                    board[7][2] = null;
                    lineBlack = 7;
                    columnBlack = 4;
                    return false;
                }
            } else {
                return false;
            }
        }
        this.nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";
        return true;
    }

    public boolean castling7() {
        if (this.nowPlayer.equals("White")) {
            if (board[0][7].getSymbol().equals("R") && board[0][7].check && board[0][4].getSymbol().equals("K") && board[0][4].check) {
                for (int j = 5; j < 7; j++) {
                    if (board[0][j] != null) {
                        return false;
                    }
                }
                board[0][5] = board[0][7];
                board[0][6] = board[0][4];
                board[0][7] = null;
                board[0][4] = null;
                lineWhite = 0;
                columnWhite = 6;
                if (!isKingUnderAttack()) {
                    board[0][7] = board[0][5];
                    board[0][4] = board[0][6];
                    board[0][5] = null;
                    board[0][6] = null;
                    lineWhite = 0;
                    columnWhite = 4;
                    return false;
                }
            } else {
                return false;
            }
        } else {
            if (board[7][7].getSymbol().equals("R") && board[7][7].check && board[7][4].getSymbol().equals("K") && board[7][4].check) {
                for (int j = 5; j < 7; j++) {
                    if (board[7][j] != null) {
                        return false;
                    }
                }
                board[7][5] = board[7][7];
                board[7][6] = board[7][4];
                board[7][7] = null;
                board[7][4] = null;
                lineBlack = 7;
                columnBlack = 6;
                if (!isKingUnderAttack()) {
                    board[7][7] = board[7][5];
                    board[7][4] = board[7][6];
                    board[7][5] = null;
                    board[7][6] = null;
                    lineWhite = 7;
                    columnWhite = 4;
                    return false;
                }
            } else {
                return false;
            }
        }
        this.nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";
        return true;
    }

    public void printBoard() {  //print board in console
        System.out.println("Turn " + nowPlayer);
        System.out.println();
        System.out.println("Player 2(Black)");
        System.out.println();
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");

        for (int i = 7; i > -1; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(board[i][j].getSymbol() + board[i][j].getColor().substring(0, 1).toLowerCase() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Player 1(White)");
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}
