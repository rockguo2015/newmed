package edu.fudan.langlab.gxt.client.component.form.factory;

import java.util.Collection;

import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.event.StoreAddEvent;
import com.sencha.gxt.data.shared.event.StoreAddEvent.StoreAddHandler;
import com.sencha.gxt.data.shared.event.StoreRecordChangeEvent;
import com.sencha.gxt.data.shared.event.StoreRecordChangeEvent.StoreRecordChangeHandler;
import com.sencha.gxt.data.shared.event.StoreRemoveEvent;
import com.sencha.gxt.data.shared.event.StoreRemoveEvent.StoreRemoveHandler;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.AdapterField;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.info.Info;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.RequireContentProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValuesProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;
import com.uniquesoft.gwt.shared.GWTEntity;

import edu.fudan.langlab.gxt.client.component.form.factory.tree.CheckboxTreeMultiSelector;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeContentProvider;

public class DefaultObjectsSelectorFactory implements IInitializerSupport {
	@Inject
	RuntimeGinjector runtimeGinjector;

	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);
	}

	@WidgetProvider
	@RequireContentProvider
	public <T> CheckBoxMultiSelector<T> createAsCheckBoxItem(String id,
			String title) {
		return new CheckBoxMultiSelector<T>(id, title, runtimeGinjector);
	}

	@WidgetProvider(isDefault = true)
	@RequireContentProvider
	public <T> DualListMultiSelector<T> createAsDualListItem(String id,
			String title) {
		return new DualListMultiSelector<T>(id, title, false, runtimeGinjector);
	}

	@WidgetProvider
	@RequireContentProvider
	public <T> DualListMultiSelector<T> createAsRequiredDualListItem(String id,
			String title) {
		return new DualListMultiSelector<T>(id, title, true, runtimeGinjector);
	}

	@WidgetProvider
	@RequireContentProvider
	public <T> CheckboxTreeMultiSelector<T> createAsCheckboxTreeItem(String id,
			String title, ITreeContentProvider<T> treeContentProvider) {
		return new CheckboxTreeMultiSelector<T>(id, title, false,
				treeContentProvider, runtimeGinjector);
	}

	@WidgetProvider
	public <T extends GWTEntity> ListGridBasedItemsProvider<T> createAsListGridBasedItem(
			String id, String title, GXTGridComponent<T> gridComponent) {
		return new ListGridBasedItemsProvider<T>(id, title, gridComponent);
	}

	@WidgetProvider
	public <T extends GWTEntity> ListGridBasedItemsProvider<T> createAsReadonlyListGridBasedItem(
			String id, String title, GXTGridComponent<T> gridComponent) {
		return new ListGridBasedItemsProvider<T>(id, title, gridComponent, true);
	}

	@WidgetProvider
	public <T extends GWTEntity> ListGridBasedItemsProvider<T> createAsEditonlyListGridBasedItem(
			String id, String title, GXTGridComponent<T> gridComponent) {
		return new ListGridBasedItemsProvider<T>(id, title, gridComponent, true);
	}

	@WidgetProvider
	public <T extends GWTEntity> ReadonlyItems<T> createAsReadonlyItems(
			String id, String title) {
		return new ReadonlyItems<T>(id, title,
				runtimeGinjector.getObjectNameProvider());
	}

	public class ListGridBasedItemsProvider<T extends GWTEntity> implements
			IValuesProvider<T> {
		private GXTGridComponent<T> gridComponent;
		private FieldLabel label;
		private Long nextId = -1l;
		private boolean isEditonly;
		private String title;

		public ListGridBasedItemsProvider(String id, final String title,
				final GXTGridComponent<T> gridComponent) {
			this(id, title, gridComponent, false);
		}

		public ListGridBasedItemsProvider(String id, final String title,
				final GXTGridComponent<T> gridComponent,
				final boolean isEditonly) {
			this.gridComponent = gridComponent;
			this.isEditonly = isEditonly;
			this.title = title;
			System.out.println("construct isEditOnly:"+isEditonly);
		}

		@Override
		public void setValue(Collection<T> value) {
			gridComponent.asWidget().getStore().clear();
			for (T t : value) {
				addObject(t);
			}
			// gridComponent.setObjects(value);
		}

		@Override
		public FieldLabel asWidget() {
			if (label == null) {
				System.out.println("isEditOnly:"+isEditonly);
				HorizontalLayoutContainer composite = new HorizontalLayoutContainer();
				VerticalLayoutContainer toolbar = new VerticalLayoutContainer();
				if (!isEditonly) {
					composite.add(gridComponent.asWidget(),
							new HorizontalLayoutData(-1, 1));
					TextButton addButton = new TextButton("添加");
					addButton.setWidth(50);
					toolbar.add(addButton);
					addButton.addSelectHandler(new SelectHandler() {
						@Override
						public void onSelect(SelectEvent event) {
							triggleAddEvent();
						}
					});

					TextButton deleteButton = new TextButton("删除");
					deleteButton.setWidth(50);
					toolbar.add(deleteButton);
					deleteButton.addSelectHandler(new SelectHandler() {

						@Override
						public void onSelect(SelectEvent event) {
							Iterable<T> selected = ListGridBasedItemsProvider.this.gridComponent
									.getSelectedObjects();
							if (IterableExtensions.size(selected) != 0) {
								T selectedObject = ListGridBasedItemsProvider.this.gridComponent
										.getSelectedObjects().iterator().next();
								gridComponent.asWidget().getStore()
										.remove(selectedObject);
							}

						}
					});

					composite.add(toolbar, new HorizontalLayoutData(1, 1));
				} else {
					composite.add(gridComponent.asWidget(),
							new HorizontalLayoutData(1, 1));

				}
				ListGridBasedItemsProvider.this.gridComponent = gridComponent;
				AdapterField<Collection<T>> field = new AdapterField<Collection<T>>(
						composite) {

					@Override
					public void setValue(Collection<T> value) {

						ListGridBasedItemsProvider.this.setValue(value);
					}

					@Override
					public Collection<T> getValue() {
						return ListGridBasedItemsProvider.this.getValue();
					}
				};
				label = new FieldLabel(field, title);
			}
			return label;
		}

		@Override
		public Collection<T> getValue() {
			return Lists.newArrayList(gridComponent.getObjects());
		}

		private IObjectCreater<T> objectCreater;

		public void setObjectCreater(final Function<Void, T> objectCreater) {
			this.objectCreater = new IObjectCreater<T>() {

				@Override
				public T createObject() {
					return objectCreater.apply(null);
				}

			};
		}

		public void triggleAddEvent() {
			T newObject = ListGridBasedItemsProvider.this.objectCreater
					.createObject();
			if (newObject != null) {
				addObject(newObject);
			}

		}

		private void addObject(T newObject) {
			if (newObject.getId() == null) {
				newObject.setId(nextId--);
			}
			ModelKeyProvider<? super T> kp = gridComponent.asWidget()
					.getStore().getKeyProvider();
			Boolean hasDup = false;
			for (T t : gridComponent.asWidget().getStore().getAll()) {
				if (kp.getKey(t).equals(kp.getKey(newObject))) {
					hasDup = true;
				}
			}
			if (hasDup) {
				Info.display("错误", "试图加入重复的数据");
			} else
				gridComponent.asWidget().getStore().add(newObject);

		}

		@Override
		public void addValueChangedListener(
				ValueChangedListener<Collection<T>> listener) {

		}

		public void addRemoveObjectListener(final Procedure1<T> listener) {
			gridComponent.asWidget().getStore()
					.addStoreRemoveHandler(new StoreRemoveHandler<T>() {

						@Override
						public void onRemove(StoreRemoveEvent<T> event) {
							listener.apply(event.getItem());
						}
					});
		}

		public void addChangeObjectListener(final Procedure1<T> listener) {
			gridComponent
					.asWidget()
					.getStore()
					.addStoreRecordChangeHandler(
							new StoreRecordChangeHandler<T>() {

								@Override
								public void onRecordChange(
										StoreRecordChangeEvent<T> event) {
									listener.apply(event.getRecord().getModel());
								}
							});
		}

		public void addAddObjectListener(final Procedure1<Iterable<T>> listener) {
			gridComponent.asWidget().getStore()
					.addStoreAddHandler(new StoreAddHandler<T>() {

						@Override
						public void onAdd(StoreAddEvent<T> event) {
							listener.apply(event.getItems());
						}
					});
		}

	}

}
