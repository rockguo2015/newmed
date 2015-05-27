package com.lanmon.business.client.code;

import com.lanmon.business.shared.code.GWTCodeType;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class GWTCodeTypeContentProvider extends AbstractContentProvider<GWTCodeType> {
  private static ArrayList<GWTCodeType> contents = com.google.common.collect.Lists.newArrayList(
    						GWTCodeType.Domain,GWTCodeType.Scale,GWTCodeType.Property,GWTCodeType.Region,GWTCodeType.Contact
    					);;
  
  public Collection<GWTCodeType> getContents() {
    return contents;
  }
}
