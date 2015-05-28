package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIRepairQuality;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class UIRepairQualityContentProvider extends AbstractContentProvider<UIRepairQuality> {
  private static ArrayList<UIRepairQuality> contents = com.google.common.collect.Lists.newArrayList(
    						UIRepairQuality.bad,UIRepairQuality.good,UIRepairQuality.normal
    					);;
  
  public Collection<UIRepairQuality> getContents() {
    return contents;
  }
}
