package catchBox;

import agentSearch.Action;
import agentSearch.State;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CatchState extends State implements Cloneable {
    //TODO this class might require the definition of additional methods and/or attributes

    protected int[][] matrix;
    private int line;
    private int column;
    private int numBox;
    private Cell goalPosition;
    private int nrSteps;

    public CatchState(int[][] matrix) {
        this.matrix = new int[matrix.length][matrix.length];
        numBox = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                this.matrix[i][j] = matrix[i][j];
                if(this.matrix[i][j] == 1) {
                    line= i;
                    column = j;
                }
                if(this.matrix[i][j] == 2){
                    numBox++;
                }
            }
        }
        nrSteps = 0;


    }

    public void executeAction(Action action) {
        action.execute(this);
        fireUpdatedEnvironment();

        throw new UnsupportedOperationException("Not implemented at"); // delete after implementing
    }

    public boolean canMoveUp() {
        if(line != 0 && (matrix[line+1][column] == 0 || matrix[line+1][column] ==2 )){
            return true;
        }

        return false;
    }

    public boolean canMoveRight() {
        if(column != matrix[0].length && (matrix[line][column+1] == 0 || matrix[line][column+1] ==2 )){
            return true;
        }

        return false;
    }

    public boolean canMoveDown() {
        if(line != matrix.length && (matrix[line-1][column] == 0 || matrix[line-1][column] ==2 )){
            return true;
        }

        return false;
    }

    public boolean canMoveLeft() {
        if(column != 0 && (matrix[line][column-1] == 0 || matrix[line][column-1] ==2 )){
            return true;
        }

        return false;
    }

    public void moveUp() {
        if(canMoveUp()){
            setCellCatch(line + 1,column);
        }
    }

    public void moveRight() {
        if(canMoveRight(){
            setCellCatch(line,column+1);
        }
    }

    public void moveDown() {
        if(canMoveDown(){
            setCellCatch(line-1,column);
        }
    }

    public void moveLeft() {
        if(canMoveLeft(){
            setCellCatch(line,column -1);
        }
    }

    public int getNumBox() {
        return this.numBox;
    }

    public void setCellCatch(int line1, int column1) {
        //LIMPA A CELULA
        matrix[this.line][this.column] = 0;

        //METE O AGENTE NA CELULA
        matrix[line1][column1] = 1;

        nrSteps++;


    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setGoal(int line, int column) {
        goalPosition = new Cell(line,column);
    }

    public Cell getGoal(){
        return goalPosition;
    }

    public int getSteps() {
        return nrSteps;
    }

    public int getSize() {
        return matrix.length;
    }

    public Color getCellColor(int line, int column) {
        switch (matrix[line][column]) {
            case Properties.BOX:
                return Properties.COLORBOX;
            case Properties.CATCH:
                return Properties.COLORCATCH;
            case Properties.DOOR:
                return Properties.COLORDOOR;
            case Properties.WALL:
                return Properties.COLORWALL;
            default:
                return Properties.COLOREMPTY;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof CatchState)) {
            return false;
        }

        CatchState o = (CatchState) other;
        if (matrix.length != o.matrix.length) {
            return false;
        }

        return Arrays.deepEquals(matrix, o.matrix);
    }

    @Override
    public int hashCode() {
        return 97 * 7 + Arrays.deepHashCode(this.matrix);
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            buffer.append('\n');
            for (int j = 0; j < matrix.length; j++) {
                buffer.append(matrix[i][j]);
                buffer.append(' ');
            }
        }
        return buffer.toString();
    }

    @Override
    public CatchState clone() {
        //TODO
        throw new UnsupportedOperationException("Not implemented at");
    }

    //Listeners
    private final ArrayList<EnvironmentListener> listeners = new ArrayList<>();

    public synchronized void addEnvironmentListener(EnvironmentListener l) {
        if (!listeners.contains(l)) {
            listeners.add(l);
        }
    }

    public synchronized void removeEnvironmentListener(EnvironmentListener l) {
        listeners.remove(l);
    }

    public void fireUpdatedEnvironment() {
        for (EnvironmentListener listener : listeners) {
            listener.environmentUpdated();
        }
    }

}
