module hohn_tanner.savannah {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens hohn_tanner.savannah to javafx.fxml;
    exports hohn_tanner.savannah;
}