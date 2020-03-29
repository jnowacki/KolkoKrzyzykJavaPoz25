package pl.jnowacki;

import pl.jnowacki.games.TicTacToe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        TicTacToe ticTacToe;

        System.out.println("Czy chcesz podac nazwy graczy? (y/n)");
        String decision = in.nextLine();

        if(decision.equalsIgnoreCase("y")) {
            System.out.print("Podaj nazwe 1 gracza: ");
            String player1 = in.nextLine();

            System.out.print("\nPodaj nazwe 2 gracza: ");
            String player2 = in.nextLine();

            ticTacToe = new TicTacToe(player1, player2);
        } else {
            ticTacToe = new TicTacToe();
        }

        ticTacToe.startGame();
    }
}
