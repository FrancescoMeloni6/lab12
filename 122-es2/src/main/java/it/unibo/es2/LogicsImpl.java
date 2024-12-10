package it.unibo.es2;

public class LogicsImpl implements Logics {

    private static final String EMPTY_BUTTON = "";
    private static final String FILLED_BUTTON = "*";

    private Boolean[][] matrix;
    private final int side;

    public LogicsImpl(final int side) {
        this.side = side;
        initializeMatrix();
    }

    private void initializeMatrix(){
        matrix = new Boolean[side][side];
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                matrix[i][j] = false;
            }
        }
    }

    @Override
    public Boolean isQuittable() {    
        return checkRows() || checkColoumns();
    }

    private Boolean checkRows() {
        Boolean rowFilled;
        for (int i = 0; i < this.side; i++) {
            rowFilled = true;
            for (int j = 0; j < this.side && rowFilled; j++) {
                if (matrix[i][j]) {
                    rowFilled = false;
                }
                if (rowFilled) {
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean checkColoumns() {
        Boolean coloumnFilled;
        for (int i = 0; i < this.side; i++) {
            coloumnFilled = true;
            for (int j = 0; j < this.side && coloumnFilled; j++) {
                if (matrix[i][j]) {
                    coloumnFilled = false;
                }
                if (coloumnFilled) {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public <X, Y> String changeBox(Pair<X, Y> position) {
        matrix[(int)position.getX()][(int)position.getY()] = !matrix[(int)position.getX()][(int)position.getY()];
        return matrix[(int)position.getX()][(int)position.getY()] ? FILLED_BUTTON : EMPTY_BUTTON;
    }
    
}
