package Environment;

import java.util.Random;

/**
 * Created by Jona Q on 8/12/2016.
 */
public class TimeManager {
    private int hour;
    final static int DAY_LENGTH = 24;
    final static int NOON = DAY_LENGTH / 2;

    public TimeManager(){
        Random rnd = new Random();
        this.hour = rnd.nextInt(DAY_LENGTH);
    }

    /**
     * Contructs an instance of a TimeManager object
     * @param hour_ Hour to initialized day to.
     */
    public TimeManager(int hour_){
        this.hour = hour_;
    }

    /**
     *
     * @return  Current hour
     */
    public int getHour(){
        return this.hour;
    }
    /**
     * Increases day's hour by one. Resets hour to 1 if increment equaled (dayLength + 1)
     */
    public void incHour(){
        this.hour++;
        if(this.hour == DAY_LENGTH)
            this.hour = 0;
    }

    /**
     *
     * @return  True if hour is less than or equal to noon
     */
    boolean isDay(){
        return this.hour < NOON;
    }

}
