package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.AllWorkers4OrgContentProviderServiceAsync;
import com.fudanmed.platform.core.web.shared.organization.AllWorkers4OrgContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.project.UIWorker;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProviderWithFilter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class AllWorkers4OrgContentProvider extends AbstractAsyncContentProviderWithFilter<UIWorker,AllWorkers4OrgContentProviderCriteria> {
  private AllWorkers4OrgContentProviderCriteria _criteria;
  
  public AllWorkers4OrgContentProviderCriteria createCriteria() {
    if(_criteria==null) _criteria = new com.fudanmed.platform.core.web.shared.organization.AllWorkers4OrgContentProviderCriteria();
    return _criteria;
    
  }
  
  @Inject
  private AllWorkers4OrgContentProviderServiceAsync service;
  
  protected void doGetContent(final AllWorkers4OrgContentProviderCriteria context, final ServiceCallback<Collection<UIWorker>> callback) {
    service.load(context, callback);
  }
  
  public void load(final RCOrganizationProxy org, final Procedure1<Void> notifier) {
    AllWorkers4OrgContentProviderCriteria criteria = createCriteria();
    criteria.setOrg(org);
    loadContent(criteria,new com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentLoadedCallback(){
    							public void contentLoaded(){
    								notifier.apply(null);
    							}
    						});
  }
}
