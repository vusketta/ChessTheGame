package com.gmail.vusketta;

import com.gmail.vusketta.board.Board;
import com.gmail.vusketta.players.Player;

public class TwoPlayerGame implements Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private int moveNumber = 1;

    public TwoPlayerGame(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public int play(boolean log) {
        while (true) {
            final int result1 = makeMove(player1, 1, log);
            if (result1 != -1) return result1;
            final int result2 = makeMove(player2, 2, log);
            if (result2 != -1) return result2;
        }
    }

    private int makeMove(Player player, int no, boolean log) {
        final Position position = board.getPosition();
        final Move move = player.makeMove(position);
        final GameResult result = board.makeMove(move, true);
        if (log) {
            System.out.println();
            System.out.println("Player: " + no);
            System.out.println(move);
            System.out.println(board);
            System.out.println("Result: " + result);
            System.out.println("MoveNumber: " + moveNumber++);
            System.out.println("FEN: " + board.getPosition().getFen());
        }
        return switch (result) {
            case WIN -> no;
            case LOSE -> 3 - no;
            case DRAW -> 0;
            case UNKNOWN -> -1;
        };
    }
}