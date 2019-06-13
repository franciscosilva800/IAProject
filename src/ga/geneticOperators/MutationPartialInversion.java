package ga.geneticOperators;

import ga.IntVectorIndividual;
import ga.Problem;

import static ga.GeneticAlgorithm.random;

/*
* Seleciona um numero de genes e troca as posicoes entre eles. o ultimo passa para o primeiro e assim andiante
*
* [1,2,3,4,5,6,7,8,9,10]
*
* posParaTrocar.length = 5
* randStart = 4;
*
* posParaTrocar[4,5,6,7,8];
* POS  0,1,2,3,4,5,6,7,8,9
* FIN [1,2,3,4,9,8,7,6,5,10]
*
* */

public class MutationPartialInversion<I extends IntVectorIndividual, P extends Problem<I>> extends Mutation<I, P> {


    public MutationPartialInversion(double probability) {
        super(probability);
    }

    @Override
    public void mutate(I individual) {
        //TODO
        int numGenes = individual.getNumGenes();
        int val = 2, geneAux;
        int[] posParaTrocar = new int[numGenes / val];


        int randomStart = random.nextInt();
        if (randomStart < 0){
            randomStart = -randomStart;
        }
        if (randomStart > numGenes)
            randomStart = randomStart - numGenes;


        int end = randomStart + posParaTrocar.length;


        for (int i = 0; i < posParaTrocar.length; i++) {
            posParaTrocar[i] = randomStart;
            randomStart++;

            if (end >= numGenes) {
                randomStart = 0;
            }
        }

        int j = posParaTrocar.length - 1;
        for (int i = 0; i < posParaTrocar.length / 2; i++) {
            geneAux = individual.getGene(posParaTrocar[j]);

            individual.setGene(j, individual.getGene(posParaTrocar[i]));

            individual.setGene(i, geneAux);

            j--;
        }
    }

    @Override
    public String toString() {
        return "Mutation 1";
    }
}