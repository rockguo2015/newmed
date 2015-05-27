package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLResource;
import edu.fudan.mylang.pf.event.IEntityEventsListner;

public interface DLResourceEventsListener extends IEntityEventsListner<DLResource> {
  public abstract void repair(final DLResource entity, final String comment);
  
  public abstract void borrow(final DLResource entity);
  
  public abstract void doReturn(final DLResource entity);
  
  public abstract void extBorrow(final DLResource entity, final String comment);
  
  public abstract void doExtReturn(final DLResource entity);
  
  public abstract void unregister(final DLResource entity, final String comment);
  
  public abstract void finishRepair(final DLResource entity, final String comment);
}
