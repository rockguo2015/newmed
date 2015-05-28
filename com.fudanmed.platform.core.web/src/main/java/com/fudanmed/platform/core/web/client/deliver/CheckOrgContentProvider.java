package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import com.fudanmed.platform.core.web.client.deliver.CheckOrgContentProviderServiceAsync;
import com.fudanmed.platform.core.web.shared.deliver.CheckOrgContentProviderCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProviderWithFilter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CheckOrgContentProvider extends AbstractAsyncContentProviderWithFilter<DLCheckOrganizationProxy,CheckOrgContentProviderCriteria> {
  private CheckOrgContentProviderCriteria _criteria;
  
  public CheckOrgContentProviderCriteria createCriteria() {
    if(_criteria==null) _criteria = new com.fudanmed.platform.core.web.shared.deliver.CheckOrgContentProviderCriteria();
    return _criteria;
    
  }
  
  @Inject
  private CheckOrgContentProviderServiceAsync service;
  
  protected void doGetContent(final CheckOrgContentProviderCriteria context, final ServiceCallback<Collection<DLCheckOrganizationProxy>> callback) {
    service.load(context, callback);
  }
  
  public void load(final DLDeliverPatientCheckTypeProxy checkType, final Procedure1<Void> notifier) {
    CheckOrgContentProviderCriteria criteria = createCriteria();
    criteria.setCheckType(checkType);
    loadContent(criteria,new com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentLoadedCallback(){
    							public void contentLoaded(){
    								notifier.apply(null);
    							}
    						});
  }
}
