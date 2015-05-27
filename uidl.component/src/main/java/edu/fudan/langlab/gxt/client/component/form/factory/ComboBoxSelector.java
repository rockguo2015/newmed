package edu.fudan.langlab.gxt.client.component.form.factory;

import com.google.common.collect.Lists;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.widget.core.client.form.ComboBox;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;
import com.uniquesoft.gwt.client.common.name.IObjectNameProvider;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider.ContentChangedListener;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ISingleValueSelector;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

public class ComboBoxSelector<T> implements ISingleValueSelector<T>,
		ObjectSelectionProvider<T> {

	private IObjectNameProvider nameProvider;
	private FieldLabel fieldLabel;
	private ValueChangedManager<T> selectionChangeManager = new ValueChangedManager<T>();

	public ComboBoxSelector(String id, final String title, Boolean isRequired,
			RuntimeGinjector runtimeGinjector) {
		nameProvider = runtimeGinjector.getObjectNameProvider();

		store = new ListStore<T>(new ModelKeyProvider<T>() {

			@Override
			public String getKey(T item) {
				return nameProvider.getId(item);
			}

		});
		comboBox = new ComboBox<T>(store, new LabelProvider<T>() {

			@Override
			public String getLabel(T item) {
				return nameProvider.getName(item);
			}
		});
		comboBox.setForceSelection(false);
		comboBox.setTriggerAction(TriggerAction.ALL);
		comboBox.setTypeAhead(true);
		if (isRequired) {
			fieldLabel = new FieldLabel(comboBox);
			fieldLabel.setHTML(Forms.toRequiredTitle(title));
		} else
			fieldLabel = new FieldLabel(comboBox, title);
	}

	private ListStore<T> store;
	private ComboBox<T> comboBox;
	ContentProvider<T> provider;

	@Override
	public void setContentProvider(ContentProvider<T> provider) {

		this.provider = provider;
		provider.addContentChangedListener(new ContentChangedListener() {

			@Override
			public void onContentChanged() {
				store.clear();
				for (T item : ComboBoxSelector.this.provider.getContents()) {
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

	public FieldLabel asReadonlyWidget() {
		comboBox.setReadOnly(true);
		return fieldLabel;
	}

	@Override
	public Iterable<T> getSelectedObjects() {
		if (getValue() != null)
			return Lists.newArrayList(getValue());
		else
			return Lists.newArrayList();
	}

	@Override
	public void addSelectionChangedListener(
			final com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener<T> listener) {

		comboBox.addSelectionHandler(new SelectionHandler<T>() {

			@Override
			public void onSelection(SelectionEvent<T> event) {
				listener.selectionChanged(Lists.newArrayList(event
						.getSelectedItem()));
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

	public void selectFirst() {
		if (store.get(0) != null)
			comboBox.setValue(store.get(0));
	}
}
