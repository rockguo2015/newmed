package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UIPrimaryTypeEnum;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class UIPrimaryTypeEnumContentProvider extends AbstractContentProvider<UIPrimaryTypeEnum> {
  private static ArrayList<UIPrimaryTypeEnum> contents = com.google.common.collect.Lists.newArrayList(
    						UIPrimaryTypeEnum.number,UIPrimaryTypeEnum.numberWithUnit,UIPrimaryTypeEnum.range,UIPrimaryTypeEnum.string,UIPrimaryTypeEnum.date
    					);;
  
  public Collection<UIPrimaryTypeEnum> getContents() {
    return contents;
  }
}
