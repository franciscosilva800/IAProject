package catchBox;

import agentSearch.Action;
import agentSearch.State;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CatchState extends State implements Cloneable {

    protected int[][] matrix;
    private int lineCatch;
    private int columnCatch;
    private int numBox;
    private int lineGoal;
    private int columnGoal;
    private int nrSteps;

    public int getLineCatch() {
        return lineCatch;
    }

    public int getColumnCatch() {
        return columnCatch;
    }

    public CatchState(int[][] matrix) {
        this.matrix = new int[matrix.length][matrix.length];
        numBox = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                this.matrix[i][j] = matrix[i][j];
                if(this.matrix[i][j] == Properties.CATCH) {
                    lineCatch = i;
                    columnCatch = j;
                }
                if(this.matrix[i][j] == Properties.BOX){
                    numBox++;
                }
            }
        }
        nrSteps = 0;

    }

    public void executeAction(Action action) {
        action.execute(this);
        fireUpdatedEnvironment();

    }

    public int computeDistance(Cell goalCell){

        return Math.abs(goalCell.getLine() - lineCatch) + Math.abs(goalCell.getColumn() - columnCatch);
    }

    public boolean canMoveUp() {
        if(lineCatch == 0 || matrix[lineCatch-1][columnCatch] == Properties.WALL){
            return false;
        }

        return true;
    }

    public boolean canMoveRight() {
        if(columnCatch == matrix[lineCatch].length-1 || matrix[lineCatch][columnCatch +1] == Properties.WALL){
            return false;
        }

        return true;
    }

    public boolean canMoveDown() {
        if(lineCatch == matrix.length-1  || matrix[lineCatch+1][columnCatch] ==Properties.WALL ){
            return false;
        }

        return true;
    }

    public boolean canMoveLeft() {
        if(columnCatch == 0  || matrix[lineCatch][columnCatch-1] == Properties.WALL){
            return false;
        }

        return true;
    }

    public void moveUp() {
        if(canMoveUp()){
            setCellCatch(lineCatch -1, columnCatch);
        }
    }

    public void moveRight() {
        if(canMoveRight()){
            setCellCatch(lineCatch, columnCatch +1);
        }
    }

    public void moveDown() {
        if(canMoveDown()){
            setCellCatch(lineCatch +1, columnCatch);
        }
    }

    public void moveLeft() {
        if(canMoveLeft()){
            setCellCatch(lineCatch, columnCatch -1);
        }
    }

    public int getNumBox() {
        return this.numBox;
    }

    public void setCellCatch(int line1, int column1) {
        //LIMPA A CELULA
        matrix[this.lineCatch][this.columnCatch] = Properties.EMPTY;

        //METE O AGENTE NA CELULA
        matrix[line1][column1] = Properties.CATCH;
        lineCatch = line1;
        columnCatch = column1;

        nrSteps++;


    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setGoal(int line, int column) {
        this.lineGoal = line;
        this.columnGoal = column;
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
        return new CatchState(this.matrix);
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
