package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIFrequencyProblem;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class UIFrequencyProblemContentProvider extends AbstractContentProvider<UIFrequencyProblem> {
  private static ArrayList<UIFrequencyProblem> contents = com.google.common.collect.Lists.newArrayList(
    						UIFrequencyProblem.bad,UIFrequencyProblem.good,UIFrequencyProblem.normal
    					);;
  
  public Collection<UIFrequencyProblem> getContents() {
    return contents;
  }
}
