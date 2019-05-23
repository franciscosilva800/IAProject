package catchBox;

import agentSearch.Heuristic;

public class HeuristicCatch extends Heuristic<CatchProblemSearch, CatchState> {

    @Override
    public double compute(CatchState state) {
        return state.computeDistance(problem.getGoal());
    }

    @Override
    public String toString() {
        return "Heuristic: Compute Distance Between Two Points";

    }

}