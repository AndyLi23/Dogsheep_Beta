package GUI;

import Functions.BasicCalc;
import Functions.FibGen;
import Functions.PrimeGen;
import Functions.QuadCalc;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.math.BigDecimal;
import java.math.BigInteger;

public class controller {
    @FXML public TextArea changelog;
    @FXML public Label changelogUpdater;

    //quad calc
    @FXML public TextArea quadCalcResult;
    @FXML public TextField aText;
    @FXML public TextField bText;
    @FXML public TextField cText;

    //fib gen
    @FXML public TextArea fibGenResult;
    @FXML public TextField fibInput;

    //prime gen
    @FXML public TextField primeInput;
    @FXML public TextArea primeGenResult;

    //calc
    @FXML public TextField calcInput;
    @FXML public TextArea calc;

    @FXML public void showChangelog() {
        changelog.setText("11/3/19: Created main application\n11/4/19: Added tabs, introduction, CSS stylesheet\n11/9/19: New function: quadratic calculator\n11/10/19: New functions: fibonacci generator, primes generator");
        changelogUpdater.setText("Hide Changelog");
        changelogUpdater.setOnMouseClicked(event -> hideChangelog());
    }

    @FXML public void hideChangelog() {
        changelog.setText("");
        changelogUpdater.setText("Show Changelog");
        changelogUpdater.setOnMouseClicked(event -> showChangelog());
    }

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

    @FXML public void fibGenList() {
        int a = Integer.parseInt(fibInput.getText());
        FibGen fibGen = new FibGen();
        String ans = fibGen.generateFib(a);
        fibGenResult.setText(ans);
    }

    @FXML public void fibGen() {
        double a = Double.parseDouble(fibInput.getText());
        FibGen fibGen = new FibGen();
        BigInteger ans = fibGen.getFib(a);
        fibGenResult.setText(""+ans);
    }

    @FXML public void primeGen() {
        double a = Double.parseDouble(primeInput.getText());
        PrimeGen primeGen = new PrimeGen();
        String ans = primeGen.generatePrimes(a+1);
        //int ans = primeGen.primeGap(a+1);
        primeGenResult.setText(ans.replaceFirst(", ", ""));
    }

    @FXML public void calc() {
        String a = calcInput.getText();
        BasicCalc basicCalc = new BasicCalc();
        String postfix = basicCalc.postfix(a);
        BigDecimal ans = basicCalc.postfixCalc(postfix);
        calc.setText(""+ans);
    }

}
