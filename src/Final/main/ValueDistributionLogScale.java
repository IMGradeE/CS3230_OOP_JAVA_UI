package Final.main;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ValueDistributionLogScale {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Value Distribution with Log Scale");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            // Create sample data (you can replace this with your ArrayList)
            ArrayList<Double> values = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                double value = Math.random() * 100; // Generate random values between 0 and maxValue (100 in this case)
                values.add(value);
            }

            double maxValue = 100.0; // Adjust this to your desired maximum value

            // Create the dataset
            DefaultCategoryDataset dataset = createDataset(values, 10, maxValue);

            // Create the chart
            JFreeChart chart = createBarChart(dataset);

            // Create a chart panel to display the chart
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(600, 400));

            frame.getContentPane().add(chartPanel);
            frame.setVisible(true);
        });
    }

    public static DefaultCategoryDataset createDataset(ArrayList<Double> values, int numBins, double maxValue) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Count the frequency of values in different bins
        Map<Integer, Integer> valueCounts = new HashMap<>();
        //int numBins = 10; // Number of bins
        double binSize = maxValue / numBins;

        for (double value : values) {
            int bin = (int) (value / binSize);
            valueCounts.put(bin, valueCounts.getOrDefault(bin, 0) + 1);
        }

        // Add data points to the dataset
        for (int bin = 0; bin < numBins; bin++) {
            double binStart = bin * binSize;
            double binEnd = (bin + 1) * binSize;
            int count = valueCounts.getOrDefault(bin, 0);
            dataset.addValue(count, "Frequency", String.format("%.2f - %.2f", binStart, binEnd));
        }

        return dataset;
    }

    public static JFreeChart createBarChart(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Value Distribution (Log Scale)", // Chart title
                "Value Bins", // X-axis label
                "Frequency", // Y-axis label
                dataset, // Dataset
                PlotOrientation.VERTICAL,
                true, // Show legend
                true, // Show tooltips
                false // Show URLs
        );

        // Customize the chart
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setFont(new Font("SansSerif", Font.BOLD, 16));
        chart.addSubtitle(new TextTitle("Histogram Example"));

        // Customize the plot
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.lightGray);

        // Create a logarithmic y-axis
        LogarithmicAxis logAxis = new LogarithmicAxis("Frequency (Log Scale)");
        logAxis.setAllowNegativesFlag(false);
        logAxis.setRange(1, 1000); // Adjust the range as needed
        plot.setRangeAxis(logAxis);

        // Customize the renderer
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setBarPainter(new StandardBarPainter());
        renderer.setDrawBarOutline(false);

        return chart;
    }
}
