package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLTask;
import com.fudanmed.platform.core.deliver.impl.DLTaskEventImpl;
import com.fudanmed.platform.core.deliver.proxy.DLTaskEventProxy;
import com.fudanmed.platform.core.domain.RCEmployee;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Date;

@EntityImplementation(implementBy = DLTaskEventImpl.class)
public interface DLTaskEvent extends IModelObject {
  public abstract Date getCreateTime();
  
  public abstract DLTaskEvent setCreateTime(final Date createTime);
  
  public abstract RCEmployee getOperator();
  
  public abstract DLTaskEvent setOperator(final RCEmployee operator);
  
  public abstract String getDescription();
  
  public abstract DLTask getTask();
  
  public abstract DLTaskEvent setTask(final DLTask task);
  
  public abstract DLTaskEventProxy toProxy();
}
