package Final.main;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYDotRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.util.ArrayList;

public class CapitalVsTalentBarChart extends ApplicationFrame {
    public CapitalVsTalentBarChart(String title) {
        super(title);
    }

    public static XYSeriesCollection createDataset(ArrayList<Person> people) {
        XYSeriesCollection dataset = new XYSeriesCollection();

        // Create a series for the scatter plot
        XYSeries series = new XYSeries("Talent vs. Capital");

        for (Person person : people) {
            series.add(person.getCapital(), person.getTalent());
        }

        dataset.addSeries(series);

        return dataset;
    }

    public static JFreeChart createChart(XYSeriesCollection dataset) {
        JFreeChart chart = ChartFactory.createScatterPlot(
                "Scatter Plot: Talent vs. Capital",
                "Capital",
                "Talent",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        // Customize the appearance of the scatter plot points
        XYDotRenderer renderer = new XYDotRenderer();
        renderer.setDotHeight(5); // Customize the dot height
        renderer.setDotWidth(5);  // Customize the dot width
        plot.setRenderer(renderer);

        chart.setBackgroundPaint(Color.white);

        TextTitle title = chart.getTitle();
        title.setFont(new Font("Arial", Font.BOLD, 16));

        return chart;
    }

}
