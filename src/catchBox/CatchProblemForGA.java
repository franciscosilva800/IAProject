package catchBox;

import ga.Problem;

import java.util.Hashtable;
import java.util.LinkedList;

public class CatchProblemForGA implements Problem<CatchIndividual> {
    private LinkedList<Cell> cellBoxes;
    private Hashtable<String,Integer> pairs;
    private Cell cellCatch, door;
    private int size;

    public CatchProblemForGA(LinkedList<Cell> cellBoxes, LinkedList<Pair> pairsList, Cell cellCatch, Cell door) {
        String key = null;
        this.cellBoxes = cellBoxes;
        this.pairs = new Hashtable<>();

        /*PASSA A LINKEDLIST PARA A HASTABLE*/
        for (Pair pair : pairsList) {
            key = pair.getCell1().toString() + '#' + pair.getCell2().toString();
            pairs.put(key,pair.getValue());
        }

        this.cellCatch = cellCatch;
        this.door = door;
        this.size = cellBoxes.size();
    }

    public int getDistanceBetweenCells(Cell origin, Cell destiny) {
        return pairs.get(origin.toString() + '#' + destiny.toString()) != null ? pairs.get(origin.toString() + '#' + destiny.toString()) : pairs.get(destiny.toString()+ '#' + origin.toString());
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

    public Hashtable<String, Integer> getPairs() {
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
