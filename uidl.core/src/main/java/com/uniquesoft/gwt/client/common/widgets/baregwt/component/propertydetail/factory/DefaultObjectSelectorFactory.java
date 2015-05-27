package com.uniquesoft.gwt.client.common.widgets.baregwt.component.propertydetail.factory;

import com.uniquesoft.gwt.client.common.widgets.baregwt.component.propertydetail.factory.item.AbstractPropertyDetailItem;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;

import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;

/**
 * If the object field type doesn't not match any other detail objects selector factory,
 * it will use the DefaultObjectSelectorFactory class to build a detailItem.In UIDL,
 * use it like this:
 * ui-datatype Book{
		bookName : String "name"
		bookAuthor : String
		bookPrice : Float
		
		ui-component TestDetail as GWTPropertyDetailView{
			binding{
				bookName as DefaultPropertyDetailItem,
				bookAuthor,
				bookPrice
			}
		}
	}
	
	Right now this factory only have one class ,and it may replaced by VListGrid
 *
 */
public class DefaultObjectSelectorFactory {

	@Inject
    RuntimeGinjector runtimeGinjector;
	
	 public static class DefaultPropertyDetailItem<T> extends AbstractPropertyDetailItem<T> {

		RuntimeGinjector runtimeGinjector;
		
		public DefaultPropertyDetailItem(String id, String title, RuntimeGinjector runtimeGinjector) {
			super(id, title);
			this.runtimeGinjector = runtimeGinjector;
		}

		@Override
		public IValueViewer<T> setValue(T value) {
			this.widget.setValue(value.toString());
			return this;
		}
		 
	 }
	 
	 @WidgetProvider(isDefault=true)
	    public <T> DefaultPropertyDetailItem<T> createAsDefaultPropertyDetailItem(String id, String title) {
	        return new DefaultPropertyDetailItem<T>(id,title,runtimeGinjector);
	    }

}
