/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Final.main;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author zycmm
 */
public class TopIndividualsMenu extends JDialog {

    /**
     * Creates new form TopIndividualsMenu
     */
    public TopIndividualsMenu(Frame parent, boolean modal, ArrayList<Double> capitals) {
        super(parent, modal);
        initComponents();
        this.capitals = capitals;
        // Sort the ArrayList in descending order
        Collections.sort(capitals, Collections.reverseOrder());
        totalCapitals = 0.0;
        for(Double capital : capitals)
        {
            totalCapitals += capital;
        }

        percentageSlider.setMajorTickSpacing(10);
        percentageSlider.setMinorTickSpacing(1);
        percentageSlider.setPaintTicks(true);
        percentageSlider.setPaintLabels(true);
        percentageSlider.addChangeListener(new SliderChangeListener());

        percentageTitleLabel.setText("Choose a percentage of the highest-performing individuals:");
        // inital display with 50% selected percentage
        percentageOutputLabel.setText("Selected Percentage: " + 50 + "%, Sum of Richest Individuals: " + calculateCapitalPercentage(50) + "%");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        percentageSlider = new JSlider();
        percentageOutputLabel = new JLabel();
        percentageTitleLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(percentageTitleLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(percentageOutputLabel, GroupLayout.PREFERRED_SIZE, 530, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(percentageSlider, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(percentageTitleLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(percentageSlider, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(percentageOutputLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String calculateCapitalPercentage(int percentage)
    {
        /* TODO: complete this method to calculate the total capital percentage based on a given percentage and a list of capitals.
            The input percentage, for example, 20, signifies the top 20% of the wealthiest individuals based on their capitals.
            The method is designed to compute the total capital held by this 20% and then return a formatted string
            representing the percentage of this calculated total capital in comparison to the overall sum of all capitals.
            To format a string, use String formattedString = String.format("%.2f", value);
         */
        double n = percentage/100.0; // make the argument a percentage
        int numberOfCapitalEntries = capitals.size(); // get the number of items in the capital array
        int index = (int) Math.floor(numberOfCapitalEntries*n); // get the index of the lowest entry within the desired range
        double sumOfRichestIndividuals = 0.0;
        for(int i = 0; i < index; i++){
            sumOfRichestIndividuals += capitals.get(i); // Sum all entries within the range.
        }
        double calculatedCapitalPercentage = (sumOfRichestIndividuals/totalCapitals)*100;// Get the percentage of total wealth owned by this portion of the population.

        return String.format("%.2f", calculatedCapitalPercentage); // return the value as a string.
    }

    public class SliderChangeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            /* TODO: this is an inner class that implements the ChangeListener interface in Java.
                It is designed to handle changes in the state of a slider component. This method is called whenever the
                state of the observed component changes. Your objective is to complete the implementation of this
                method so that, when the user adjusts the slider's value, the percentageOutputLabel updates.
                The updated label should display information about the selected percentage and provide the
                calculated sum of the capital percentages of the wealthiest individuals.
             */
            percentageOutputLabel.setText("Selected Percentage: " + percentageSlider.getValue()+"%, Sum of Richest Individuals: " + calculateCapitalPercentage(percentageSlider.getValue())+"%");

        }
    }

    public JLabel getPercentageOutputLabel() {
        return percentageOutputLabel;
    }

    public JSlider getPercentageSlider() {
        return percentageSlider;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel percentageOutputLabel;
    private JSlider percentageSlider;
    private JLabel percentageTitleLabel;
    // End of variables declaration//GEN-END:variables

    // manually-defined variables
    private ArrayList<Double> capitals;
    private Double totalCapitals;

}