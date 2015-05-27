package edu.fudan.langlab.gxt.client.component.form.factory;

import java.util.Collection;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

import com.google.common.collect.Lists;
import com.google.gwt.core.client.Callback;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.text.shared.AbstractSafeHtmlRenderer;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.loader.BeforeLoadEvent;
import com.sencha.gxt.data.shared.loader.DataProxy;
import com.sencha.gxt.data.shared.loader.LoadEvent;
import com.sencha.gxt.data.shared.loader.LoadExceptionEvent;
import com.sencha.gxt.data.shared.loader.LoaderHandler;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoadResultBean;
import com.sencha.gxt.data.shared.loader.PagingLoader;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.form.ComboBox;
import com.sencha.gxt.widget.core.client.form.Field;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;
import com.uniquesoft.gwt.client.common.name.IObjectNameProvider;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AsyncContentProviderWithFilter;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentLoadedCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider.ContentChangedListener;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.IObjectNameFilter;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ISingleValueSelector;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

import edu.fudan.langlab.gxt.client.component.listview.GXTListViewComponent;

public class SuggestionComboBoxSelector<T> implements ISingleValueSelector<T>,
		ObjectSelectionProvider<T> {

	private final class PagerDataProxy implements
			DataProxy<PagingLoadConfig, PagingLoadResult<T>> {
		@Override
		public void load(final PagingLoadConfig loadConfig,
				final Callback<PagingLoadResult<T>, Throwable> callback) {
			IObjectNameFilter criteria = provider.createCriteria();
			criteria.setName("%" + comboBox.getText() + "%");
			System.out.println(criteria.getName());
			int targetPage = loadConfig.getOffset() / loadConfig.getLimit() + 1;
			criteria.setPage(targetPage);
			criteria.setPageSize(loadConfig.getLimit());
			provider.loadContent(criteria, new ContentLoadedCallback() {

				@Override
				public void contentLoaded() {
					if (provider.getContents() instanceof IPagedResult) {
						System.out.println("paged result ");
						long totalRecords = ((IPagedResult<T>) provider
								.getContents()).getTotalRecords();
						int targetPage = ((IPagedResult<T>) provider
								.getContents()).getPage();
						callback.onSuccess(new PagingLoadResultBean<T>(Lists
								.newArrayList(provider.getContents()),
								(int) totalRecords, (targetPage - 1)
										* loadConfig.getLimit()));

					} else {
						System.out.println("not paged result ");

						Collection<T> contents = provider.getContents();
						callback.onSuccess(new PagingLoadResultBean<T>(Lists
								.newArrayList(contents), (int) 20, 0));
					}
				}

			});
		}
	}

	private IObjectNameProvider nameProvider;
	private FieldLabel fieldLabel;
	private Function1<T, String> renderer;

	public SuggestionComboBoxSelector(String id, final String title,
			Boolean isRequired, GXTListViewComponent<T> listViewComponent,
			RuntimeGinjector runtimeGinjector) {
		nameProvider = runtimeGinjector.getObjectNameProvider();

		store = new ListStore<T>(new ModelKeyProvider<T>() {

			@Override
			public String getKey(T item) {
				return nameProvider.getId(item);

			}

		});
		final PagingLoader<PagingLoadConfig, PagingLoadResult<T>> loader = new PagingLoader<PagingLoadConfig, PagingLoadResult<T>>(
				new PagerDataProxy());

		LabelProvider<T> labelProvider = new LabelProvider<T>() {

			@Override
			public String getLabel(T item) {
				return nameProvider.getName(item);
			}
		};

		comboBox = new ComboBox<T>(new ComboBoxCell<T>(store, labelProvider,
				listViewComponent.asWidget()) {
		});

		loader.addLoaderHandler(new LoaderHandler<PagingLoadConfig, PagingLoadResult<T>>() {

			@Override
			public void onBeforeLoad(BeforeLoadEvent<PagingLoadConfig> event) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onLoadException(
					LoadExceptionEvent<PagingLoadConfig> event) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onLoad(
					LoadEvent<PagingLoadConfig, PagingLoadResult<T>> event) {
				if (comboBox.getCell().getStore().size() > 0) {
					comboBox.getCell().select(0);
				}

			}

		});

		comboBox.setLoader(loader);
		comboBox.setPageSize(20);
		comboBox.setMinListWidth(320);
		comboBox.getCell().setMinChars(1);

		if (isRequired) {
			fieldLabel = new FieldLabel(comboBox);
			fieldLabel.setHTML(Forms.toRequiredTitle(title));
		} else
			fieldLabel = new FieldLabel(comboBox, title);

	}

	public SuggestionComboBoxSelector(String id, final String title,Boolean isRequired,
			RuntimeGinjector runtimeGinjector) {
		nameProvider = runtimeGinjector.getObjectNameProvider();

		store = new ListStore<T>(new ModelKeyProvider<T>() {

			@Override
			public String getKey(T item) {
				return nameProvider.getId(item);

			}

		});
		final PagingLoader<PagingLoadConfig, PagingLoadResult<T>> loader = new PagingLoader<PagingLoadConfig, PagingLoadResult<T>>(
				new PagerDataProxy());

		comboBox = new ComboBox<T>(store, new LabelProvider<T>() {

			@Override
			public String getLabel(T item) {
				return nameProvider.getName(item);
			}
		}, new AbstractSafeHtmlRenderer<T>() {

			@Override
			public SafeHtml render(T object) {
				if (renderer == null)
					return SafeHtmlUtils.fromString(nameProvider
							.getName(object));
				else
					return SafeHtmlUtils.fromTrustedString(renderer
							.apply(object));
			}

		});

		loader.addLoaderHandler(new LoaderHandler<PagingLoadConfig, PagingLoadResult<T>>() {

			@Override
			public void onBeforeLoad(BeforeLoadEvent<PagingLoadConfig> event) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onLoadException(
					LoadExceptionEvent<PagingLoadConfig> event) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onLoad(
					LoadEvent<PagingLoadConfig, PagingLoadResult<T>> event) {
				if (comboBox.getCell().getStore().size() > 0) {
					comboBox.getCell().select(0);
				}

			}

		});

		comboBox.setLoader(loader);
		comboBox.setPageSize(20);
		comboBox.setMinListWidth(320);
		comboBox.getCell().setMinChars(1);
		if (isRequired) {
			fieldLabel = new FieldLabel(comboBox);
			fieldLabel.setHTML(Forms.toRequiredTitle(title));
		} else
			fieldLabel = new FieldLabel(comboBox, title);

	}

	private ListStore<T> store;
	private ComboBox<T> comboBox;
	private AsyncContentProviderWithFilter<T, IObjectNameFilter> provider;

	public void setRenderer(Function1<T, String> renderer) {
		this.renderer = renderer;
	}

	@Override
	public void setContentProvider(ContentProvider<T> provider) {

		this.provider = (AsyncContentProviderWithFilter<T, IObjectNameFilter>) provider;
		provider.addContentChangedListener(new ContentChangedListener() {

			@Override
			public void onContentChanged() {
				store.clear();
				for (T item : SuggestionComboBoxSelector.this.provider
						.getContents()) {
					store.add(item);
				}
			}
		});
		store.clear();
		for (T item : provider.getContents()) {
			store.add(item);
		}

	}

	@Override
	public T getValue() {
		return comboBox.getValue();
	}

	@Override
	public void addValueChangedListener(final ValueChangedListener<T> listener) {
		comboBox.addValueChangeHandler(new ValueChangeHandler<T>() {

			@Override
			public void onValueChange(ValueChangeEvent<T> event) {
				listener.onValueChanged(event.getValue());

			}
		});

	}

	@Override
	public IValueViewer<T> setValue(T value) {

		comboBox.setValue(value);
		comboBox.select(value);
		return this;
	}

	@Override
	public FieldLabel asWidget() {
		return fieldLabel;
	}

	public void focus() {
		comboBox.focus();
	}

	public Component getField() {
		return comboBox;
	}

	@Override
	public Iterable<T> getSelectedObjects() {
		if (getValue() != null)
			return Lists.newArrayList(getValue());
		else
			return Lists.newArrayList();
	}

	public ComboBox<T> getComboBox() {
		return comboBox;
	}

	@Override
	public void addSelectionChangedListener(
			final com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener<T> listener) {
		comboBox.addValueChangeHandler(new ValueChangeHandler<T>() {

			@Override
			public void onValueChange(ValueChangeEvent<T> event) {
				listener.selectionChanged(getSelectedObjects());

			}

		});

	}

	@Override
	public void deselect() {
		comboBox.setValue(null);

	}

	@Override
	public void select(T item) {
		comboBox.setValue(item);

	}

	public void clear() {
		comboBox.setValue(null);
		store.clear();
	}

}
