package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLTask;
import com.fudanmed.platform.core.deliver.DLTaskSourceType;
import com.fudanmed.platform.core.deliver.impl.DLTaskCriteriaImpl;
import com.fudanmed.platform.core.domain.RCEmployee;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;
import java.util.Date;

@QueryImplementation(implementBy = DLTaskCriteriaImpl.class)
public interface DLTaskCriteria extends IPagedCriteria<DLTask> {
  public abstract String getSid();
  
  public abstract DLTaskCriteria setSid(final String sid);
  
  public abstract Date getCreateTimeFrom();
  
  public abstract DLTaskCriteria setCreateTimeFrom(final Date createTimeFrom);
  
  public abstract Date getCreateTimeTo();
  
  public abstract DLTaskCriteria setCreateTimeTo(final Date createTimeTo);
  
  public abstract RCEmployee getPerformer();
  
  public abstract DLTaskCriteria setPerformer(final RCEmployee performer);
  
  public abstract DLTaskSourceType getTaskSourceType();
  
  public abstract DLTaskCriteria setTaskSourceType(final DLTaskSourceType taskSourceType);
}
