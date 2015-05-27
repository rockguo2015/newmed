package edu.fudan.langlab.common.client;

import com.google.gwt.core.client.EntryPoint;
import com.uniquesoft.gwt.client.common.Presenter;

public abstract class UIDLApplication implements EntryPoint {

	public abstract Presenter<?> createMainPresenter();

}
