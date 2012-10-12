package chart_evaluator;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.layout.FillLayout;
import swing2swt.layout.FlowLayout;
import swing2swt.layout.BoxLayout;

public class Result {

	public Result() {
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new BorderLayout(0, 0));
		
		Label lblChart = new Label(parent, SWT.BORDER | SWT.CENTER);
		lblChart.setLayoutData(BorderLayout.CENTER);
		lblChart.setText("chart");
		
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(BorderLayout.NORTH);
		FillLayout fl_composite = new FillLayout(SWT.VERTICAL);
		fl_composite.spacing = 2;
		fl_composite.marginWidth = 2;
		fl_composite.marginHeight = 2;
		composite.setLayout(fl_composite);
		
		Label lblTime = new Label(composite, SWT.BORDER | SWT.HORIZONTAL);
		lblTime.setText("Dataset created in 123ms\r\nRendered in 4567ms");
		
		ProgressBar progressBar = new ProgressBar(composite, SWT.NONE);
	}

	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
		// TODO	Set the focus to control
	}

}
