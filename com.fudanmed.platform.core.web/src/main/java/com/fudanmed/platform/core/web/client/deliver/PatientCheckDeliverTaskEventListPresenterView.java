package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.PatientCheckDeliverTaskEventListView;
import com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliverTaskEvent;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import java.util.Collection;

@ImplementedBy(value = PatientCheckDeliverTaskEventListView.class)
public interface PatientCheckDeliverTaskEventListPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIPatientCheckDeliverTaskEvent> results);
  
  public abstract ActionContext<UIPatientCheckDeliverTaskEvent> getActionContext();
  
  public abstract void clear();
}
