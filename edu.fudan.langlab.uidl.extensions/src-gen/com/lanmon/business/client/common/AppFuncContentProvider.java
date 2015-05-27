package com.lanmon.business.client.common;

import com.lanmon.business.shared.common.AppFunc;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class AppFuncContentProvider extends AbstractContentProvider<AppFunc> {
  private static ArrayList<AppFunc> contents = com.google.common.collect.Lists.newArrayList(
    						AppFunc.SaleConsole,AppFunc.AdvisorConsole,AppFunc.AdminFunctionGroup,AppFunc.CreateCustomer,AppFunc.ModifyCustomer,AppFunc.DiscardCustomer
    					);;
  
  public Collection<AppFunc> getContents() {
    return contents;
  }
}
