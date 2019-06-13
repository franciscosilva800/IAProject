package ga.geneticOperators;

import ga.IntVectorIndividual;
import ga.Problem;

import static ga.GeneticAlgorithm.random;

/*
* Seleciona um numero de genes e troca as posicoes entre eles. o ultimo passa para o primeiro e assim andiante
* */

public class Mutation2<I extends IntVectorIndividual, P extends Problem<I>> extends Mutation<I, P> {


    public Mutation2(double probability) {
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
        //TODO
        return "Mutation 1";
    }
}