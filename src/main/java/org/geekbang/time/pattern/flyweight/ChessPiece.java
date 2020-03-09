package org.geekbang.time.pattern.flyweight;

/**
 * 棋子
 */
public class ChessPiece {

    private ChessPieceUnit chessPieceUnit;
    private int positionX;
    private int positionY;

    public ChessPiece(ChessPieceUnit chessPieceUnit, int positionX, int positionY) {
        this.chessPieceUnit = chessPieceUnit;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public ChessPieceUnit getChessPieceUnit() {
        return chessPieceUnit;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

}
