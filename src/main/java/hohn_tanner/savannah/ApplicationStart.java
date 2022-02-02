package hohn_tanner.savannah;
//click the hello button so the text above says the welcome button, and the button text now says goodbye,
//Press Goodbye button for it to say goodbye message.


import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationStart extends Application {
    public static final int WIDTH = 700;
    public static final int HEIGHT = 600;

    private Label output = new Label("A"); //label allows colored background, text does not
    private TextField input = new TextField("A");
    private TextArea area1 = new TextArea();
    private TextArea area2 = new TextArea();
    private TextArea area3 = new TextArea();
    private Button button = new Button("A");
    private Button[] buttons = new Button[4];
    private CheckBox check = new CheckBox("Check me!");
    private ComboBox<String> myList;

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



    //b.setStyle("-fx-background-color: colorName;");
    private Pane top = new Pane();
    private Pane left = new Pane();
    private Pane right = new Pane();

    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(ApplicationStart.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Pane root;
        root = makeBorderContents();

        Scene scene = new Scene(root,WIDTH , HEIGHT);


        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private Pane makeBorderContents(  ) {
        BorderPane root = new BorderPane();

        root.setTop(makeTopContents());
        root.setLeft(left);
        root.setRight(right);
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
}