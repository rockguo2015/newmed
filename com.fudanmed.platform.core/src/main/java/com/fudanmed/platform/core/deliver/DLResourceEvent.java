package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLResource;
import com.fudanmed.platform.core.deliver.impl.DLResourceEventImpl;
import com.fudanmed.platform.core.deliver.proxy.DLResourceEventProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Date;

@EntityImplementation(implementBy = DLResourceEventImpl.class)
public interface DLResourceEvent extends IModelObject {
  public abstract Date getDate();
  
  public abstract DLResourceEvent setDate(final Date date);
  
  public abstract String getComment();
  
  public abstract DLResourceEvent setComment(final String comment);
  
  public abstract DLResource getResource();
  
  public abstract DLResourceEvent setResource(final DLResource resource);
  
  public abstract DLResourceEventProxy toProxy();
}
