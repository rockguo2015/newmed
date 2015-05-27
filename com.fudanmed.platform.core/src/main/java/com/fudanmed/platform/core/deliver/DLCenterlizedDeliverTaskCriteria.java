package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask;
import com.fudanmed.platform.core.deliver.DLTaskSourceType;
import com.fudanmed.platform.core.deliver.impl.DLCenterlizedDeliverTaskCriteriaImpl;
import com.fudanmed.platform.core.domain.RCEmployee;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;
import java.util.Date;

@QueryImplementation(implementBy = DLCenterlizedDeliverTaskCriteriaImpl.class)
public interface DLCenterlizedDeliverTaskCriteria extends IPagedCriteria<DLCenterlizedDeliverTask> {
  public abstract String getSid();
  
  public abstract DLCenterlizedDeliverTaskCriteria setSid(final String sid);
  
  public abstract Date getCreateTimeFrom();
  
  public abstract DLCenterlizedDeliverTaskCriteria setCreateTimeFrom(final Date createTimeFrom);
  
  public abstract Date getCreateTimeTo();
  
  public abstract DLCenterlizedDeliverTaskCriteria setCreateTimeTo(final Date createTimeTo);
  
  public abstract RCEmployee getPerformer();
  
  public abstract DLCenterlizedDeliverTaskCriteria setPerformer(final RCEmployee performer);
  
  public abstract DLTaskSourceType getTaskSourceType();
  
  public abstract DLCenterlizedDeliverTaskCriteria setTaskSourceType(final DLTaskSourceType taskSourceType);
}
