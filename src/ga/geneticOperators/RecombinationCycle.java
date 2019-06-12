package ga.geneticOperators;

import ga.IntVectorIndividual;
import ga.Problem;

import java.util.LinkedList;

public class RecombinationCycle<I extends IntVectorIndividual, P extends Problem<I>> extends Recombination<I, P> {

    private LinkedList<Integer> indices;

    public RecombinationCycle(double probability) {
        super(probability);
        indices = new LinkedList<>();
    }

    @Override
    public void recombine(I p1, I p2) {
        int idx = 0, item,aux;

        /*CRIAS OS CICLOS*/
        do{

            indices.add(idx);
            item = p2.getGene(idx);
            idx = p1.getIndexof(item);

        }while(!indices.contains(idx));

        /*SUBSTITUI OS VALORES*/
        for(int i = 0; i < indices.size(); i++){
            aux = p1.getGene(indices.get(i));
            p1.setGene(indices.get(i),p2.getGene(indices.get(i)));
            p2.setGene(indices.get(i),aux);
        }
    }


    @Override
    public String toString() {
        return "CYCLE";

    }
}