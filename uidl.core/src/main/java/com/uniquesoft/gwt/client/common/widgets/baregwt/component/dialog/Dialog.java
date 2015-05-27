package com.uniquesoft.gwt.client.common.widgets.baregwt.component.dialog;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.uniquesoft.gwt.client.common.Presenter;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;

/**
 * This class extends from the GWT dialog "DialogBox";
 *Bind a presenter for a dialog,and set the dialog title when we 
 *init it. however, this class is not directly used in UIDL, DialogExtensions
 * make a further encapsulation for it.
 *
 */
public class Dialog extends DialogBox {

	private Presenter<?> presenter;
	private String dialogTitle;
	private boolean okOnly = false;
	private Procedure1<Void> postAction;
	
	/**
	 * @param presenter
	 * @param title
	 * Bind a presenter and view for the dialog to show, if the presenter has not inplement from 
	 * IManableByDialog, it will throw an exception
	 */
	public Dialog(Presenter<?> presenter, String title) {
		if (!(presenter instanceof IManagableByDialog))
			throw new RuntimeException(
					"presenter that will show in dialog should implement IManagableByDialog interface");
		this.presenter = presenter;
		this.dialogTitle = title;
	}
	
	public Dialog(Presenter<?> presenter, String title,Procedure1<Void> postAction) {
		this(presenter,title);
		this.postAction = postAction;
		
	}
	
	/**
	 * @param okOnly Boolean value to decide whether a cancel button is needed.
	 * In UIDL set "okonly" true or false to decide whether 
	 * a cancel button will be added on the dialog
	 */
	public void setOkOnly(Boolean okOnly){
		this.okOnly = okOnly;
	}
	
	/**
	 * After the presenter has got all the things ready, put the binded presenter contents in a 
	 * VerticalPanel, then add a "ok" button for client to save data and close the dialog.if needed,
	 * add a cancel button to close the dialog. 
	 */
	public void initialize() {
		this.setGlassEnabled(true);
		this.setAnimationEnabled(true);
		this.setText(dialogTitle);
		this.center();
		presenter.activate(new IPostInitializeAction() {

			@Override
			public void initializeFinished(Void v) {
				VerticalPanel dialogContents = new VerticalPanel();
				dialogContents.setWidth("100%");
//				dialogContents.setSpacing(4);
				Dialog.this.setWidget(dialogContents);
//				dialogContents.add(presenter.getView().asWidget());
				Button okButton = new Button("Ok");
				okButton.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						((IManagableByDialog) presenter)
						.performFinish(new Procedure0() {

							@Override
							public void apply() {
								if(Dialog.this.postAction!=null)
									postAction.apply(null);
								Dialog.this.hide();
							}
						});
					}

				});
				Button cancelButton = new Button("Cancel");
				cancelButton.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						Dialog.this.hide();
					}
				});
				HorizontalPanel buttonPanel = new HorizontalPanel();
				dialogContents.add(buttonPanel);
				dialogContents.setCellHorizontalAlignment(buttonPanel,HasHorizontalAlignment.ALIGN_RIGHT);
				buttonPanel.add(okButton);
				if(!Dialog.this.okOnly){
					buttonPanel.add(cancelButton);
				}
				
			}

		});
	}
}
