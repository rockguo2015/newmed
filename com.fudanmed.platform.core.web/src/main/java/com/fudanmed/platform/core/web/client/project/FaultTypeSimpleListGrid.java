package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class FaultTypeSimpleListGrid extends GXTGridComponent<UIFaultType> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIFaultType> name;
  
  public StringValueColumn<UIFaultType,RCFaultLevelProxy> faultRiskLevel;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIFaultType value = new UIFaultType();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsStringColumn("name","名称",UIFaultType.NameAccessor);
    widgetsRegistory.put("name",name);
    faultRiskLevel = defaultObjectSelectorFactory.createAsDefaultColumn("faultRiskLevel","风险等级",UIFaultType.FaultRiskLevelAccessor);
    widgetsRegistory.put("faultRiskLevel",faultRiskLevel);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIFaultType getValueAsNew() {
    UIFaultType value = new UIFaultType();
    value.setName(name.getValue());
    value.setFaultRiskLevel(faultRiskLevel.getValue());
    return value;
  }
  
  public UIFaultType doGetValue() {
    
    value.setName(name.getValue());
    value.setFaultRiskLevel(faultRiskLevel.getValue());
    return value;
  }
  
  public UIFaultType getValue(final UIFaultType copyValue) {
    
    copyValue.setName(name.getValue());
    copyValue.setFaultRiskLevel(faultRiskLevel.getValue());
    return copyValue;
  }
  
  protected FaultTypeSimpleListGrid doSetValue(final UIFaultType value) {
    this.value = value;
    name.setValue(value.getName());
    faultRiskLevel.setValue(value.getFaultRiskLevel());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)name,(ICanAsWidget)faultRiskLevel
    					);
  }
}
