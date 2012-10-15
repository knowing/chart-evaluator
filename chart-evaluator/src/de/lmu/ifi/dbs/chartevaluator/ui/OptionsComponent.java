package de.lmu.ifi.dbs.chartevaluator.ui;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.CCombo;

public class OptionsComponent {

	public OptionsComponent() {
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(4, false));
		
		CCombo comboBar_chartLib = new CCombo(parent, SWT.BORDER);
		comboBar_chartLib.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		comboBar_chartLib.setItems(new String[] {"Lib1", "Lib2", "Lib3"});
		comboBar_chartLib.setText("Chart Library");
		
		CCombo comboBar_chartType = new CCombo(parent, SWT.BORDER);
		comboBar_chartType.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		comboBar_chartType.setItems(new String[] {"Bar", "Area", "Pie", "Bubble"});
		comboBar_chartType.setText("Chart Type");
		
		Scale scale_numData = new Scale(parent, SWT.NONE);
		scale_numData.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		scale_numData.setMaximum(1000000);
		
		Button button_Run = new Button(parent, SWT.NONE);
		button_Run.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		button_Run.setText("Run");
	}

	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
		// TODO	Set the focus to control
	}

}
