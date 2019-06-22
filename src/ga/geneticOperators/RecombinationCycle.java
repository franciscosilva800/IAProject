package ga.geneticOperators;

import ga.IntVectorIndividual;
import ga.Problem;

import java.util.LinkedList;

public class RecombinationCycle<I extends IntVectorIndividual, P extends Problem<I>> extends Recombination<I, P> {

    private LinkedList<Integer> indexes;

    public RecombinationCycle(double probability) {
        super(probability);
        indexes = new LinkedList<>();
    }

    @Override
    public void recombine(I p1, I p2) {
        int idx = 0, item,aux;

        /*CRIA OS CICLOS*/
        do{

            indexes.add(idx);
            item = p2.getGene(idx);
            idx = p1.getIndexof(item);

        }while(!indexes.contains(idx));

        /*SUBSTITUI OS VALORES*/
        for(int i = 0; i < indexes.size(); i++){
            aux = p1.getGene(indexes.get(i));
            p1.setGene(indexes.get(i),p2.getGene(indexes.get(i)));
            p2.setGene(indexes.get(i),aux);
        }

        indexes.clear();
    }


    @Override
    public String toString() {
        return "CYCLE";

    }
}