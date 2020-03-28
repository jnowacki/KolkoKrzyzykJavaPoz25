package pl.jnowacki;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Witaj w grze o i x");

        System.out.print("Podaj nazwe 1 gracza: ");
        String player1 = in.nextLine();

        System.out.print("\nPodaj nazwe 2 gracza: ");
        String player2 = in.nextLine();

        System.out.printf("%s(o) gra z %s(x). Powodzenia!\n", player1, player2);

        String winner = "";
        int boardSize = 3;

        String[][] board = new String[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++){
            for (int j = 0; j < boardSize; j++){
                board[i][j] = "a";
            }
        }

        do {

            for (int i = 0; i < boardSize; i++){
                for (int j = 0; j < boardSize; j++){
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }

        } while (!winner.isEmpty());
    }
}
