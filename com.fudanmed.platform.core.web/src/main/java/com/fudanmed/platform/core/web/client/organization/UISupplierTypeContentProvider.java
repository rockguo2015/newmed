package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.shared.organization.UISupplierType;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class UISupplierTypeContentProvider extends AbstractContentProvider<UISupplierType> {
  private static ArrayList<UISupplierType> contents = com.google.common.collect.Lists.newArrayList(
    						UISupplierType.maintenanceProvider,UISupplierType.materialSupplier
    					);;
  
  public Collection<UISupplierType> getContents() {
    return contents;
  }
}
