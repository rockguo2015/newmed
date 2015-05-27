package edu.fudan.langlab.gxt.client.dialog;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.HideEvent;
import com.sencha.gxt.widget.core.client.event.HideEvent.HideHandler;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.uniquesoft.gwt.client.common.AbstractPresenter;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.Presenter;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;

public class GXTDialog extends Dialog {

	private Procedure0 postAction;

	public void setPostAction(Procedure0 postAction) {
		this.postAction = postAction;
	}

	private void initialize(final CommitablePresenter presenter) {
		this.setResizable(false);
		add(((Presenter<?>) presenter).getView().asWidget());
		this.addHideHandler( new HideHandler() {
			
			@Override
			public void onHide(HideEvent event) {
				if(((Presenter<?>) presenter).getIsActivated()){
					((Presenter<?>) presenter).deactivate();
				}
			}
		});

		TextButton cancelButton = getButtonById(PredefinedButton.CANCEL.name());
		cancelButton.addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				GXTDialog.this.hide();
			}
		});
		final TextButton okButton = getButtonById(PredefinedButton.OK.name());
		((AbstractPresenter<?>) presenter)
				.setRPCFailureHandler(new Procedure0() {

					@Override
					public void apply() {
						okButton.enable();

					}
				});
		okButton.addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				okButton.disable();
				presenter.performCommit(new CommitResultNotifier() {

					@Override
					public void success() {
						GXTDialog.this.hide();
						if (postAction != null)
							postAction.apply();
					}

					@Override
					public void failed() {
						okButton.enable();
					}
				});
			}
		});

	}

	public GXTDialog(final CommitablePresenter presenter, boolean isActivated) {
		setPredefinedButtons(PredefinedButton.OK, PredefinedButton.CANCEL);

		this.setModal(true);
		if (!isActivated)
			((Presenter<?>) presenter).activate(new IPostInitializeAction() {

				@Override
				public void initializeFinished(Void v) {
					initialize(presenter);
				}
			});
		else
			initialize(presenter);

	}

	public GXTDialog(final CommitablePresenter presenter) {
		setPredefinedButtons(PredefinedButton.OK, PredefinedButton.CANCEL);

		this.setModal(true);
		((Presenter<?>) presenter).activate(new IPostInitializeAction() {

			@Override
			public void initializeFinished(Void v) {
				initialize(presenter);
			}
		});
	}
	
}
