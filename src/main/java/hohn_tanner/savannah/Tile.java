package hohn_tanner.savannah;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Tile {

    private Animal animalHolder;
    private PropertyChangeSupport subject;
    private int row;
    private int col;
    //subject goes here
    public Tile(int row, int col){
        this.row = row;
        this.col = col;
        animalHolder = new None();
        subject = new PropertyChangeSupport(this);
    }

    public int getRow(){return row;}

    public int getCol(){return col;}

    public Animal getAnimal(){
        return animalHolder;
    }

    public void addObserver(PropertyChangeListener obv) {
        subject.addPropertyChangeListener(obv); //GRADING: SUBJECT
    }

    public void newDay(){
        animalHolder.newDay();
        if(animalHolder.getName() == "Z" || animalHolder.getName() == "C"
                || animalHolder.getName() == "E"|| animalHolder.getName() == "G"){//Can check if not None instead
            if(animalHolder.getHealth() <= 0){
                animalHolder = new None();
            }
        }
        subject.firePropertyChange("newDay", null, animalHolder);
    }

    public void setAnimal(Animal a){
        animalHolder = a;
        subject.firePropertyChange("setAnimal", null, a);
    }

}
