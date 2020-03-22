package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;


import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void moveFigureWhenWayNotEmpty() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new PawnBlack(Cell.B2));
        boolean result = logic.move(Cell.C1, Cell.B2);
        assertFalse(result);
    }

    @Test
    public void moveFigureWhenWayFree() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        boolean result = logic.move(Cell.C1, Cell.D2);
        assertTrue(result);
    }
}