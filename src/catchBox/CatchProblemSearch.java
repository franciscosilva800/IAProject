package catchBox;

import agentSearch.Problem;

import java.util.List;

public class CatchProblemSearch<S extends CatchState> extends Problem<S> {
    //TODO this class might require the definition of additional methods and/or attributes
    private Cell goalPosition;
    public CatchProblemSearch(S initialCatchState, Cell goalPosition) {
        super(initialCatchState);
        this.goalPosition = goalPosition;
        //TODO
        throw new UnsupportedOperationException("Not implemented at");
    }

    @Override
    public List<S> executeActions(S state) {
        //TODO
        throw new UnsupportedOperationException("Not implemented at");
    }

    public boolean isGoal(S state) {
        return goalPosition.equals(state.getGoal());
    }
}
