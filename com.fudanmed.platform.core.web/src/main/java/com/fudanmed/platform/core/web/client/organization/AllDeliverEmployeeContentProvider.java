package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverOrganizationProxy;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.client.organization.AllDeliverEmployeeContentProviderServiceAsync;
import com.fudanmed.platform.core.web.shared.organization.AllDeliverEmployeeContentProviderCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProviderWithFilter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class AllDeliverEmployeeContentProvider extends AbstractAsyncContentProviderWithFilter<RCEmployeeProxy,AllDeliverEmployeeContentProviderCriteria> {
  private AllDeliverEmployeeContentProviderCriteria _criteria;
  
  public AllDeliverEmployeeContentProviderCriteria createCriteria() {
    if(_criteria==null) _criteria = new com.fudanmed.platform.core.web.shared.organization.AllDeliverEmployeeContentProviderCriteria();
    return _criteria;
    
  }
  
  @Inject
  private AllDeliverEmployeeContentProviderServiceAsync service;
  
  protected void doGetContent(final AllDeliverEmployeeContentProviderCriteria context, final ServiceCallback<Collection<RCEmployeeProxy>> callback) {
    service.load(context, callback);
  }
  
  public void load(final DLDeliverOrganizationProxy org, final Procedure1<Void> notifier) {
    AllDeliverEmployeeContentProviderCriteria criteria = createCriteria();
    criteria.setOrg(org);
    loadContent(criteria,new com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentLoadedCallback(){
    							public void contentLoaded(){
    								notifier.apply(null);
    							}
    						});
  }
}
