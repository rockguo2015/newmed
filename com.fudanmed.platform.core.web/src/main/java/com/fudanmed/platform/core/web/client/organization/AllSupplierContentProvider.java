package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.web.client.organization.AllSupplierContentProviderServiceAsync;
import com.fudanmed.platform.core.web.shared.organization.AllSupplierContentProviderCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProviderWithFilter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class AllSupplierContentProvider extends AbstractAsyncContentProviderWithFilter<RCSupplierProxy,AllSupplierContentProviderCriteria> {
  private AllSupplierContentProviderCriteria _criteria;
  
  public AllSupplierContentProviderCriteria createCriteria() {
    if(_criteria==null) _criteria = new com.fudanmed.platform.core.web.shared.organization.AllSupplierContentProviderCriteria();
    return _criteria;
    
  }
  
  @Inject
  private AllSupplierContentProviderServiceAsync service;
  
  protected void doGetContent(final AllSupplierContentProviderCriteria context, final ServiceCallback<Collection<RCSupplierProxy>> callback) {
    service.load(context, callback);
  }
  
  public void load(final Procedure1<Void> notifier) {
    AllSupplierContentProviderCriteria criteria = createCriteria();
    loadContent(criteria,new com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentLoadedCallback(){
    							public void contentLoaded(){
    								notifier.apply(null);
    							}
    						});
  }
}
