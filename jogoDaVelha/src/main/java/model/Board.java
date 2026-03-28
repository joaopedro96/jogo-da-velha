package model;

public class Board {

    private char[][] cells;

    public Board() {
        cells = new char[3][3];
        reset();
    }

    public void reset() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                cells[i][j] = ' ';
    }

    public char[][] getCells() {
        return cells;
    }
}
