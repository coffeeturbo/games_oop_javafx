package job4j.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        return this.winCondition(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return this.winCondition(Figure3T::hasMarkO);
    }

    private boolean winCondition(Predicate<Figure3T> predicate) {
        return
            this.fillBy(predicate, 0, 0, 1, 0)
                || this.fillBy(predicate, 0, 0, 0, 1)
                || this.fillBy(predicate, 0,0, 1, 1)
                || this.fillBy(predicate, this.table.length - 1, 0, -1, 1)
                || this.fillBy(predicate, 0 , 1, 1, 0)
                || this.fillBy(predicate, 1 , 0, 0, 1)
                || this.fillBy(predicate, 2 , 0, 0, 1)
                || this.fillBy(predicate, 0 , 2, 1, 0)
            ;
    }

    public boolean hasGap() {
        Predicate<Figure3T> predicate = f -> !f.hasMarkX() && !f.hasMarkO();
        List<Figure3T> figures = Arrays.stream(table)
            .flatMap(Arrays::stream)
            .filter(predicate)
            .collect(Collectors.toList());

        return figures.size() != 0;
    }
}
