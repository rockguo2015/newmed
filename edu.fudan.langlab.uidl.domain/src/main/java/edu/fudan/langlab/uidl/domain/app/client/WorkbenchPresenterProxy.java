package edu.fudan.langlab.uidl.domain.app.client;

import com.uniquesoft.gwt.client.common.Presenter;

public interface WorkbenchPresenterProxy extends WorkbenchPartProxy{

	Presenter<?> getPresenter();
}
