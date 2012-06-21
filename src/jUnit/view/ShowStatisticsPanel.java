package jUnit.view;

import jUnit.control.commands.Command;
import jUnit.control.Controller;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ShowStatisticsPanel extends JPanel {

    private JTextArea statistics;
    private Button showFollowTestsButton;

    public ShowStatisticsPanel() {
        super();
        statistics = new JTextArea();
        statistics.setText(Controller.getInstance().testsStatistics());
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
