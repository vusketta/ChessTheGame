package com.gmail.vusketta;

import com.gmail.vusketta.board.ChessBoard;
import com.gmail.vusketta.players.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Game game = new TwoPlayerGame(
                new ChessBoard(),
                getPlayer(),
                getPlayer()
        );
        final int result = game.play(true);
        switch (result) {
            case 1 -> System.out.println("First player won");
            case 2 -> System.out.println("Second player won");
            case 0 -> System.out.println("Draw");
            default -> throw new AssertionError("Unknown result " + result);
        }
    }

    private static Player getPlayer() {
        Scanner in = new Scanner(System.in);
        System.out.println(
                "Введите \"human\" для обычного игрока, " +
                        "\"random\" для случайного или \"stockfish\" для сверх гения: "
        );
        while (true) {
            switch (in.next()) {
                case "human" -> {
                    return new HumanPlayer(new Scanner(System.in));
                }
                case "random" -> {
                    return new RandomPlayer();
                }
                case "stockfish" -> {
                    return new StockfishPlayer();
                }

                default -> {
                    System.out.println("Некорректный игрок");
                    System.out.println("Попробуйте ещё раз");
                }
            }
        }
    }
}