package com.lanmon.business.client.code;

import com.google.inject.Inject;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.code.GWTCode;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.ListViewComponent;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.StringValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.StringValueProviderFactory.StringListViewItem;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;

public class CodeListGrid extends ListViewComponent<GWTCode> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public StringListViewItem name;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private GWTCode value = new GWTCode();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsListGridField("name","名称");
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public GWTCode getValueAsNew() {
    GWTCode value = new GWTCode();
    value.setName(name.getValue());
    return value;
  }
  
  public GWTCode doGetValue() {
    
    value.setName(name.getValue());
    return value;
  }
  
  public GWTCode getValue(final GWTCode copyValue) {
    
    copyValue.setName(name.getValue());
    return copyValue;
  }
  
  protected CodeListGrid doSetValue(final GWTCode value) {
    this.value = value;
    name.setValue(value.getName());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)name
    					);
  }
}
