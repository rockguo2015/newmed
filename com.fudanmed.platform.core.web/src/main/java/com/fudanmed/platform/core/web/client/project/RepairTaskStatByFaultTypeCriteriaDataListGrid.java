package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByFaultTypeCriteriaData;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class RepairTaskStatByFaultTypeCriteriaDataListGrid extends GXTGridComponent<UIRepairTaskStatByFaultTypeCriteriaData> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UIRepairTaskStatByFaultTypeCriteriaData,RCFaultTypeProxy> faultType;
  
  public StringValueColumn<UIRepairTaskStatByFaultTypeCriteriaData,Long> cnt;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UIRepairTaskStatByFaultTypeCriteriaData value = new UIRepairTaskStatByFaultTypeCriteriaData();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();faultType = defaultObjectSelectorFactory.createAsDefaultColumn("faultType","故障类型",UIRepairTaskStatByFaultTypeCriteriaData.FaultTypeAccessor);
    widgetsRegistory.put("faultType",faultType);
    cnt = defaultObjectSelectorFactory.createAsDefaultColumn("cnt","数量",UIRepairTaskStatByFaultTypeCriteriaData.CntAccessor);
    widgetsRegistory.put("cnt",cnt);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIRepairTaskStatByFaultTypeCriteriaData getValueAsNew() {
    UIRepairTaskStatByFaultTypeCriteriaData value = new UIRepairTaskStatByFaultTypeCriteriaData();
    value.setFaultType(faultType.getValue());
    value.setCnt(cnt.getValue());
    return value;
  }
  
  public UIRepairTaskStatByFaultTypeCriteriaData doGetValue() {
    
    value.setFaultType(faultType.getValue());
    value.setCnt(cnt.getValue());
    return value;
  }
  
  public UIRepairTaskStatByFaultTypeCriteriaData getValue(final UIRepairTaskStatByFaultTypeCriteriaData copyValue) {
    
    copyValue.setFaultType(faultType.getValue());
    copyValue.setCnt(cnt.getValue());
    return copyValue;
  }
  
  protected RepairTaskStatByFaultTypeCriteriaDataListGrid doSetValue(final UIRepairTaskStatByFaultTypeCriteriaData value) {
    this.value = value;
    faultType.setValue(value.getFaultType());
    cnt.setValue(value.getCnt());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)faultType,(ICanAsWidget)cnt
    					);
  }
}
