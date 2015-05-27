package com.uniquesoft.gwt.client.common.widgets.baregwt.component.detail.factory;

import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;
import com.uniquesoft.gwt.client.common.name.IObjectNameProvider;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.detail.factory.item.SingleElementDetailItem;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;

/**
 * The default place for one object to connect its data type and a detailItem.
 * 
 */
public class DefaultObjectSelectorFactory {

	@Inject
	private RuntimeGinjector runtimeGinjector;

	/**
	 * For a single object ,display its title and value 
	 *  in two label.
	 *
	 * @param <T>
	 */
	public static class ObjectDetaiItem<T> extends SingleElementDetailItem<T> {

		private Label content = new Label();
		private IObjectNameProvider nameProvider;
		
		/**
		 * @param id The id of the object that will be shown on the page
		 * @param title The title of the object
		 * @param runtimeGinjector It is used to get the IObjectNameProvider to get the value we needed.
		 */
		public ObjectDetaiItem(String id, String title,RuntimeGinjector runtimeGinjector) {
			super(id, title);
			add(titleLabel);
			add(contentContainer);
			contentContainer.add(content);
			nameProvider = runtimeGinjector.getObjectNameProvider();
		}

		/* (non-Javadoc)
		 * @see com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer#setValue(java.lang.Object)
		 * Show the object value in a label. 
		 */
		@Override
		public IValueViewer<T> setValue(T value) {
			content.setText(nameProvider.getName(value));
			return this;
		}
	}

	/**
	 * @param id object's unique mark.
	 * @param title the name of the object that will be shown.
	 * @return the detailItem that can be shown on the page.
	 * DetailItem is the option name provided by the UIDL suggestion contents.
	 */
	@WidgetProvider(isDefault=true)
	public <T> ObjectDetaiItem<T> createAsDetailItem(String id,
			String title) {
		return new ObjectDetaiItem<T>(id, title, runtimeGinjector);
	}
}
