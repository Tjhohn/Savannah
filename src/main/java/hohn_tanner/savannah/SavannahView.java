package hohn_tanner.savannah;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

public class SavannahView extends GridPane {

    private Savannah model;

    public SavannahView(){
        makePane(3);
    }

    public void setModel(Savannah model) {
        this.model = model;
    }

    public void resize( Integer row, Integer cols){
        makePane(row);
    }

    private void makePane(Integer size){
        for( int i = 0; i < size; i++){
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.ALWAYS);
            this.getRowConstraints().add(row);
            ColumnConstraints column = new ColumnConstraints();
            column.setHgrow(Priority.ALWAYS);
            this.getColumnConstraints().add(column);
            for(int j = 0; j < size; j++){
                Button btn = new Button("N:0");
                btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                this.add(btn, j, i);
            }
        }
    }


}
