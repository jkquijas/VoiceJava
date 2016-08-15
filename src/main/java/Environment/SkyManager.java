package Environment;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Jona Q on 8/12/2016.
 */
public class SkyManager{
    static final Random RANDOM = new Random();
    //	Sun/Moon Coordinates
    int iMainStar;
    int jMainStar;

    int width;
    int length;

    boolean isCloudy;
    boolean isRaining;
    boolean isSnowing;
    boolean isFoggy;
    boolean isWindy;

    boolean isDay;

    //  Grid
    GridSquare[][] sky;

    /**
     *
     * @param length_   Sky length i.e. number of rows
     * @param width_    Sky width i.e. number of columns
     * @param cloudy    Determines if sky is cloudy
     * @param raining   Determines if sky is rainy
     * @param snowing   Determines is sky is snowing
     * @param foggy     Determines if sky is foggy
     * @param day       Determines if its daytime
     */
    SkyManager (int length_, int width_, boolean cloudy, boolean raining, boolean snowing, boolean foggy, boolean windy, boolean day){

        //	Set dimensions
        this.width = width_;
        this.length = length_;

        //	Set weather conditions
        this.isCloudy = cloudy;
        this.isRaining = raining;
        this.isSnowing = snowing;
        this.isFoggy = foggy;
        this.isDay = day;
        this.isWindy = windy;
        //	"Allocate" sky
        this.sky = new SkySquare [length][width];
    }
    public void setClouds(boolean isCloudy_){ this.isCloudy = isCloudy_; }
    public void setRain(boolean isRainy_){ this.isRaining = isRainy_; }
    public void setSnow(boolean isSnowing_){ this.isSnowing = isSnowing_; }
    public void setFog(boolean isFoggy_){ this.isFoggy = isFoggy_; }
    public void setDay(boolean isDay_){ this.isDay = isDay_; }

    /**
     * This method generates a sun or moon, based on time and weather conditions
     * @param hour Integer <- [1, 12]. Dictates main star's position
     */
    void generateMainStar(int hour){
        this.iMainStar = RANDOM.nextInt(this.length);
        this.jMainStar = hour;

        //	GENERATE SUN OR MOON
        //	It's day
        //	Generate sun
        if (this.isDay){
            //	Is it cloudy?
            if (this.isCloudy){
                //	Is it also raining?
                if (this.isRaining || this.isSnowing){
                    this.sky[this.iMainStar][this.jMainStar] = new Sun(this.iMainStar, this.jMainStar, Sun.SUN_CLOUD_RAIN);
                }
                //  Is it windy?
                else if(this.isWindy){
                    this.sky[this.iMainStar][this.jMainStar] = new Sun(this.iMainStar, this.jMainStar, Sun.SUN_CLOUD);
                }
                //	Just cloudy
                else{
                    this.sky[this.iMainStar][this.jMainStar] = new Sun(this.iMainStar, this.jMainStar, Sun.SUN_CLOUD);
                }
            }
            //	It's overcast and day
            else{
                this.sky[this.iMainStar][this.jMainStar] = new Sun(this.iMainStar, this.jMainStar, Sun.SUN_2);
            }
        }
        //	It's night
        //	Generate moon
        else{
            this.sky[this.iMainStar][this.jMainStar] = new Moon(this.iMainStar, this.jMainStar, Moon.IMAGES[RANDOM.nextInt(Moon.NUM_IMAGES)]);
        }
    }

    /**
     *
     * @return  A string representation of the sky.
     * Used for printing on the terminal
     */
    public String toString(){
        String s = "";
        for (int i = 0; i < this.length; i++){
            for (int j = 0; j < this.width; j++){
                s += this.sky[i][j].getImage();
            }
            s += "\n";
        }
        s += "\n";
        return s;
    }

    void generateSky(WeatherManager weatherManager, TimeManager timeManager) {
        //	Set weather conditions
        this.isCloudy = weatherManager.isCloudy();
        this.isRaining = weatherManager.isRaining();
        this.isSnowing = weatherManager.isSnowing();
        this.isFoggy = weatherManager.isFoggy();
        this.isWindy = weatherManager.isWindy();
        this.isDay = timeManager.isDay();

        //  Generate main star
        this.generateMainStar(timeManager.getHour()%TimeManager.NOON);

        ArrayList<String> skyImages = new ArrayList<String>();

        //	Is it cloudy?
        if (this.isCloudy) {
            //	Is it also raining?
            if (this.isRaining){
                skyImages.add(Cloud.CLOUD_LIGHTNING);
                skyImages.add(Cloud.CLOUD_RAIN);
                skyImages.add(Cloud.CLOUD_THUNDER_RAIN);
                skyImages.add(Cloud.CLOUD_TORNADO);
                skyImages.add((WeatherSquare.RAIN));
            }
            //  Is it also snowing?
            if (this.isSnowing) {
                skyImages.add(Cloud.CLOUD_SNOW);
                skyImages.add(WeatherSquare.SNOW);
            }
            skyImages.add(Cloud.CLOUD_NORMAL);
        }
        //  TODO    For now, add clouds even if not cloudy
        else{
            skyImages.add(Cloud.CLOUD_NORMAL);
        }
        if (this.isFoggy) {
            skyImages.add(WeatherSquare.FOG);
        }
        else if (this.isWindy) {
            skyImages.add(WeatherSquare.WIND_1);
            skyImages.add(WeatherSquare.WIND_2);
        }
        //  If it's night overcast
        if (!this.isDay && !this.isCloudy && !this.isSnowing && !this.isRaining) {
            skyImages.add(Star.COMET);
            skyImages.add(Star.STARS_1);
            skyImages.add(Star.STARS_2);
        }

        //  Generate images
        for(int i = 0; i < this.length; i++){
            for(int j = 0; j < this.width; j++){
                if(!(i == this.iMainStar && j == this.jMainStar)){
                    int n = RANDOM.nextInt(skyImages.size());
                    this.sky[i][j] = new SkySquare(i, j, skyImages.get(n));
                }
            }
        }
    }

}