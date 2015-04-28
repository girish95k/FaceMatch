import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

  public class Matching extends ApplicationFrame {
    public DefaultCategoryDataset dataset;
    public SpiderWebPlot plot;
    
    static int openness1;
    static int conscientiousness1;
    static int extraversion1;
    static int agreeableness1;
    static int neuroticism1;
    
    static int openness2;
    static int conscientiousness2;
    static int extraversion2;
    static int agreeableness2;
    static int neuroticism2;

    public Matching(String title) {
        super(title);
        String series1 = "First";
        String series2 = "Second";
        String series3 = "Third";
        String series4 = "Fourth";

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
        /*       
        dataset.addValue(50.0, series3, category1);
        dataset.addValue(50.0, series3, category2);
        dataset.addValue(50.0, series3, category3);
        dataset.addValue(50.0, series3, category4);
        dataset.addValue(50.0, series3, category5);
*/
        dataset.addValue(extraversion1, series2, category1);
        dataset.addValue(agreeableness1, series2, category2);
        dataset.addValue(conscientiousness1, series2, category3);
        dataset.addValue(neuroticism1, series2, category4);
        dataset.addValue(openness1, series2, category5);
        
        dataset.addValue(extraversion2, series4, category1);
        dataset.addValue(agreeableness2, series4, category2);
        dataset.addValue(conscientiousness2, series4, category3);
        dataset.addValue(neuroticism2, series4, category4);
        dataset.addValue(openness2, series4, category5);


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


        public static void main(String[] args) throws IOException {
        	
        	String everything;
        	
        	 BufferedReader br = new BufferedReader(new FileReader("database.txt"));
        	    try {
        	        StringBuilder sb = new StringBuilder();
        	        String line = br.readLine();

        	        while (line != null) {
        	            sb.append(line);
        	            sb.append(System.lineSeparator());
        	            line = br.readLine();
        	        }
        	        everything = sb.toString();
        	    } finally {
        	        br.close();
        	    }
        	    
        	    String datalines[] = everything.split("\n");
        	    
        	    for(int i=0; i<2; i++)
        	    {
        	    	String data[] = datalines[i].split(",");
        	    	for(int j=2; j<data.length; j++)
        	    	{
        	    		System.out.println(data[j]);
        	    		if(i==0)
        	    		{
        	    			openness1 = Integer.parseInt(data[2]);
        	            	agreeableness1 = Integer.parseInt(data[3]);
        	            	neuroticism1 = Integer.parseInt(data[4]);
        	            	conscientiousness1 = Integer.parseInt(data[5]);
        	            	data[6]=data[6].substring(0,2);
        	            	//System.out.print(data[6]);
        	            	extraversion1 = Integer.parseInt(data[6]);
        	    		}
        	    		if(i==1)
        	    		{
        	    			openness2 = Integer.parseInt(data[2]);
        	            	agreeableness2 = Integer.parseInt(data[3]);
        	            	neuroticism2 = Integer.parseInt(data[4]);
        	            	conscientiousness2 = Integer.parseInt(data[5]);
        	            	data[6]=data[6].substring(0,2);
        	            	//System.out.print(data[6]);
        	            	extraversion2 = Integer.parseInt(data[6]);
        	    		}
        	    	}
        	    }
                Matching demo = new Matching("BIG5");
                demo.pack();
                RefineryUtilities.centerFrameOnScreen(demo);
                demo.setVisible(true);
        }
        public static void call(int o, int a, int n, int c, int e)
        {
        	openness1 = o;
        	agreeableness1 = a;
        	neuroticism1 = n;
        	conscientiousness1 = c;
        	extraversion1 = e;
        	Matching demo = new Matching("BIG5");
            demo.pack();
            RefineryUtilities.centerFrameOnScreen(demo);
            demo.setVisible(true);
        }
}
