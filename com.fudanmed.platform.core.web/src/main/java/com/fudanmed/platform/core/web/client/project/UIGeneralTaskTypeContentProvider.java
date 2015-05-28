package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIGeneralTaskType;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class UIGeneralTaskTypeContentProvider extends AbstractContentProvider<UIGeneralTaskType> {
  private static ArrayList<UIGeneralTaskType> contents = com.google.common.collect.Lists.newArrayList(
    						UIGeneralTaskType.workitemTask,UIGeneralTaskType.groupTask
    					);;
  
  public Collection<UIGeneralTaskType> getContents() {
    return contents;
  }
}
