package com.gmail.vusketta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int result = new TwoPlayerGame(
                new ChessBoard(),
                new RandomPlayer(),
                new RandomPlayer()
        ).play(true);
        switch (result) {
            case 1 -> System.out.println("First player won");
            case 2 -> System.out.println("Second player won");
            case 0 -> System.out.println("Draw");
            default -> throw new AssertionError("Unknown result " + result);
        }
    }
}