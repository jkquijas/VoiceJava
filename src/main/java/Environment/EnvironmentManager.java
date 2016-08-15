package Environment;

import java.util.ArrayList;
import java.util.Random;


/**
 * Created by Jona Q on 8/12/2016.
 */
public class EnvironmentManager {

    static final Random RND = new Random();
    static final int GROUND      = 1;
    static final int FLOWERS     = 2;
    static final int HAZARDS     = 3;
    static final int ENVIRONMENT = 4;

    static final int [] ENVIRONMENTS = {GROUND, FLOWERS, HAZARDS, ENVIRONMENT};

    static final double GROUND_PERCENT = 0.4;
    static final double FLOWERS_PERCENT = 0.1;
    static final double HAZARDS_PERCENT = 0.2;
    static final double ENVIRONMENT_PERCENT = 0.3;

    static final double[] ENVIRONMENT_PROBABILITIES = {GROUND_PERCENT, FLOWERS_PERCENT, HAZARDS_PERCENT, ENVIRONMENT_PERCENT};

    public static final int FOREST = 1;
    public static final int MOUNTAIN = 2;
    public static final int DESERT = 3;
    public static final int CASTLE = 4;

    static final int FOREST_CASTLE = 5;
    static final int MOUNTAIN_CASTLE = 6;

    public static final int GROUND_SIZE = 12;
    public static final int SKY_SIZE = 2;

    final int groundSize = GROUND_SIZE;
    final int skySize = SKY_SIZE;
    GridSquare[][] grid;

    TimeManager timeManager;
    WeatherManager weatherManager;
    SkyManager skyManager;
    ArrayList<String[]> groundImages;

    public EnvironmentManager() {
        this.weatherManager = new WeatherManager();
        this.timeManager = new TimeManager();
        this.skyManager = new SkyManager(this.skySize, this.groundSize, weatherManager.isCloudy(), weatherManager.isRaining(),
                weatherManager.isSnowing(), weatherManager.isFoggy(), weatherManager.isWindy(), this.timeManager.isDay());
        this.grid = new GridSquare[this.groundSize][this.groundSize];

        this.groundImages = new ArrayList<String[]>();
        this.groundImages.add(GroundSquare.IMAGES);
        this.groundImages.add(FlowerSquare.IMAGES);
        this.groundImages.add(LethalSquare.IMAGES);
    }

    /**
     *This class is in charge of making the environment
     * @param isCloudy_
     * @param isRaining_
     * @param isSnowing_
     * @param isFoggy_
     * @param isWindy_
     * @param hour_
     */
    public EnvironmentManager(boolean isCloudy_, boolean isRaining_, boolean isSnowing_, boolean isFoggy_, boolean isWindy_, int hour_) {
        this.weatherManager = new WeatherManager(isCloudy_, isRaining_, isSnowing_, isFoggy_, isWindy_);
        this.timeManager = new TimeManager(hour_);
        this.skyManager = new SkyManager(this.skySize, this.groundSize, isCloudy_, isRaining_, isSnowing_, isFoggy_, isWindy_, this.timeManager.isDay());
        this.grid = new GridSquare[this.groundSize][this.groundSize];

        this.groundImages = new ArrayList<String[]>();
        this.groundImages.add(GroundSquare.IMAGES);
        this.groundImages.add(FlowerSquare.IMAGES);
        this.groundImages.add(LethalSquare.IMAGES);
    }

    /**
     * This method creates the environment i.e. sets up sky, environment(ground), weather conditions, time, etc
     */
    public void generateEnvironment(int environmentType){
        this.weatherManager.generateWeather();
        this.skyManager.generateSky(this.weatherManager, this.timeManager);
        switch(environmentType){
            case FOREST:
                groundImages.add(ForestSquare.IMAGES);
                break;
            case MOUNTAIN:
                groundImages.add(MountainSquare.IMAGES);
                break;
            case DESERT:
                groundImages.add(DesertSquare.IMAGES);
                break;
            case CASTLE:
                groundImages.add(CastleSquare.IMAGES);
                break;
            default:break;
        }
        /*  Generate Environment Here */
        for (int i = 0; i < this.groundSize; i++){
            for (int j = 0; j < this.groundSize; j++){
                double p = Math.random();
                double c = 0.0;
                int idx = 0;
                while(c <= p){
                    c += ENVIRONMENT_PROBABILITIES[idx++];
                }
                switch(idx){
                    case GROUND:
                        grid[i][j] = new GroundSquare(i, j, GroundSquare.IMAGES[RND.nextInt(GroundSquare.NUM_IMAGES)]);
                        break;
                    case FLOWERS:
                        grid[i][j] = new FlowerSquare(i, j, FlowerSquare.IMAGES[RND.nextInt(FlowerSquare.NUM_IMAGES)]);
                        break;
                    case HAZARDS:
                        grid[i][j] = new LethalSquare(i, j, LethalSquare.IMAGES[RND.nextInt(LethalSquare.NUM_IMAGES)]);
                        break;
                    case ENVIRONMENT:
                        switch(environmentType) {
                            case FOREST:
                                grid[i][j] = new ForestSquare(i, j, ForestSquare.IMAGES[RND.nextInt(ForestSquare.NUM_IMAGES)]);
                                break;
                            case MOUNTAIN:
                                grid[i][j] = new MountainSquare(i, j, MountainSquare.IMAGES[RND.nextInt(MountainSquare.NUM_IMAGES)]);
                                break;
                            case DESERT:
                                grid[i][j] = new DesertSquare(i, j, DesertSquare.IMAGES[RND.nextInt(DesertSquare.NUM_IMAGES)]);
                                break;
                            case CASTLE:
                                grid[i][j] = new CastleSquare(i, j, CastleSquare.IMAGES[RND.nextInt(CastleSquare.NUM_IMAGES)]);
                                break;
                            default:
                                break;
                        }
                    default:break;
                }
            }
        }

    }

    /**
     * This method increases time by one hour.
     */
    void increaseHour(){
        this.timeManager.incHour();
    }

    public boolean isWalkable(int i, int j){
        if(this.grid[i][j].isWalkable())
            return true;
        return false;
    }

    /**
     *  Get the specified GridSquare
     * @param i Grid's ith coordinate
     * @param j Grid's jth coordinate
     * @return  The GridSquare at coordinates (i, j)
     */
    public GridSquare getSquare(int i, int j){
        return this.grid[i][j];
    }

    /**
     *
     * @return  A string representation of the whole environment, used for displaying on terminal.
     */
    public String toString() {
        String s = this.skyManager.toString();
        for (int i = 0; i < this.groundSize; i++){
            for (int j = 0; j < this.groundSize; j++){
                s += this.grid[i][j].getImage();
            }
            s += "\n";
        }
        s += "\n";
        return s;
    }
}