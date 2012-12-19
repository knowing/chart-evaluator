package de.lmu.ifi.dbs.chartevaluator.ui;

public interface ChartProvider<T> {

	public T createChart(ChartProperties properties);

	public static enum JFreeChartTypes {
		XYSplineRenderer, XYBarChart, PieChart;
	}

}