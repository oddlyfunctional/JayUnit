package jayUnit.tests;

import jayUnit.framework.PersistentTestDecorator;
import jayUnit.framework.TestCase;
import jayUnit.framework.TestResult;
import jayUnit.framework.TestSuite;
import jayUnit.model.PersistentTestResultDAO;

public class PersistentTestDecoratorTest extends TestCase {

    private PersistentTestDecorator persistentTestDecorator;
    private WasRun wasRun;
    private TestResult result;

    public PersistentTestDecoratorTest(String name) {
        super(name);
    }

    @Override
    protected void setUp() {
        wasRun = new WasRun("testMethod");
        persistentTestDecorator = new PersistentTestDecorator(wasRun);
        result = new TestResult();
    }

    public void testRunTestCase() {
        persistentTestDecorator.run(result);
        assertEquals("setUp testMethod tearDown", wasRun.log());
    }

    public void testCreatePersistentTestResult() {
        PersistentTestResultDAO dao = PersistentTestResultDAO.getInstance();
        assertEquals(dao.findAll().size(), 0);
        persistentTestDecorator.run(result);
        assertEquals(dao.findAll().size(), 1);
    }

    public void testExecutionTime() {
        PersistentTestResultDAO dao = PersistentTestResultDAO.getInstance();
        persistentTestDecorator.run(result);
        assertNotEquals(dao.findAll().get(0).getExecutionTimeInNanoSecs(), 0L);
    }

    @Override
    protected void tearDown() {
        PersistentTestResultDAO.getInstance().findAll().clear();
    }

    public static void main(String[] args) throws Exception {
        TestSuite suite = new TestSuite(PersistentTestDecoratorTest.class);
        TestResult result = new TestResult();
        suite.run(result);
        System.out.println(result.summary());
    }
}
