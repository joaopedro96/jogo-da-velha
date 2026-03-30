package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Scoreboard {

    private final Map<String, Integer> wins;
    private int draws;

    public Scoreboard(Player player1, Player player2) {
        wins = new LinkedHashMap<>();
        wins.put(player1.getName(), 0);
        wins.put(player2.getName(), 0);
        draws = 0;
    }

    public void addWin(Player player) {
        String name = player.getName();
        wins.put(name, wins.get(name) + 1);
    }

    public void addDraw() {
        draws++;
    }

    public int getWins(Player player) {
        return wins.getOrDefault(player.getName(), 0);
    }

    public int getDraws() {
        return draws;
    }

    public void reset() {
        wins.replaceAll((name, count) -> 0);
        draws = 0;
    }

    public String getSummary() {
        StringBuilder sb = new StringBuilder();
        wins.forEach((name, count) ->
                sb.append(String.format("  %s: %d vitória(s)%n", name, count))
        );
        sb.append(String.format("  Empates: %d%n", draws));
        return sb.toString();
    }
}