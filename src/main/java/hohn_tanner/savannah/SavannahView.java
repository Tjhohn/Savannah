package hohn_tanner.savannah;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

public class SavannahView extends GridPane implements PropertyChangeListener {

    private Savannah model;

    public SavannahView(Savannah model){
        this.model = model;
        makePane(3);
    }

    private void clearGrid(){
        getChildren().clear();
        getRowConstraints().clear();
        getColumnConstraints().clear();
    }

    public void passEvent(PropertyChangeEvent evt){
        for( int i = 0; i < model.getSize(); i++){
            for(int j = 0; j < model.getSize(); j++){

            }
        }
    }

    public void setModel(Savannah model) {
        this.model = model;
    }

    public void resize( Integer row, Integer cols){
        makePane(row);
    }

    private void makePane(Integer size){
        clearGrid();
        for( int i = 0; i < size; i++){
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.ALWAYS);
            this.getRowConstraints().add(row);
            ColumnConstraints column = new ColumnConstraints();
            column.setHgrow(Priority.ALWAYS);
            this.getColumnConstraints().add(column);
            for(int j = 0; j < size; j++){
                TileView btn = new TileView("N:0",i,j, model.getTile(i,j));
                this.add(btn, j, i);
            }
        }
    }

    @Override //GRADING: OBSERVE
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
