package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.AllProductSpecificationContentProviderServiceAsync;
import com.fudanmed.platform.core.web.shared.warehouse.AllProductSpecificationContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProviderWithFilter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class AllProductSpecificationContentProvider extends AbstractAsyncContentProviderWithFilter<UIProductSpecification,AllProductSpecificationContentProviderCriteria> {
  private AllProductSpecificationContentProviderCriteria _criteria;
  
  public AllProductSpecificationContentProviderCriteria createCriteria() {
    if(_criteria==null) _criteria = new com.fudanmed.platform.core.web.shared.warehouse.AllProductSpecificationContentProviderCriteria();
    return _criteria;
    
  }
  
  @Inject
  private AllProductSpecificationContentProviderServiceAsync service;
  
  protected void doGetContent(final AllProductSpecificationContentProviderCriteria context, final ServiceCallback<Collection<UIProductSpecification>> callback) {
    service.load(context, callback);
  }
  
  public void load(final Procedure1<Void> notifier) {
    AllProductSpecificationContentProviderCriteria criteria = createCriteria();
    loadContent(criteria,new com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentLoadedCallback(){
    							public void contentLoaded(){
    								notifier.apply(null);
    							}
    						});
  }
}
