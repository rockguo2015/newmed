package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLCheckOrganization;
import com.fudanmed.platform.core.deliver.impl.DLCheckOrganizationCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

@QueryImplementation(implementBy = DLCheckOrganizationCriteriaImpl.class)
public interface DLCheckOrganizationCriteria extends IPagedCriteria<DLCheckOrganization> {
  public abstract String getInfo();
  
  public abstract DLCheckOrganizationCriteria setInfo(final String info);
}
