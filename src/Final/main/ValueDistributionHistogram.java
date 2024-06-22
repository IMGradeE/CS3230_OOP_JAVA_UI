package Final.main;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ValueDistributionHistogram {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Value Distribution Histogram");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            // Create sample data (you can replace this with your ArrayList)
            /*
            ArrayList<Double> values = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                double value = Math.random(); // Generate random values between 0 and 1
                values.add(value);
            }
            */
            PersonComponent component = new PersonComponent();
            ArrayList<Person> people = component.getPeople();
            ArrayList<Double> values = new ArrayList<>();
            for(Person person : people)
            {
                values.add(person.getTalent());
            }

            // Create the dataset
            DefaultCategoryDataset dataset = createDataset(values, 30, 1.0);

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
        // int numBins = 50; // Number of bins
        // double binSize = 1.0 / numBins;
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
                "Talent Distribution Histogram", // Chart title
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
        //chart.addSubtitle(new TextTitle("Histogram Example"));

        // Customize the plot
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.lightGray);
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.lightGray);

        // Customize the renderer
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setBarPainter(new StandardBarPainter());
        renderer.setDrawBarOutline(false);

        return chart;
    }
}
