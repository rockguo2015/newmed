package com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.factory;

import com.google.common.collect.Iterables;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Widget;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;
import com.uniquesoft.gwt.client.common.name.IObjectNameProvider;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.GWTFormItem;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider;
import com.uniquesoft.gwt.client.common.widgets.selector.SelectionChangeManager;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ISingleValueSelector;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;


/**
 * Put a group radio buttons in SingleSelectorItem which extends the FlexTable.
 * it needs a content provider to set the radio contents.It is translated like:
 *  days = defaultObjectSelectorFactory.createAsRadioGroupItem("days","radio type",Integer.valueOf(5));
 *  days.setContentProvider(daysContentProvider);
 *
 * @param <T>
 */
public class RadioButtonSingleEntitySelector<T> implements
ISingleValueSelector<T> {

	private IObjectNameProvider nameProvider;
	private GWTFormItem formItem;
	private com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider<T> provider;
	SelectionChangeManager<T> selectionChangeManager = new SelectionChangeManager<T>();
	private SingleSelectorItem radioPanel;
	private String widgetId;
	
	/**
	 * It is uese to set a group of widgets and list them on a FlexTable
	 * according to the columns. we can set the max columns in the constructor. 
	 *
	 */
	public class SingleSelectorItem extends FlexTable{
		private int columns = 3;
		
		public SingleSelectorItem(){
			setWidth("100%");
		}
		public SingleSelectorItem(int columns) {
			this.columns = columns;
		}

		public void setColumns(int size) {
			this.columns = size;
		}
		public int getColumns(){
			return columns;
		}
		public void setItems(Widget...widgets){
			int row = 0;
			int colNum = 0;
			for(Widget item : widgets){
				if(colNum >= columns){
					row++;
					colNum = 0;
				}
				setWidget(row, colNum++, item);
			}
			
		}
	}
	
	/**
	 * @param id
	 * @param title
	 * @param runtimeGinjector
	 * @param size
	 * Set how many columns radioItems will be listed in a row for size parameter
	 * 
	 */
	RadioButtonSingleEntitySelector(String id,
			final String title,RuntimeGinjector runtimeGinjector,int size){
		int radioCols = 3;
		if(size > 0){
			radioCols = size;
		}
		nameProvider = runtimeGinjector.getObjectNameProvider();
		widgetId = id;
		radioPanel = new SingleSelectorItem(radioCols);
		formItem = new GWTFormItem() {
			Label label = new Label(title);

			@Override
			public Widget getLabelWidget() {
				return label;
			}

			@Override
			public Widget getValueWidget() {
				return radioPanel;
			}

		};
	}
	
	/**
	 * @param id
	 * @param title
	 * @param runtimeGinjector
	 * If don't input a columns for the radioItems, it will use the 
	 * default value "3". List 3 radioItems in a row.
	 * 
	 */
	RadioButtonSingleEntitySelector(String id,
			final String title,RuntimeGinjector runtimeGinjector){
		this(id,title,runtimeGinjector,0);
	}	
	/**
	 * @param provider
	 * make the radioItem title equals the provided object id, 
	 * then set them into the  SingleSelectorItem to show.
	 */
	private void updateContents(ContentProvider<T> provider) {
		RadioButton[] radioItems = new RadioButton[Iterables.size(provider
				.getContents())];
		int index = 0;
		for (T item : provider.getContents()) {
			final RadioButton radioItem = new RadioButton(widgetId,nameProvider.getId(item));
			radioItem.setTitle(nameProvider.getId(item));
			radioItems[index++] = radioItem;
			
		}
		radioPanel.setItems(radioItems);
	}
	@Override
	public void setContentProvider(ContentProvider<T> provider) {
		this.provider = provider;
		radioPanel.clear();
		updateContents(this.provider);
	}

	/* (non-Javadoc)
	 * @see com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider#getValue()
	 * Look for the item in the contentProvider that its id equals the selected radioItem's title.
	 */
	@Override
	public T getValue() {
		String selectedId = null;
		int rowNums = radioPanel.getRowCount();
		int maxCol = radioPanel.getColumns();
		
		int tem,tem1;
		for(tem = 0;tem < rowNums;tem++){
			maxCol = radioPanel.getCellCount(tem);
			for(tem1 = 0;tem1 < maxCol;tem1++){
				
				if(((RadioButton)(radioPanel.getWidget(tem, tem1))).getValue()){
					selectedId = radioPanel.getWidget(tem, tem1).getTitle();
					
				};
			}
		}
		for (T item : provider.getContents()) {
			if (nameProvider.getId(item).equals(selectedId))
				return item;
		}
		return null;
	}

	@Override
	public void addValueChangedListener(ValueChangedListener<T> listener) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Deselect all the radioItems
	 */
	private void clearWidget(){
		int rowNums = radioPanel.getRowCount();
		int maxCol = radioPanel.getColumns();
		int tem,tem1;
		for(tem = 0;tem < rowNums;tem++){
			for(tem1 = 0;tem1 < maxCol;tem1++){
				((RadioButton)(radioPanel.getWidget(tem, tem1))).setValue(false);
			}
		}
	}
	/* (non-Javadoc)
	 * @see com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer#setValue(java.lang.Object)
	 * Select the radioItem that its title equals the object's id.
	 */
	@Override
	public IValueViewer<T> setValue(T value) {
		clearWidget();
		int rowNums = radioPanel.getRowCount();
		int maxCol = radioPanel.getColumns();
		int tem,tem1;
		for(tem = 0;tem < rowNums;tem++){
			for(tem1 = 0;tem1 < maxCol;tem1++){
				if(radioPanel.getWidget(tem, tem1).getTitle().equals(nameProvider.getId(value))){
					((RadioButton)(radioPanel.getWidget(tem, tem1))).setValue(true);
				}
			}
		}
		return this;
	}

	@Override
	public GWTFormItem asWidget() {
	
		return formItem;
	}
	
}