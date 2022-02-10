package hohn_tanner.savannah;

public class Animal {
    private Integer health;
    private Integer dayDecrement;
    private String name;

    public Animal(String animalName, Integer startHealth, Integer healthDecrementPerDay){
        health = startHealth;
        name = animalName;
        dayDecrement = healthDecrementPerDay;
    }

    public void newDay(){

    }

}
