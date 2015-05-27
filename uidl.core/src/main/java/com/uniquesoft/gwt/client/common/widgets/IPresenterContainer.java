package com.uniquesoft.gwt.client.common.widgets;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.gwt.user.client.ui.Widget;
import com.uniquesoft.gwt.client.common.Presenter;

public interface IPresenterContainer {

	public abstract void showActivatedPresenter(String title, Presenter p);

	public abstract void showActivatedPresenter(Presenter p);

	public abstract void showPresenter(Presenter p);

	public abstract void showPresenter(Presenter p,
			Procedure1<? super Void> postInitializer);
	
	public abstract void clear();

	public abstract Widget asWidget();

	public abstract void destory();

}