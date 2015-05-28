package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class WorkItemStockRecordCriteriaForm extends GXTFormComponent<UIWorkItemStockRecordCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem info;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIWorkItemStockRecordCriteria value = new UIWorkItemStockRecordCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();info = stringValueProviderFactory.createAsEscapedTextItem("info","领/退料单号");
    widgetsRegistory.put("info",info);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIWorkItemStockRecordCriteria getValueAsNew() {
    UIWorkItemStockRecordCriteria value = new UIWorkItemStockRecordCriteria();
    value.setInfo(info.getValue());
    return value;
  }
  
  public UIWorkItemStockRecordCriteria doGetValue() {
    
    value.setInfo(info.getValue());
    return value;
  }
  
  public UIWorkItemStockRecordCriteria getValue(final UIWorkItemStockRecordCriteria copyValue) {
    
    copyValue.setInfo(info.getValue());
    return copyValue;
  }
  
  protected WorkItemStockRecordCriteriaForm doSetValue(final UIWorkItemStockRecordCriteria value) {
    this.value = value;
    info.setValue(value.getInfo());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)info
    					);
  }
}
