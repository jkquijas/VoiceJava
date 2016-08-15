package Environment;

/**
 * Created by Jona Q on 8/12/2016.
 */
public class GridSquare {

    protected int i;
    protected int j;
    protected boolean walkable;
    protected String image;

    static final String [] IMAGES = {};
    static final int NUM_IMAGES = 0;

    public GridSquare(int ii, int jj){
        this.i = ii;
        this.j = jj;
    }

    public GridSquare(int ii, int jj, String img){
        this.i = ii;
        this.j = jj;
        this.image = img;
    }

    /**
     *
     * @param img   image's image String
     */
    public void setImage(String img) {
        this.image = img;
    }
    public String getImage(){
        return this.image;
    }
    public boolean isWalkable(){
        return this.walkable;
    }


}