package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            return new Cell[] {};

            }

        int size = Math.abs(dest.x - source.x);
        Cell[] steps = new Cell[size];
        int dx = dest.x > source.x ? 1 : -1;
        int dy = dest.y > source.y ? 1 : -1;
        for (int i = 0; i < size; i++) {
            int delta = 8 * (i + 1) * (dx) + (i + 1) * dy;
            steps[i] = Cell.values()[source.ordinal() + delta];
        }

        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
