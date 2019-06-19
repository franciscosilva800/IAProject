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

        int numGenes = individual.getNumGenes(),random1, random2;

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