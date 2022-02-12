package hohn_tanner.savannah;


import javafx.scene.control.Button;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

public class TileView extends Button implements PropertyChangeListener {

    private Tile tile;
    private int xCoor;
    private int yCoor;

    public TileView(String s,int x, int y, Tile t) {
        super(s);
        xCoor = x;
        yCoor = y;
        tile = t;
        tile.addObserver(this);
        this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }

    public int getX(){ return xCoor; }

    public int getY(){ return yCoor; }

    public Tile getTile(){return tile;}

    @Override //GRADING: OBSERVE
    public void propertyChange(PropertyChangeEvent evt) {
        if (Objects.equals(evt.getPropertyName(), "setAnimal"))
        {

        }
        setText("observed??");
    }
}
