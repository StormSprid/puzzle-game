package STORMSPRID.model;

public enum Direction {
    UP(-1,0),
    RIGHT(0,1),
    DOWN(1,0),
    LEFT(0,-1);

    private final int rowChange;
    private final int colChange;

    Direction(int rowChange, int colChange) {
        this.rowChange = rowChange;
        this.colChange = colChange;
    }

    public static Direction of(int rowChange,int colChange){
        for(Direction direction:values()){
            if (direction.rowChange ==rowChange
            && direction.colChange ==colChange) {
                return direction;
            }
        }
        throw new IllegalArgumentException();
    }
}
