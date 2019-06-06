package ga.geneticOperators;

import ga.IntVectorIndividual;
import ga.Problem;

import java.util.LinkedList;

public class RecombinationCycle<I extends IntVectorIndividual, P extends Problem<I>> extends Recombination<I, P> {

    private LinkedList<Integer> visited;
    private LinkedList<Integer> indices;
    private int[] child1, child2, segment1, segment2;


    public RecombinationCycle(double probability) {
        super(probability);
        visited = new LinkedList<>();
        indices = new LinkedList<>();
    }

    @Override
    public void recombine(I p1, I p2) {
        int idx = 0, item = 0,cycle = 1;

        /*

        i= posicao no ciclo
        j=posicao no p1


         */

        /*CRIAS OS CICLOS*/
        while(visited.size() < p1.getNumGenes()){
            item = p2.getGene(idx);
            idx = p1.getIndexof(item);


            //ADICIONA O INDICE A LISTA DE INDICES
            indices.add(idx);


            /*ENQUANTO O IDX NAO FOR O MESMO DA PRIMEIRA POSICAO*/
            while(!indices.contains(idx)){
                indices.add(idx);

                item = p2.getGene(idx);

                idx = p1.getIndexof(item);
            }

            /*ADICIONAR O CICLO AOS FILHOS*/

            /*SE O CICLO FOR IMPAR*/
            if (cycle++ % 2 != 0) {
                for (int i = 0; i < indices.size(); i++) {

                    /*CHILD 1 */
                    int position = indices.get(i);
                    item = p1.getGene(position);

                    child1[position] = item;

                    /*CHILD 2*/
                    item = p1.getGene(position);
                    position = p2.getIndexof(item);

                    child2[position] = item;

                }
            }
            visited.addAll(indices);
            indices.clear();
        }
        for (int i = 0; i < p1.getNumGenes(); i++) {
            p1.setGene(i, child1[i]);
            p2.setGene(i, child2[i]);
        }


    }


    @Override
    public String toString() {
        return "CYCLE";

    }
}