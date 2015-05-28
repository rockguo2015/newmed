package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.web.client.organization.AllDeviceSupplierContentProviderServiceAsync;
import com.fudanmed.platform.core.web.shared.organization.AllDeviceSupplierContentProviderCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProviderWithFilter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class AllDeviceSupplierContentProvider extends AbstractAsyncContentProviderWithFilter<RCSupplierProxy,AllDeviceSupplierContentProviderCriteria> {
  private AllDeviceSupplierContentProviderCriteria _criteria;
  
  public AllDeviceSupplierContentProviderCriteria createCriteria() {
    if(_criteria==null) _criteria = new com.fudanmed.platform.core.web.shared.organization.AllDeviceSupplierContentProviderCriteria();
    return _criteria;
    
  }
  
  @Inject
  private AllDeviceSupplierContentProviderServiceAsync service;
  
  protected void doGetContent(final AllDeviceSupplierContentProviderCriteria context, final ServiceCallback<Collection<RCSupplierProxy>> callback) {
    service.load(context, callback);
  }
  
  public void load(final Procedure1<Void> notifier) {
    AllDeviceSupplierContentProviderCriteria criteria = createCriteria();
    loadContent(criteria,new com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentLoadedCallback(){
    							public void contentLoaded(){
    								notifier.apply(null);
    							}
    						});
  }
}
