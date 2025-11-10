package org.digitalstack.chess;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if (pawn == null) {
            throw new IllegalArgumentException("pawn cannot be null");
        }

        if (!isLegalBoardPosition(xCoordinate, yCoordinate) ||
                !isEmptySquare(xCoordinate, yCoordinate) ||
                !isValidStarPoint(pieceColor, xCoordinate)) {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
            return;
        }

        pawn.setChessBoard(this);
        pawn.setXCoordinate(xCoordinate);
        pawn.setYCoordinate(yCoordinate);
        pieces[xCoordinate][yCoordinate] = pawn;
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        final boolean isHorizontallyLegal = xCoordinate >= 0 && xCoordinate < BOARD_WIDTH;
        final boolean isVerticallyLegal = yCoordinate >= 0 && yCoordinate < BOARD_HEIGHT;

        return isVerticallyLegal && isHorizontallyLegal;
    }


    public boolean isEmptySquare(int xCoordinate, int yCoordinate) {
        return pieces[xCoordinate][yCoordinate] == null;
    }

    private boolean isValidStarPoint(PieceColor pieceColor, int xCoordinate) {
        return PieceColor.WHITE.equals(pieceColor) && xCoordinate == 1 ||
                PieceColor.BLACK.equals(pieceColor) && xCoordinate == 6;
    }
}
