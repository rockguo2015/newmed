package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.shared.organization.UIEmployeeStatus;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class UIEmployeeStatusContentProvider extends AbstractContentProvider<UIEmployeeStatus> {
  private static ArrayList<UIEmployeeStatus> contents = com.google.common.collect.Lists.newArrayList(
    						UIEmployeeStatus.leaveJob,UIEmployeeStatus.onJob
    					);;
  
  public Collection<UIEmployeeStatus> getContents() {
    return contents;
  }
}
