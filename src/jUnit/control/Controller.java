/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit.control;

import jUnit.FooTest;
import jUnit.view.FollowTestsPanel;
import jUnit.view.MainFrame;
import jUnit.view.ShowStatisticsPanel;

/**
 *
 * @author marcos
 */
public class Controller {

    private MainFrame mainFrame;
    private static Controller instance;

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Controller() {
        mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }

    public void runTests() {
        try {
            mainFrame.setView(new FollowTestsPanel(FooTest.class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void showStatistics() {
        mainFrame.setView(new ShowStatisticsPanel());
    }
}
