package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class BishopBlackTest {

    @Test
    public void position() {
        Cell cell =  Cell.C4;
        Figure bishop =  new BishopBlack(cell);
        Cell result = bishop.position();
        assertEquals(cell, result);
    }

    @Test
    public void copy() {
        Cell cell =  Cell.C1;
        Cell cellDest =  Cell.C6;
        Figure bishop =  new BishopBlack(cell);
        Figure result = bishop.copy(cellDest);
        assertEquals(cellDest, result.position());
    }

    @Test
    public void way() {
        Cell startCell =  Cell.C1;
        Figure bishop =  new BishopBlack(startCell);
        Cell[] cells = bishop.way(startCell, Cell.G5);

        assertArrayEquals(new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5}, cells);

    }
}