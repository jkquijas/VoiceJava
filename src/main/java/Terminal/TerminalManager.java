/*
*Colors Manager Class
*/
package Terminal;
import java.io.PrintStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
public class TerminalManager{

    public TerminalManager(){
    }

    /**
     * Print the game onto the terminal
     * @param s String representation of the game's configuration
     */
    public void printTerminal(String s){
        PrintStream out;
        try {
            out = new PrintStream(System.out, true, "UTF-8");
            out.println(s);
        } catch (UnsupportedEncodingException e){
            System.out.println("Failed to create PrintStream, used for printing the unicode characters on grid");
            System.out.println(e);
        }
    }
}

