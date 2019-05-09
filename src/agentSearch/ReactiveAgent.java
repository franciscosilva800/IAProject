package reactiveAgent;

import java.awt.Color;

public class ReactiveAgent implements Agent {

    private Cell cell;
    private Cell previousCell;
    private int nrChecks;

    public ReactiveAgent(Cell cell) {
        this.cell = cell;
        this.cell.setAgent(this);
        this.nrChecks = Integer.MAX_VALUE;
    }

    public void act(Environment environment) {
        Perception perception = buildPerception(environment);
        Action action = decide(perception);
        execute(action, environment);
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.previousCell = this.cell;
        this.cell.setAgent(null);
        this.cell.incrementChecked();
        this.cell = cell;
        this.cell.setAgent(this);

        this.cell.setGarbage(null);
    }

    public Color getColor() {
        return Color.BLACK;
    }

    private Perception buildPerception(Environment environment) {
        return new Perception(
                environment.getNorthCell(cell),
                environment.getSouthCell(cell),
                environment.getEastCell(cell),
                environment.getWestCell(cell));
    }

    private Action decide(Perception perception) {
        // todo modify to improve the ReactiveAgent's decision process

        //SE PUDER VAI PARA WEST
        //ELSE NORTH
        //ELSE EAST
        //ELSE SOUTH
        Cell w = perception.getW();
        Cell n = perception.getN();
        Cell e = perception.getE();
        Cell s = perception.getS();

        Action actionEscolhida = null;
        int minNumVezes = Integer.MAX_VALUE;

        if(w != null && w.hasGarbage() ){
            return Action.WEST;
        }
        if(n != null && n.hasGarbage()){
            return Action.NORTH;
        }

        if(e != null && e.hasGarbage()){
            return Action.EAST;
        }

        if(w != null && !w.hasWall() &&  w.getChecked() < minNumVezes ) {
            minNumVezes = w.getChecked();
            actionEscolhida = Action.WEST;
        }

        if(n != null && !n.hasWall()  && n.getChecked() < minNumVezes){
            minNumVezes = n.getChecked();
            actionEscolhida = Action.NORTH;
        }

        if(e != null && !e.hasWall() && e.getChecked() < minNumVezes){
            minNumVezes = e.getChecked();
            actionEscolhida = Action.EAST;
        }

        if(s != null && !s.hasWall() && s.getChecked() < minNumVezes){
            minNumVezes = s.getChecked();
            actionEscolhida = Action.SOUTH;
        }


        return actionEscolhida;
    }

    private void execute(Action action, Environment environment) {

        
        Cell nextCell = null;

        if (action == Action.NORTH && environment.hasNorthCell(cell)) {
            nextCell = environment.getNorthCell(cell);
        } else if (action == Action.SOUTH && environment.hasSouthCell(cell)) {
            nextCell = environment.getSouthCell(cell);
        } else if (action == Action.WEST && environment.hasWestCell(cell)) {
            nextCell = environment.getWestCell(cell);
        } else if (action == Action.EAST && environment.hasEastCell(cell)) {
            nextCell = environment.getEastCell(cell);
        }

        if (nextCell != null && !nextCell.hasWall() && !nextCell.hasAgent()) {
            setCell(nextCell);

        }

    }
}
