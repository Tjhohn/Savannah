package hohn_tanner.savannah;

public class Tile {
    private Animal animalHolder;
    public Tile(){

    }

    public void newDay(){
        animalHolder.newDay();
    }

    public void setAnimal(Animal a){
        animalHolder =a;
    }

}
