package hohn_tanner.savannah;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {

    private boolean isOn = false;

    @FXML
    private Label welcomeText;
    @FXML
    private Button welcomeBtn;

    @FXML
    protected void onHelloButtonClick() {
        if (!isOn){
            welcomeText.setText("Welcome to JavaFX Application!");
            welcomeBtn.setText("Goodbye!");
        }
        else{
            welcomeText.setText("Goodbye from JavaFX Application!");
            welcomeBtn.setText("Hello!");
        }
        isOn = !isOn;
    }


}