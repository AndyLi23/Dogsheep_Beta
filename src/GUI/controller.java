package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class controller {
    @FXML public Text result;
    @FXML public TextField quadCalcNums;
    @FXML public void quadCalc() {
        String vals = quadCalcNums.getCharacters().toString();
        result.setText(vals);
    }
}
