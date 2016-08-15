






import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;

import Environment.EnvironmentManager;
import Agent.*;
import GameManager.GameManager;
import Terminal.*;

public class Voice{

    public static void main(String args[]){
        /*Agent agent = new Agent(5, 6);
        EnvironmentManager environmentManager = new EnvironmentManager();
        environmentManager.generateEnvironment(EnvironmentManager.CASTLE);
        TerminalManager tm = new TerminalManager();
        tm.printTerminal(environmentManager.toString());*/

        GameManager gm = new GameManager();

        JFrame frame = new JFrame("Voice");
        frame.getContentPane().add(gm);
        frame.setFont(new Font("Lucida Console", Font.PLAIN, 11));
        frame.setBackground(Color.DARK_GRAY);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        //  Run the game
        while(true) {
            gm.repaint();
            try {
                Thread.sleep(100);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}


