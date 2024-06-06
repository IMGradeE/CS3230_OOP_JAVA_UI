package GUIFundamentals.main;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class DrawingFrame extends Frame {
    private JFrame frame;
    private JPanel canvas;
    private String selectedShape = "Oval"; // Default selected shape
    private Color selectedColor = Color.BLACK;
    private int shapeSize = 50;
    private int x = 50, y = 50;
    private String selectedItem = "";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DrawingFrame().createAndShowGUI());
    }

    public void createAndShowGUI() {
        frame = new JFrame("Shape Drawing App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(selectedColor);
                switch (selectedShape) {
                    case "Oval": g.drawOval(x, y, shapeSize/2, shapeSize); break;
                    case "Rectangle": g.drawRect(x, y, shapeSize, shapeSize); break;
                    case "Circle": g.drawOval(x, y, shapeSize, shapeSize); break;
                    case "String": g.drawString(selectedItem, x, y); break;
                }
            }
        };

        frame.add(canvas, BorderLayout.CENTER);

        JPanel colorPanel = new JPanel();
        JLabel colorLabel = new JLabel("Selected Color: ");
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setRenderer(new ColoredTextComboBoxRenderer());
        Map<String, Color> itemColors = new HashMap<>();
        itemColors.put("Blue", Color.BLUE);
        itemColors.put("Green", Color.GREEN);
        itemColors.put("Red", Color.RED);
        itemColors.put("Orange", Color.ORANGE);

        for (String item : itemColors.keySet()) {
            comboBox.addItem(item);
        }

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedItem = (String) comboBox.getSelectedItem();
                String colorStr;
                // TODO: xx Complete the code to evaluate the selectedItem and determine which color to use.
                selectedColor = itemColors.get(selectedItem);
                colorStr = selectedColor.toString();
                colorLabel.setText("<html><font color='" + colorStr + "'>" + "Selected Color: " + colorStr + "</font></html>");
                canvas.repaint();
            }
        });

        colorPanel.add(comboBox);
        colorPanel.add(colorLabel);
        frame.add(colorPanel, BorderLayout.NORTH);

        JPanel controlPanel = new JPanel();

        JLabel sliderLabel = new JLabel("Selected Value: 50");
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // TODO:xx Update the value of the variable shapeSize with the current value of a slider and also
                //  updating the text of the label (sliderLabel) to display the selected value
                shapeSize = slider.getValue();
                sliderLabel.setText(Integer.toString(shapeSize));
                canvas.repaint();
            }
        });

        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.add(sliderLabel);
        controlPanel.add(slider);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // TODO:xx Create four buttons each labeled as 'Oval,', 'Circle,' 'Rectangle,' and 'String';
        //  add action listeners to each button using the customized  shapeButtonListener class;
        //  then add buttons to buttonPanel
        String[] s = new String[]{"Oval","Circle","Rectangle","String"};
        JButton b;
        for (String str: s) {
            b = new JButton(str);
            b.addActionListener(new ShapeButtonListener(str));
            buttonPanel.add(b);
        }

        controlPanel.add(buttonPanel);

        frame.add(controlPanel, BorderLayout.SOUTH);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    class ShapeButtonListener implements ActionListener {
        private String shapeType;

        public ShapeButtonListener(String type) {
            shapeType = type;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            selectedShape = shapeType;
            canvas.repaint();
        }
    }

    // Custom ListCellRenderer to set text color
    static class ColoredTextComboBoxRenderer extends DefaultListCellRenderer {
        private Map<String, Color> itemColors;

        public ColoredTextComboBoxRenderer() {
            itemColors = new HashMap<>();
            itemColors.put("Blue", Color.BLUE);
            itemColors.put("Green", Color.GREEN);
            itemColors.put("Red", Color.RED);
            itemColors.put("Orange", Color.ORANGE);
        }

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (value != null) {
                setText("<html><font color='" + getColor(itemColors.get(value.toString())) + "'>" + value + "</font></html>");
            }

            return this;
        }

        private String getColor(Color color) {
            if (color == Color.RED) return "red";
            if (color == Color.BLUE) return "blue";
            if (color == Color.GREEN) return "green";
            if (color == Color.ORANGE) return "orange";
            if (color == Color.MAGENTA) return "magenta";
            return "black"; // Default color
        }
    }

    public String getSelectedShape() {
        return selectedShape;
    }

    public Color getSelectedColor() {
        return selectedColor;
    }

    public int getShapeSize() {
        return shapeSize;
    }
}

