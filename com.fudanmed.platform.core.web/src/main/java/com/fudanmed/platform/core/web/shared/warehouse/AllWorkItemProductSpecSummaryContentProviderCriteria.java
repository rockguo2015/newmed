package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ObjectNameFilter;

public class AllWorkItemProductSpecSummaryContentProviderCriteria extends ObjectNameFilter implements IsSerializable {
  private RCWorkItemTaskProxy workItem;
  
  public RCWorkItemTaskProxy getWorkItem() {
    return this.workItem;
  }
  
  public void setWorkItem(final RCWorkItemTaskProxy workItem) {
    this.workItem = workItem;
  }
  
  public final static String P_WorkItem = "workItem";
}
