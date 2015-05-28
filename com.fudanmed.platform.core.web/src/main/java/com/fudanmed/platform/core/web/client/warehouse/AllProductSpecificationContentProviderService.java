package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.shared.warehouse.AllProductSpecificationContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.AllProductSpecificationContentProviderService")
public interface AllProductSpecificationContentProviderService extends RemoteService {
  public abstract Collection<UIProductSpecification> load(final AllProductSpecificationContentProviderCriteria criteria);
}
