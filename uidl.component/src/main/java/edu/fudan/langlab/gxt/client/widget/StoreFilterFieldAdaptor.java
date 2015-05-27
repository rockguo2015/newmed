package edu.fudan.langlab.gxt.client.widget;

import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.Functions.Function4;

import com.sencha.gxt.data.shared.Store;
import com.sencha.gxt.widget.core.client.form.StoreFilterField;

public class StoreFilterFieldAdaptor {
	
	public static <T> StoreFilterField <T>create(final Function4<? super Store<T>,? super T,? super T,? super String, ? extends Boolean> selector){
		return new  StoreFilterField<T>(){

			@Override
			protected boolean doSelect(Store<T> store, T parent, T item,
					String filter) {
				return selector.apply(store,parent,item,filter);
			}
			
		};
	}

	public static <T> StoreFilterField <T>create(final Function2<? super T,? super String, ? extends Boolean> selector){
		return new  StoreFilterField<T>(){

			@Override
			protected boolean doSelect(Store<T> store, T parent, T item,
					String filter) {
				return selector.apply(item,filter);
			}
			
		};
	}

}
