package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.AllOrganizationAsyncContentProviderServiceAsync;
import com.fudanmed.platform.core.web.shared.organization.AllOrganizationAsyncContentProviderCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProviderWithFilter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class AllOrganizationAsyncContentProvider extends AbstractAsyncContentProviderWithFilter<RCOrganizationProxy,AllOrganizationAsyncContentProviderCriteria> {
  private AllOrganizationAsyncContentProviderCriteria _criteria;
  
  public AllOrganizationAsyncContentProviderCriteria createCriteria() {
    if(_criteria==null) _criteria = new com.fudanmed.platform.core.web.shared.organization.AllOrganizationAsyncContentProviderCriteria();
    return _criteria;
    
  }
  
  @Inject
  private AllOrganizationAsyncContentProviderServiceAsync service;
  
  protected void doGetContent(final AllOrganizationAsyncContentProviderCriteria context, final ServiceCallback<Collection<RCOrganizationProxy>> callback) {
    service.load(context, callback);
  }
  
  public void load(final Procedure1<Void> notifier) {
    AllOrganizationAsyncContentProviderCriteria criteria = createCriteria();
    loadContent(criteria,new com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentLoadedCallback(){
    							public void contentLoaded(){
    								notifier.apply(null);
    							}
    						});
  }
}
