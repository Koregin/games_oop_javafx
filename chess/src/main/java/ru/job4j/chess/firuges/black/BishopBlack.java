package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
              String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(dest.getX() - position().getX());
        Cell[] steps = new Cell[size];
        int deltaX = dest.getX() > position().getX() ? 1 : -1;
        int deltaY = dest.getY() > position().getY() ? 1 : -1;
        int x = position().getX();
        int y = position().getY();
        for (int index = 0; index < size; index++) {
            x += deltaX;
            y += deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(dest.getX() - source.getX()) == Math.abs(dest.getY() - source.getY());
        /*int x1 = source.getX();
        int x2 = dest.getX();
        int y1 = source.getY();
        int y2 = dest.getY();
        boolean res = false;
        if ((x2 > x1 && y2 < y1) || (x2 < x1 && y2 > y1)) {
            res = x1 + y1 == x2 + y2;
        }
        if ((x2 < x1 && y2 < y1) || (x2 > x1 && y2 > y1)) {
            res = y1 - x1 == y2 - x2;
        }
        return res;*/
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
