package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTaskStatus;
import com.fudanmed.platform.core.deliver.DLDeliverSubject;
import com.fudanmed.platform.core.deliver.DLPatientCheckDeliverTaskEvent;
import com.fudanmed.platform.core.deliver.DLPatientCheckDeliverTaskEventType;
import com.fudanmed.platform.core.deliver.DLPlanDateTime;
import com.fudanmed.platform.core.deliver.DLResource;
import com.fudanmed.platform.core.deliver.DLTask;
import com.fudanmed.platform.core.deliver.impl.DLCenterlizedDeliverTaskImpl;
import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.domain.RCEmployee;
import edu.fudan.mylang.pf.EntityImplementation;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@EntityImplementation(implementBy = DLCenterlizedDeliverTaskImpl.class)
public interface DLCenterlizedDeliverTask extends DLTask {
  public abstract Collection<DLResource> getResources();
  
  public abstract DLCenterlizedDeliverTask addtoResources(final DLResource dLResource);
  
  public abstract DLCenterlizedDeliverTask setResources(final Iterable<DLResource> resources);
  
  public abstract DLCenterlizedDeliverTask removeFromResources(final DLResource dLResource);
  
  public abstract DLCenterlizedDeliverTask removeAllResources();
  
  public abstract DLDeliverSubject getSubject();
  
  public abstract DLCenterlizedDeliverTask setSubject(final DLDeliverSubject subject);
  
  public abstract DLPlanDateTime getPlanDateTime();
  
  public abstract DLCenterlizedDeliverTask setPlanDateTime(final DLPlanDateTime planDateTime);
  
  public abstract DLPatientCheckDeliverTaskEvent createEvent(final DLPatientCheckDeliverTaskEventType eventType);
  
  public abstract DLCenterlizedDeliverTaskStatus getStatus();
  
  public abstract void start();
  
  public abstract void dispatch(final Collection<RCEmployee> performers);
  
  public abstract void finish(final String comment);
  
  public abstract void cancelDispatch(final String comment);
  
  public abstract void performUpdate(final Procedure1<? super DLCenterlizedDeliverTask> updater);
  
  public abstract void cancel(final String comment);
  
  public abstract Boolean isScheduled();
  
  public abstract Boolean isDispatched();
  
  public abstract Boolean isCanceled();
  
  public abstract Boolean isFinished();
  
  public abstract DLCenterlizedDeliverTaskProxy toProxy();
}
