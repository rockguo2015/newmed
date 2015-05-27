package edu.fudan.langlab.uidl.domain.app;

import com.uniquesoft.gwt.client.common.RuntimeGinjector;

import edu.fudan.langlab.uidl.domain.app.client.workbench.FramedPresenter;

public interface UIDLRuntimeGinjector extends RuntimeGinjector {
	public FramedPresenter getFramedPresenter();
}
