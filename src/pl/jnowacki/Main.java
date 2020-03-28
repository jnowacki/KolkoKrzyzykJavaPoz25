package pl.jnowacki;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Witaj w grze o i x");

        System.out.print("Podaj nazwe 1 gracza: ");
        String player1 = "a"; //in.nextLine();

        System.out.print("\nPodaj nazwe 2 gracza: ");
        String player2 = "b"; //in.nextLine();

        System.out.printf("%s(o) gra z %s(x). Powodzenia!\n", player1, player2);

        String winner = "";
        int boardSize = 3;
        int round = 1;

        String[][] board = new String[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++){
            for (int j = 0; j < boardSize; j++){
                board[i][j] = " ";
            }
        }

        do {
            System.out.println("Runda nr " + round);

            System.out.println("Teraz ruch gracza " + (round % 2 == 1 ? player1 : player2));
            System.out.println("Gdzie chcesz postawic " + (round % 2 == 1 ? "o" : "x"));

            System.out.println("Podaj wiersz do postawienia tokena: ");
            int row = Integer.valueOf(in.nextLine()) - 1;

            System.out.println("Podaj kolumne do postawienia tokena: ");
            int col = Integer.valueOf(in.nextLine()) - 1;

            if(row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Niepoprawne dane");
                continue;
            }

            board[row][col] = round % 2 == 1 ? "o" : "x";

//            wyswietlanie
            for (int i = 0; i < boardSize; i++){
                for (int j = 0; j < boardSize; j++){

//                    wyswietlanie pola
                    System.out.print(board[i][j]);

//                    rodziela pola w wierszu
                    if(j < boardSize - 1) {
                        System.out.print("|");
                    }
                }

//                linia konca wiersza
                if(i < boardSize - 1) {
                    System.out.println("\n-----");
                }

////                dynamiczna wersja rodzialu wierszy:
//                System.out.println();
//                if(i < boardSize - 1) {
//                    for (int k = 0; k < 2 * boardSize - 1; k++){
//                        System.out.print("-");
//                    }
//                }
//                System.out.println();
            }

            System.out.println("\n");

            round += 1;
        } while (winner.isEmpty() && round <= 9);
    }
}
