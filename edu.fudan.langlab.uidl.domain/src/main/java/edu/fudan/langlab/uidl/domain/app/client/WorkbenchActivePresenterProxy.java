package edu.fudan.langlab.uidl.domain.app.client;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.uniquesoft.gwt.client.common.Presenter;

public interface WorkbenchActivePresenterProxy extends WorkbenchPartProxy{
	
	void getPresenter(Procedure1<Presenter<? extends Object>> postInit);

}
