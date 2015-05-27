package edu.fudan.langlab.gxt.client.component.form;

import java.util.Collection;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.uniquesoft.gwt.client.common.AbstractPresenter;
import com.uniquesoft.gwt.client.common.SessionTimeoutEvent;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import com.uniquesoft.gwt.client.common.extensions.ConfigurableAsyncCallback;
import com.uniquesoft.gwt.client.common.widgets.component.ValueProviderComponent;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;

public abstract class GXTFormComponent<VT> extends ValueProviderComponent<VT> {
	public abstract ICanAsWidget getWidget(String key) ;
	private Widget con;
	
	@Override
	public Widget asWidget() {
		if(con==null){
			con = createWidget();
		}
		return con;
	}
	
	public Widget createWidget(){
		return null;
	}
	public <T extends Object> AsyncCallback<T> onSuccess(
			final Procedure1<? super T> onSuccess) {
		final ConfigurableAsyncCallback<T> callback = new ConfigurableAsyncCallback<T>();
		callback.onSuccessDo(onSuccess);
		return callback;
	}	
}
