package edu.fudan.langlab.uidl.domain.app.client;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.Presenter;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;

public interface WorkbenchManager extends IInitializerSupport {

	void registerPresenterCategory(WorkbenchPartCategory category);

	void registerPresenterProxy(WorkbenchPartProxy workbenchAction);

	void registerPresenterProxy(WorkbenchPartCategory category,
			final String functionId, final Provider<? extends Presenter<?>> p,
			final String title);

	void registerPresenterProxy(String categoryId, final String functionId,
			final Provider<? extends Presenter<?>> p, final String title);

	void registerPresenterProxy(String categoryId, final String functionId,
			Procedure1<? super Procedure1<? super Presenter<?>>> p,
			final String title);
	
	void registerCommand(final WorkbenchPartCategory category,BaseSimpleCommand simpleCommand);

	public void registerDialogProxy(final String categoryId,
			final String functionId,
			final Procedure1<? super Procedure1<? super Presenter<?>>> creator,
			final String title);

	Iterable<WorkbenchPartCategory> getCategories();

	Iterable<WorkbenchPartProxy> getPresenterParts(
			WorkbenchPartCategory category);

	void registerHeaderPresenter(Presenter<? extends Viewer> header);

	Presenter<? extends Viewer> getHeaderPresenter();

}
