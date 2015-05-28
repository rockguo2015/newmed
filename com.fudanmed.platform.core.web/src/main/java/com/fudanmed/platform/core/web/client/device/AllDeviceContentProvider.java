package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.AllDeviceContentProviderServiceAsync;
import com.fudanmed.platform.core.web.shared.device.AllDeviceContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProviderWithFilter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class AllDeviceContentProvider extends AbstractAsyncContentProviderWithFilter<UIDevice,AllDeviceContentProviderCriteria> {
  private AllDeviceContentProviderCriteria _criteria;
  
  public AllDeviceContentProviderCriteria createCriteria() {
    if(_criteria==null) _criteria = new com.fudanmed.platform.core.web.shared.device.AllDeviceContentProviderCriteria();
    return _criteria;
    
  }
  
  @Inject
  private AllDeviceContentProviderServiceAsync service;
  
  protected void doGetContent(final AllDeviceContentProviderCriteria context, final ServiceCallback<Collection<UIDevice>> callback) {
    service.load(context, callback);
  }
  
  public void load(final Procedure1<Void> notifier) {
    AllDeviceContentProviderCriteria criteria = createCriteria();
    loadContent(criteria,new com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentLoadedCallback(){
    							public void contentLoaded(){
    								notifier.apply(null);
    							}
    						});
  }
}
