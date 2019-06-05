package ga;

import catchBox.Cell;
import catchBox.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class IntVectorIndividual<P extends Problem, I extends IntVectorIndividual> extends Individual<P, I> {
    protected int[] genome;
    private Random random;

    public IntVectorIndividual(P problem, int size) {
        super(problem);
        genome = new int[size];
        LinkedList<Integer> visitados = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            int r = GeneticAlgorithm.random.nextInt(size)+1;

            while (visitados.size() > 0 && visitados.contains(r)) {
                r=GeneticAlgorithm.random.nextInt(size)+1;

            }
            visitados.add(r);
            genome[i] = r;
        }

      }

    public IntVectorIndividual(IntVectorIndividual<P, I> original) {
        super(original);
        this.genome = new int[original.genome.length];
        System.arraycopy(original.genome, 0, genome, 0, genome.length);
    }

    @Override
    public int getNumGenes() {
        return genome.length;
    }

    public int getIndexof(int value){
        for (int i = 0; i < genome.length; i++) {
            if (genome[i] == value)
                return i;
        }
        return -1;
    }

    public int getGene(int index) {
        return genome[index];
    }

    public void setGene(int index, int newValue) {
        genome[index] = newValue;
    }

    @Override
    public void swapGenes(IntVectorIndividual other, int index) {
        int aux = genome[index];
        genome[index] = other.genome[index];
        other.genome[index] = aux;
    }
}
