package jayUnit.framework;

public abstract class TestComponent {

    public abstract void run(TestResult result);
    
    public void add(TestComponent test) {}
}
