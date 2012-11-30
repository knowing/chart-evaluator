package de.lmu.ifi.dbs.chartevaluator.ui;

import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Minute;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYIntervalSeries;
import org.jfree.data.xy.XYIntervalSeriesCollection;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class SampleDataFactory {
	
	//Create Dataset for PieChart
	public static DefaultPieDataset SampleDataPie(long size){
		DefaultPieDataset dataset = new DefaultPieDataset();
		long one = 0;
		long two = 0;
		long three = 0;
		
		for(long i = 0; i < size; i++){
			
			int a = randomActivity(3);

			if (a == 1){
				one++;
			} else if (a == 2){
				two++;
			} else if (a == 3){
				three++;
			} else {
				System.out.println("randomActivity: " + a);
			}
		}
		
		
		dataset.setValue("A1", new Double(one));
		dataset.setValue("A2", new Double(two));
		dataset.setValue("A3", new Double(three));
		return dataset;
	}
	
	//Create Dataset for XYBarChart
	public static IntervalXYDataset SampleDataBar(long size){
		Minute m0 = new Minute(13, 6, 14, 11, 2011);
	    XYIntervalSeriesCollection dataset = new XYIntervalSeriesCollection();
	    XYIntervalSeries s1 = new XYIntervalSeries("S1");
	    XYIntervalSeries s2 = new XYIntervalSeries("S2");
	    XYIntervalSeries s3 = new XYIntervalSeries("S3");

		for(long i = 0; i < size; i++){
			int a = randomActivity(3);
			Minute m1 = (Minute) m0.next();
			
			if (a == 1){
				addItem(s1, m0, m1, a-1);
			} else if (a == 2){
				addItem(s2, m0, m1, a-1);
			} else if (a == 3){
				addItem(s3, m0, m1, a-1);
			} else {
				System.out.println("randomActivity: " + a);
			}
			
			m0 = m1;
			
		}


	    dataset.addSeries(s1);
	    dataset.addSeries(s2);
	    dataset.addSeries(s3);
	    return dataset;
	}
	
	//Create Dataset for XYSplineChart
	public static XYDataset SampleDataSpline(long size){
		
		XYSeries series1 = new XYSeries("Series 1");
		XYSeries series2 = new XYSeries("Series 2");
		XYSeries series3 = new XYSeries("Series 3");
		
		
		for(long i = 0; i < size; i++){
			int a = randomActivity(3);
			
			if (a == 1){
				series1.add((double) i, Math.random());
			} else if (a == 2){
				series2.add((double) i, Math.random());
			} else if (a == 3){
				series3.add((double) i, Math.random());
			} else {
				System.out.println("randomActivity: " + a);
			}
		
		}
		

        XYSeriesCollection dataset = new XYSeriesCollection(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
		
		return dataset;
	}
	
	
    private static void addItem(XYIntervalSeries s, RegularTimePeriod p0, RegularTimePeriod p1, int index) {
        s.add(index, index - 0.45, index + 0.45, p0.getFirstMillisecond(), p0.getFirstMillisecond(), p1.getLastMillisecond());
    }
	
    
	public static int randomActivity(int i) {
		i++;
		return (int) (Math.random() * (i - 1) + 1);
	}
	
	

}
