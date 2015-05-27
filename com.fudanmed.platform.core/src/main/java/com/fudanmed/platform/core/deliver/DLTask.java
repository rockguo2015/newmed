package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLTaskEvent;
import com.fudanmed.platform.core.deliver.DLTaskSource;
import com.fudanmed.platform.core.deliver.impl.DLTaskImpl;
import com.fudanmed.platform.core.deliver.proxy.DLTaskProxy;
import com.fudanmed.platform.core.domain.RCEmployee;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;
import java.util.Date;

@EntityImplementation(implementBy = DLTaskImpl.class)
public interface DLTask extends IModelObject {
  public abstract String getSid();
  
  public abstract DLTask setSid(final String sid);
  
  public abstract Date getCreateTime();
  
  public abstract DLTask setCreateTime(final Date createTime);
  
  public abstract Collection<RCEmployee> getPerformers();
  
  public abstract DLTask addtoPerformers(final RCEmployee rCEmployee);
  
  public abstract DLTask setPerformers(final Iterable<RCEmployee> performers);
  
  public abstract DLTask removeFromPerformers(final RCEmployee rCEmployee);
  
  public abstract DLTask removeAllPerformers();
  
  public abstract RCEmployee getOperator();
  
  public abstract DLTask setOperator(final RCEmployee operator);
  
  public abstract DLTaskSource getTaskSource();
  
  public abstract DLTask setTaskSource(final DLTaskSource taskSource);
  
  public abstract Collection<DLTaskEvent> getEvents();
  
  public abstract DLTask removeFromEvents(final DLTaskEvent dLTaskEvent);
  
  public abstract DLTask removeAllEvents();
  
  public abstract void chackValid();
  
  public abstract DLTaskProxy toProxy();
}
