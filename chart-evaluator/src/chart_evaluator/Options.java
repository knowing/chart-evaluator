package chart_evaluator;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.widgets.Composite;
import swing2swt.layout.FlowLayout;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Button;

public class Options {

	public Options() {
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		ToolBar toolBar = new ToolBar(parent, SWT.FLAT | SWT.RIGHT);
		
		ToolItem tltmChartLibrary = new ToolItem(toolBar, SWT.DROP_DOWN);
		tltmChartLibrary.setText("Chart Library");
		
		ToolBar toolBar_1 = new ToolBar(parent, SWT.FLAT | SWT.RIGHT);
		
		ToolItem tltmChartType = new ToolItem(toolBar_1, SWT.DROP_DOWN);
		tltmChartType.setText("Chart Type");
		
		Scale scale = new Scale(parent, SWT.NONE);
		scale.setMaximum(1000000);
		
		Button btnRun = new Button(parent, SWT.NONE);
		btnRun.setText("Run");
	}

	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
		// TODO	Set the focus to control
	}

}
