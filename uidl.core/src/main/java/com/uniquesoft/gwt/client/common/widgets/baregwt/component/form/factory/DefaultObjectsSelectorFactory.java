package com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.factory;

import java.util.Collection;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;
import com.uniquesoft.gwt.client.common.name.IObjectNameProvider;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.GWTFormItem;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.MultySelectorItem;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.RequireContentProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider.ContentChangedListener;
import com.uniquesoft.gwt.client.common.widgets.selector.SelectionChangeManager;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IMultiValueSelector;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

/**
 * For a collection type, if there is no other type factory matched, it will
 * use this class. It use a content provider to get the multy items.Each item 
 * is built as a checkbox on a panel, then we can select several checkbox to 
 * choose the items that we wanted.
 * now we provided four widgets. But mainly use checkbox as default widget.
 * we may extend it in the next stage. In UIDL ,it is used like this:
 * days3 : Week[*] "multy days as checkbox" ,and it's translated as below: 
 * public class WeekContentProvider extends AbstractContentProvider<Week> {
 * private static ArrayList<Week> contents = com.google.common.collect.Lists.newArrayList(
 * 						Week.Monday,Week.Tuesday,Week.Wednesday,Week.Thursday,Week.Friday
 *  					);;
 *public Collection<Week> getContents() {
 * return contents;
 *}
 *}
 * public WeekContentProvider days3ContentProvider;
 *  days3 = defaultObjectsSelectorFactory.createAsCheckBoxItem("days3","multy days as checkbox",Integer.valueOf(5));
 *  days3.setContentProvider(days3ContentProvider)
 * 
 *
 */
public class DefaultObjectsSelectorFactory {
	@Inject
	RuntimeGinjector runtimeGinjector;
	
	public class CheckboxMultiEntitySelector<T> implements
	IMultiValueSelector<T> {

		IObjectNameProvider nameProvider;

		private ContentProvider<T> provider;
		private CheckBox[] checkboxItems;
		private MultySelectorItem hPanel;
		private GWTFormItem formItem;
		private SelectionChangeManager<Iterable<T>> selectionChangeManager = new SelectionChangeManager<Iterable<T>>();
		
		CheckboxMultiEntitySelector(String id, final String title,int size) {
			int checkboxCols=3;
			if(size > 0){
				checkboxCols = size;
			}
			nameProvider = runtimeGinjector.getObjectNameProvider();
			hPanel = new MultySelectorItem(checkboxCols);
			formItem = new GWTFormItem() {
				Label label = new Label(title);

				@Override
				public Widget getLabelWidget() {
					return label;
				}

				@Override
				public Widget getValueWidget() {
					return hPanel;
				}

			};
		}
		CheckboxMultiEntitySelector(String id, final String title) {
			this(id,title,3);
		}
		@Override
		public Collection<T> getValue() {
			Collection<T> result = Lists.newArrayList();
			for (T item : provider.getContents()) {
				if (((CheckBox) hPanel.getField(nameProvider
						.getId(item))).getValue()) {
					result.add(item);
				}
			}
			return result;
		}

		@Override
		public void addValueChangedListener(
				ValueChangedListener<Collection<T>> listener) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setValue(Collection<T> values) {
			for (CheckBox checkboxItem : checkboxItems) {
				checkboxItem.setValue(false);
				if (contains(values, checkboxItem.getText())) {
					checkboxItem.setValue(true);
				}
			}
			
		}

		@Override
		public GWTFormItem asWidget() {
			
			return formItem;
		}

		private boolean contains(Iterable<T> values, String id) {
			for (T value : values) {
				if (nameProvider.getId(value).equals(id))
					return true;
			}
			return false;
		}
		
		/**
		 * @param provider
		 * use the checkbox title to store the item id information
		 */
		private void updateContents(ContentProvider<T> provider) {
			checkboxItems = new CheckBox[Iterables.size(provider
					.getContents())];
			int index = 0;
			for (T item : provider.getContents()) {
				final CheckBox roleItem = new CheckBox();
				roleItem.setText(nameProvider.getName(item));
				roleItem.setTitle(nameProvider.getId(item));
				checkboxItems[index++] = roleItem;
				roleItem.addValueChangeHandler(new ValueChangeHandler<Boolean>(){

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						selectionChangeManager
						.fireSelectionChangedEvent(getValue());
						
					}
					
				});
			}
			hPanel.setItems(checkboxItems);
		}
		@Override
		public void setContentProvider(ContentProvider<T> provider) {
			this.provider = provider;
			updateContents(provider);
			this.provider
					.addContentChangedListener(new ContentChangedListener() {

						@Override
						public void onContentChanged() {
							updateContents(CheckboxMultiEntitySelector.this.provider);

						}
					});
		}
		/**
		 * @param numCols
		 * set the internal cols of the checkbox widgets
		 */
		public void setNumCols(int numCols) {
			hPanel.setColumns(numCols);
		}

		public void selectAll() {
			setValue(provider.getContents());
		}
		
	}
	
	@WidgetProvider(isDefault = true)
	@RequireContentProvider
	public <T> CheckboxMultiEntitySelector<T> createDefaultValueProvider(
			String id, String title,int checkboxCols) {
		return new CheckboxMultiEntitySelector<T>(id, title,checkboxCols);
	}
	@WidgetProvider
	public <T> CheckboxMultiEntitySelector<T> createAsCheckBoxItem(String id,
			String title,int checkboxCols) {
		return new CheckboxMultiEntitySelector<T>(id, title,checkboxCols);
	}
	/**
	 * @param id
	 * @param title
	 * @return
	 * Use the default value for the internal checkbox to arrange
	 */
	@WidgetProvider
	public <T> CheckboxMultiEntitySelector<T> createAsCheckBoxItem(String id,
			String title) {
		return new CheckboxMultiEntitySelector<T>(id, title);
	}
	
	@WidgetProvider(isReadonly = true)
	public <T> ReadonlyValuesProvider<T> createAsReadonlyText(String id,
			String title) {
		return new ReadonlyValuesProvider<T>(id, title, runtimeGinjector);
	}
	@WidgetProvider
	public <T> ImgButtonBasedSelector<T> createAsImgBasedValueProvider(
			String id, String title) {
		return new ImgButtonBasedSelector<T>(id, title, runtimeGinjector);
	}
	
	@WidgetProvider
	public <T> PullDownListBoxMultiEntitySelector<T> createAsMultyListBox(
			String id, String title) {
		return new PullDownListBoxMultiEntitySelector<T>(id, title, runtimeGinjector);
	}
}