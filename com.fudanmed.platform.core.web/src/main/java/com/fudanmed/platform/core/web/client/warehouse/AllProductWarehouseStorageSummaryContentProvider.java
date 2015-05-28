package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.AllProductWarehouseStorageSummaryContentProviderServiceAsync;
import com.fudanmed.platform.core.web.shared.warehouse.AllProductWarehouseStorageSummaryContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProviderWithFilter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class AllProductWarehouseStorageSummaryContentProvider extends AbstractAsyncContentProviderWithFilter<UIProductWarehouseStorageSummary,AllProductWarehouseStorageSummaryContentProviderCriteria> {
  private AllProductWarehouseStorageSummaryContentProviderCriteria _criteria;
  
  public AllProductWarehouseStorageSummaryContentProviderCriteria createCriteria() {
    if(_criteria==null) _criteria = new com.fudanmed.platform.core.web.shared.warehouse.AllProductWarehouseStorageSummaryContentProviderCriteria();
    return _criteria;
    
  }
  
  @Inject
  private AllProductWarehouseStorageSummaryContentProviderServiceAsync service;
  
  protected void doGetContent(final AllProductWarehouseStorageSummaryContentProviderCriteria context, final ServiceCallback<Collection<UIProductWarehouseStorageSummary>> callback) {
    service.load(context, callback);
  }
  
  public void load(final RCWarehouseProxy store, final Procedure1<Void> notifier) {
    AllProductWarehouseStorageSummaryContentProviderCriteria criteria = createCriteria();
    criteria.setStore(store);
    loadContent(criteria,new com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentLoadedCallback(){
    							public void contentLoaded(){
    								notifier.apply(null);
    							}
    						});
  }
}
