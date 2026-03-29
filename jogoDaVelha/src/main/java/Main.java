import controller.GameController;
import exceptions.InvalidCoordinateException;
import exceptions.PositionAlreadyTakenException;
import model.Board;
import model.Coordinate;
import model.Player;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    Scanner input = new Scanner(System.in);
    Player player1 = new Player("Jogador 1", 'X');
    Player player2 = new Player("Jogador 2", 'O');

    public static void main(String[] args) {
        Main app = new Main();
        Board board = new Board();
        app.startGame(board);
    }

    private void startGame(Board board) {
        System.out.println("Bem vindos ao Jogo da Velha!\n");
        System.out.printf("%s: %c\n%s: %c", player1.name, player1.symbol, player2.name, player2.symbol);
        System.out.println("\nVamos começar!\n\n");
        boolean isPlayer1 = true;

        while (!GameController.isGameOver(board.getCells())) {
            board.showBoard();
            Player currentPlayer = getCurrentPlayer(isPlayer1);

            try {
                Coordinate userSelectedCoordinates = getUserInput(currentPlayer);
                board.updateBoard(currentPlayer.symbol, userSelectedCoordinates);
                isPlayer1 = !isPlayer1;

            } catch (InvalidCoordinateException | PositionAlreadyTakenException e) {
                System.out.println("Erro: " + e.getMessage());

            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números!");
                input.nextLine();
            }
        }

        board.showBoard();
        System.out.println("Fim de jogo!\n\n");
        input.close();
    }

    private Coordinate getUserInput(Player currentPlayer) {
        System.out.print("\n" + currentPlayer.name + ", digite uma coordenada: ");
        int row = input.nextInt();
        int column = input.nextInt();
        return new Coordinate(row, column);
    }

    private Player getCurrentPlayer(Boolean isPlayer1) {
        return isPlayer1 ? player1 : player2;
    }
}