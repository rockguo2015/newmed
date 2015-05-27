package edu.fudan.langlab.gxt.client.component.listview;

import com.google.common.collect.Lists;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.inject.Provider;
import com.sencha.gxt.core.client.IdentityValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.event.StoreDataChangeEvent;
import com.sencha.gxt.data.shared.event.StoreDataChangeEvent.StoreDataChangeHandler;
import com.sencha.gxt.widget.core.client.ListView;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent.SelectionChangedHandler;
import com.uniquesoft.gwt.client.common.widgets.ObjectListView;
import com.uniquesoft.gwt.client.common.widgets.component.Component;
import com.uniquesoft.gwt.client.common.widgets.component.ValueProviderComponent;

import edu.fudan.langlab.gxt.client.component.KeyProvider;

public abstract class GXTListViewComponent<VT> extends
		ValueProviderComponent<VT> implements ObjectListView<VT> {

	private ListStore<VT> store = new ListStore<VT>(new KeyProvider<VT>());
	private ListView<VT, VT> listView = new ListView<VT, VT>(store,
			new IdentityValueProvider<VT>());

	private boolean initialized = false;
	@Override
	public Iterable<VT> getSelectedObjects() {
		return listView.getSelectionModel().getSelectedItems();
	}
	@Override
	public void deselect() {
		listView.getSelectionModel().deselectAll();
	}
	@Override
	public void select(VT item) {
		listView.getSelectionModel().select(item,false);
	}
	@Override
	public void addSelectionChangedListener(
			final com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener<VT> listener) {
		listView.getSelectionModel().addSelectionChangedHandler(
				new SelectionChangedHandler<VT>() {

					@Override
					public void onSelectionChanged(
							SelectionChangedEvent<VT> event) {
						listener.selectionChanged(getSelectedObjects());

					}
				});

	}

	@Override
	public void setObjects(Iterable<VT> result) {
		listView.getStore().clear();
		listView.getStore().addAll(Lists.newArrayList(result));

	}

	@Override
	public Iterable<VT> getObjects() {
		return listView.getStore().getAll();
	}

	@Override
	public void addContentChangedListener(
			final com.uniquesoft.gwt.client.common.widgets.ObjectListView.ContentChangedListener<VT> listener) {
		listView.getStore().addStoreDataChangeHandler(
				new StoreDataChangeHandler<VT>() {

					@Override
					public void onDataChange(StoreDataChangeEvent<VT> event) {
						listener.contentChanged(getObjects());

					}
				});

	}

	@Override
	public void addSelectEntityListener(
			final com.uniquesoft.gwt.client.common.widgets.ObjectListView.SelectEntityListener<VT> listener) {
		listView.getSelectionModel().addSelectionChangedHandler(
				new SelectionChangedHandler<VT>() {

					@Override
					public void onSelectionChanged(
							SelectionChangedEvent<VT> event) {
						if (event.getSelection().size() != 0)
							listener.objectSelected(listView
									.getSelectionModel().getSelectedItem());

					}
				});

	}

	@Override
	public void setComponentProvider(
			Provider<? extends Component<VT>> componentProvider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addElement(VT uientity) {
		listView.getStore().add(uientity);

	}

	@Override
	public void removeElement(VT uientity) {
		listView.getStore().remove(uientity);

	}

	@Override
	public ListView<VT, VT> asWidget() {
		if(!initialized){
			listView.setCell(new AbstractCell<VT>(){

				@Override
				public void render(
						com.google.gwt.cell.client.Cell.Context context,
						VT value, SafeHtmlBuilder sb) {
					sb.append(GXTListViewComponent.this.render(value));
				}
			});
			initialized = true;
		}
		return listView;
	}

	public SafeHtml render(VT uientity) {
		return SafeHtmlUtils.fromTrustedString(uientity == null ? "" : uientity
				.toString());
	}
}
