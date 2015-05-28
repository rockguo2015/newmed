package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.client.organization.AllEmployeesAsyncContentProviderServiceAsync;
import com.fudanmed.platform.core.web.shared.organization.AllEmployeesAsyncContentProviderCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProviderWithFilter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class AllEmployeesAsyncContentProvider extends AbstractAsyncContentProviderWithFilter<RCEmployeeProxy,AllEmployeesAsyncContentProviderCriteria> {
  private AllEmployeesAsyncContentProviderCriteria _criteria;
  
  public AllEmployeesAsyncContentProviderCriteria createCriteria() {
    if(_criteria==null) _criteria = new com.fudanmed.platform.core.web.shared.organization.AllEmployeesAsyncContentProviderCriteria();
    return _criteria;
    
  }
  
  @Inject
  private AllEmployeesAsyncContentProviderServiceAsync service;
  
  protected void doGetContent(final AllEmployeesAsyncContentProviderCriteria context, final ServiceCallback<Collection<RCEmployeeProxy>> callback) {
    service.load(context, callback);
  }
  
  public void load(final Procedure1<Void> notifier) {
    AllEmployeesAsyncContentProviderCriteria criteria = createCriteria();
    loadContent(criteria,new com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentLoadedCallback(){
    							public void contentLoaded(){
    								notifier.apply(null);
    							}
    						});
  }
}
