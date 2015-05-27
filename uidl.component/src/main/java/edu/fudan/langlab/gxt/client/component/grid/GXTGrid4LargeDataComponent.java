package edu.fudan.langlab.gxt.client.component.grid;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.collect.Lists;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.event.StoreAddEvent;

import edu.fudan.langlab.gxt.client.component.KeyProvider;

public abstract class GXTGrid4LargeDataComponent<VT> extends GXTGridComponent<VT>{

	protected ListStore<VT> getStore(){
		if(_store==null){
			_store = new ListStore<VT>(new KeyProvider<VT>()){

				protected void fireSortedAddEvents(
						java.util.Collection<? extends VT> items) {
					if(items.size()==0) return;
					int startIndex = indexOf(IterableExtensions.head(items));
					fireEvent(new StoreAddEvent<VT>(startIndex,Lists.newArrayList(items)));
				};
			};;
		}
		return _store;
	}	
}
