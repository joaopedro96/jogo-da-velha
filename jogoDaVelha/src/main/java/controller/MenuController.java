package controller;

import model.MenuOption;
import model.Player;
import model.Scoreboard;
import view.GameView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuController {

    private Player player1;
    private Player player2;
    private Scoreboard scoreboard;
    private final GameView view;
    private final Scanner input;

    public MenuController() {
        this.view = new GameView();
        this.input = new Scanner(System.in);
        this.player1 = new Player("Jogador 1", 'X');
        this.player2 = new Player("Jogador 2", 'O');
        this.scoreboard = new Scoreboard(player1, player2);
    }

    public void run() {
        view.showWelcome();

        boolean running = true;
        while (running) {
            view.showMenu();
            MenuOption option = readOption();

            if (option == null) {
                view.showError("Opção inválida! Digite um número do menu.");
                continue;
            }

            switch (option) {
                case NEW_GAME         -> startNewGame();
                case SCOREBOARD       -> view.showScoreboard(scoreboard);
                case INSTRUCTIONS     -> view.showInstructions();
                case CONFIGURE_PLAYERS -> configurePlayers();
                case EXIT             -> running = false;
            }
        }

        view.showMessage("Até a próxima!");
        input.close();
    }

    private void startNewGame() {
        GameController gameController = new GameController(player1, player2, scoreboard, view, input);
        gameController.startGame();
    }

    private void configurePlayers() {
        view.showMessage("\n══ Configurar jogadores ══\n");

        view.showMessage("Nome do Jogador 1 (Enter para \"Jogador 1\"): ");
        input.nextLine();
        String name1 = input.nextLine().trim();
        if (name1.isEmpty()) name1 = "Jogador 1";

        view.showMessage("Nome do Jogador 2 (Enter para \"Jogador 2\"): ");
        String name2 = input.nextLine().trim();
        if (name2.isEmpty()) name2 = "Jogador 2";

        player1 = new Player(name1, 'X');
        player2 = new Player(name2, 'O');
        scoreboard = new Scoreboard(player1, player2); // reseta ao trocar nomes

        view.showMessage(String.format(
                "\nJogadores configurados: %s (X)  vs  %s (O)\n",
                player1.getName(), player2.getName()
        ));
    }

    private MenuOption readOption() {
        try {
            view.showMessage("Escolha uma opção: ");
            int code = input.nextInt();
            return MenuOption.fromCode(code);
        } catch (InputMismatchException e) {
            input.nextLine();
            return null;
        }
    }
}