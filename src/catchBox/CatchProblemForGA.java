package catchBox;

import ga.Problem;

import java.util.LinkedList;

public class CatchProblemForGA implements Problem<CatchIndividual> {
    private LinkedList<Cell> cellBoxes;
    private LinkedList<Pair> pairs;
    private Cell cellCatch, door;
    private int size;

    public CatchProblemForGA(LinkedList<Cell> cellBoxes, LinkedList<Pair> pairs, Cell cellCatch, Cell door) {
        this.cellBoxes = cellBoxes;
        this.pairs = pairs;
        this.cellCatch = cellCatch;
        this.door = door;
    }

    @Override
    public CatchIndividual getNewIndividual() {
        return new CatchIndividual(this,size);
    }

    @Override
    public String toString() {
        //TODO
        throw new UnsupportedOperationException("Not implemented at");
    }
}
