package ga.geneticOperators;

import ga.IntVectorIndividual;
import ga.Problem;

import static ga.GeneticAlgorithm.random;

public class MutationSwitchAndShift<I extends IntVectorIndividual, P extends Problem<I>> extends Mutation<I, P> {

    public MutationSwitchAndShift(double probability) {
        super(probability);
    }


    @Override
    public void mutate(I individual) {
        int numGenes = individual.getNumGenes();
        int random1, random2;

        do{
            random1 = random.nextInt(numGenes);
            random2 = random.nextInt(numGenes);
        }while(random1 == random2);


        int minVal = (random1 < random2) ? random1 : random2;
        int maxVal = (random1 > random2) ? random1 : random2;

        int geneAux = individual.getGene(maxVal);

        for (int i = maxVal; i > minVal + 1; i--) {
            individual.setGene(i, individual.getGene(i-1));
        }

        individual.setGene(minVal+1, geneAux);

    }

    @Override
    public String toString() {
        return "Switch And Shift";
    }
}