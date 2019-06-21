package ga.geneticOperators;

import ga.IntVectorIndividual;
import ga.Problem;

import static ga.GeneticAlgorithm.random;


public class MutationPartialInversion<I extends IntVectorIndividual, P extends Problem<I>> extends Mutation<I, P> {


    public MutationPartialInversion(double probability) {
        super(probability);
    }

    @Override
    public void mutate(I individual) {

        int numGenes = individual.getNumGenes();
        int  random1,random2,j=0;

        I ind2 =(I) individual.clone();

        do{
            random1 = random.nextInt(numGenes);
            random2 = random.nextInt(numGenes);
        }while(random1 == random2);

        int minVal = j = (random1 < random2) ? random1 : random2;
        int maxVal = (random1 > random2) ? random1 : random2;


        for(int i = maxVal; i >= minVal; i--){
            individual.setGene(j,ind2.getGene(i));
            j++;
        }


    }

    @Override
    public String toString() {
        return "Partial Inversion";
    }
}