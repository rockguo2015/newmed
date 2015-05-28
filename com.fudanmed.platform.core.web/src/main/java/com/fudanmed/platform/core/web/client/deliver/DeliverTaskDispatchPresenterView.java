package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.DeliverTaskDispatchView;
import com.fudanmed.platform.core.web.shared.deliver.DeliverTaskDispatchData;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = DeliverTaskDispatchView.class)
public interface DeliverTaskDispatchPresenterView extends ViewerWithValidation {
  public abstract DeliverTaskDispatchData getValue();
  
  public abstract void setTasks(final Iterable<UICenterlizedDeliverTask> tasks);
  
  public abstract Iterable<UICenterlizedDeliverTask> getTasks();
}
