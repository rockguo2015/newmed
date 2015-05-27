package com.lanmon.business.client.customer;

import com.lanmon.business.shared.customer.GWTRole;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class GWTRoleContentProvider extends AbstractContentProvider<GWTRole> {
  private static ArrayList<GWTRole> contents = com.google.common.collect.Lists.newArrayList(
    						GWTRole.admin,GWTRole.phoneSales,GWTRole.onsiteSales,GWTRole.manager,GWTRole.test
    					);;
  
  public Collection<GWTRole> getContents() {
    return contents;
  }
}
