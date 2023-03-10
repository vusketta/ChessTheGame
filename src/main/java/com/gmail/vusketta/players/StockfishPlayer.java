package com.gmail.vusketta.players;

import com.gmail.vusketta.*;
import com.gmail.vusketta.board.BoardUtils;

import java.util.Map;

public class StockfishPlayer implements Player {
    private final Stockfish engine;

    public StockfishPlayer() {
        this.engine = new Stockfish();
    }

    public String getBestMove(String fen) {
        engine.startEngine();
        String move = engine.getBestMove(fen);
        engine.stopEngine();
        return move;
    }

    @Override
    public Move makeMove(Position position) {
        Map<Character, Integer> notation = BoardUtils.getNotation();
        String fen = position.getFen();
        String move = getBestMove(fen);
        System.out.println(move);
        return new Move(
                Coordinate.of(notation.get(move.charAt(0)) - 1, Integer.parseInt(String.valueOf(move.charAt(1))) - 1),
                Coordinate.of(notation.get(move.charAt(2)) - 1, Integer.parseInt(String.valueOf(move.charAt(3))) - 1)
        );
    }
}