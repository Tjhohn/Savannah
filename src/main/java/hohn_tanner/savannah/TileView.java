package hohn_tanner.savannah;


import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

public class TileView extends Button implements PropertyChangeListener {

    private Tile tile;
    private int xCoor;
    private int yCoor;
    private final Image none = new Image(
            Objects.requireNonNull(getClass().getResourceAsStream("Empty.jpg")), 40, 40, false, false);
    private final Image zebra = new Image(
            Objects.requireNonNull(getClass().getResourceAsStream("zebraprint.png")), 40, 40, false, false);
    private final Image cheetah = new Image(
            Objects.requireNonNull(getClass().getResourceAsStream("giraffeprint.png")), 40, 40, false, false);
    private final Image lion = new Image(
            Objects.requireNonNull(getClass().getResourceAsStream("lion.png")), 40, 40, false, false);
    private final Image elephant = new Image(
            Objects.requireNonNull(getClass().getResourceAsStream("elephant.png")), 40, 40, false, false);
    private final Image giraffe = new Image(
            Objects.requireNonNull(getClass().getResourceAsStream("giraffe.png")), 40, 40, false, false);
    private ImageView imageView;

    public TileView(String s,int x, int y, Tile t) {
        super(s);
        xCoor = x;
        yCoor = y;
        tile = t;
        tile.addObserver(this);
        this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        imageView = new ImageView(none);
        this.setGraphic(imageView);
    }

    public int getX(){ return xCoor; }

    public int getY(){ return yCoor; }

    public Tile getTile(){return tile;}

    @Override //GRADING: OBSERVE
    public void propertyChange(PropertyChangeEvent evt) {
        if (Objects.equals(evt.getPropertyName(), "setAnimal"))
        {
            setText(tile.getAnimal().getFirstLetter()+":"+ tile.getAnimal().getHealth().toString());
            imageforAnimal();
        }
        if (Objects.equals(evt.getPropertyName(), "newDay"))
        {
            setText(tile.getAnimal().getFirstLetter()+":"+ tile.getAnimal().getHealth().toString());
            imageforAnimal();
        }
    }

    private void imageforAnimal(){
        if(tile.getAnimal().getName().equals("Giraffe")){
            imageView.setImage(giraffe);
        }
        else if(tile.getAnimal().getName().equals("Cheetah")){
            imageView.setImage(cheetah);
        }
        else if(tile.getAnimal().getName().equals("Lion")){
            imageView.setImage(lion);
        }
        else if(tile.getAnimal().getName().equals("Zebra")){
            imageView.setImage(zebra);
        }
        else if(tile.getAnimal().getName().equals("Elephant")){
            imageView.setImage(elephant);
        }
        else {
            imageView.setImage(none);
        }
    }
}
