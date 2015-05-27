package com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.factory;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.Widget;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;
import com.uniquesoft.gwt.client.common.name.IObjectNameProvider;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.GWTFormItem;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AsyncContentProviderWithFilter;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentLoadedCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.IObjectNameFilter;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ISingleValueSelector;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;


/**
 * When we write several letters of the the word, the suggestion box will
 * provider all the options we may use, the suggestions contents are provided by 
 * "contentProvider". It means that we have to write a "content provider" for the
 *  suggest box. In UIDL, it is used like this:
 *  suggest : Week 
 *  suggest as SuggestItem content from MyWeekContentProvider
 *  content-provider MyWeekContentProvider for Week{
		criteria implements IObjectNameFilter{
			name : String
		}
		
		contents{
			 val contents1 = newArrayList(
    						Week::Monday,Week::Tuesday,Week::Wednesday,Week::Thursday,Week::Friday)
			contents1
		}
	}
 *
 *It will be translated as below :
 *  public MyWeekContentProvider suggestContentProvider;
 *  suggest = defaultObjectSelectorFactory.createAsSuggestItem("suggest","suggest");
 *  suggest.setContentProvider(suggestContentProvider);
 * @param <T>
 */
public class SuggestionTextBox<T> implements ISingleValueSelector<T> {

	Collection<ValueChangedListener<T>> listeners = Lists.newArrayList();
	private GWTFormItem formItem = null;
	private IObjectNameProvider nameProvider;
	private AsyncContentProviderWithFilter<T, IObjectNameFilter> contentProvider;
	private SuggestBox suggestItem;
	private Label label;
	private MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
	private LinkedHashMap<String,String> values = new LinkedHashMap<String,String>();
	SuggestionTextBox(String id,
			final String title,RuntimeGinjector runtimeGinjector){
		nameProvider = runtimeGinjector.getObjectNameProvider();
		label = new Label(title);
		
		suggestItem = new SuggestBox(oracle);
		formItem = new GWTFormItem() {
			@Override
			public Widget getLabelWidget() {
				return label;
			}

			@Override
			public Widget getValueWidget() {
				return suggestItem;
			}

		};			
	}
		
	/**
	 * @param value
	 * @return
	 * SuggestBox just shows the titles of the provided contents, but we need 
	 * to find the related item by its id, so the LinkedHashMap store the <id,title>,
	 * then we need to get the id by its title.
	 */
	private String getMapKey(String value){
		Set<String> mapSet = values.keySet();
		Iterator mapIterator = mapSet.iterator();
		 while (mapIterator.hasNext()) {
			  String keyValue = (String) mapIterator.next();
			  if(values.get(keyValue).equals(value)){
			  return keyValue;
			 }
		 }
            
		return "";
	}
	/* (non-Javadoc)
	 * @see com.uniquesoft.gwt.client.common.widgets.valueprovider.ISelector#setContentProvider(com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider)
	 * "AsyncContentProviderWithFilter" gets the data asynchronously, so we have to write a criteria for it. use loadContent method to 
	 * get the provider data asynchronously. you cann't get the data directly like contentProvider
	 */
	@Override
	public void setContentProvider(final ContentProvider<T> provider) {
		this.contentProvider = (AsyncContentProviderWithFilter<T, IObjectNameFilter>) provider;
		contentProvider.loadContent(null, new ContentLoadedCallback() {

			@Override
			public void contentLoaded() {
				values.clear();
				for (T item : provider.getContents()) {
					oracle.add(nameProvider.getName(item));
					values.put(nameProvider.getId(item),
							nameProvider.getName(item));
				}
				suggestItem.refreshSuggestionList();

			}

		});

	}

	/* 
	 * @see com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider#getValue()
	 * To get the option item By the suggestbox value
	 */
	@Override
	public T getValue() {
		String selectedName =suggestItem.getValue();
		String selectedId = getMapKey(selectedName);
		for (T item : contentProvider.getContents()) {
			if(nameProvider.getId(item).equals(selectedId)){
				return item;
			}
		}
		return null;
	}

	@Override
	public void addValueChangedListener(ValueChangedListener<T> listener) {
		listeners.add(listener);
		
	}

	/* 
	 * @see com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer#setValue(java.lang.Object)
	 * Set the suggest box value to display on the page
	 */
	@Override
	public IValueViewer<T> setValue(T value) {
		if(value != null){
			suggestItem.setValue(nameProvider.getId(value));
		}
		return this;
	}

	/* 
	 * @see com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget#asWidget()
	 * 
	 */
	/* 
	 * @see com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget#asWidget()
	 * Return the encapsulated GWTFormItem to the show on the page 
	 */
	@Override
	public GWTFormItem asWidget() {
		
		return formItem;
	}
	
}