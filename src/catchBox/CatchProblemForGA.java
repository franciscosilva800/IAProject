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
        this.size = cellBoxes.size();
    }

    public int getDistanceBetweenCells(Cell origin, Cell destiny) {
        for (Pair pair : pairs) {
            if ((pair.getCell1().equals(origin) && pair.getCell2().equals(destiny))||(pair.getCell1().equals(destiny) && pair.getCell2().equals(origin))){
                return pair.getValue();
            }
        }
        return 0;
    }

    @Override
    public CatchIndividual getNewIndividual() {
        return new CatchIndividual(this,size);
    }

    public int getNrCellBoxes() {
        return cellBoxes.size();
    }

    public Cell getCellCatch() {
        return cellCatch;
    }

    public Cell getDoor() {
        return door;
    }

    public LinkedList<Pair> getPairs() {
        return pairs;
    }

    public LinkedList<Cell> getCellBoxes(){
        return this.cellBoxes;
    }

    @Override
    public String toString() {
        return "CatchProblemForGA";
    }
}
