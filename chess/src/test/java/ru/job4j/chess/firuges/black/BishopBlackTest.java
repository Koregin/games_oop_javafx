package ru.job4j.chess.firuges.black;

import org.junit.Test;
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
        bishopBlack.way(Cell.G5);
    }
}