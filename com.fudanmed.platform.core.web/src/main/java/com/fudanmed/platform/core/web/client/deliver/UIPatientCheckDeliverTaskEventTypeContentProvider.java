package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliverTaskEventType;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class UIPatientCheckDeliverTaskEventTypeContentProvider extends AbstractContentProvider<UIPatientCheckDeliverTaskEventType> {
  private static ArrayList<UIPatientCheckDeliverTaskEventType> contents = com.google.common.collect.Lists.newArrayList(
    						UIPatientCheckDeliverTaskEventType.cancel,UIPatientCheckDeliverTaskEventType.cancelDispatch,UIPatientCheckDeliverTaskEventType.create,UIPatientCheckDeliverTaskEventType.dispatch,UIPatientCheckDeliverTaskEventType.finish,UIPatientCheckDeliverTaskEventType.performUpdate
    					);;
  
  public Collection<UIPatientCheckDeliverTaskEventType> getContents() {
    return contents;
  }
}
