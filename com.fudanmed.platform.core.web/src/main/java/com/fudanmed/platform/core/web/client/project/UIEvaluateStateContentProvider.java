package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIEvaluateState;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class UIEvaluateStateContentProvider extends AbstractContentProvider<UIEvaluateState> {
  private static ArrayList<UIEvaluateState> contents = com.google.common.collect.Lists.newArrayList(
    						UIEvaluateState.autoCommitted,UIEvaluateState.finished,UIEvaluateState.notReady,UIEvaluateState.waiting
    					);;
  
  public Collection<UIEvaluateState> getContents() {
    return contents;
  }
}
