package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverOrganization;
import com.fudanmed.platform.core.deliver.impl.DLDeliverOrganizationCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

@QueryImplementation(implementBy = DLDeliverOrganizationCriteriaImpl.class)
public interface DLDeliverOrganizationCriteria extends IPagedCriteria<DLDeliverOrganization> {
  public abstract String getInfo();
  
  public abstract DLDeliverOrganizationCriteria setInfo(final String info);
}
