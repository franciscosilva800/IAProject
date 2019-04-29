package catchBox;

import agentSearch.Action;
import agentSearch.State;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CatchState extends State implements Cloneable {
    //TODO this class might require the definition of additional methods and/or attributes

    protected int[][] matrix;

    public CatchState(int[][] matrix) {
        //TODO
        throw new NotImplementedException();
    }

    public void executeAction(Action action) {
        action.execute(this);
        // TODO
        fireUpdatedEnvironment();

        throw new NotImplementedException(); // delete after implementing
    }

    public boolean canMoveUp() {
        //TODO
        throw new NotImplementedException();
    }

    public boolean canMoveRight() {
        //TODO
        throw new NotImplementedException();
    }

    public boolean canMoveDown() {
        //TODO
        throw new NotImplementedException();
    }

    public boolean canMoveLeft() {
        //TODO
        throw new NotImplementedException();
    }

    public void moveUp() {
        //TODO
        throw new NotImplementedException();
    }

    public void moveRight() {
        //TODO
        throw new NotImplementedException();
    }

    public void moveDown() {
        //TODO
        throw new NotImplementedException();
    }

    public void moveLeft() {
        //TODO
        throw new NotImplementedException();
    }

    public int getNumBox() {
        //TODO
        throw new NotImplementedException();
    }

    public void setCellCatch(int line, int column) {
        //TODO
        throw new NotImplementedException();
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setGoal(int line, int column) {
        //TODO
        throw new NotImplementedException();
    }

    public int getSteps() {
        //TODO
        throw new NotImplementedException();
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
        throw new NotImplementedException();
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
