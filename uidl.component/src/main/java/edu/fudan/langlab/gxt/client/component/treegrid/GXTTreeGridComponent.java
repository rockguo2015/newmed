package edu.fudan.langlab.gxt.client.component.treegrid;

import java.util.List;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;

import com.google.common.collect.Lists;
import com.google.inject.Provider;
import com.sencha.gxt.data.shared.Store;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.data.shared.event.StoreDataChangeEvent;
import com.sencha.gxt.data.shared.event.StoreDataChangeEvent.StoreDataChangeHandler;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent.SelectionChangedHandler;
import com.uniquesoft.gwt.client.common.widgets.ObjectListView;
import com.uniquesoft.gwt.client.common.widgets.component.Component;
import com.uniquesoft.gwt.client.common.widgets.component.ValueProviderComponent;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;

import edu.fudan.langlab.gxt.client.component.KeyProvider;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridColumn;
import edu.fudan.langlab.gxt.client.widget.IHasStoreComponent;
import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeContentProvider;
import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeGridContentProvider;

public abstract class GXTTreeGridComponent<VT> extends
		ValueProviderComponent<VT> implements ObjectListView<VT>,
		IHasStoreComponent<VT> {

	protected SGrid<VT> grid;

	@Override
	public Iterable<VT> getSelectedObjects() {
		return grid.getSelectionModel().getSelectedItems();
	}

	@Override
	public void deselect() {
		grid.getSelectionModel().deselectAll();
	}
	@Override
	public void select(VT item) {
		grid.getSelectionModel().select(item, false);
	}
	@Override
	public void addSelectionChangedListener(
			final com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener<VT> listener) {
		grid.getSelectionModel().addSelectionChangedHandler(
				new SelectionChangedHandler<VT>() {

					@Override
					public void onSelectionChanged(
							SelectionChangedEvent<VT> event) {
						listener.selectionChanged(getSelectedObjects());

					}
				});
	}
	

	protected ITreeContentProvider<VT> getTreeContentProvider(){
		if(getChildrenCalculator()!=null){
			return new ITreeContentProvider<VT>(){

				@Override
				public Iterable<VT> getRootElements(Iterable<VT> allElements) {
					return getChildrenCalculator().apply(allElements,null);
				}

				@Override
				public Iterable<VT> getChildren(VT parent, Iterable<VT> allElements) {
					return getChildrenCalculator().apply(allElements,parent);
				}
				
			};
		}
		else return null;
	}
	protected  Function2<Iterable<VT>,VT,Iterable<VT>> getChildrenCalculator(){
		return null;
	}
	@Override
	public void setObjects(Iterable<VT> result) {
		if(getTreeContentProvider()!=null){
			grid.getTreeStore().clear();
			for (VT element : getTreeContentProvider().getRootElements(result)) {
				grid.getTreeStore().add(element);
				processTree(element, result,getTreeContentProvider());
			}
		}
	}
	private void processTree(VT parent,Iterable<VT> objects,
			ITreeContentProvider<VT> contentProvider) {
		for (VT element : contentProvider.getChildren(parent,objects)) {
			grid.getTreeStore().add(parent, element);
			processTree(element, objects,contentProvider);
		}
	}

	
	
	public void setContentProvider(ITreeGridContentProvider<VT> contentProvider) {
		grid.getTreeStore().clear();
		for (VT element : contentProvider.getRootElements()) {
			grid.getTreeStore().add(element);
			processTree(element, contentProvider);
		}
	}

	private void processTree(VT parent,
			ITreeGridContentProvider<VT> contentProvider) {
		for (VT element : contentProvider.getChildren(parent)) {
			grid.getTreeStore().add(parent, element);
			processTree(element, contentProvider);
		}
	}

	@Override
	public Iterable<VT> getObjects() {
		return grid.getTreeStore().getAll();
	}

	@Override
	public void addContentChangedListener(
			final com.uniquesoft.gwt.client.common.widgets.ObjectListView.ContentChangedListener<VT> listener) {
		grid.getTreeStore().addStoreDataChangeHandler(
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
		grid.getSelectionModel().addSelectionChangedHandler(
				new SelectionChangedHandler<VT>() {

					@Override
					public void onSelectionChanged(
							SelectionChangedEvent<VT> event) {
						if (event.getSelection().size() != 0)
							listener.objectSelected(grid.getSelectionModel()
									.getSelectedItem());

					}
				});

	}

	@Override
	public void setComponentProvider(
			Provider<? extends Component<VT>> componentProvider) {

	}

	@Override
	public void addElement(VT uientity) {
		grid.getTreeStore().add(uientity);

	}

	@Override
	public void removeElement(VT uientity) {
		grid.getTreeStore().remove(uientity);

	}

	protected TreeStore<VT> store = new TreeStore<VT>(new KeyProvider<VT>());

	@Override
	public SGrid<VT> asWidget() {
		if (grid != null)
			return grid;
		List<ColumnConfig<VT, ?>> columns = Lists.newArrayList();
		for (ICanAsWidget column : this.getAllProperties()) {
			GXTGridColumn gridColumn = (GXTGridColumn) column;
			columns.add(gridColumn.asWidget());
		}
		GXTGridColumn firstColumn = (GXTGridColumn) getAllProperties()
				.iterator().next();
		grid = new SGrid<VT>(store, new ColumnModel<VT>(columns),
				firstColumn.asWidget());
		grid.getView().setAutoFill(true);
		for (ICanAsWidget column : this.getAllProperties()) {
			GXTGridColumn gridColumn = (GXTGridColumn) column;
			if (gridColumn.isAutoExpand()) {
				this.setAutoExpandColumn(gridColumn);
			}
		}
		return grid;
	}

	public void setState(Object stateObject) {
		grid.setState(stateObject);
	}

	public void setAutoExpandColumn(GXTGridColumn<VT, ?> column) {
		grid.getView().setAutoExpandColumn(column.asWidget());
	}

	@Override
	public TreeStore<VT> getStore() {
		return grid.getTreeStore();
	}
}
