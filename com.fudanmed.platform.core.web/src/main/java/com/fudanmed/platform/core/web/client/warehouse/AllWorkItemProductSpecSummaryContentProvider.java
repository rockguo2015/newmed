package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.client.warehouse.AllWorkItemProductSpecSummaryContentProviderServiceAsync;
import com.fudanmed.platform.core.web.shared.warehouse.AllWorkItemProductSpecSummaryContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecificationSummary;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProviderWithFilter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class AllWorkItemProductSpecSummaryContentProvider extends AbstractAsyncContentProviderWithFilter<UIProductSpecificationSummary,AllWorkItemProductSpecSummaryContentProviderCriteria> {
  private AllWorkItemProductSpecSummaryContentProviderCriteria _criteria;
  
  public AllWorkItemProductSpecSummaryContentProviderCriteria createCriteria() {
    if(_criteria==null) _criteria = new com.fudanmed.platform.core.web.shared.warehouse.AllWorkItemProductSpecSummaryContentProviderCriteria();
    return _criteria;
    
  }
  
  @Inject
  private AllWorkItemProductSpecSummaryContentProviderServiceAsync service;
  
  protected void doGetContent(final AllWorkItemProductSpecSummaryContentProviderCriteria context, final ServiceCallback<Collection<UIProductSpecificationSummary>> callback) {
    service.load(context, callback);
  }
  
  public void load(final RCWorkItemTaskProxy workItem, final Procedure1<Void> notifier) {
    AllWorkItemProductSpecSummaryContentProviderCriteria criteria = createCriteria();
    criteria.setWorkItem(workItem);
    loadContent(criteria,new com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentLoadedCallback(){
    							public void contentLoaded(){
    								notifier.apply(null);
    							}
    						});
  }
}
