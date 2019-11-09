package GUI;

import Functions.QuadCalc;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class controller {
    @FXML public Text quadCalcResult;
    @FXML public TextField aText;
    @FXML public TextField bText;
    @FXML public TextField cText;
    @FXML public void quadCalc() {
        double a = Double.parseDouble(aText.getText());
        double b = Double.parseDouble(bText.getText());
        double c = Double.parseDouble(cText.getText());
        double[] vals = new double[3];
        vals[0] = a;
        vals[1] = b;
        vals[2] = c;
        QuadCalc quadCalc = new QuadCalc();
        String ans = quadCalc.calculate(vals);
        quadCalcResult.setText(ans);
    }
}
