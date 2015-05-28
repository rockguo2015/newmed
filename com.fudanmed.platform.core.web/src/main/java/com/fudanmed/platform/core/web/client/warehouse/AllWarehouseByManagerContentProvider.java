package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.AllWarehouseByManagerContentProviderServiceAsync;
import com.fudanmed.platform.core.web.shared.warehouse.AllWarehouseByManagerContentProviderCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProviderWithFilter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class AllWarehouseByManagerContentProvider extends AbstractAsyncContentProviderWithFilter<RCWarehouseProxy,AllWarehouseByManagerContentProviderCriteria> {
  private AllWarehouseByManagerContentProviderCriteria _criteria;
  
  public AllWarehouseByManagerContentProviderCriteria createCriteria() {
    if(_criteria==null) _criteria = new com.fudanmed.platform.core.web.shared.warehouse.AllWarehouseByManagerContentProviderCriteria();
    return _criteria;
    
  }
  
  @Inject
  private AllWarehouseByManagerContentProviderServiceAsync service;
  
  protected void doGetContent(final AllWarehouseByManagerContentProviderCriteria context, final ServiceCallback<Collection<RCWarehouseProxy>> callback) {
    service.load(context, callback);
  }
  
  public void load(final RCEmployeeProxy employee, final Procedure1<Void> notifier) {
    AllWarehouseByManagerContentProviderCriteria criteria = createCriteria();
    criteria.setEmployee(employee);
    loadContent(criteria,new com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentLoadedCallback(){
    							public void contentLoaded(){
    								notifier.apply(null);
    							}
    						});
  }
}
