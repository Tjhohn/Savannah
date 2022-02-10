package hohn_tanner.savannah;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

//builds layout? most likely move the stuff that creates stuff from Appstart here
public class Layout implements PropertyChangeListener{
    //main
    private Pane root;
    private Integer gridSize = 3;
    private Savannah model;

    //top
    private Text day = new Text("Day: 0");
    private Text filled = new Text("Filled: 0");
    private Text died = new Text("Died: 0");
    private Region springTopLeft = new Region();
    private Button newDayBtn = new Button("New Day");
    private Region springTopRight = new Region();
    private Label resizeLbl = new Label("Resize: ");
    private Button threeBtn = new Button("3X3");
    private Button fiveBtn = new Button("5X5");
    private Button eightBtn = new Button("8X8");

    //side
    private Region springSideTop = new Region();
    private Region springSideMid = new Region();
    private Region springSideBot = new Region();
    private Text animalInfo = new Text("Animal Info");
    private ComboBox<String> myList;

    public Layout(Savannah model){
        this.model = model;
        model.addObserver( this);
        root = makeContents();
    }

    private Pane makeContents(  ) {
        VBox root = new VBox();
        ObservableList<Node> rootList = root.getChildren();
        HBox lower = new HBox();
        VBox.setVgrow(lower, Priority.ALWAYS);
        Pane grid = makeCenterContents(gridSize);
        HBox.setHgrow(grid, Priority.ALWAYS);
        ObservableList lowerList = lower.getChildren();
        lowerList.addAll(makeSideContents(),grid );
        rootList.addAll(makeTopContents(), lower);
        return root;
    }

    private Pane makeTopContents(){
        HBox root = new HBox();
        HBox.setHgrow(springTopLeft, Priority.ALWAYS);
        HBox.setHgrow(springTopRight, Priority.ALWAYS);
        ObservableList<Node> listMain = root.getChildren();

        VBox leftSide = new VBox();
        leftSide.setFillWidth(true);
        ObservableList<Node> listLeft = leftSide.getChildren();
        listLeft.add(day);
        listLeft.add(filled);
        listLeft.add(died);

        GridPane rightSide = new GridPane();
        rightSide.add(resizeLbl, 0, 1);
        rightSide.add(threeBtn, 1, 0);
        rightSide.add(fiveBtn, 1, 1);
        rightSide.add(eightBtn, 1, 2);

        VBox center = new VBox();
        center.setAlignment(Pos.CENTER);
        ObservableList<Node> listCenter = center.getChildren();
        listCenter.add(newDayBtn);
        listMain.addAll(leftSide, springTopLeft, center, springTopRight,rightSide);

        return root;
    }

    private Pane makeSideContents(){
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        ObservableList<Node> listMain = root.getChildren();

        VBox.setVgrow(springSideTop, Priority.ALWAYS);
        VBox.setVgrow(springSideMid, Priority.ALWAYS);
        VBox.setVgrow(springSideBot, Priority.ALWAYS);

        ObservableList<String> options =
                FXCollections.observableArrayList( "Zebra", "Cheetah");
        myList = new ComboBox<>(options);
        myList.getSelectionModel().select(0); //set the current selection

        //radio buttons
        ToggleGroup group = new ToggleGroup(); //the group where only 1 can be selected
        RadioButton rBtn1 = new RadioButton("Add");
        RadioButton rBtn2 = new RadioButton("View");
        rBtn1.setToggleGroup(group);
        rBtn2.setToggleGroup(group);
        rBtn1.setLayoutY(200);
        rBtn2.setLayoutY(220);
        group.selectToggle( rBtn1 );

        listMain.addAll(springSideTop, myList, rBtn1, rBtn2,springSideMid, animalInfo, springSideBot);

        return root;
    }

    private Pane makeCenterContents(Integer size){
        GridPane grid = new GridPane();
        for( int i = 0; i < size; i++){
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.ALWAYS);
            grid.getRowConstraints().add(row);
            ColumnConstraints column = new ColumnConstraints();
            column.setHgrow(Priority.ALWAYS);
            grid.getColumnConstraints().add(column);
            for(int j = 0; j < size; j++){
                Button btn = new Button("N:0");
                btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                grid.add(btn, j, i);
            }
        }
        return  grid;
    }

    public Pane getLayout(){
        return root;
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //stuff for model
    }
}
