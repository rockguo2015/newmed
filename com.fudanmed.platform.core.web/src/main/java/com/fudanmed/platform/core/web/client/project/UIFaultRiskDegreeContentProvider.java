package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIFaultRiskDegree;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class UIFaultRiskDegreeContentProvider extends AbstractContentProvider<UIFaultRiskDegree> {
  private static ArrayList<UIFaultRiskDegree> contents = com.google.common.collect.Lists.newArrayList(
    						UIFaultRiskDegree.jiaoda,UIFaultRiskDegree.yanzhong,UIFaultRiskDegree.yiban,UIFaultRiskDegree.zhongda
    					);;
  
  public Collection<UIFaultRiskDegree> getContents() {
    return contents;
  }
}
