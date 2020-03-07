package org.geekbang.time.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 棋局
 */
public class ChessBoard {

    private Map<Integer, ChessPiece> chessPieces = new HashMap<>();

    public ChessBoard() {
        init();
    }

    private void init() {
        chessPieces.put(1, new ChessPiece(ChessPieceUnitFactory.getChessPiece(1), 0, 0));
        chessPieces.put(1, new ChessPiece(ChessPieceUnitFactory.getChessPiece(2), 0, 1));
        // 省略其他棋子
    }

    public void move(int chessPieceId, int toPositionX, int toPositionY) {

    }

}
