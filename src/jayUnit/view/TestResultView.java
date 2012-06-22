package jayUnit.view;

import jayUnit.framework.ObservableTestResult;
import jayUnit.framework.Observer;
import jayUnit.framework.TestResult;

public class TestResultView extends javax.swing.JTextArea implements Observer {

    private TestResult result;

    public TestResultView() {
        setText("0 run, 0 failed");
    }

    public TestResultView(TestResult result) {
        this.result = result;
    }

    public void setResult(ObservableTestResult result) {
        this.result = result;
        result.attach(this);
    }

    public void update() {
        setText(result.summary());
    }
}
