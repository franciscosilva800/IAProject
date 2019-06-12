package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;

import java.util.LinkedList;

public class RecombinationOrder1<I extends IntVectorIndividual, P extends Problem<I>> extends Recombination<I, P> {


    public RecombinationOrder1(double probability) {
        super(probability);
    }

    private int child1[],child2[], position1, position2;
    private LinkedList<Integer> visited;

    @Override
    public void recombine(I ind1, I ind2) {
        child1 = new int[ind1.getNumGenes()];
        child2 = new int[ind2.getNumGenes()];
        position1 = position2 = 0;

        while(position1 == position2) {
            position1 = GeneticAlgorithm.random.nextInt(ind1.getNumGenes());
            position2 = GeneticAlgorithm.random.nextInt(ind1.getNumGenes());
        }
        visited = new LinkedList<>();

        if (position1 > position2) {
            int aux = position1;
            position1 = position2;
            position2 = aux;
        }

        createSegment(ind1,ind2,child1);
        reorder(ind1,ind2,child1,true);
        createSegment(ind1,ind2,child2);
        reorder(ind1,ind2,child2,false);

        changePositions(ind1,ind2);


    }

    public void createSegment(I ind1,I ind2,int[] child){
        for(int i=position1+1;i<=position2;i++){
            child[i] = ind1.getGene(i);
            visited.add(ind1.getGene(i));
        }
    }

    public void reorder(I ind1,I ind2,int[] child,boolean isImpar){
        int fatherPos = position2+1,childPos=position2+1,count = position2-position1;

        while(count < child.length){

            if(fatherPos > ind1.getNumGenes()-1){
                fatherPos = 0;
            }

            if(childPos > child.length-1){
                childPos = 0;
            }

            if(isImpar){
                if(!visited.contains(ind2.getGene(fatherPos))){
                    child[childPos] = ind2.getGene(fatherPos);
                    visited.add(ind2.getGene(fatherPos));
                    childPos++;
                    count++;
                }
            }else{
                if(!visited.contains(ind1.getGene(fatherPos))){
                    child[childPos] = ind1.getGene(fatherPos);
                    visited.add(ind1.getGene(fatherPos));
                    childPos++;
                    count++;
                }
            }
            fatherPos++;



        }
        visited.clear();
    }

    public void changePositions(I ind1,I ind2){
        for(int i = 0; i < ind1.getNumGenes();i++){
            ind1.setGene(i,child1[i]);
            ind2.setGene(i,child2[i]);
        }
    }


    @Override
    public String toString(){
        return "ORDER1";
    }
}