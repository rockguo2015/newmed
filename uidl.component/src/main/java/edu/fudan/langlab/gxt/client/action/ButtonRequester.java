package edu.fudan.langlab.gxt.client.action;

import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.action.Requester;

public class ButtonRequester implements Requester {

	private final TextButton btnRequester;

	public ButtonRequester(String title) {
		btnRequester = new TextButton(title);
	}
	
	public ButtonRequester(TextButton btn){
		this.btnRequester = btn;
	}

	@Override
	public TextButton asWidget() {
		return btnRequester;
	}

	@Override
	public void disable() {
		btnRequester.disable();
	}

	@Override
	public void enable() {
		btnRequester.enable();
	}

	@Override
	public void setRequestHandler(final RequestHandler requestHandler) {
		btnRequester.addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				requestHandler.execute();

			}
		});

	}

}
