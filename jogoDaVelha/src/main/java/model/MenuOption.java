package model;

public enum MenuOption {
    NEW_GAME(1, "Novo jogo"),
    SCOREBOARD(2, "Ver placar"),
    INSTRUCTIONS(3, "Como jogar"),
    CONFIGURE_PLAYERS(4, "Configurar jogadores"),
    EXIT(0, "Sair");

    private final int code;
    private final String label;

    MenuOption(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public int getCode() { return code; }
    public String getLabel() { return label; }

    public static MenuOption fromCode(int code) {
        for (MenuOption option : values()) {
            if (option.code == code) return option;
        }
        return null;
    }
}