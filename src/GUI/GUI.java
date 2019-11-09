package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class GUI extends Application{
    public GUI() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~\nStarting Application\n~~~~~~~~~~~~~~~~~~~~");
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Dogsheep Beta");
        stage.setWidth(1540);
        stage.setHeight(860);
        stage.setMaximized(true);

        Parent header = FXMLLoader.load(getClass().getResource("menu.fxml"));

        Scene menu = new Scene(header);

        stage.setScene(menu);

        stage.show();

    }

}
