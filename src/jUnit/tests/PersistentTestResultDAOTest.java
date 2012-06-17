package jUnit.tests;

import jUnit.framework.TestCase;
import jUnit.framework.TestResult;
import jUnit.framework.TestSuite;
import jUnit.model.PersistentTestResult;
import jUnit.model.PersistentTestResultDAO;
import java.util.ArrayList;
import java.util.List;

public class PersistentTestResultDAOTest extends TestCase {

    private PersistentTestResult persistentResult;
    private PersistentTestResultDAO dao;

    public PersistentTestResultDAOTest(String name) {
        super(name);
    }

    @Override
    protected void setUp() {
        TestResult result = new TestResult();
        persistentResult = new PersistentTestResult(result, 0);
        dao = PersistentTestResultDAO.getInstance();
    }

    public void testSingletonCreation() {
        assertEquals(PersistentTestResultDAO.getInstance(), dao);
    }

    public void testInsert() {
        dao.insert(persistentResult);
        assertContains(dao.findAll(), persistentResult);
    }

    public void testFindAll() {
        dao.insert(persistentResult);
        List<PersistentTestResult> results = new ArrayList<PersistentTestResult>();
        results.add(persistentResult);
        assertArrayEquals(dao.findAll(), results);
    }

    public void testDelete() {
        dao.insert(persistentResult);
        dao.delete(persistentResult);
        assertDoNotContain(dao.findAll(), persistentResult);
    }

    @Override
    protected void tearDown() {
        PersistentTestResultDAO.getInstance().findAll().clear();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(TestSuite.runTestSuiteFor(PersistentTestResultDAOTest.class).summary());
    }
}
