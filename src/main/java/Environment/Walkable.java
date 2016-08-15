package Environment;

/**
 * Created by Jona Q on 8/12/2016.
 */
public class Walkable extends GridSquare {
    public Walkable(int ii, int jj){
        super(ii, jj);
        this.walkable = true;
    }

    public Walkable(int ii, int jj, String img){
        super(ii, jj, img);
        this.walkable = true;
    }
}

/**
 * Lethal Walkable class
 */
class LethalSquare extends Walkable{

    static final String HOLE  = " ? ";
    static final String FLAME = " ? ";
    static final String WATER = " ? ";
    static final String [] IMAGES = {HOLE, FLAME, WATER};
    static final int NUM_IMAGES = IMAGES.length;
    LethalSquare(int ii, int jj){
        super(ii, jj);
    }
    LethalSquare(int ii, int jj, String img){
        super(ii, jj, img);
    }
}

class Road extends Walkable {

    static final String[] IMAGES = {" ═ ", " ║ ", " ╔ ", " ╗ ", " ╚ ", " ╝ ", " ╠ ",
            " ╣ ", " ╦ ", " ╩ ", " ╬ "};
    static final int NUM_IMAGES = IMAGES.length;
    Road(int ii, int jj) {
        super(ii, jj);
    }
}

/**
 * Ground walkable grid square e.g. grass, leaves, etc
 */
class GroundSquare extends Walkable {


    static final String[] IMAGES = {" ☙ ", " 🌱 ", " 🌾 ", " 🌿 ", " ☘ ", " 🍀 ", " 🍁 ", " 🍂 "};
    static final int NUM_IMAGES = IMAGES.length;

    public GroundSquare(int ii, int jj) {
        super(ii, jj);
    }
    public GroundSquare(int ii, int jj, String img) {
        super(ii, jj, img);
    }

}

/**
 * Flower walkable grid square
 */
class FlowerSquare extends Walkable{

    static final String [] IMAGES = { " ⚘ ", " 💮 ", " 🌷 ", " 🌸 ", " 🌹 ", " 🌺 ", " 🌻 ", " 🌼 ", " 🎕 ", " 🏵 ", " 🏶 "};
    static final int NUM_IMAGES = IMAGES.length;
    FlowerSquare(int ii, int jj){
        super(ii, jj);
    }
    FlowerSquare(int ii, int jj, String img){
        super(ii, jj, img);
    }
}

/**
 * Super class of any item that may be picked up. Inherits from Walkable
 */
class Item extends Walkable{
    static final String PICKED_UP = " ⛶ ";
    boolean pickedUp;

    public Item(int ii, int jj){
        super(ii, jj);
        this.pickedUp = false;
    }

    void pickUp(){
        this.pickedUp = true;
        this.image = PICKED_UP;
    }
    boolean isPickedUp(){
        return this.pickedUp;
    }
}

/**
 * Weapon item, inherits from Item class
 */
class Weapon extends Item {
    static final String SICKLE = " ☭ ";
    static final String SWORD = " 🗡 ";
    static final String DUAL_SWORDS = " ⚔ ";
    static final String MACHETE = " 🔪 ";
    //	Blunt & Misc
    static final String HAMMER = " 🔨 ";
    static final String PICK = " ⛏ ";
    static final String CAESTUS = " ✊ ";
    //	Staffs
    static final String STAFF_1 = " ⚕ ";
    static final String STAFF_2 = " ⚚ ";
    static final String STAFF_3 = " ☤ ";
    //	Shields
    static final String SHIELD_HOLY = " ⛨ ";
    static final String SHIELD_LIGHT = " ⛊ ";
    static final String SHIELD_DARK = " ⛉ ";
    static final String SHIELD_GREAT = " 🛡 ";

    static final String [] IMAGES = { SICKLE, HAMMER, SWORD, DUAL_SWORDS, PICK, CAESTUS,
            SHIELD_HOLY, SHIELD_LIGHT, SHIELD_DARK, SHIELD_GREAT };
    static final int NUM_IMAGES = IMAGES.length;

    public Weapon(int ii, int jj) {
        super(ii, jj);
    }
}

/**
 * Faith item. Needed for the Voice.
 * Inherits from Item class.
 */
class FaithItem extends Item{
    static final String CROSS_1 = " ☥ ";
    static final String CROSS_2 = " ☦ ";
    static final String CROSS_3 = " ☨ ";
    static final String CROSS_4 = " ☩ ";
    static final String STAR_CRESCENT = " ☪ ";
    static final String YIN_YANG = " ☯ ";
    static final String PENTAGRAM = " ⛧ ";
    static final String [] IMAGES = { CROSS_1, CROSS_2, CROSS_3, CROSS_4,STAR_CRESCENT, YIN_YANG, PENTAGRAM };
    static final int NUM_IMAGES = IMAGES.length;
    FaithItem(int ii, int jj) {
        super(ii, jj);
    }
}

/**
 * Food item needed for health regeneration and hunger depletion.
 * Inherits from Item class.
 */
class Food extends Item{

    //	Fruits
    static final String APPLE_RED   = " 🍎 ";
    static final String APPLE_GREEN = " 🍏 ";
    static final String TOMATO      = " 🍅 ";
    static final String TANGERINE   = " 🍊 ";
    static final String GRAPES      = " 🍇 ";
    static final String MELON       = " 🍈 ";
    static final String BANANA      = " 🍌 ";
    static final String LEMON       = " 🍋 ";
    static final String PINEAPPLE   = " 🍍 ";
    static final String PEAR        = " 🍐 ";
    static final String PEACH       = " 🍑 ";
    static final String CHERRIES    = " 🍒 ";
    static final String STRAWBERRY  = " 🍓 ";
    static final String AUBERGINE   = " 🍆 ";
    //	Carbs
    static final String RICE        = " 🍙 ";
    static final String BREAD       = " 🍞 ";
    static final String POT_OF_FOOD = " 🍲 ";
    static final String POTATO      = " 🍠 ";
    static final String ODEN = " 🍢 ";
    //	Nuts & Spices
    static final String CHESTNUT = " 🌰 ";
    static final String MAIZE = " 🌽 ";
    static final String PEPPER = " 🌶 ";
    static final String MUSHROOM = " 🍄 ";
    //	Meats
    static final String MEAT_ON_BONE = " 🍖 ";
    static final String POULTRY_LEG = " 🍗 ";
    //	Drinks
    static final String WATER = " ⛲ ";
    static final String WINE = " 🍷 ";
    static final String TEA = " 🍵 ";
    static final String SAKE = " 🍶 ";
    static final String BEER = " 🍺 ";
    static final String [] IMAGES = { APPLE_RED, APPLE_GREEN, TOMATO, TANGERINE, GRAPES, MELON, BANANA, LEMON, PINEAPPLE, PEAR,
            PEACH, CHERRIES, STRAWBERRY, AUBERGINE, RICE, BREAD, POT_OF_FOOD, POTATO, ODEN, CHESTNUT, MAIZE, PEPPER,
            MUSHROOM, MEAT_ON_BONE, POULTRY_LEG, WATER, WINE, TEA, SAKE, BEER };
    static final int NUM_IMAGES = IMAGES.length;

    Food(int ii, int jj){
        super(ii, jj);
    }
}

