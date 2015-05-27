package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLResourceEvent;
import com.fudanmed.platform.core.deliver.impl.DLResourceExtBorrowEventImpl;
import com.fudanmed.platform.core.deliver.proxy.DLResourceExtBorrowEventProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import java.util.Date;

@EntityImplementation(implementBy = DLResourceExtBorrowEventImpl.class)
public interface DLResourceExtBorrowEvent extends DLResourceEvent {
  public abstract Date getDateTime();
  
  public abstract DLResourceExtBorrowEvent setDateTime(final Date dateTime);
  
  public abstract Date getReturnDateTime();
  
  public abstract DLResourceExtBorrowEvent setReturnDateTime(final Date returnDateTime);
  
  public abstract Boolean getReturned();
  
  public abstract DLResourceExtBorrowEvent setReturned(final Boolean returned);
  
  public abstract DLResourceExtBorrowEventProxy toProxy();
}
