package Final.main;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.util.ArrayList;

public class TalentVsCapitalBarChart extends ApplicationFrame {
    public TalentVsCapitalBarChart(ArrayList<Person> people, String title) {
        super(title);

    }

    public static DefaultCategoryDataset createDataset(ArrayList<Person> people) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Person person : people) {
            dataset.addValue(person.getCapital(), "Capital", String.valueOf(person.getTalent()));
        }

        return dataset;
    }

    public static XYSeriesCollection createXYPlotDataset(ArrayList<Person> people) {
        XYSeries dataset = new XYSeries("Talent vs Capital");
        for (Person person : people) {
            dataset.add(person.getCapital(), person.getTalent());
        }
        XYSeriesCollection data = new XYSeriesCollection(dataset);

        return data;
    }

    public static IntervalXYDataset createXYBarChartDataset(ArrayList<Person> people) {
        XYSeriesCollection dataset = new XYSeriesCollection();

        // Create a series for the bar chart
        XYSeries series = new XYSeries("Capital vs. Talent");

        for (Person person : people) {
            series.add(person.getCapital(), person.getTalent());
        }

        dataset.addSeries(series);

        return dataset;
    }

    public static JFreeChart createXYBarChart(IntervalXYDataset dataset) {
        JFreeChart chart = ChartFactory.createXYBarChart(
                "Capital vs. Talent Bar Chart",
                "Talent",
                false,
                "Capital",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        // Customize the x-axis tick units
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        xAxis.setTickUnit(new NumberTickUnit(2.0)); // Set the tick unit (adjust as needed)
        xAxis.setRange(0, 1); // Adjust the x-axis range as needed

        chart.setBackgroundPaint(Color.white);

        TextTitle title = chart.getTitle();
        title.setFont(new Font("Arial", Font.BOLD, 16));

        return chart;
    }


    public static JFreeChart createXYPlotChart(XYSeriesCollection dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Talent vs. Capital Bar Chart",
                "Talent",
                "Capital",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = (XYPlot)chart.getPlot();
        // Create an NumberAxis
        NumberAxis xAxis = new NumberAxis();
        xAxis.setTickUnit(new NumberTickUnit(1));
        plot.setDomainAxis(xAxis);

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesLinesVisible(0, false);

        plot.setRenderer(renderer);

        chart.setBackgroundPaint(Color.white);

        TextTitle title = chart.getTitle();
        title.setFont(new Font("Arial", Font.BOLD, 16));

        return chart;
    }
    public static JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Talent vs. Capital Bar Chart",
                "Talent",
                "Capital",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        CategoryPlot plot = chart.getCategoryPlot();

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        chart.setBackgroundPaint(Color.white);

        TextTitle title = chart.getTitle();
        title.setFont(new Font("Arial", Font.BOLD, 16));

        return chart;
    }

}

