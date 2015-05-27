package com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.factory;

import java.util.Collection;


import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.Widget;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;
import com.uniquesoft.gwt.client.common.name.IObjectNameProvider;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.GWTFormItem;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.MultySelectorItem;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider.ContentChangedListener;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IMultiValueSelector;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

public class ImgButtonBasedSelector<T> implements IMultiValueSelector<T> {

	IObjectNameProvider nameProvider;

	private ContentProvider<T> provider;
	private ToggleButton[] toggleButtons; 
	private MultySelectorItem buttonPanel;
	private GWTFormItem formItem;
	private ValueChangedManager<Collection<T>> valueChangedManager = new ValueChangedManager<Collection<T>>();
	ImgButtonBasedSelector(String id, final String title,RuntimeGinjector runtimeGinjector){
		nameProvider = runtimeGinjector.getObjectNameProvider();
		buttonPanel = new MultySelectorItem();
		formItem = new GWTFormItem() {
			Label label = new Label(title);

			@Override
			public Widget getLabelWidget() {
				return label;
			}

			@Override
			public Widget getValueWidget() {
				return buttonPanel;
			}

		};
	}
	@Override
	public Collection<T> getValue() {
		Collection<T> result = Lists.newArrayList();
		for (T item : provider.getContents()) {

			if (((ToggleButton) buttonPanel.getField(nameProvider
					.getId(item))).getValue()) {
				result.add(item);
			}
		
		}
		return result;
	}

	@Override
	public void addValueChangedListener(
			ValueChangedListener<Collection<T>> listener) {
		valueChangedManager.addValueChangedListener(listener);		
	}

	private boolean contains(Iterable<T> values, String id) {
		for (T value : values) {
			if (nameProvider.getId(value).equals(id))
				return true;
		}
		return false;
	}
	@Override
	public void setValue(Collection<T> values) {

		for (ToggleButton toggleButtonItem : toggleButtons) {
			toggleButtonItem.setValue(false);
			if (contains(values, toggleButtonItem.getText())) {
				toggleButtonItem.setValue(true);
			}
		}
	}

	@Override
	public GWTFormItem asWidget() {
				return formItem;
	}

	private void updateContents(ContentProvider<T> provider) {
		toggleButtons = new ToggleButton[Iterables.size(provider
					.getContents())];
		int index = 0;
		for (T item : provider.getContents()) {
			String src = "text_" + nameProvider.getId(item).toLowerCase()
					+ ".png";
			Image itemImage = new Image(src);
			ToggleButton roleItem = new ToggleButton(itemImage);
			roleItem.setTitle(nameProvider.getId(item));
			roleItem.setSize("24", "24");
			roleItem.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					valueChangedManager.fireValueChangedEvent(getValue());
				}
				
			});
			toggleButtons[index++] = roleItem;
			
		}
		buttonPanel.setItems(toggleButtons);
	}
	@Override
	public void setContentProvider(ContentProvider<T> provider) {

		this.provider = provider;
		updateContents(provider);
		this.provider
				.addContentChangedListener(new ContentChangedListener() {

					@Override
					public void onContentChanged() {
						updateContents(ImgButtonBasedSelector.this.provider);

					}
				});
	
		
		
	}
	
}