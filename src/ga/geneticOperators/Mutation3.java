package ga.geneticOperators;

import ga.IntVectorIndividual;
import ga.Problem;

import static ga.GeneticAlgorithm.random;

public class Mutation3<I extends IntVectorIndividual, P extends Problem<I>> extends Mutation<I, P> {

    public Mutation3(double probability) {
        super(probability);
    }

    @Override
    public void mutate(I individual) {
        //TODO
        int numGenes = individual.getNumGenes();

        for (int i = 0; i < numGenes; i++) {
            int newValue = random.nextInt();

            for (int j = 0; j < numGenes; j++) {
                if (individual.getGene(j) == newValue){
                    newValue = random.nextInt();
                }
            }
            if (getProbability() > random.nextDouble()){


                individual.setGene(i, newValue);
            }
        }

    }

    @Override
    public String toString() {
        //TODO
        return "Mutation 2";
    }
}