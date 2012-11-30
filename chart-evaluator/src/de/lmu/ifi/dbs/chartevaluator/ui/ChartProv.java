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
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.RectangleInsets;


public class ChartProv implements ChartProvider<JFreeChart>{
	
	public JFreeChart chart;

	public JFreeChart createChart(ChartProperties properties){
		
		if(properties.GetType().equals("XYSplineRenderer")){
			
	        NumberAxis xAxis = new NumberAxis("Time");
	        xAxis.setAutoRangeIncludesZero(false);
	        NumberAxis yAxis = new NumberAxis("Activity");
	        yAxis.setAutoRangeIncludesZero(false);

	        XYSplineRenderer renderer = new XYSplineRenderer();
	        XYPlot plot = new XYPlot(SampleDataFactory.SampleDataSpline(properties.GetSize()), xAxis, yAxis, renderer);
	        plot.setAxisOffset(new RectangleInsets(4, 4, 4, 4));
	        JFreeChart splinechart = new JFreeChart("XYSplineRenderer", JFreeChart.DEFAULT_TITLE_FONT, plot, true);
	        ChartUtilities.applyCurrentTheme(splinechart);
	        
	        this.chart = splinechart;
	        
		} else if(properties.GetType().equals("PieChart")){

			JFreeChart piechart = ChartFactory.createPieChart("Piechart", SampleDataFactory.SampleDataPie(properties.GetSize()), true, true, false);
			PiePlot plot = (PiePlot) piechart.getPlot();
			plot.setCircular(true);
			
			this.chart = piechart;
			
		} else if(properties.GetType().equals("XYBarChart")){					
		    
		        JFreeChart barchart = ChartFactory.createXYBarChart("XYBarChart", "X", true, "Y", SampleDataFactory.SampleDataBar(properties.GetSize()), PlotOrientation.HORIZONTAL, true, false, false);

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
