package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.client.organization.AllOnsitePositionAyncContentProviderServiceAsync;
import com.fudanmed.platform.core.web.shared.organization.AllOnsitePositionAyncContentProviderCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProviderWithFilter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class AllOnsitePositionAyncContentProvider extends AbstractAsyncContentProviderWithFilter<RCOnsitePositionProxy,AllOnsitePositionAyncContentProviderCriteria> {
  private AllOnsitePositionAyncContentProviderCriteria _criteria;
  
  public AllOnsitePositionAyncContentProviderCriteria createCriteria() {
    if(_criteria==null) _criteria = new com.fudanmed.platform.core.web.shared.organization.AllOnsitePositionAyncContentProviderCriteria();
    return _criteria;
    
  }
  
  @Inject
  private AllOnsitePositionAyncContentProviderServiceAsync service;
  
  protected void doGetContent(final AllOnsitePositionAyncContentProviderCriteria context, final ServiceCallback<Collection<RCOnsitePositionProxy>> callback) {
    service.load(context, callback);
  }
  
  public void load(final Procedure1<Void> notifier) {
    AllOnsitePositionAyncContentProviderCriteria criteria = createCriteria();
    loadContent(criteria,new com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentLoadedCallback(){
    							public void contentLoaded(){
    								notifier.apply(null);
    							}
    						});
  }
}
