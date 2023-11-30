package GiocoDel15;

import java.util.Random;

class Game {
    private final int[][] board;
    private final int dimension;
    private int emptyRow;
    private int emptyCol;
    private int moves;

    public Game() {
        dimension = 4;
        board = new int[dimension][dimension];
        inizializzaBoard();
    }

    private void inizializzaBoard() {
        int number = 1;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                board[i][j] = number;
                number++;
            }
        }
        board[dimension - 1][dimension - 1] = 0;
        emptyRow = dimension - 1;
        emptyCol = dimension - 1;
    }

    public void sposta(int number) {
        if (number < 0 || number >= dimension * dimension) {
            System.out.println("Numero non valido!");
            return;
        }

        int row = -1;
        int col = -1;

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (board[i][j] == number) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        if ((Math.abs(row - emptyRow) == 1 && col == emptyCol) ||
                (Math.abs(col - emptyCol) == 1 && row == emptyRow)) {
            board[emptyRow][emptyCol] = board[row][col];
            board[row][col] = 0;
            emptyRow = row;
            emptyCol = col;
        } else {
            System.out.println("Mossa non valida!");
        }
    }

    public void riceviDifficolta(int difficulty) {
        switch (difficulty) {
            case 1:
                difficulty = 100;
                System.out.println("Board mescolata 100 volte");
                break;
            case 2:
                difficulty = 500;
                System.out.println("Board mescolata 500 volte");
                break;
            case 3:
                difficulty = 1000;
                System.out.println("Board mescolata 1000 volte");
                break;
            case 4:
                difficulty = 2000;
                System.out.println("Board mescolata 2000 volte");
                break;
            case 5:
                difficulty = 10;
                System.out.println("Board mescolata 10 volte, for testing");
            default:
                break;
        }
        mescolaBoard(difficulty);
    }

    private void mescolaBoard(int difficulty) {
        Random random = new Random();

        for (int i = 0; i < difficulty; i++) {
            int numeroCasuale = random.nextInt(4);

            switch (numeroCasuale) {
                case 0:
                    spostaNumero(emptyRow + 1, emptyCol);
                    break;
                case 1:
                    spostaNumero(emptyRow - 1, emptyCol);
                    break;
                case 2:
                    spostaNumero(emptyRow, emptyCol + 1);
                    break;
                case 3:
                    spostaNumero(emptyRow, emptyCol - 1);
                    break;
                default:
                    break;
            }
        }
    }

    private void spostaNumero(int newRow, int newCol) {
        if (newRow >= 0 && newRow < dimension && newCol >= 0 && newCol < dimension) {
            sposta(board[newRow][newCol]);
            moves++;
        }
    }

    public boolean giocoFinito() {
        int number = 1;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (board[i][j] != number % (dimension * dimension)) {
                    return false;
                }
                number++;
            }
        }
        System.out.println("Hai vinto il gioco del 15 in " + moves + " mosse.");
        return true;
    }



    public int[][] getBoard() {
        return board;
    }

    public int getDimension() {
        return dimension;
    }
}