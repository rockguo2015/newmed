package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.AllFaultTypeSContentProviderServiceAsync;
import com.fudanmed.platform.core.web.shared.project.AllFaultTypeSContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProviderWithFilter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class AllFaultTypeSContentProvider extends AbstractAsyncContentProviderWithFilter<UIFaultType,AllFaultTypeSContentProviderCriteria> {
  private AllFaultTypeSContentProviderCriteria _criteria;
  
  public AllFaultTypeSContentProviderCriteria createCriteria() {
    if(_criteria==null) _criteria = new com.fudanmed.platform.core.web.shared.project.AllFaultTypeSContentProviderCriteria();
    return _criteria;
    
  }
  
  @Inject
  private AllFaultTypeSContentProviderServiceAsync service;
  
  protected void doGetContent(final AllFaultTypeSContentProviderCriteria context, final ServiceCallback<Collection<UIFaultType>> callback) {
    service.load(context, callback);
  }
  
  public void load(final Procedure1<Void> notifier) {
    AllFaultTypeSContentProviderCriteria criteria = createCriteria();
    loadContent(criteria,new com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentLoadedCallback(){
    							public void contentLoaded(){
    								notifier.apply(null);
    							}
    						});
  }
}
