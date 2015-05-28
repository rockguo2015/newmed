package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.shared.deliver.UIGender;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class UIGenderContentProvider extends AbstractContentProvider<UIGender> {
  private static ArrayList<UIGender> contents = com.google.common.collect.Lists.newArrayList(
    						UIGender.female,UIGender.male
    					);;
  
  public Collection<UIGender> getContents() {
    return contents;
  }
}
