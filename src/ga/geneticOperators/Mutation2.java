package ga.geneticOperators;

import ga.IntVectorIndividual;
import ga.Problem;

import static ga.GeneticAlgorithm.random;

public class Mutation2<I extends IntVectorIndividual, P extends Problem<I>> extends Mutation<I, P> {


    public Mutation2(double probability) {
        super(probability);
    }

    @Override
    public void mutate(I individual) {
        //TODO
        int numGenes = individual.getNumGenes();
        int pos1 = numGenes / 3, pos2 = pos1 - numGenes;

        for (int i = 0; i < numGenes; i++) {

            if (i+3 >= numGenes){
                int gene = individual.getGene(i);

                individual.setGene(i, individual.getGene(i+3));
                individual.setGene(i+3, gene);

            }

        }


    }

    @Override
    public String toString() {
        //TODO
        return "Mutation 1";
    }
}