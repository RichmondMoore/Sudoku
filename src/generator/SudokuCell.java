package generator;

import java.awt.*;

public class SudokuCell {
    Point coord;
    int value;

    public SudokuCell(int X, int Y) {
        coord = new Point(X,Y);
    }

    public Point getCoord() {
        return coord;
    }

    public void setCoord(Point coord) {
        this.coord = coord;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
