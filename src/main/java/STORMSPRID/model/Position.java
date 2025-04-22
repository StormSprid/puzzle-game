package STORMSPRID.model;

import java.util.Objects;

public class Position {
    private final int row;
    private final int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row && col == position.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)",row,col);
    }

    public Position move(Direction direction){
        return new Position(
                row + direction.getRowChange(),
                col + direction.getColChange()
        );
    }
    public Position moveUp() {
        return move(Direction.UP);
    }
    public Position moveLeft(){
        return move(Direction.LEFT);
    }

    public Position moveDown(){
        return move(Direction.DOWN);
    }
    public Position moveRight(){
        return move(Direction.RIGHT);
    }
}
