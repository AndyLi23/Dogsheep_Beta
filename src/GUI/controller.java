package GUI;

import Functions.FibGen;
import Functions.QuadCalc;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.math.BigInteger;
import java.util.ArrayList;

public class controller {
    //quad calc
    @FXML public Text quadCalcResult;
    @FXML public TextField aText;
    @FXML public TextField bText;
    @FXML public TextField cText;

    //fib gen
    @FXML public TextArea fibGenResult;
    @FXML public TextField fibInput;

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

    @FXML public void fibGen() {
        int a = Integer.parseInt(fibInput.getText());
        FibGen fibGen = new FibGen();
        String ans = fibGen.generateFib(a);
        fibGenResult.setText(ans);
    }

    @FXML public void fibGenList() {
        double a = Double.parseDouble(fibInput.getText());
        FibGen fibGen = new FibGen();
        BigInteger ans = fibGen.getFib(a);
        fibGenResult.setText(""+ans);
    }
}
