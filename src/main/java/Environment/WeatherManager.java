package Environment;

import java.util.Random;

/**
 * Created by Jona Q on 8/12/2016.
 */
public class WeatherManager {
    static final Random RANDOM = new Random();

    //	Weather Conditions
    private boolean isCloudy;
    private boolean isRaining;
    private boolean isSnowing;
    private boolean isFoggy;
    private boolean isWindy;

    public WeatherManager(){
        generateWeather();
    }

    public WeatherManager(boolean isCloudy_, boolean isRaining_, boolean isSnowing_, boolean isFoggy_, boolean isWindy_){
        isCloudy = isCloudy_;
        isRaining = isRaining_;
        isSnowing = isSnowing_;
        isFoggy = isFoggy_;
        isWindy = isWindy_;
    }

    void generateWeather(){

        do{
            this.isCloudy = RANDOM.nextBoolean();
            this.isRaining = RANDOM.nextBoolean();
            this.isSnowing = RANDOM.nextBoolean();
            this.isFoggy = RANDOM.nextBoolean();
            this.isWindy = RANDOM.nextBoolean();
        }while(!(this.isCloudy || this.isRaining || this.isSnowing || this.isFoggy || this.isWindy));


    }

    public boolean isCloudy(){ return this.isCloudy;}

    public boolean isRaining() {return this.isRaining;}

    public boolean isSnowing() {return this.isSnowing;}

    public boolean isFoggy() {return this.isFoggy;}

    public boolean isWindy(){return this.isWindy;}

}


