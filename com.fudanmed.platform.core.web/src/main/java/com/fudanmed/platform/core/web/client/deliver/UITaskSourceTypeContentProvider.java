package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.shared.deliver.UITaskSourceType;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class UITaskSourceTypeContentProvider extends AbstractContentProvider<UITaskSourceType> {
  private static ArrayList<UITaskSourceType> contents = com.google.common.collect.Lists.newArrayList(
    						UITaskSourceType.curtomerRequest,UITaskSourceType.imported
    					);;
  
  public Collection<UITaskSourceType> getContents() {
    return contents;
  }
}
