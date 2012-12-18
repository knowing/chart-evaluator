package de.lmu.ifi.dbs.chartevaluator.ui;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.jfree.chart.JFreeChart;
import org.jfree.experimental.chart.swt.ChartComposite;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

import org.eclipse.swt.layout.FillLayout;

import com.google.common.base.Stopwatch;


public class ResultComponent {

	private JFreeChart chart;
	private ChartComposite composite;
	private Composite composite_Chart;
	private Composite compositeTimeMeasurement;
	private Label lblTime;
	private String option_chartType = "";
	
	public static String measuredDataset = "";
	public static String measuredChart = "";
	public static String measuredRendering = "";
	
	public static final String TOPIC_NEWDATA = "TOPIC_NEWDATA";

	
	
	
	public ResultComponent() {
	}
	
	@Inject @Optional
	void closeHandler(@UIEventTopic(TOPIC_NEWDATA) ChartProperties prop) {
		ChartProv newchart = new ChartProv();
		chart = newchart.createChart(prop);
		composite.setChart(chart);
		TimeMeasurement.measureChart();
		TimeMeasurement.startMeasurement();
	    composite.pack();
	    composite_Chart.layout();
		measureRendering();
		
	} 

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		
		//time measurement
		compositeTimeMeasurement = new Composite(parent, SWT.BORDER);
		compositeTimeMeasurement.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		compositeTimeMeasurement.setLayout(new GridLayout(1, false));
		
		lblTime = new Label(compositeTimeMeasurement, SWT.HORIZONTAL);
		lblTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblTime.setText("\r\n\r\n\r\n");
		
		
		ProgressBar progressBar = new ProgressBar(parent, SWT.NONE);
		progressBar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		
		//resulting chart
		composite_Chart = new Composite(parent, SWT.NONE);
		composite_Chart.setLayout(new FillLayout(SWT.HORIZONTAL));
		composite_Chart.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		composite = new ChartComposite(composite_Chart, SWT.NONE);

	}
	
	public void upd(){
		Display.getCurrent().update();
	}
	
	
	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
		// TODO	Set the focus to control
	}
	
	  private void measureRendering() {
		    Display.getDefault().asyncExec(new Runnable() {
		      public void run() {
		    	TimeMeasurement.measureRendering();
		    	lblTime.setText("Dataset created in " + measuredDataset + "\r\nChart created in " + measuredChart + "\r\nRendered in " + measuredRendering);
		  		compositeTimeMeasurement.layout();
		      }
		    });
	  }

}
