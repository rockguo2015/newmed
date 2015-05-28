package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.AllOrgEmployeeContentProviderServiceAsync;
import com.fudanmed.platform.core.web.shared.organization.AllOrgEmployeeContentProviderCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProviderWithFilter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class AllOrgEmployeeContentProvider extends AbstractAsyncContentProviderWithFilter<RCEmployeeProxy,AllOrgEmployeeContentProviderCriteria> {
  private AllOrgEmployeeContentProviderCriteria _criteria;
  
  public AllOrgEmployeeContentProviderCriteria createCriteria() {
    if(_criteria==null) _criteria = new com.fudanmed.platform.core.web.shared.organization.AllOrgEmployeeContentProviderCriteria();
    return _criteria;
    
  }
  
  @Inject
  private AllOrgEmployeeContentProviderServiceAsync service;
  
  protected void doGetContent(final AllOrgEmployeeContentProviderCriteria context, final ServiceCallback<Collection<RCEmployeeProxy>> callback) {
    service.load(context, callback);
  }
  
  public void load(final RCOrganizationProxy org, final Procedure1<Void> notifier) {
    AllOrgEmployeeContentProviderCriteria criteria = createCriteria();
    criteria.setOrg(org);
    loadContent(criteria,new com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentLoadedCallback(){
    							public void contentLoaded(){
    								notifier.apply(null);
    							}
    						});
  }
}
