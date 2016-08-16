package Agent;

import java.util.Random;

import Environment.EnvironmentManager;
import Environment.GridSquare;

/**
 * Created by Jona Q on 8/11/2016.
 */
public class Agent{
    private int i;
    private int j;
    private double health;
    private double hunger;
    private double thirst;
    private double faith;
    private double cold;
    private double heat;
    private double fear;
    private String image;

    /**
     *
     */
    public Agent(){
        this.i = EnvironmentManager.GROUND_SIZE/2;
        this.j = EnvironmentManager.GROUND_SIZE/2;

        this.health = 100.0;
        this.hunger = 0.0;
        this.thirst = 0.0;
        this.faith = 50.0;
        this.cold = 0.0;
        this.heat = 0.0;
        this.fear = 25.0;
        this.image = " \uD83D\uDEB9 ";
    }
    public Agent(int ii, int jj) {
        this.i = ii;
        this.j = jj;
        this.health = 100.0;
        this.hunger = 0.0;
        this.thirst = 0.0;
        this.faith = 50.0;
        this.cold = 0.0;
        this.heat = 0.0;
        this.fear = 25.0;
        this.image = " \uD83D\uDEB9 ";
    }

    /**
     *
     * @param ii    New row position to move the agent to
     * @param jj    New row position to move the agent to
     */
    public void movePosition(int ii, int jj) {
        this.i = ii;
        this.j = jj;
    }


    /**
     * Updates the agent's stats
     */
    public void updateStatus(){

    }

    public void takeAction(GridSquare gridSquare){

    }

}
