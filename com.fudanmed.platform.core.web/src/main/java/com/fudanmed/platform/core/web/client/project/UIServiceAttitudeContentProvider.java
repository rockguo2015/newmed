package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIServiceAttitude;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class UIServiceAttitudeContentProvider extends AbstractContentProvider<UIServiceAttitude> {
  private static ArrayList<UIServiceAttitude> contents = com.google.common.collect.Lists.newArrayList(
    						UIServiceAttitude.bad,UIServiceAttitude.good,UIServiceAttitude.normal
    					);;
  
  public Collection<UIServiceAttitude> getContents() {
    return contents;
  }
}
