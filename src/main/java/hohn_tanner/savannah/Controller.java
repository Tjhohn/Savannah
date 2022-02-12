package hohn_tanner.savannah;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javax.swing.*;

public class Controller {

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
                pressed.getTile().setAnimal(getAnimalViaSelection(layout.getComboBox().getSelectionModel().getSelectedIndex()));
            }
        });

    }

    private Animal getAnimalViaSelection(int index){
        if(index == 0){
            return new Zebra();
        }
        else if(index == 1){
            return new Cheetah();
        }
        return new None();
    }


}