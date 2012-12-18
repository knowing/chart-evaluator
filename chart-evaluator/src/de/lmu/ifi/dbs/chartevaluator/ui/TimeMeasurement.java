package de.lmu.ifi.dbs.chartevaluator.ui;

import com.google.common.base.Stopwatch;

public class TimeMeasurement {
	
	public static Stopwatch stopwatch = new Stopwatch();
	
	public static void startMeasurement(){
		if (stopwatch.isRunning()){
			stopwatch.stop();
		}
		stopwatch.reset();
		stopwatch.start();
	}
	
	public static void measureDataset(){
		if (stopwatch.isRunning()){
			stopwatch.stop();
			ResultComponent.measuredDataset = stopwatch.toString();
			System.out.println("Dataset: " + ResultComponent.measuredDataset);
		} else {
			System.out.println("Stopwatch hastn't started yet");
		}
	}
	
	public static void measureChart(){
		if (stopwatch.isRunning()){
			stopwatch.stop();
			ResultComponent.measuredChart = stopwatch.toString();
			System.out.println("Chart: " + ResultComponent.measuredChart);
		} else {
			System.out.println("Stopwatch hastn't started yet");
		}
	}
	
	public static void measureRendering(){
		if (stopwatch.isRunning()){
			stopwatch.stop();
			ResultComponent.measuredRendering = stopwatch.toString();
			System.out.println("Rendering: " + ResultComponent.measuredRendering);
		} else {
			System.out.println("Stopwatch hastn't started yet");
		}
	}
	
	

}
