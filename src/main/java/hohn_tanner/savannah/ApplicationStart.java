package hohn_tanner.savannah;

//Complete the following checklist. If you partially completed an item, put a note how it can be checked for what is working for partial credit.
//
//
//done ____ Followed the class OOP diagram 	14
//done ____ Observer pattern (ignores tiers)	20
//
//
//1.	Tier: Views and animal
//done ____ a. All objects (ignoring the sim area)
//done ____ b. Have a 9 tile sim area	5
//done ____ c. Able to add/remove an animal properly
//done ____ d. Info bar listed correctly with all three items with default values
//done ____ e. Tile Text correct for each for one rectangle
//done ____ f. Tile Text correct for each for all rectangles
//done ____ g. Radio buttons update properly
//done ____ h. Selecting a rectangle with “view” affects the animal info somehow
//done ____ i. Selecting a rectangle with “view” affects the animal info correctly
//
//
//2a Tier: Advanced functionality	32
//done ____ a. New day button has some noticeable effect
//done ____ b. Animals updated properly on “new day”
//done ____ c. Day count in info bar is correct
//done ____ d. Animal removed when dead on “new day”
//done ____ e. Num died in info bar is correct (updates on the day the animal dies)
//done ____ f. Num tiles filled in info bar is correct at all times
//done (if I understand properly)____ e. The animal info at least holds
//done ____ f. Reselecting the tile updates the animal information correctly
//
//
//2b: Layout	48
//done ____ a. Location of all items in correct spot
//done ____ b. Layout still correct on window resize
//done ____ c. Resize grid at minimum resets the grid and info
//done ____ d. Everything still working that is listed above with resize
//
// I believe I have all standard points from above.
//
//Final Tier: Extensions 30
//Extension 1: <4.c> <5> <Add more animal types>: <have 3 more options in dropdown: Lion with 46 health and loses 4 each new day
// Elephant with 50 health and loses 3 health each day, and Giraffe with 14 health and loses 2 each day>
//Extension 2: <2a> <5> <Mark rectangle shown in animal section>: <Animal Info now has the row and column number shown as well>
//Extension 3: <2b> <10> <Add images with text>: <Tile view now shows an image I made myself for each animal(I did my best okay!!)>
//
//
//The grade you compute is the starting point for course staff, who reserve the right to change the grade if they disagree with your assessment and to deduct points for other issues they may encounter, such as errors in the submission process, naming issues, etc.
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ApplicationStart extends Application {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 700;

    //Model
    private Savannah model;

    //View
    private Layout layout;

    //Controller
    private Controller controller;

    @Override
    public void start(Stage stage) throws IOException {
        model = new Savannah();
        layout = new Layout(model);
        Scene scene = new Scene(layout.getLayout(),WIDTH , HEIGHT);
        stage.setTitle("Savannah");
        stage.setScene(scene);
        stage.setMinWidth(700);
        stage.setMinHeight(600);

        controller = new Controller(model, layout);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}