/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit.view;

import jUnit.Command;
import jUnit.control.Controller;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author marcos
 */
public class ShowStatisticsPanel extends JPanel {

    private JTextArea statistics;
    private Button showFollowTestsButton;

    public ShowStatisticsPanel() {
        super();
        statistics = new JTextArea();
        showFollowTestsButton = new Button(new Command() {
            public void execute() {
                Controller.getInstance().runTests();
            }
        });
        showFollowTestsButton.setText("Follow Tests");

        initializeComponents();
    }

    private void initializeComponents() {
        setLayout(new BorderLayout());
        add(statistics, BorderLayout.CENTER);
        add(showFollowTestsButton, BorderLayout.SOUTH);
    }
}
