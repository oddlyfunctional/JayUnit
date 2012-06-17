package jUnit.model;

import java.util.ArrayList;
import java.util.List;

public class PersistentTestResultDAO {

    private static PersistentTestResultDAO instance;
    private List<PersistentTestResult> results;

    public PersistentTestResultDAO() {
        results = new ArrayList<PersistentTestResult>();
    }

    public static PersistentTestResultDAO getInstance() {
        if (instance == null) {
            instance = new PersistentTestResultDAO();
        }
        return instance;
    }

    public void insert(PersistentTestResult result) {
        results.add(result);
    }

    public void delete(PersistentTestResult result) {
        results.remove(result);
    }

    public List<PersistentTestResult> findAll() {
        return results;
    }
}
