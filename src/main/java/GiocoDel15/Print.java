package GiocoDel15;

public class Print {
    public final Game game;

    public Print(Game game) {
        this.game = game;
    }

    public void stampaBoard() {
        for (int i = 0; i < game.getDimension(); i++) {
            for (int j = 0; j < game.getDimension(); j++) {
                System.out.print(game.getBoard()[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
