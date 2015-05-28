package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.AllProductWarehouseStorageContentProviderServiceAsync;
import com.fudanmed.platform.core.web.shared.warehouse.AllProductWarehouseStorageContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorage;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProviderWithFilter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class AllProductWarehouseStorageContentProvider extends AbstractAsyncContentProviderWithFilter<UIProductWarehouseStorage,AllProductWarehouseStorageContentProviderCriteria> {
  private AllProductWarehouseStorageContentProviderCriteria _criteria;
  
  public AllProductWarehouseStorageContentProviderCriteria createCriteria() {
    if(_criteria==null) _criteria = new com.fudanmed.platform.core.web.shared.warehouse.AllProductWarehouseStorageContentProviderCriteria();
    return _criteria;
    
  }
  
  @Inject
  private AllProductWarehouseStorageContentProviderServiceAsync service;
  
  protected void doGetContent(final AllProductWarehouseStorageContentProviderCriteria context, final ServiceCallback<Collection<UIProductWarehouseStorage>> callback) {
    service.load(context, callback);
  }
  
  public void load(final Procedure1<Void> notifier) {
    AllProductWarehouseStorageContentProviderCriteria criteria = createCriteria();
    loadContent(criteria,new com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentLoadedCallback(){
    							public void contentLoaded(){
    								notifier.apply(null);
    							}
    						});
  }
}
