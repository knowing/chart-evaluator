package de.lmu.ifi.dbs.chartevaluator.ui;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;


public class OptionsComponent {
	
	@Inject
	private IEventBroker eventBroker; 
	
	Scale scale_numData;
	Combo comboBar_chartType;
	Combo comboBar_chartLib;
	int datasetSize = 0;
	ChartProvider.JFreeChartTypes option_chartType;
	private Label lblDatasetSize;
	

	public OptionsComponent() {
	}
	
	
	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(5, false));
		
		
		//choose chart library
		comboBar_chartLib = new Combo(parent, SWT.BORDER);
		comboBar_chartLib.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		comboBar_chartLib.setItems(new String[] {"JFreeChart"});
		comboBar_chartLib.setText("Chart Library");
		
		
		//choose chart type
		ChartProvider.JFreeChartTypes[] chartTypes = ChartProvider.JFreeChartTypes.values();
		String[] chTypes = new String[chartTypes.length];
		for (int i = 0; i < chartTypes.length; i++) {
			chTypes[i] = chartTypes[i].toString();
		}
		
		comboBar_chartType = new Combo(parent, SWT.BORDER);
		comboBar_chartType.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		comboBar_chartType.setItems(chTypes);
		comboBar_chartType.setText("Chart Type");

		comboBar_chartType.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				option_chartType = ChartProvider.JFreeChartTypes.valueOf(comboBar_chartType.getItem(comboBar_chartType.getSelectionIndex()));
			}
		});
		
		
		//choose dataset size
		scale_numData = new Scale(parent, SWT.NONE);
		scale_numData.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		scale_numData.setMaximum(100000);
		scale_numData.setToolTipText("Size: " + datasetSize);
		scale_numData.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				datasetSize = scale_numData.getSelection();
				scale_numData.setToolTipText("Size: " + datasetSize);
				lblDatasetSize.setText("size: "+datasetSize);
				lblDatasetSize.update();
			}
		});

		
		//show dataset size
		lblDatasetSize = new Label(parent, SWT.NONE);
		lblDatasetSize.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblDatasetSize.setText("size: 0-100000");

		
		//submit choices
		Button button_Run = new Button(parent, SWT.NONE);
		button_Run.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		button_Run.setText("Run");
		button_Run.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ChartProperties prop = new ChartProperties();
				prop.setType(option_chartType);
				prop.setSize(datasetSize);
				eventBroker.post(ResultComponent.TOPIC_NEWDATA, prop);
			}
		});

	}

	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
		// TODO	Set the focus to control
	}
	



	
}
