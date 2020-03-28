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

        String[][] board = initBoard(boardSize);

        do {
            System.out.println("Runda nr " + round);

            System.out.println("Teraz ruch gracza " + (round % 2 == 1 ? player1 : player2));
            System.out.println("Gdzie chcesz postawic " + (round % 2 == 1 ? "o" : "x"));

            System.out.println("Podaj wiersz do postawienia tokena: ");
            int row = Integer.parseInt(in.nextLine()) - 1;

            System.out.println("Podaj kolumne do postawienia tokena: ");
            int col = Integer.parseInt(in.nextLine()) - 1;

            if(row < 0 || row > 2 || col < 0 || col > 2) {
//                TODO: dodac sprawdzenie, czy pole jest puste
                System.out.println("Niepoprawne dane");
                continue;
            }

            board[row][col] = round % 2 == 1 ? "o" : "x";

            drawBoard(board, boardSize);

//            TODO: warunek zwyciestwa i przypisanie zwyciezcy do zmiennej "winner"

            round += 1;
        } while (shouldContinue(winner, round));

        displaySummary(winner);
    }

    private static boolean shouldContinue(String winner, int round) {
        return winner.isEmpty() && round <= 9;
    }

    private static void displaySummary(String winner) {
        if(winner.isEmpty()) {
            System.out.println("Byl remis");
        } else {
            System.out.println("Wygral gracz " + winner + ", gratulacje!");
        }
    }

    private static void drawBoard(String[][] board, int length) {
        for (int i = 0; i < length; i++){
            for (int j = 0; j < length; j++){

//                    wyswietlanie pola
                System.out.print(board[i][j]);

//                    rodziela pola w wierszu
                if(j < length - 1) {
                    System.out.print("|");
                }
            }

//                linia konca wiersza
            if(i < length - 1) {
                System.out.println("\n-----");
            }
        }

        System.out.println("\n");
    }

    private static String[][] initBoard(int boardSize){
        String[][] board = new String[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++){
            for (int j = 0; j < boardSize; j++){
                board[i][j] = " ";
            }
        }

        return board;
    }
}
