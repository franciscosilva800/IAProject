package ga.geneticOperators;

import ga.IntVectorIndividual;
import ga.Problem;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Mutation3<I extends IntVectorIndividual, P extends Problem<I>> extends Mutation<I, P> {

    public Mutation3(double probability) {
        super(probability);
    }

    @Override
    public void mutate(I ind) {
        //TODO
        throw new NotImplementedException();
    }

    @Override
    public String toString() {
        //TODO
        throw new NotImplementedException();
    }
}