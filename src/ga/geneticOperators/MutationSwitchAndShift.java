package ga.geneticOperators;

import ga.IntVectorIndividual;
import ga.Problem;

import static ga.GeneticAlgorithm.random;

public class MutationSwitchAndShift<I extends IntVectorIndividual, P extends Problem<I>> extends Mutation<I, P> {

    public MutationSwitchAndShift(double probability) {
        super(probability);
    }



    /*
    * Vai buscar a posicao de 2 genes.
    * A posicao com indice menor serve de marcador
    * O gene na posicao com o indice maior vai ser colocado na posicao a seguir à do indice menor.
    * faz o shift do resto das posicoes ate à posicao do indice maior.
    * [1,2,3,4,5,6]
    * pos1 = 1, pos2 = 4;
    * val ant:     3   5
    * final : [1,2,5,3,4,6]
    * */
    @Override
    public void mutate(I individual) {
        //TODO
        int numGenes = individual.getNumGenes();

        int random1 = random.nextInt();
        int random2 = random.nextInt();

        if (random1 < 0) {
            random1 = -random1;
        } else if (random1 > numGenes) {
            random1 = random1 - numGenes;
        } else {
            random1 = numGenes - 1;
        }
        if (random2 > numGenes) {
            random2 = random2 - numGenes;
        } else if (random2 < 0) {
            random2 = -random2;
        } else {
            random2 = numGenes - 1;
        }


        int minVal = (random1 < random2) ? random1 : random2;
        int maxVal = (random1 > random2) ? random1 : random2;

        int geneAux = individual.getGene(maxVal);

        for (int i = maxVal; i > minVal + 1; i--) {
            individual.setGene(i, individual.getGene(i-1));
        }

        individual.setGene(minVal + 1, geneAux);
    }

    @Override
    public String toString() {
        //TODO
        return "Mutation 2";
    }
}