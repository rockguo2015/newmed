package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.shared.organization.UIStandardColor;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class UIStandardColorContentProvider extends AbstractContentProvider<UIStandardColor> {
  private static ArrayList<UIStandardColor> contents = com.google.common.collect.Lists.newArrayList(
    						UIStandardColor.aqua,UIStandardColor.black,UIStandardColor.blue,UIStandardColor.fuchsia,UIStandardColor.gray,UIStandardColor.green,UIStandardColor.orange,UIStandardColor.purple,UIStandardColor.red,UIStandardColor.yellow
    					);;
  
  public Collection<UIStandardColor> getContents() {
    return contents;
  }
}
