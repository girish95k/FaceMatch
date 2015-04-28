import java.awt.*;
import org.jfree.ui.*;
import org.jfree.chart.*;
 import org.jfree.chart.plot.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.title.*;
import org.jfree.data.category.*;

  public class RadarChart extends ApplicationFrame {
    public DefaultCategoryDataset dataset;
    public SpiderWebPlot plot;
    
    static int openness;
    static int conscientiousness;
    static int extraversion;
    static int agreeableness;
    static int neuroticism;

    public RadarChart(String title) {
        super(title);
        String series1 = "First";
        String series2 = "Second";
        String series3 = "Third";
        //String series4 = "Fourth";

        String category1 = "Extraversion";
        String category2 = "Agreeableness";
        String category3 = "Conscientiousness";
        String category4 = "Neuroticism";
        String category5 = "Openness";

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100.0, series1, category1);
        dataset.addValue(100.0, series1, category2);
        dataset.addValue(100.0, series1, category3);
        dataset.addValue(100.0, series1, category4);
        dataset.addValue(100.0, series1, category5);
               
        dataset.addValue(50.0, series3, category1);
        dataset.addValue(50.0, series3, category2);
        dataset.addValue(50.0, series3, category3);
        dataset.addValue(50.0, series3, category4);
        dataset.addValue(50.0, series3, category5);

        dataset.addValue(extraversion, series2, category1);
        dataset.addValue(agreeableness, series2, category2);
        dataset.addValue(conscientiousness, series2, category3);
        dataset.addValue(neuroticism, series2, category4);
        dataset.addValue(openness, series2, category5);
        
       /* dataset.addValue(60.0, series4, category1);
        dataset.addValue(75.0, series4, category2);
        dataset.addValue(20.0, series4, category3);
        dataset.addValue(55.0, series4, category4);
        dataset.addValue(90.0, series4, category5);*/


        SpiderWebPlot plot = new SpiderWebPlot(dataset);

        plot.setStartAngle(90);

        plot.setInteriorGap(0.20);

        plot.setToolTipGenerator(new StandardCategoryToolTipGenerator());

        JFreeChart chart = new JFreeChart("", TextTitle.DEFAULT_FONT, plot, false);

        ChartUtilities.applyCurrentTheme(chart);
        //Dimension d=new Dimension(500,270);

        ChartPanel chartPanel = new ChartPanel(chart);
        this.plot = (SpiderWebPlot) chartPanel.getChart().getPlot();
        this.dataset = (DefaultCategoryDataset) plot.getDataset();
        
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
        }


        public static void main(String[] args) {
                RadarChart demo = new RadarChart("BIG5");
                demo.pack();
                RefineryUtilities.centerFrameOnScreen(demo);
                demo.setVisible(true);
        }
        public static void call(int o, int a, int n, int c, int e)
        {
        	openness = o;
        	agreeableness = a;
        	neuroticism = n;
        	conscientiousness = c;
        	extraversion = e;
        	RadarChart demo = new RadarChart("BIG5");
            demo.pack();
            RefineryUtilities.centerFrameOnScreen(demo);
            demo.setVisible(true);
        }
}
