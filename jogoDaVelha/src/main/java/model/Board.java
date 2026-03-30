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
        char[][] copy = new char[3][3];
        for (int i = 0; i < 3; i++)
            copy[i] = cells[i].clone();
        return copy;
    }

    public void updateBoard(char symbol, Coordinate coordinate)
            throws InvalidCoordinateException, PositionAlreadyTakenException {

        if (coordinate.getRow() < 0 || coordinate.getRow() > 2 ||
                coordinate.getColumn() < 0 || coordinate.getColumn() > 2) {
            throw new InvalidCoordinateException("Coordenada inválida!");
        }

        if (cells[coordinate.getRow()][coordinate.getColumn()] != ' ') {
            throw new PositionAlreadyTakenException("Posição já ocupada!");
        }

        cells[coordinate.getRow()][coordinate.getColumn()] = symbol;
    }

    public boolean hasVictory() {
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] != ' ' && cells[i][0] == cells[i][1] && cells[i][1] == cells[i][2]) return true;
            if (cells[0][i] != ' ' && cells[0][i] == cells[1][i] && cells[1][i] == cells[2][i]) return true;
        }
        if (cells[0][0] != ' ' && cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2]) return true;
        if (cells[0][2] != ' ' && cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0]) return true;
        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (cells[i][j] == ' ') return false;
        return true;
    }

    public boolean hasDraw() {
        return isFull() && !hasVictory();
    }

    public boolean isGameOver() {
        return hasVictory() || hasDraw();
    }

    public char getWinnerSymbol() {
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] != ' ' && cells[i][0] == cells[i][1] && cells[i][1] == cells[i][2]) return cells[i][0];
            if (cells[0][i] != ' ' && cells[0][i] == cells[1][i] && cells[1][i] == cells[2][i]) return cells[0][i];
        }
        if (cells[0][0] != ' ' && cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2]) return cells[0][0];
        if (cells[0][2] != ' ' && cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0]) return cells[0][2];
        return ' ';
    }
}