package view;

import model.Board;

public class GameView {

    public GameView() {
    }

    //metodo para intanciar board e printar o tabuleiro e outras informações
    public void showBoard(Board board) {
        char[][] cells =  board.getCells(); // cria instancia do board

        for (int i = 0; i < cells.length; i++) {
            System.out.print(" ");
            for (int j = 0; j < cells[i].length; j++) {
                System.out.print(cells[i][j]);
                if (j < cells[i].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < cells.length - 1) {
                System.out.println("---+---+---");
            }
        }
    }



}
