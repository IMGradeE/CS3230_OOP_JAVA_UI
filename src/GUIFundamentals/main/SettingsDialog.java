package GUIFundamentals.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsDialog extends JDialog {

    private JButton cancelButton;
    private JLabel delayLabel;
    private JTextField delayTextField;
    private JLabel numberEventLabel;
    private JTextField numberEventTextField;
    private JLabel numberPeopleLabel;
    private JTextField numberPeopleTextField;
    private JButton okButton;
    private JLabel stepsLabel;
    private JTextField stepsTextField;
    private JComboBox<String> thresholdComboBox;
    private JLabel thresholdLabel;
    private SimulatorParameters parameters;

    private int columns = 10;

    private StringBuilder warnings;

    public SettingsDialog(JFrame parentFrame) {
        super(parentFrame, "Settings", true); // 'true' makes it a modal dialog

        parameters = new SimulatorParameters();
        warnings = new StringBuilder();

        numberPeopleLabel = new JLabel("Number of People.");
        numberPeopleTextField = new JTextField();

        numberEventLabel = new JLabel("Number of Events.");
        numberEventTextField = new JTextField();

        stepsLabel = new JLabel("Simulation Steps.");
        stepsTextField = new JTextField();

        delayLabel = new JLabel("Thread Delay Time");
        delayTextField = new JTextField();

        thresholdLabel = new JLabel("Distance Threshold.");
        thresholdComboBox = new JComboBox<>();
        String[] s = new String[]{"0", "1", "2", "3", "4", "5", "6"};
        for (String str: s){
            thresholdComboBox.addItem(str);
        }

        // Layout components
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(numberPeopleLabel);
        panel.add(numberPeopleTextField);

        panel.add(numberEventLabel);
        panel.add(numberEventTextField);

        panel.add(stepsLabel);
        panel.add(stepsTextField);

        panel.add(thresholdLabel);
        panel.add(thresholdComboBox);

        panel.add(delayLabel);
        panel.add(delayTextField);

        // Create buttons
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        // Add action listeners to buttons
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveSettings(true);
                dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        // Add components to the dialog
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Set dialog properties
        pack();
        setLocationRelativeTo(parentFrame);
    }

    public void saveSettings(boolean showWarningDialog) {
        int numberPeople = 0;
        int numberEvents = 0;
        int steps = 0;
        double threshold = 0;
        int delay = 0;

        String[] stringsPre = new String[]{"Number of People", "Number of Events", "Simulation Steps", "Thread Delay Time"};
        String[] stringsPost = new String[]{" field", " field", "", ""};
        Object[] numbers = new Object[]{numberPeople,numberEvents,steps,delay};
        JTextField[] fields = new JTextField[]{numberPeopleTextField,numberEventTextField,stepsTextField,delayTextField};
        String text;


        for (int i = 0; i < stringsPre.length; i++) {
            try{
                text = fields[i].getText();
                if(text.isEmpty()){throw new NullPointerException();}
                numbers[i] = Integer.parseInt(text);
            }catch (NumberFormatException e){
                showWarningDialog = true;
                warnings.append(stringsPre[i]+" must be an integer number.\n");
            }catch(NullPointerException e){
                showWarningDialog = true;
                if (i==1){warnings.append("Number of Event"+stringsPost[i]+" must not be empty.\n");}
                else{ //Please write consistently when testing for whole string matches.
                    warnings.append(stringsPre[i] + stringsPost[i] + " must not be empty.\n");
                }
            }
        }
        if (!warnings.isEmpty() && showWarningDialog) {
            JOptionPane.showMessageDialog(this, warnings.toString(), "Setting Warnings", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            parameters.setNumberEvents(numberEvents);
            parameters.setDistanceThreshold(threshold);
            parameters.setDelayTime(delay);
            parameters.setSimulationSteps(steps);
            parameters.setNumberPeople(numberPeople);
            dispose();
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Settings Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JButton openDialogButton = new JButton("Open Settings");
            openDialogButton.addActionListener(e -> {
                SettingsDialog settingsDialog = new SettingsDialog(frame);
                settingsDialog.setVisible(true);
            });

            frame.add(openDialogButton);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JLabel getDelayLabel() {
        return delayLabel;
    }

    public JTextField getDelayTextField() {
        return delayTextField;
    }

    public JLabel getNumberEventLabel() {
        return numberEventLabel;
    }

    public JTextField getNumberEventTextField() {
        return numberEventTextField;
    }

    public JLabel getNumberPeopleLabel() {
        return numberPeopleLabel;
    }

    public JTextField getNumberPeopleTextField() {
        return numberPeopleTextField;
    }

    public JButton getOkButton() {
        return okButton;
    }

    public JLabel getStepsLabel() {
        return stepsLabel;
    }

    public JTextField getStepsTextField() {
        return stepsTextField;
    }

    public JComboBox<String> getThresholdComboBox() {
        return thresholdComboBox;
    }

    public JLabel getThresholdLabel() {
        return thresholdLabel;
    }

    public SimulatorParameters getParameters() {
        return parameters;
    }

    public int getColumns() {
        return columns;
    }

    public StringBuilder getWarnings() {
        return warnings;
    }
}
