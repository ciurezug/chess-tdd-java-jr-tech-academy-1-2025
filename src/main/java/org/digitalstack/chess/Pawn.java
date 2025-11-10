package org.digitalstack.chess;

import static java.lang.Math.abs;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChesssBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void move(MovementType movementType, int newX, int newY) {
        if (!MovementType.MOVE.equals(movementType) ||
                !chessBoard.isLegalBoardPosition(newX, newY) ||
                !chessBoard.isEmptySquare(newX, newY)) {
            return;
        }
        // Simulate a bad move, but all tests will pass
        // In this scenario a Pawn can move only one square at a time on each direction (top-bottom-left-right)
        final boolean hasHorizontalMove = abs(newX - xCoordinate) == 1;
        final boolean hasVerticalMove = abs(newY - yCoordinate) == 1;

        // XoR Gate
        if (hasHorizontalMove ^ hasVerticalMove) {
            setXCoordinate(newX);
            setYCoordinate(newY);
        }
    }

    @Override
    public String toString() {
        return currentPositionAsString();
    }

    protected String currentPositionAsString() {
        return String.format("Current X: %s\nCurrent Y: %s\nPiece Color: %s", xCoordinate, yCoordinate, pieceColor);
    }
}
