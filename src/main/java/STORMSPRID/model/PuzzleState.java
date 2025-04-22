package STORMSPRID.model;

import java.util.Objects;

public class PuzzleState {
    private static final int BLOCK=0;
    private static final int RED_SHOE=1;
    private static final int BLUE_SHOE=2;
    private static final int BLACK_SHOE=3;
    private static final int BOARD_SIZE =3;
    private Position[] positions;

    public PuzzleState() {
        this.positions = new Position[]{
          new Position(0,0), //square
          new Position(2,0), //red
          new Position(1,1), //blue
          new Position(0,2)  //black
        };
    }

    public PuzzleState(Position... positions){
        checkPosition(positions);
        this.positions=positions.clone();
    }

    private boolean isOnBoard(Position position){
        return position.getRow()>=0
                && position.getRow() < BOARD_SIZE
                && position.getCol() >=0
                && position.getCol() <BOARD_SIZE;
    }
    private void checkPosition(Position[] positions){
        if (positions.length!=4){
            throw new IllegalArgumentException();
        }

        for (Position position:positions){
            if (!isOnBoard(position)){
                throw new IllegalArgumentException();
            }
        }
        if(Objects.equals(positions[BLUE_SHOE],positions[BLACK_SHOE])){
            throw new IllegalArgumentException();
        }


    }

    public Position getPosition(int index){
        return positions[index];
    }
    private boolean samePosition(int position1,int position2){
       return Objects.equals(
                positions[position1],positions[position2]
        );
    }

    public boolean isGoal(){
//        return Objects.equals(
//                positions[BLUE_SHOE],positions[BLUE_SHOE]
//        );
        return samePosition(BLUE_SHOE,RED_SHOE);
    }
}
