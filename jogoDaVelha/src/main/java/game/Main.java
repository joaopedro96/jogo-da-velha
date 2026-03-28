package game;

public class Main {
    public static void main(String[] args) {
        char[][] tabuleiro = {
                {' ', ' ', 'X'},
                {' ', 'X', ' '},
                {'O', ' ', ' '}
        };

        imprimirTabuleiro(tabuleiro);
    }

    public static void imprimirTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            System.out.print(" ");
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j < tabuleiro[i].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < tabuleiro.length - 1) {
                System.out.println("---+---+---");
            }
        }
    }
}