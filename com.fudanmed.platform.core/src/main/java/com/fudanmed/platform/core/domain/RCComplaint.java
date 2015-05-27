package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.impl.RCComplaintImpl;
import com.fudanmed.platform.core.domain.proxy.RCComplaintProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Date;

@EntityImplementation(implementBy = RCComplaintImpl.class)
public interface RCComplaint extends IModelObject {
  public abstract RCRepairTask getRepairTask();
  
  public abstract RCComplaint setRepairTask(final RCRepairTask repairTask);
  
  public abstract Date getDate();
  
  public abstract RCComplaint setDate(final Date date);
  
  public abstract String getContents();
  
  public abstract RCComplaint setContents(final String contents);
  
  public abstract RCEmployee getOwner();
  
  public abstract RCComplaint setOwner(final RCEmployee owner);
  
  public abstract RCComplaintProxy toProxy();
}
