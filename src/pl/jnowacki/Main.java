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

        System.out.printf("\n%s(o) gra z %s(x). Powodzenia!\n", player1, player2);

        String winner = "";
        int boardSize = 3;
        int round = 1;

        String[][] board = initBoard(boardSize);

        do {
            System.out.println("Runda nr " + round);

            String activePlayer = round % 2 == 1 ? player1 : player2;
            String activeToken = round % 2 == 1 ? "o" : "x";

            System.out.println("Teraz ruch gracza " + activePlayer);
            System.out.println("Gdzie chcesz postawic " + activeToken);

            System.out.println("Podaj wiersz do postawienia tokena: ");
            int row = Integer.parseInt(in.nextLine()) - 1;

            System.out.println("Podaj kolumne do postawienia tokena: ");
            int col = Integer.parseInt(in.nextLine()) - 1;

            if(!isValidMove(board, row, col)) {
                System.out.println("Niepoprawne dane");
                continue;
            }

            board[row][col] = activeToken;

            drawBoard(board);

//            warunek zwyciestwa i przypisanie zwyciezcy do zmiennej "winner"
            if(wasWinningMove(activeToken, board)) {
                winner = activePlayer;
            }

            round += 1;
        } while (shouldContinue(winner, round));

        displaySummary(winner);
    }

    private static boolean wasWinningMove(String token, String[][] board) {
        return isVerticalWin(token, board) ||
                isHorizontalWin(token, board) ||
                isDiagonalWin(token, board);
    }

    private static boolean isValidMove(String[][] board, int row, int col) {
        return row >= 0 && row <= board.length - 1 &&
                col >= 0 && col <= board.length - 1 &&
                board[row][col].isBlank();
    }

    private static boolean isVerticalWin(String token, String[][] board) {

        for(int i = 0; i < board.length; i++) {

            boolean win = true;

            for(int j = 0; j < board.length; j++) {
                if(!board[j][i].equals(token)){
                    win = false;
                    break;
                }
            }

            if (win) {
                return true;
            }
        }

        return false;
    }

    private static boolean isHorizontalWin(String token, String[][] board) {
        for(int i = 0; i < board.length; i++) {

            boolean win = true;

            for(int j = 0; j < board.length; j++) {
                if(!board[i][j].equals(token)){
                    win = false;
                    break;
                }
            }

            if (win) {
                return true;
            }
        }

        return false;
    }

    private static boolean isDiagonalWin(String token, String[][] board) {

        boolean winD1 = true;
        boolean winD2 = true;

        for(int i = 0; i < board.length; i++) {
            if (!board[i][i].equals(token)){
                winD1 = false;
            }

            if (!board[i][board.length - (i + 1)].equals(token)){
                winD2 = false;
            }

            if(!(winD1 || winD2)) {
                return false;
            }
        }

        return true;
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

    private static void drawBoard(String[][] board) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){

//                    wyswietlanie pola
                System.out.print(board[i][j]);

//                    rodziela pola w wierszu
                if(j < board.length - 1) {
                    System.out.print("|");
                }
            }

//                linia konca wiersza
            if(i < board.length - 1) {
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
