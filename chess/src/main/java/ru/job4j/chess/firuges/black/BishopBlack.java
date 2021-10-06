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
        /*throw new ImpossibleMoveException(
                String.format("Could not way by diagonal from %s to %s", position, dest)
        );*/
        System.out.println();
        System.out.println(dest.toString());
        System.out.println(dest.getX());
        System.out.println(dest.getY());
        int size = 4;
        Cell[] steps = new Cell[size];
        int deltaX = 1;
        int deltaY = 1;
        int x = dest.getX();
        int y = dest.getY();
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
