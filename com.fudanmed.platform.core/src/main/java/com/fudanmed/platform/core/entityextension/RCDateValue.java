package com.fudanmed.platform.core.entityextension;

import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCPrimaryValue;
import com.fudanmed.platform.core.entityextension.impl.RCDateValueImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCDateValueProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import java.util.Date;

@EntityImplementation(implementBy = RCDateValueImpl.class)
public interface RCDateValue extends RCPrimaryValue {
  public abstract Date getDate();
  
  public abstract RCDateValue setDate(final Date date);
  
  public abstract String getEntityName();
  
  public abstract void setValue(final Date date);
  
  public abstract RCDateValue cloneIn(final RCExtensiableEntity rootOwner);
  
  public abstract RCDateValueProxy toProxy();
}
