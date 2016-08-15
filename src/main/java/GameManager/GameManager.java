package GameManager;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import Agent.Agent;
import Environment.EnvironmentManager;
import Environment.GridSquare;
import Terminal.TerminalManager;

/**
 * Created by Jona Q on 8/14/2016.
 */
public class GameManager extends JPanel{
    Agent agent;
    EnvironmentManager environmentManager;
    TerminalManager terminalManager;


    public GameManager(){
        this.agent = new Agent();
        this.environmentManager = new EnvironmentManager();
        this.terminalManager = new TerminalManager();
    }

    public GameManager(Agent agent_, EnvironmentManager environmentManager_, TerminalManager terminalManager_) {
        this.agent = agent_;
        this.environmentManager = environmentManager_;
        this.terminalManager = terminalManager_;
    }


    /**
     *
     * @param i Agent's new ith coordinate
     * @param j Agent's new jth coordinate
     */
    public void moveAgent(int i, int j){
        //  If valid move
        if (this.environmentManager.isWalkable(i, j)) {
            this.agent.movePosition(i, j);
            this.environmentManager.getSquare(i, j);

        }
    }

    /**
     * Print the game to the terminal
     */
    public void printGame(){
        this.terminalManager.printTerminal(this.environmentManager.toString());
    }

    void processMove(GridSquare square){
        agent.takeAction(square);
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Font font = new Font("Lucida Console", Font.PLAIN, 11);
        g2.setFont(font);
        g2.drawString(environmentManager.toString(), 120, 120);
    }

}
