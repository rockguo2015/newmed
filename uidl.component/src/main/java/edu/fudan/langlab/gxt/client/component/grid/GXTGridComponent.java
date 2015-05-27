package edu.fudan.langlab.gxt.client.component.grid;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

import com.google.common.collect.Lists;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.inject.Provider;
import com.sencha.gxt.core.client.IdentityValueProvider;
import com.sencha.gxt.core.client.Style.SelectionMode;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.event.StoreAddEvent;
import com.sencha.gxt.data.shared.event.StoreDataChangeEvent;
import com.sencha.gxt.data.shared.event.StoreDataChangeEvent.StoreDataChangeHandler;
import com.sencha.gxt.widget.core.client.event.CompleteEditEvent;
import com.sencha.gxt.widget.core.client.event.RowDoubleClickEvent;
import com.sencha.gxt.widget.core.client.event.CompleteEditEvent.CompleteEditHandler;
import com.sencha.gxt.widget.core.client.event.RowDoubleClickEvent.RowDoubleClickHandler;
import com.sencha.gxt.widget.core.client.grid.CheckBoxSelectionModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.GroupSummaryView;
import com.sencha.gxt.widget.core.client.grid.GroupingView;
import com.sencha.gxt.widget.core.client.grid.RowExpander;
import com.sencha.gxt.widget.core.client.grid.editing.GridEditing;
import com.sencha.gxt.widget.core.client.grid.editing.GridInlineEditing;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent.SelectionChangedHandler;
import com.uniquesoft.gwt.client.common.widgets.ObjectListView;
import com.uniquesoft.gwt.client.common.widgets.component.Component;
import com.uniquesoft.gwt.client.common.widgets.component.ValueProviderComponent;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.shared.GWTNamedEntity;

import edu.fudan.langlab.gxt.client.component.KeyProvider;
import edu.fudan.langlab.gxt.client.component.grid.factory.IEditableColumn;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

public abstract class GXTGridComponent<VT> extends ValueProviderComponent<VT>
		implements ObjectListView<VT> {

	public interface EditCompleteListener<VT> {
		void onEditComplete(VT value);
	}

	protected SGrid<VT> grid;

	private boolean keepSelection = false;

	@Override
	public Iterable<VT> getSelectedObjects() {
		List<VT> selectedItems = grid.getSelectionModel().getSelectedItems();
		if (selectedItems == null)
			return Lists.newArrayList();
		else
			return selectedItems;
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

	@Override
	public void setObjects(Iterable<VT> result) {
		if (keepSelection) {
			final VT selectedItem = grid.getSelectionModel().getSelectedItem();
			grid.getStore().clear();
			grid.getStore().addAll(Lists.newArrayList(result));
			final ModelKeyProvider<? super VT> kp = grid.getStore()
					.getKeyProvider();
			if (selectedItem != null) {
				VT keepSelectedItem = IterableExtensions.findFirst(grid
						.getStore().getAll(), new Function1<VT, Boolean>() {

					@Override
					public Boolean apply(VT p) {
						return kp.getKey(selectedItem).equals(kp.getKey(p));
					}
				});
				if (keepSelectedItem != null)
					select(keepSelectedItem);
				else if (IterableExtensions.head(result) != null) {
					select(IterableExtensions.head(result));
				}
			} else if (IterableExtensions.head(result) != null) {
				select(IterableExtensions.head(result));
			}
		} else {
			grid.getStore().clear();
			grid.getStore().addAll(Lists.newArrayList(result));

		}
	}

	public GXTGridComponent<VT> keepSelection() {
		keepSelection = true;
		return this;
	}

	@Override
	public Iterable<VT> getObjects() {
		if (editor != null) {
//			editor.completeEditing();
			grid.getStore().commitChanges();
		}
		return grid.getStore().getAll();
	}

	@Override
	public void addContentChangedListener(
			final com.uniquesoft.gwt.client.common.widgets.ObjectListView.ContentChangedListener<VT> listener) {
		grid.getStore().addStoreDataChangeHandler(
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
	
	public void addDoubleClickSelectListener(final com.uniquesoft.gwt.client.common.widgets.ObjectListView.SelectEntityListener<VT> listener){
		grid.addRowDoubleClickHandler(new RowDoubleClickHandler() {
			
			@Override
			public void onRowDoubleClick(RowDoubleClickEvent event) {
				VT selectedItem = grid.getSelectionModel().getSelectedItem();
				if(selectedItem!=null) listener.objectSelected(selectedItem);
			}
		});
	}

	@Override
	public void setComponentProvider(
			Provider<? extends Component<VT>> componentProvider) {

	}

	@Override
	public void addElement(VT uientity) {
		grid.getStore().add(uientity);

	}

	@Override
	public void removeElement(VT uientity) {
		grid.getStore().remove(uientity);

	}

	public void updateElement(VT uientity) {
		grid.getStore().update(uientity);
	}

	protected ListStore<VT> _store
//	= new ListStore<VT>(new KeyProvider<VT>()) {
//
//		protected void fireSortedAddEvents(
//				java.util.Collection<? extends VT> items) {
//			if(items.size()==0) return;
//			int startIndex = indexOf(IterableExtensions.head(items));
//			fireEvent(new StoreAddEvent<VT>(startIndex,Lists.newArrayList(items)));
//		};
//	}
	;
	
	protected ListStore<VT> getStore(){
		if(_store==null){
			_store = new ListStore<VT>(new KeyProvider<VT>());
		}
		return _store;
	}
	private GridEditing<VT> editor;

	private boolean isMultiSelectable = false;
	
	
	private RowExpander<VT> expander;
	
	public void withExpander(final Procedure2<VT, SafeHtmlBuilder> render){
		expander = new RowExpander<VT>(new IdentityValueProvider<VT>(), new AbstractCell<VT>() {

			@Override
			public void render(com.google.gwt.cell.client.Cell.Context context,
					VT value, SafeHtmlBuilder sb) {
				render.apply(value, sb);
				
			}
			 
	      });
	}
	public SGroupingGrid<VT> asGroupedWidget() {
		if (grid != null)
			return (SGroupingGrid) grid;
				
		List<ColumnConfig<VT, ?>> columns = Lists.newArrayList();
		if(expander!=null)columns.add(expander);
		grid = new SGroupingGrid<VT>(getStore(), new ColumnModel<VT>(columns));
		if (isMultiSelectable) {
			final CheckBoxSelectionModel<VT> sm = new CheckBoxSelectionModel<VT>(
					new IdentityValueProvider<VT>());
			sm.setSelectionMode(SelectionMode.SIMPLE);
			grid.setSelectionModel(sm);
			columns.add(sm.getColumn());

		}
		for (ICanAsWidget column : this.getAllProperties()) {
			GXTGridColumn gridColumn = (GXTGridColumn) column;
			columns.add(gridColumn.asWidget());
		}
		final GroupingView<VT> view = new GroupSummaryView<VT>();
		// view.setShowGroupedColumn(false);
		grid.setView(view);
		for (ICanAsWidget column : this.getAllProperties()) {
			GXTGridColumn gridColumn = (GXTGridColumn) column;

			if (gridColumn.isAutoExpand()) {
				this.setAutoExpandColumn(gridColumn);
			}
			if (gridColumn instanceof IEditableColumn) {
				if (editor == null)
					editor = new GridInlineEditing<VT>(grid);
				((IEditableColumn) gridColumn).initializeEditor(editor);

			}
		}
		grid.getView().setAutoFill(true);
		grid.getView().setStripeRows(true);
		if(expander!=null)expander.initPlugin(grid);
		return (SGroupingGrid) grid;
	}

	public void addEditCompleteListener(final EditCompleteListener<VT> listener) {
		if (editor != null)
			editor.addCompleteEditHandler(new CompleteEditHandler<VT>() {

				@Override
				public void onCompleteEdit(CompleteEditEvent<VT> event) {
					VT editingValue = editor.getEditableGrid().getStore()
							.get(event.getEditCell().getRow());
					listener.onEditComplete(editingValue);
				}
			});

	}

	public SGroupingGrid<VT> asMultiSelectGrid() {
		isMultiSelectable = true;
		return asWidget();
	}

	@Override
	public SGroupingGrid<VT> asWidget() {
		return asGroupedWidget();
		// if (grid != null)
		// return grid;
		// List<ColumnConfig<VT, ?>> columns = Lists.newArrayList();
		// for (ICanAsWidget column : this.getAllProperties()) {
		// GXTGridColumn gridColumn = (GXTGridColumn) column;
		// columns.add(gridColumn.asWidget());
		// }
		// grid = new SGrid<VT>(store, new ColumnModel<VT>(columns));
		// for (ICanAsWidget column : this.getAllProperties()) {
		// GXTGridColumn gridColumn = (GXTGridColumn) column;
		//
		// if (gridColumn.isAutoExpand()) {
		// this.setAutoExpandColumn(gridColumn);
		// }
		// if(gridColumn instanceof IEditableColumn){
		// if(editor==null)
		// editor = new GridInlineEditing<VT>(grid);
		// ((IEditableColumn)gridColumn).initializeEditor(editor);
		// }
		// }
		// grid.getView().setAutoFill(true);
		// return grid;
	}

	public void setState(Object stateObject) {
		grid.setState(stateObject);
	}

	public void setAutoExpandColumn(GXTGridColumn<VT, ?> column) {
		grid.getView().setAutoExpandColumn(column.asWidget());
	}

	public void unForceFit() {
		grid.getView().setForceFit(false);
		grid.getView().setAutoFill(false);
	}

	public void groupBy(GXTGridColumn<VT, ?> column) {
		((GroupingView<VT>) grid.getView()).groupBy(column.columnConfig);
	}

	public void refresh() {
		grid.getView().refresh(true);
	}

	public void reveal(final Object v) {
		VT result = IterableExtensions.findFirst(grid.getStore().getAll(),
				new Function1<VT, Boolean>() {

					@Override
					public Boolean apply(VT p) {
						return p.hashCode() == v.hashCode();
					}

				});
		if (result != null)
			select(result);
	}
}
