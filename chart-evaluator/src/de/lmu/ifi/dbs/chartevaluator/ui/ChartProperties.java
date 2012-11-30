package de.lmu.ifi.dbs.chartevaluator.ui;


public class ChartProperties {
	public int datasetSize = 0;
	
	private String chartType = "XYSplineRenderer";
	
	public String GetType(){
		return this.chartType;
	}
	
	public void SetType(String type){
		this.chartType = type;
	}
	
	public int GetSize(){
		return this.datasetSize;
	}
	
	public void SetSize(int size){
		this.datasetSize = size;
	}


	
}
