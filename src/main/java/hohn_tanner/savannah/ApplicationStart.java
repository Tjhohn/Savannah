package hohn_tanner.savannah;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    //View
    private Layout layout;

    @Override
    public void start(Stage stage) throws IOException {
        layout = new Layout(3);
        Scene scene = new Scene(layout.getLayout(),WIDTH , HEIGHT);

        stage.setTitle("Savannah");
        stage.setScene(scene);
        stage.setMinWidth(WIDTH);
        stage.setMinHeight(HEIGHT);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}