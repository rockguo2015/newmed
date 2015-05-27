package edu.fudan.langlab.gxt.client.component.grid.factory;

import com.google.common.collect.Lists;
import com.google.gwt.cell.client.AbstractSafeHtmlCell;
import com.google.gwt.core.client.Callback;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.text.shared.SafeHtmlRenderer;
import com.google.inject.Inject;
import com.sencha.gxt.data.shared.Converter;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.loader.DataProxy;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoadResultBean;
import com.sencha.gxt.data.shared.loader.PagingLoader;
import com.sencha.gxt.widget.core.client.form.ComboBox;
import com.sencha.gxt.widget.core.client.form.NumberField;
import com.sencha.gxt.widget.core.client.form.NumberPropertyEditor;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.SummaryColumnConfig;
import com.sencha.gxt.widget.core.client.grid.SummaryType;
import com.sencha.gxt.widget.core.client.grid.editing.GridEditing;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.name.IObjectNameProvider;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AsyncContentProviderWithFilter;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentLoadedCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.IObjectNameFilter;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.RequireContentProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider.ContentChangedListener;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ISingleValueSelector;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

import edu.fudan.langlab.gxt.client.component.form.factory.ComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.SuggestionComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridColumn;
import edu.fudan.langlab.gxt.client.component.grid.ValueProviderAdaptor;
import edu.fudan.langlab.gxt.client.component.listview.GXTListViewComponent;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
public class DefaultObjectSelectorFactory implements IInitializerSupport {
	@Inject
	RuntimeGinjector runtimeGinjector;

	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);
	}

	public static class SimpleSafeHtmlRenderer<C> implements
			SafeHtmlRenderer<C> {

		private IObjectNameProvider objectNameProvider;

		public SimpleSafeHtmlRenderer(IObjectNameProvider objectNameProvider) {
			this.objectNameProvider = objectNameProvider;
		}

		@Override
		public SafeHtml render(C object) {
			return (object == null) ? SafeHtmlUtils.EMPTY_SAFE_HTML
					: SafeHtmlUtils.fromString(objectNameProvider
							.getName(object));
		}

		@Override
		public void render(C object, SafeHtmlBuilder appendable) {
			appendable.append(SafeHtmlUtils.fromString(objectNameProvider
					.getName(object)));

		}

	}

	public static class SimpleCell<C> extends AbstractSafeHtmlCell<C> {

		public SimpleCell(IObjectNameProvider objectNameProvider) {
			super(new SimpleSafeHtmlRenderer<C>(objectNameProvider));
		}

		@Override
		protected void render(com.google.gwt.cell.client.Cell.Context context,
				SafeHtml value, SafeHtmlBuilder sb) {
			if (value != null) {
				sb.append(value);
			}

		}

	}

	public static class StringValueColumn<D, C> extends GXTGridColumn<D, C> {

		public StringValueColumn(String id, String title,
				IObjectFieldAccessor<D, C> objectValues,
				RuntimeGinjector runtimeGinjector) {
			columnConfig = new SummaryColumnConfig<D, C>(
					new ValueProviderAdaptor<D, C>(objectValues, id));
			columnConfig.setSummaryType(new SummaryType.CountSummaryType<C>());
			columnConfig.setCell(new SimpleCell<C>(runtimeGinjector
					.getObjectNameProvider()));
			columnConfig.setHeader(title);
		}

		public StringValueColumn(String id, String title,
				IObjectFieldAccessor<D, C> objectValues, int width,
				RuntimeGinjector runtimeGinjector) {
			columnConfig = new SummaryColumnConfig<D, C>(
					new ValueProviderAdaptor<D, C>(objectValues, id), width);
			columnConfig.setSummaryType(new SummaryType.CountSummaryType<C>());
			columnConfig.setCell(new SimpleCell<C>(runtimeGinjector
					.getObjectNameProvider()));
			columnConfig.setHeader(title);
		}

		@Override
		public SummaryColumnConfig<D, C> asWidget() {
			return columnConfig;
		}
	}
	

	public static class SuggestionColumn<D, C> extends GXTGridColumn<D, C>
			implements IEditableColumn<D>, ISingleValueSelector<C>,ObjectSelectionProvider<C>{
		private ListStore<C> store;
		private ComboBox<C> comboBox;
		private AsyncContentProviderWithFilter<C, IObjectNameFilter> provider;
		private IObjectNameProvider nameProvider;

		public SuggestionColumn(String id, String title,
				GXTListViewComponent<C> listViewComponent,
				IObjectFieldAccessor<D, C> objectValues,
				RuntimeGinjector runtimeGinjector) {
			columnConfig = new SummaryColumnConfig<D, C>(
					new ValueProviderAdaptor<D, C>(objectValues, id));
			columnConfig.setCell(new SimpleCell<C>(runtimeGinjector
					.getObjectNameProvider()));
			columnConfig.setHeader(title);
			
			
			nameProvider = runtimeGinjector.getObjectNameProvider();

			store = new ListStore<C>(new ModelKeyProvider<C>() {

				@Override
				public String getKey(C item) {
					return nameProvider.getId(item);

				}

			});
			final PagingLoader<PagingLoadConfig, PagingLoadResult<C>> loader = new PagingLoader<PagingLoadConfig, PagingLoadResult<C>>(
					new DataProxy<PagingLoadConfig, PagingLoadResult<C>>() {

						@Override
						public void load(
								final PagingLoadConfig loadConfig,
								final Callback<PagingLoadResult<C>, Throwable> callback) {
							IObjectNameFilter criteria = provider.createCriteria();
							criteria.setName(comboBox.getText() + "%");
							int targetPage = loadConfig.getOffset()
									/ loadConfig.getLimit() + 1;
							criteria.setPage(targetPage);
							criteria.setPageSize(loadConfig.getLimit());
							provider.loadContent(criteria,
									new ContentLoadedCallback() {

										@Override
										public void contentLoaded() {
											if (provider.getContents() instanceof IPagedResult) {
												long totalRecords = ((IPagedResult<C>) provider
														.getContents())
														.getTotalRecords();
												int targetPage = ((IPagedResult<C>) provider
														.getContents()).getPage();
												callback.onSuccess(new PagingLoadResultBean<C>(
														Lists.newArrayList(provider
																.getContents()),
														(int) totalRecords,
														targetPage - 1));

											} else
												callback.onSuccess(new PagingLoadResultBean<C>(
														Lists.newArrayList(provider
																.getContents()),
														(int) 100, 0));
										}

									});
						}
					});

			comboBox = new ComboBox<C>(store, new LabelProvider<C>() {

				@Override
				public String getLabel(C item) {
					return nameProvider.getName(item);
				}
			}, listViewComponent.asWidget());

			comboBox.setLoader(loader);
			comboBox.setPageSize(10);
			comboBox.setForceSelection(false);
			comboBox.setMinListWidth(300);
			// comboBox.setTriggerAction(TriggerAction.ALL);
			// comboBox.setTypeAhead(true);
			comboBox.getCell().setMinChars(2);
			
		}

		@Override
		public void initializeEditor(GridEditing<D> gridEditing) {
			gridEditing.addEditor(columnConfig,comboBox);
		}

		@Override
		public void setContentProvider(ContentProvider<C> provider) {
			this.provider = (AsyncContentProviderWithFilter<C, IObjectNameFilter>) provider;
			provider.addContentChangedListener(new ContentChangedListener() {

				@Override
				public void onContentChanged() {
					store.clear();
					for (C item : SuggestionColumn.this.provider
							.getContents()) {
						store.add(item);
					}
				}
			});
			store.clear();
			for (C item : provider.getContents()) {
				store.add(item);
			}
		}

		@Override
		public Iterable<C> getSelectedObjects() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void deselect() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void select(C item) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addSelectionChangedListener(
				final com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener<C> listener) {
			comboBox.addValueChangeHandler(new ValueChangeHandler<C>() {

				@Override
				public void onValueChange(ValueChangeEvent<C> event) {
					listener.selectionChanged(getSelectedObjects());
				}

			});
			
		}

	}

	@WidgetProvider(isDefault = true, requireAccessor = true)
	public <D, C> StringValueColumn<D, C> createAsDefaultColumn(String id,
			String title, IObjectFieldAccessor<D, C> objectValues) {
		return new StringValueColumn<D, C>(id, title, objectValues,
				runtimeGinjector);
	}

	@WidgetProvider(requireAccessor = true)
	public <D, C> StringValueColumn<D, C> createAsDefaultColumn(String id,
			String title, IObjectFieldAccessor<D, C> objectValues, int width) {
		return new StringValueColumn<D, C>(id, title, objectValues, width,
				runtimeGinjector);
	}
	
	@WidgetProvider(requireAccessor = true)
	public <D, C> StringValueColumn<D, C> createAsStringColumn(String id,
			String title, IObjectFieldAccessor<D, C> objectValues, int width) {
		return new StringValueColumn<D, C>(id, title, objectValues, width,
				runtimeGinjector);
	}

	@WidgetProvider(requireAccessor = true)
	public <D, C> StringValueColumn<D, C> createAsAutoExpandColumn(String id,
			String title, IObjectFieldAccessor<D, C> objectValues) {
		StringValueColumn<D, C> result = new StringValueColumn<D, C>(id, title,
				objectValues, runtimeGinjector);
		result.setAutoExpand(true);
		return result;
	}

	@WidgetProvider(requireAccessor = true)
	@RequireContentProvider
	public <D, C> SuggestionColumn<D, C> createAsSuggestionColumn(
			String id, String title,IObjectFieldAccessor<D, C> objectValues, GXTListViewComponent<C> listViewComponent) {
		SuggestionColumn<D, C> result = new SuggestionColumn<D, C>(id, title,listViewComponent,
				objectValues, runtimeGinjector);
		return result;
	}

}
