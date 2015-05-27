package com.fudanmed.platform.core.domain.rest;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.RCWorkItemTaskStatus;
import com.fudanmed.platform.core.domain.rest.impl.RCWorkItemTaskCriteria4StatusImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;
import java.util.Date;

@QueryImplementation(implementBy = RCWorkItemTaskCriteria4StatusImpl.class)
public interface RCWorkItemTaskCriteria4Status extends IPagedCriteria<RCWorkItemTask> {
  public abstract RCEmployee getOwner();
  
  public abstract RCWorkItemTaskCriteria4Status setOwner(final RCEmployee owner);
  
  public abstract RCWorkItemTaskStatus getStatus();
  
  public abstract RCWorkItemTaskCriteria4Status setStatus(final RCWorkItemTaskStatus status);
  
  public abstract Date getFromDate();
  
  public abstract RCWorkItemTaskCriteria4Status setFromDate(final Date fromDate);
  
  public abstract Date getToDate();
  
  public abstract RCWorkItemTaskCriteria4Status setToDate(final Date toDate);
}
