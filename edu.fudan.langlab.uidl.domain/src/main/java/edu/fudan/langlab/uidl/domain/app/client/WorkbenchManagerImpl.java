package edu.fudan.langlab.uidl.domain.app.client;

import java.util.Collection;

import javax.annotation.Nullable;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.Presenter;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;

import edu.fudan.langlab.uidl.domain.app.client.workbench.Workbenchs;

public class WorkbenchManagerImpl implements WorkbenchManager {

	@Inject
	EventBus eventbus;

	private Collection<WorkbenchPartProxy> parts = Lists.newArrayList();
	private Collection<WorkbenchPartCategory> categories = Lists.newArrayList();

	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);

	}

	@Override
	public void registerPresenterProxy(WorkbenchPartProxy workbenchAction) {
		parts.add(workbenchAction);

	}

	@Override
	public Iterable<WorkbenchPartProxy> getPresenterParts(
			final WorkbenchPartCategory category) {
		return Iterables.filter(parts, new Predicate<WorkbenchPartProxy>() {

			@Override
			public boolean apply(@Nullable WorkbenchPartProxy input) {
				return input.getCategory().getCategoryId()
						.equals(category.getCategoryId());
			}
		});
	}

	@Override
	public void registerPresenterProxy(final WorkbenchPartCategory category,
			final String functionId, final Provider<? extends Presenter<?>> p,
			final String title) {
		registerPresenterProxy(new WorkbenchPresenterProxy() {

			@Override
			public Presenter<?> getPresenter() {
				return p.get();
			}

			@Override
			public String getName() {
				return title;
			}

			@Override
			public WorkbenchPartCategory getCategory() {
				return category;
			}

			@Override
			public String getFunctionId() {
				return functionId;
			}
			@Override
			public Boolean requireCheck() {
				return true;
			}
		});
	}

	@Override
	public void registerPresenterCategory(WorkbenchPartCategory category) {
		categories.add(category);

	}

	public void registerDialogProxy(final String categoryId,
			final String functionId,
			final Procedure1<? super Procedure1<? super Presenter<?>>> creator,
			final String title) {
		final WorkbenchPartCategory category = Iterables.find(categories,
				new Predicate<WorkbenchPartCategory>() {

					@Override
					public boolean apply(@Nullable WorkbenchPartCategory input) {
						return input.getCategoryId().equals(categoryId);
					}
				}, null);
		registerPresenterProxy(new WorkbenchWindowProxy() {

			@Override
			public WorkbenchPartCategory getCategory() {
				return category;
			}

			@Override
			public String getFunctionId() {
				return functionId;
			}

			@Override
			public String getName() {
				return title;
			}
			
			@Override
			public Boolean requireCheck() {
				return true;
			}

			@Override
			public void show() {
				creator.apply(new Procedure1<Presenter<?>>() {

					@Override
					public void apply(Presenter<?> p) {
						Workbenchs.popup(p, eventbus);

					}
				});
			}

		});

	}

	@Override
	public void registerPresenterProxy(final String categoryId,
			final String functionId, Provider<? extends Presenter<?>> p,
			String title) {
		WorkbenchPartCategory category = Iterables.find(categories,
				new Predicate<WorkbenchPartCategory>() {

					@Override
					public boolean apply(@Nullable WorkbenchPartCategory input) {
						return input.getCategoryId().equals(categoryId);
					}
				}, null);
		registerPresenterProxy(category, functionId, p, title);
	}

	@Override
	public void registerCommand(final WorkbenchPartCategory category,final BaseSimpleCommand simpleCommand) {

		registerPresenterProxy(new WorkbenchCommandProxy() {
			
			@Override
			public String getName() {
				return simpleCommand.getTitle();
			}
			
			@Override
			public String getFunctionId() {
				return simpleCommand.getActionId();
			}
			
			@Override
			public WorkbenchPartCategory getCategory(){
				return category;
			}
			
			@Override
			public void execute() {
				simpleCommand.execute();
				
			}

			@Override
			public Boolean requireCheck() {
				return simpleCommand.requireCheck();
			}
		});
	}
	
	@Override
	public void registerPresenterProxy(final String categoryId,
			final String functionId,
			final Procedure1<? super Procedure1<? super Presenter<?>>> creator,
			final String title) {
		final WorkbenchPartCategory category = Iterables.find(categories,
				new Predicate<WorkbenchPartCategory>() {

					@Override
					public boolean apply(@Nullable WorkbenchPartCategory input) {
						return input.getCategoryId().equals(categoryId);
					}
				}, null);
		WorkbenchActivePresenterProxy p = new WorkbenchActivePresenterProxy() {

			@Override
			public WorkbenchPartCategory getCategory() {
				return category;
			}

			@Override
			public String getName() {
				return title;
			}

			@Override
			public void getPresenter(
					Procedure1<Presenter<? extends Object>> postInit) {
				creator.apply(postInit);
			}

			@Override
			public String getFunctionId() {
				return functionId;
			}
			@Override
			public Boolean requireCheck() {
				return true;
			}

		};

		registerPresenterProxy(p);

	}

	@Override
	public Collection<WorkbenchPartCategory> getCategories() {
		return categories;
	}

	private Presenter<?> header;

	@Override
	public void registerHeaderPresenter(Presenter<?> header) {
		this.header = header;
	}

	@Override
	public Presenter<?> getHeaderPresenter() {
		return header;
	}



}
