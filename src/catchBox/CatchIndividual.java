package catchBox;

import ga.IntVectorIndividual;

import java.util.ArrayList;
import java.util.LinkedList;

public class CatchIndividual extends IntVectorIndividual<CatchProblemForGA, CatchIndividual> {

    public CatchIndividual(CatchProblemForGA problem, int size) {
        super(problem, size);
    }

    public CatchIndividual(CatchIndividual original) {
        super(original);
    }

    @Override
    public double computeFitness() {
        fitness = 0;
        LinkedList<Cell> boxes = problem.getCellBoxes();
        Cell agent = problem.getCellCatch();
        Cell door = problem.getDoor();


        //DISTANCIA DO AGENTE Á PRIMEIRA CAIXA
        fitness = problem.getDistanceBetweenCells(agent,boxes.get(genome[0]-1));


        //DISTANCIA DAS CAIXAS ENTRE SI
        for (int i = 1; i < genome.length-1 ; i++) {
            fitness += problem.getDistanceBetweenCells(boxes.get(genome[i]-1),boxes.get(genome[i+1]-1));
        }


        //DISTANCIA DA ULTIMA CAIXA A PORTA
        //So entra no ultimo valor
        fitness += problem.getDistanceBetweenCells(boxes.get(genome[genome.length-1]-1),door);


        return fitness;
    }


    public int[] getGenome() {
        return genome;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("fitness: ");
        sb.append(fitness);
        sb.append("\npath: ");
        for (int i = 0; i <genome.length ; i++) {
            sb.append(genome[i]).append(" ");
        }
        return sb.toString();
    }

    /**
     * @param i
     * @return 1 if this object is BETTER than i, -1 if it is WORST than I and
     * 0, otherwise.
     */
    @Override
    public int compareTo(CatchIndividual i) {
        return (this.fitness == i.getFitness()) ? 0 : (this.fitness < i.getFitness()) ? 1 : -1;
    }

    @Override
    public CatchIndividual clone() {
        return new CatchIndividual(this);

    }
}
