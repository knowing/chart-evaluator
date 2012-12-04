package de.lmu.ifi.dbs.chartevaluator.ui;


public class ChartProperties {
	public int datasetSize;
	
	private ChartProvider.JFreeChartTypes chartType;
	
	public ChartProvider.JFreeChartTypes getType(){
		return this.chartType;
	}
	
	public void setType(ChartProvider.JFreeChartTypes type){
		this.chartType = type;
	}
	
	public int getSize(){
		return this.datasetSize;
	}
	
	public void setSize(int size){
		this.datasetSize = size;
	}


	
}
