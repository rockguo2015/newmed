package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy;
import com.fudanmed.platform.core.web.shared.organization.UIFaultLevelColorAdaptor;
import com.fudanmed.platform.core.web.shared.organization.UIStandardColor;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class FaultLevelColorAdaptorListGrid extends GXTGridComponent<UIFaultLevelColorAdaptor> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UIFaultLevelColorAdaptor,RCFaultLevelProxy> faultLevel;
  
  public StringValueColumn<UIFaultLevelColorAdaptor,UIStandardColor> color;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UIFaultLevelColorAdaptor value = new UIFaultLevelColorAdaptor();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();faultLevel = defaultObjectSelectorFactory.createAsDefaultColumn("faultLevel","风险等级",UIFaultLevelColorAdaptor.FaultLevelAccessor);
    widgetsRegistory.put("faultLevel",faultLevel);
    color = defaultObjectSelectorFactory.createAsDefaultColumn("color","提示颜色",UIFaultLevelColorAdaptor.ColorAccessor);
    widgetsRegistory.put("color",color);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIFaultLevelColorAdaptor getValueAsNew() {
    UIFaultLevelColorAdaptor value = new UIFaultLevelColorAdaptor();
    value.setFaultLevel(faultLevel.getValue());
    value.setColor(color.getValue());
    return value;
  }
  
  public UIFaultLevelColorAdaptor doGetValue() {
    
    value.setFaultLevel(faultLevel.getValue());
    value.setColor(color.getValue());
    return value;
  }
  
  public UIFaultLevelColorAdaptor getValue(final UIFaultLevelColorAdaptor copyValue) {
    
    copyValue.setFaultLevel(faultLevel.getValue());
    copyValue.setColor(color.getValue());
    return copyValue;
  }
  
  protected FaultLevelColorAdaptorListGrid doSetValue(final UIFaultLevelColorAdaptor value) {
    this.value = value;
    faultLevel.setValue(value.getFaultLevel());
    color.setValue(value.getColor());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)faultLevel,(ICanAsWidget)color
    					);
  }
}
