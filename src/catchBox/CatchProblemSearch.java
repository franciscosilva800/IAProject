package catchBox;

import agentSearch.Action;
import agentSearch.Problem;

import java.util.ArrayList;
import java.util.List;

public class CatchProblemSearch<S extends CatchState> extends Problem<S> {
    //TODO this class might require the definition of additional methods and/or attributes

    //private final CatchState goalState;
    private ArrayList<Action> actions;

    public CatchProblemSearch(S initialCatchState, Cell goalPosition) {
        super(initialCatchState);
        initialCatchState.setGoal(goalPosition.getLine(),goalPosition.getColumn());
        //this.goalState = new CatchState(new)
        actions = new ArrayList<>(4);
        actions.add(new ActionUp());
        actions.add(new ActionRight());
        actions.add(new ActionDown());
        actions.add(new ActionLeft());


    }

    @Override
    public List<S> executeActions(S state) {
        ArrayList<S> sucessors = new ArrayList<>(4);
        S sucessor;
        for (Action action : actions) {
            if(action.isValid(state)){
                sucessor = (S) state.clone();
                action.execute(sucessor);
                sucessors.add(sucessor);

            }
        }

        /*DEVOLVER LISTA DE ESTADOS SUCESSORES*/
        return sucessors;
    }

    public boolean isGoal(S state) {
        //return goalState.equals(state);
        return true;
    }
}
