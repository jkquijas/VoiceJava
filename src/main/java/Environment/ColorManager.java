package Environment;

import java.util.Random;

/**
 * Created by Jona Q on 8/11/2016.
 */
public class ColorManager{
    private static Random rnd = new Random();
    static final String ANSI_COLOR_WHITE = "\\e[1; 37m";
    static final String ANSI_COLOR_BLACK = "\\e[0;30m";
    static final String ANSI_COLOR_RED = "\\x1b[31m";
    static final String ANSI_COLOR_GREEN = "\\x1b[32m";
    static final String ANSI_COLOR_YELLOW = "\\x1b[33m";
    static final String ANSI_COLOR_BLUE = "\\x1b[34m";
    static final String ANSI_COLOR_MAGENTA = "\\x1b[35m";
    static final String ANSI_COLOR_CYAN = "\\x1b[36m";
    static final String ANSI_COLOR_DARK_GRAY = "\\e[1;30m";
    static final String ANSI_COLOR_RESET = "\\x1b[0m";
    static final String [] COLORS = { ANSI_COLOR_WHITE, ANSI_COLOR_BLACK, ANSI_COLOR_RED, ANSI_COLOR_GREEN, ANSI_COLOR_YELLOW,
            ANSI_COLOR_BLUE, ANSI_COLOR_MAGENTA, ANSI_COLOR_CYAN, ANSI_COLOR_DARK_GRAY };

    static final int NUM_COLORS = COLORS.length;

    /**
     *
     * @param i Index integer
     * @return  Returns COLORS[i] from static color array COLORS
     */
    public static String getColor(int i) {
        return COLORS[i];
    }

    /**
     *
     * @return  Returns a random color from COLORS array
     */
    public static String getRandColor(){
        return COLORS[rnd.nextInt(NUM_COLORS)];
    }

    /**
     *
     * @return  ANSI color reset string
     */
    public static String resetColor(){
        return ANSI_COLOR_RESET;
    }
}
