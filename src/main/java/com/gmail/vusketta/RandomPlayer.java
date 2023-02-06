package com.gmail.vusketta;

import java.util.List;
import java.util.Random;

public class RandomPlayer implements Player {
    private final Random random;

    public RandomPlayer() {
        random = new Random();
    }

    @Override
    public Move makeMove(Position position) {
        List<Coordinate> pieces = position.getPieceCoordinates();
        List<Move> moves;
        do {
            Coordinate piece = pieces.get(random.nextInt(pieces.size()));
            moves = position.possibleMoves(piece);
        } while (moves.isEmpty());
        return moves.get(random.nextInt(moves.size()));
    }
}
