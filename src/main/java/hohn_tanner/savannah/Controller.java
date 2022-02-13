package hohn_tanner.savannah;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.image.Image;

import java.util.Objects;

public class Controller {

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
    private Layout layout;
    private Savannah model;

    public Controller(Savannah data, Layout layout) {
        this.layout = layout;
        model = data;

        //set up actions??
        layout.getNewDayBtn().addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                model.newDay();
            }
        });

        layout.get3Btn().addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                model.changeSize(3);
            }
        });

        layout.get5Btn().addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                model.changeSize(5);
            }
        });

        layout.get8Btn().addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                model.changeSize(8);
            }
        });

        layout.getGrid().addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TileView pressed = (TileView) actionEvent.getTarget();
                Animal currAnimal = pressed.getTile().getAnimal();
                String toggleText = getToggleText();

                if(toggleText.equals("Add")){
                    if(currAnimal.getName().equals(getAnimalViaSelection(
                            layout.getComboBox().getSelectionModel().getSelectedIndex()).getName())){
                        pressed.getTile().setAnimal(new None());
                        model.fillUpdate();
                    } else {
                        pressed.getTile().setAnimal(getAnimalViaSelection(layout.getComboBox().getSelectionModel().getSelectedIndex()));
                        model.fillUpdate();
                    }
                }else{
                    layout.getAnimalInfo().setText(currAnimal.getName() + "\nHealth: "+ currAnimal.getHealth() +
                            "\nRow: " + pressed.getTile().getRow() + "\nColumn: " + pressed.getTile().getCol());
                    imageforAnimal(currAnimal);
                    model.updateInfo(currAnimal.getName() + "\nHealth: "+ currAnimal.getHealth() +
                            "\nRow: " + pressed.getTile().getRow() + "\nColumn: " + pressed.getTile().getCol());
                }

            }
        });

        layout.getGroup().selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                if(getToggleText() != "View"){
                    model.updateInfo("Animal Info");
                    layout.getImageView().setImage(null);
                }
            }
        });

    }

    private String getToggleText(){
        return ((RadioButton) layout.getGroup().getSelectedToggle()).getText();
    }

    private Animal getAnimalViaSelection(int index){
        if(index == 0){
            return new Zebra();
        }
        else if(index == 1){
            return new Cheetah();
        }
        else if(index == 2){
            return new Elephant();
        }
        else if(index == 3){
            return new Giraffe();
        }
        else if(index == 4){
            return new Lion();
        }
        return new None();
    }

    private void imageforAnimal(Animal a){
        if(a.getName().equals("Giraffe")){
            layout.getImageView().setImage(giraffe);
        }
        else if(a.getName().equals("Cheetah")){
            layout.getImageView().setImage(cheetah);
        }
        else if(a.getName().equals("Lion")){
            layout.getImageView().setImage(lion);
        }
        else if(a.getName().equals("Zebra")){
            layout.getImageView().setImage(zebra);
        }
        else if(a.getName().equals("Elephant")){
            layout.getImageView().setImage(elephant);
        }
        else {
            layout.getImageView().setImage(none);
        }
    }
}