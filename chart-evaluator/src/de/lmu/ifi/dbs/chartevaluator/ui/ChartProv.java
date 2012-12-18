package de.lmu.ifi.dbs.chartevaluator.ui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.RectangleInsets;


public class ChartProv implements ChartProvider<JFreeChart>{
	
	public JFreeChart chart;

	public JFreeChart createChart(ChartProperties properties){
		
		if(properties.getType().equals(ChartProvider.JFreeChartTypes.XYSplineRenderer)){
			TimeMeasurement.startMeasurement();
			XYDataset dataset = SampleDataFactory.SampleDataSpline(properties.getSize());
			TimeMeasurement.measureDataset();
			
			
	        NumberAxis xAxis = new NumberAxis("Time");
	        xAxis.setAutoRangeIncludesZero(false);
	        NumberAxis yAxis = new NumberAxis("Activity");
	        yAxis.setAutoRangeIncludesZero(false);

	        XYSplineRenderer renderer = new XYSplineRenderer();
	        XYPlot plot = new XYPlot(dataset, xAxis, yAxis, renderer);
	        plot.setAxisOffset(new RectangleInsets(4, 4, 4, 4));
	        TimeMeasurement.startMeasurement();
	        JFreeChart splinechart = new JFreeChart("XYSplineRenderer", JFreeChart.DEFAULT_TITLE_FONT, plot, true);
	        ChartUtilities.applyCurrentTheme(splinechart);
	        
	        
	        
	        this.chart = splinechart;
	        
		} else if(properties.getType().equals(ChartProvider.JFreeChartTypes.PieChart)){
			
			TimeMeasurement.startMeasurement();
			DefaultPieDataset dataset = SampleDataFactory.SampleDataPie(properties.getSize());
			TimeMeasurement.measureDataset();
			TimeMeasurement.startMeasurement();
			JFreeChart piechart = ChartFactory.createPieChart("Piechart", dataset, true, true, false);
			PiePlot plot = (PiePlot) piechart.getPlot();
			plot.setCircular(true);
			
			this.chart = piechart;
			
		} else if(properties.getType().equals(ChartProvider.JFreeChartTypes.XYBarChart)){					
		    
			TimeMeasurement.startMeasurement();
			IntervalXYDataset dataset = SampleDataFactory.SampleDataBar(properties.getSize());
			TimeMeasurement.measureDataset();
			TimeMeasurement.startMeasurement();
	        JFreeChart barchart = ChartFactory.createXYBarChart("XYBarChart", "X", true, "Y", dataset, PlotOrientation.HORIZONTAL, true, false, false);

	        XYPlot plot = (XYPlot) barchart.getPlot();
	        plot.setRangeAxis(new DateAxis("Date"));
	        SymbolAxis xAxis = new SymbolAxis("Activity", new String[] {"A1", "A2", "A3"});
	        xAxis.setGridBandsVisible(false);
	        plot.setDomainAxis(xAxis);
	        XYBarRenderer renderer = (XYBarRenderer) plot.getRenderer();
	        renderer.setUseYInterval(true);
	        plot.setRenderer(renderer);


	        this.chart = barchart;
		    
		}
		
		return chart;
	}
	
}
