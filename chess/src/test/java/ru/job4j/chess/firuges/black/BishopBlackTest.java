package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.FigureNotFoundException;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.Logic;
import ru.job4j.chess.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void positionTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        assertEquals(bishopBlack.position(), Cell.D4);
    }

    @Test
    public void copyTest() {
        Figure bishopBlack = new BishopBlack(Cell.D4);
        Figure copyBishopBlack = bishopBlack.copy(Cell.H8);
        assertEquals(copyBishopBlack.position(), Cell.H8);
    }

    @Test
    public void wayTest() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertArrayEquals(expected, bishopBlack.way(Cell.G5));
    }

    @Test
    public void wayTest2() {
        Figure bishopBlack = new BishopBlack(Cell.F8);
        Cell[] expected = {Cell.G7, Cell.H6};
        assertArrayEquals(expected, bishopBlack.way(Cell.H6));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void diagonalTestException() {
        Figure bishopBlack = new BishopBlack(Cell.F8);
        Cell destcell = Cell.B3;
        bishopBlack.way(destcell);
    }

    @Test(expected = OccupiedCellException.class)
    public void moveTestFindIndexException() throws OccupiedCellException, FigureNotFoundException {
        Figure bishopBlack = new BishopBlack(Cell.F8);
        Figure pawnBlack = new PawnBlack(Cell.G7);
        Logic logic = new Logic();
        logic.add(bishopBlack);
        logic.add(pawnBlack);
        logic.move(Cell.F8, Cell.H6);
    }

    @Test
    public void findWayObject() throws OccupiedCellException, FigureNotFoundException {
        Figure bishopBlack = new BishopBlack(Cell.F8);
        Cell[] bishopway = {Cell.G7, Cell.H6};
        Logic logic = new Logic();
        logic.add(bishopBlack);
        logic.move(Cell.F8, Cell.H6);
        assertArrayEquals(bishopway, bishopBlack.way(Cell.H6));
    }
}