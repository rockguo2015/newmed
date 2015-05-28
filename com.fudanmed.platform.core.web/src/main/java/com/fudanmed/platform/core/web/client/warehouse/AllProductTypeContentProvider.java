package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy;
import com.fudanmed.platform.core.web.client.warehouse.AllProductTypeContentProviderServiceAsync;
import com.fudanmed.platform.core.web.shared.warehouse.AllProductTypeContentProviderCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProviderWithFilter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class AllProductTypeContentProvider extends AbstractAsyncContentProviderWithFilter<RCProductTypeProxy,AllProductTypeContentProviderCriteria> {
  private AllProductTypeContentProviderCriteria _criteria;
  
  public AllProductTypeContentProviderCriteria createCriteria() {
    if(_criteria==null) _criteria = new com.fudanmed.platform.core.web.shared.warehouse.AllProductTypeContentProviderCriteria();
    return _criteria;
    
  }
  
  @Inject
  private AllProductTypeContentProviderServiceAsync service;
  
  protected void doGetContent(final AllProductTypeContentProviderCriteria context, final ServiceCallback<Collection<RCProductTypeProxy>> callback) {
    service.load(context, callback);
  }
  
  public void load(final Procedure1<Void> notifier) {
    AllProductTypeContentProviderCriteria criteria = createCriteria();
    loadContent(criteria,new com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentLoadedCallback(){
    							public void contentLoaded(){
    								notifier.apply(null);
    							}
    						});
  }
}
