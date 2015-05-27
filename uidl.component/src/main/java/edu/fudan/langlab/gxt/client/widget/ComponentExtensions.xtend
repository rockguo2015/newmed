package edu.fudan.langlab.gxt.client.widget

import com.sencha.gxt.data.shared.Store
import com.sencha.gxt.widget.core.client.form.StoreFilterField

class ComponentExtensions {
	def static <T> StoreFilterField<T> createFilter(IHasStoreComponent<T> component,(Store<T>,T,T,String)=>boolean m ){
		StoreFilterFieldAdaptor::create(m)=>[
			bind(component.getStore)
		]
	}

	def static <T> StoreFilterField<T> createFilter(IHasStoreComponent<T> component,(T,String)=>boolean m ){
		StoreFilterFieldAdaptor::create(m)=>[
			bind(component.getStore)
		]
	}

}