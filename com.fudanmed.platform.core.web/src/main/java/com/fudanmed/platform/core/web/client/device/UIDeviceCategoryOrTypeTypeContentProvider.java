package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UIDeviceCategoryOrTypeType;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class UIDeviceCategoryOrTypeTypeContentProvider extends AbstractContentProvider<UIDeviceCategoryOrTypeType> {
  private static ArrayList<UIDeviceCategoryOrTypeType> contents = com.google.common.collect.Lists.newArrayList(
    						UIDeviceCategoryOrTypeType.type,UIDeviceCategoryOrTypeType.category
    					);;
  
  public Collection<UIDeviceCategoryOrTypeType> getContents() {
    return contents;
  }
}
