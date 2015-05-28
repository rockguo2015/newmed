package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanStatus;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class UIDevicePMPlanStatusContentProvider extends AbstractContentProvider<UIDevicePMPlanStatus> {
  private static ArrayList<UIDevicePMPlanStatus> contents = com.google.common.collect.Lists.newArrayList(
    						UIDevicePMPlanStatus.assigned,UIDevicePMPlanStatus.finished,UIDevicePMPlanStatus.planed,UIDevicePMPlanStatus.workerAssigned
    					);;
  
  public Collection<UIDevicePMPlanStatus> getContents() {
    return contents;
  }
}
