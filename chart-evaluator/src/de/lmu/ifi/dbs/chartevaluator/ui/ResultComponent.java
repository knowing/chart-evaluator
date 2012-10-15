package de.lmu.ifi.dbs.chartevaluator.ui;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public class ResultComponent {

	public ResultComponent() {
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		
		Label lblTime = new Label(parent, SWT.BORDER | SWT.HORIZONTAL);
		lblTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblTime.setText("Dataset created in 123ms\r\nRendered in 4567ms");
		
		ProgressBar progressBar = new ProgressBar(parent, SWT.NONE);
		progressBar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblChart = new Label(parent, SWT.BORDER | SWT.CENTER);
		lblChart.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		lblChart.setText("chart");
	}

	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
		// TODO	Set the focus to control
	}

}
