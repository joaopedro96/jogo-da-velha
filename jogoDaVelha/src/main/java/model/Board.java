package model;

import exceptions.InvalidCoordinateException;
import exceptions.PositionAlreadyTakenException;

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

    public void updateBoard(char symbol, Coordinate coordinate)
            throws InvalidCoordinateException, PositionAlreadyTakenException {

        if (coordinate.row < 0 || coordinate.row > 2 ||
                coordinate.column < 0 || coordinate.column > 2) {
            throw new InvalidCoordinateException("Coordenada inválida!");
        }

        if (cells[coordinate.row][coordinate.column] != ' ') {
            throw new PositionAlreadyTakenException("Posição já ocupada!");
        }

        cells[coordinate.row][coordinate.column] = symbol;
    }

    public void showBoard() {
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
