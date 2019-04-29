package catchBox;

import agentSearch.Problem;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class CatchProblemSearch<S extends CatchState> extends Problem<S> {
    //TODO this class might require the definition of additional methods and/or attributes

    public CatchProblemSearch(S initialCatchState, Cell goalPosition) {
        super(initialCatchState);

        //TODO
        throw new NotImplementedException();
    }

    @Override
    public List<S> executeActions(S state) {
        //TODO
        throw new NotImplementedException();
    }

    public boolean isGoal(S state) {
        //TODO
        throw new NotImplementedException();
    }
}
