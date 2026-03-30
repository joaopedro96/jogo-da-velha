package controller;

import exceptions.InvalidCoordinateException;
import exceptions.PositionAlreadyTakenException;
import model.Board;
import model.Coordinate;
import model.Player;
import model.Scoreboard;
import view.GameView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameController {

    private Board board;
    private GameView view;
    private Player player1;
    private Player player2;
    private Scoreboard scoreboard;
    private Scanner input;
    private int round;


    public GameController(Player player1, Player player2, Scoreboard scoreboard, GameView view, Scanner input) {
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
        this.scoreboard = scoreboard;
        this.view = view;
        this.input = input;
        this.round = 1;
    }

    public void startGame() {
        view.showInstructions();
        view.showPlayers(player1, player2);

        boolean isPlayer1Turn = true;

        while (!board.isGameOver()) {
            view.showBoard(board);
            Player currentPlayer = getCurrentPlayer(isPlayer1Turn);

            try {
                Coordinate coordinate = getUserInput(currentPlayer);
                board.updateBoard(currentPlayer.getSymbol(), coordinate);
                isPlayer1Turn = !isPlayer1Turn;

            } catch (InvalidCoordinateException | PositionAlreadyTakenException e) {
                view.showMessage("Erro: " + e.getMessage());

            } catch (InputMismatchException e) {
                view.showMessage("Digite apenas números!");
                input.nextLine();
            }
        }

        view.showBoard(board);
        announceResult();
    }

    private void announceResult() {
        if (board.hasVictory()) {
            char winnerSymbol = board.getWinnerSymbol();
            Player winner = winnerSymbol == player1.getSymbol() ? player1 : player2;
            view.showWinner(winner);
        } else {
            view.showDraw();
        }
    }

    private Coordinate getUserInput(Player currentPlayer) {
        view.showMessage(currentPlayer.getName() + ", digite linha e coluna (0 a 2): ");
        int row = input.nextInt();
        int column = input.nextInt();
        return new Coordinate(row, column);
    }

    private Player getCurrentPlayer(boolean isPlayer1) {
        return isPlayer1 ? player1 : player2;
    }
}