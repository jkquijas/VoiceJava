package Environment;

/**
 * Created by Jona Q on 8/12/2016.
 */
public class NonWalkable extends GridSquare{
    public NonWalkable(int ii, int jj){
        super(ii, jj);
        this.walkable = false;
    }
    public NonWalkable(int ii, int jj, String img){
        super(ii, jj, img);
        walkable = false;
    }
}

/**
 * SkySquare
 */
class SkySquare extends NonWalkable{
    static final String RAIN = " ⛆ ";
    static final String SNOW = " ❄ ";
    static final String FOG = " 🌫 ";
    static final String WIND_1 = " 🍃 ";
    static final String WIND_2 = " 🌬 ";
    static final String [] IMAGES = { RAIN, SNOW, FOG, WIND_1, WIND_2 };
    static final int NUM_IMAGES = IMAGES.length;

    public SkySquare(int ii, int jj){
        super(ii, jj);
    }
    public SkySquare(int ii, int jj, String img){
        super(ii, jj, img);
    }
}

class WeatherSquare extends SkySquare{
    static final String RAIN = " ⛆ ";
    static final String SNOW = " ❄ ";
    static final String FOG = " 🌫 ";
    static final String WIND_1 = " 🍃 ";
    static final String WIND_2 = " 🌬 ";
    static final String [] IMAGES = { RAIN, SNOW, FOG, WIND_1, WIND_2 };
    static final int NUM_IMAGES = IMAGES.length;

    public WeatherSquare(int ii, int jj){
        super(ii, jj);
    }

    public WeatherSquare(int ii, int jj, String img){
        super(ii, jj, img);
    }
}
/**
 * Star grid square
 */
class Star extends SkySquare {
    static final String STARS_1 = " 🌌 ";
    static final String STARS_2 = " 🌠 ";
    static final String COMET = " ☄ ";
    static final String[] IMAGES = {STARS_1, STARS_2, COMET};
    static final int NUM_IMAGES = IMAGES.length;

    public Star(int ii, int jj) {
        super(ii, jj);
    }
    public Star(int ii, int jj, String img) {
        super(ii, jj, img);
    }
}

/**
 * Sun grid square
 */
class Sun extends SkySquare{
    static final String SUN_CLOUD = " ⛅ ";
    static final String SUN_CLOUD_RAIN = " 🌦 ";
    static final String SUN_MOUNTAIN = " 🌄 ";
    static final String SUN_HILL = " 🌅 ";
    static final String SUN_1 = " ☼ ";
    static final String SUN_2 = " ☀ ";
    static final String RAINBOW = " 🌈 ";
    static final String [] IMAGES = { SUN_CLOUD, SUN_CLOUD_RAIN, SUN_MOUNTAIN, SUN_HILL, SUN_1, SUN_2, RAINBOW };
    static final int NUM_IMAGES = IMAGES.length;

    public Sun(int ii, int jj){
        super(ii, jj);
    }
    public Sun(int ii, int jj, String img){
        super(ii, jj, img);
    }

}

class Cloud extends SkySquare{
    static final String CLOUD_NORMAL = " ☁ ";
    static final String CLOUD_THUNDER_RAIN = " ⛈ ";
    static final String CLOUD_LIGHTNING = " 🌩 ";
    static final String CLOUD_TORNADO = " 🌪 ";
    static final String CLOUD_SNOW = " 🌨 ";
    static final String CLOUD_RAIN = " 🌧 ";

    static final String [] IMAGES = {CLOUD_NORMAL, CLOUD_THUNDER_RAIN, CLOUD_LIGHTNING, CLOUD_TORNADO, CLOUD_SNOW, CLOUD_RAIN };
    static final int NUM_IMAGES = IMAGES.length;

    Cloud(int ii, int jj){
        super(ii, jj);
    }
    Cloud(int ii, int jj, String img){
        super(ii, jj, img);
    }
}

class Moon extends SkySquare{
    static final String MOON_NEW = " \uD83C\uDF11 ";
    static final String MOON_WAXING_CRESCENT = " 🌒 ";
    static final String MOON_FIRST_QUARTER = "  🌓 ";
    static final String MOON_WAXING_GIBBOUS = " 🌔 ";
    static final String MOON_FULL = " 🌕 ";
    static final String MOON_WANING_GIBBOUS = " 🌖 ";
    static final String MOON_LAST_QUARTER = " 🌗 	";
    static final String MOON_WANING_CRESCENT = " 🌘 ";
    static final String CRESCENT_MOON = " 🌙 ";

    static final String [] IMAGES = { MOON_NEW, MOON_WAXING_CRESCENT, MOON_FIRST_QUARTER, MOON_WAXING_GIBBOUS,
            MOON_FULL, MOON_WANING_GIBBOUS, MOON_LAST_QUARTER, MOON_WANING_CRESCENT, CRESCENT_MOON };
    static final int NUM_IMAGES = IMAGES.length;


    public Moon(int ii, int jj){
        super(ii, jj);
    }

    public Moon(int ii, int jj, String img){
        super(ii, jj, img);
    }
}

/**
 * Castle square NonWalkable
 */
class CastleSquare extends NonWalkable{
    static final String CASTLE_1 = " \uD83C\uDFF0 ";
    static final String TOWER_1 = " ♖ ";
    static final String TOWER_2 = " ♜ ";
    static final String CHURCH = " ⛪ ";
    static final String CASTLE_2 = " ۩ ";

    static final String [] IMAGES = { CASTLE_1, CASTLE_2, TOWER_1, TOWER_2, CHURCH };
    static final int NUM_IMAGES = IMAGES.length;

    public CastleSquare(int ii, int jj){
        super(ii, jj);
    }

    public CastleSquare(int ii, int jj, String img){
        super(ii, jj, img);
    }
}

/**
 * Mountain square.
 * Inherits from NonWalkable
 */
class MountainSquare extends NonWalkable{
    static final String MOUNTAIN_1 = " ⛰ ";
    static final String MOUNTAIN_2 = " 🏔 ";
    static final String MOUNTAIN_3 = " 🌋 ";
    static final String [] IMAGES = { MOUNTAIN_1, MOUNTAIN_2, MOUNTAIN_3 };
    static final int NUM_IMAGES = IMAGES.length;

    MountainSquare(int ii, int jj){
        super(ii, jj);
    }
    MountainSquare(int ii, int jj, String img){
        super(ii, jj, img);
    }
}

/**
 * Tree square grid.
 * Inherits from NonWalkable
 */
class ForestSquare extends NonWalkable{
    static final String TREE_PINE = " \uD83C\uDF32 ";
    static final String TREE_DECIDUOUS = " \uD83C\uDF33 ";
    static final String [] IMAGES = { TREE_PINE, TREE_DECIDUOUS};
    static final int NUM_IMAGES = IMAGES.length;

    ForestSquare(int ii, int jj){
        super(ii, jj);
    }
    ForestSquare(int ii, int jj, String img){
        super(ii, jj, img);
    }
}

class DesertSquare extends NonWalkable{
    static final String TREE_PALM = " \uD83C\uDF34 ";
    static final String TREE_CACTUS = " \uD83C\uDF35 ";

    static final String [] IMAGES = { TREE_PALM, TREE_CACTUS};
    static final int NUM_IMAGES = IMAGES.length;

    DesertSquare(int ii, int jj){
        super(ii, jj);
    }
    DesertSquare(int ii, int jj, String img){
        super(ii, jj, img);
    }
}