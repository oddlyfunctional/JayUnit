package jayUnit.framework;

import java.util.ArrayList;
import java.util.List;

public class ObservableTestResult extends TestResult {

    private List<Observer> observers;

    public ObservableTestResult() {
        super();
        observers = new ArrayList<Observer>();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void dettach(Observer observer) {
        observers.remove(observer);
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void testFailed() {
        super.testFailed();
        notifyObservers();
    }

    @Override
    public void testStarted() {
        super.testStarted();
        notifyObservers();
    }
}
