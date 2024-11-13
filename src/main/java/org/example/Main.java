package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("1-st player name: ");
        String firstPlayer = sc.nextLine();
        System.out.print("2-nd player name: ");
        String secondPlayer = sc.nextLine();

        char[][] board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '-';
            }
        }
        boolean isPlayer1 = true;

        boolean gameEnded = false;

        while(!gameEnded) {

            printBoard(board);


            char symbol = ' ';
            if (isPlayer1) {
                symbol = 'x';
            } else {
                symbol = 'o';
            }

            if (isPlayer1) {
                System.out.println(firstPlayer + "'s turn (x)");
            } else {
                System.out.println(secondPlayer + "'s turn (o)");
            }


            int row = 0;
            int column = 0;

            while (true) {
                System.out.print("Enter row (0, 1, 2): ");
                row = sc.nextInt();
                System.out.print("Enter column (0, 1, 2): ");
                column = sc.nextInt();

                if (row < 0 || row > 2 || column < 0 || column > 2) {
                    System.out.println("out of bounds");
                } else if (board[row][column] != '-') {
                    System.out.println("this place is already used");
                } else {
                    break;
                }
            }
            board[row][column] = symbol;

            if (hasWon(board) == 'x') {
                System.out.println("\n" + firstPlayer + " has Won!");
                gameEnded = !gameEnded;
            } else if (hasWon(board) == 'o') {
                System.out.println("\n" + secondPlayer + " has Won!");
                gameEnded = !gameEnded;
            } else if (hasTied(board)) {
                System.out.println("it's a tie!");
                gameEnded = !gameEnded;
            } else {
            isPlayer1 = !isPlayer1;
            }
        }
        printBoard(board);

    }

    public static void printBoard(char[][] board) {
        System.out.println("\n");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static char hasWon(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return board[i][0];
            }
        }
        for (int j = 0; j < board.length; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
                return board[0][j];
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return board[0][0];
        }
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '-') {
            return board[2][0];
        }
        return '-';
    }

    public static boolean hasTied(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}