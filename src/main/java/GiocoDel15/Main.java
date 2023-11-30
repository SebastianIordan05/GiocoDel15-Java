package GiocoDel15;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Benvenuto al Gioco del 15!");
        System.out.println("Scegli un livello di difficoltà: ");
        System.out.println("1. Facile (il gioco viene mescolato 100 volte)");
        System.out.println("2. Medio (il gioco viene mescolato 500 volte)");
        System.out.println("3. Difficile (il gioco viene mescolato 1000 volte)");
        System.out.println("4. Molto Difficile (il gioco viene mescolato 2000 volte)");
        System.out.print("Difficoltà: ");

        int difficulty = scanner.nextInt();
        Game game = new Game();
        avviaGioco(difficulty, game);
    }

    private static void avviaGioco(int difficulty, Game game) {
        Scanner scanner = new Scanner(System.in);
        Print print = new Print(game);
        game.riceviDifficolta(difficulty);
        while (!game.giocoFinito()) {
            print.stampaBoard();
            System.out.print("Inserisci il numero da spostare (0 per uscire): ");
            int numero = scanner.nextInt();
            if (numero == 0) {
                System.out.println("Gioco terminato");
                break;
            }
            game.sposta(numero);
        }
        scanner.close();
    }
}