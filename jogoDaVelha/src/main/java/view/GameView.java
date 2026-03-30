package view;

import model.Board;
import model.Player;
import model.Scoreboard;

public class GameView {

    // ─── tabuleiro ────────────────────────────────────────────

    public void showBoard(Board board) {
        char[][] cells = board.getCells();
        System.out.println();
        System.out.println("  col:    0   1   2");
        for (int i = 0; i < cells.length; i++) {
            System.out.print("linha " + i + ":  ");
            for (int j = 0; j < cells[i].length; j++) {
                System.out.print(cells[i][j]);
                if (j < cells[i].length - 1) System.out.print(" | ");
            }
            System.out.println();
            if (i < cells.length - 1) System.out.println("         ---+---+---");
        }
        System.out.println();
    }

    // ─── boas-vindas e instruções ─────────────────────────────

    public void showInstructions() {
        System.out.println("══════════════════════════════");
        System.out.println("   JOGO DA VELHA  —  v1.0     ");
        System.out.println("══════════════════════════════\n");

        System.out.println("Como jogar:");
        System.out.println("  O tabuleiro tem linhas e colunas de 0 a 2.");
        System.out.println("  Quando for sua vez, digite o número da linha,");
        System.out.println("  pressione Enter, depois o número da coluna.\n");

        System.out.println("  Exemplo: linha 1 + coluna 2 → centro-direita\n");

        System.out.println("Pressione Enter para começar...");
        try { System.in.read(); } catch (Exception ignored) {}
    }

    public void showPlayers(Player p1, Player p2) {
        System.out.printf("%s → %c     %s → %c%n%n",
                p1.getName(), p1.getSymbol(),
                p2.getName(), p2.getSymbol());
    }

    public void showRound(int round) {
        System.out.println("══ Rodada " + round + " ══\n");
    }

    // ─── turno ────────────────────────────────────────────────

    public void showCurrentPlayer(Player player) {
        System.out.printf("%s [%c], é sua vez.%n", player.getName(), player.getSymbol());
    }

    public void showAskRow() {
        System.out.print("Digite a linha   (0-2): ");
    }

    public void showAskColumn() {
        System.out.print("Digite a coluna  (0-2): ");
    }

    // ─── resultado ────────────────────────────────────────────

    public void showWinner(Player player) {
        System.out.println("══════════════════════════════");
        System.out.printf("  %s venceu! Parabéns!%n", player.getName());
        System.out.println("══════════════════════════════\n");
    }

    public void showDraw() {
        System.out.println("══════════════════════════════");
        System.out.println("       Empate! Boa partida.   ");
        System.out.println("══════════════════════════════\n");
    }

    // ─── placar ───────────────────────────────────────────────

    public void showScoreboard(Scoreboard scoreboard) {
        System.out.println("Placar atual:");
        System.out.println("  " + scoreboard.getSummary());
    }

    // ─── erros e mensagens genéricas ──────────────────────────

    public void showError(String message) {
        System.out.println("[!] " + message);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showPlayAgain() {
        System.out.print("Deseja jogar novamente? (s/n): ");
    }

    public void showWelcome() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║     JOGO DA VELHA  v1.0      ║");
        System.out.println("╚══════════════════════════════╝\n");
    }

    public void showMenu() {
        System.out.println("  [1]  Novo jogo");
        System.out.println("  [2]  Ver placar");
        System.out.println("  [3]  Como jogar");
        System.out.println("  [4]  Configurar jogadores");
        System.out.println("  [0]  Sair");
        System.out.println("──────────────────────────────");
    }


}