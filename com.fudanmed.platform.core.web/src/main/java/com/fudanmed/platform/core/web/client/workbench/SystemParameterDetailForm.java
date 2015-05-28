package com.fudanmed.platform.core.web.client.workbench;

import com.fudanmed.platform.core.web.shared.workbench.UISystemParameter;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import edu.fudan.langlab.gxt.client.component.propertyview.GXTPropertyView;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class SystemParameterDetailForm extends GXTPropertyView<UISystemParameter> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public IValueViewer<String> applicationTitle;
  
  public IValueViewer<String> orgName;
  
  public IValueViewer<Integer> refreshInterval;
  
  public IValueViewer<Integer> eboardRefreshInterval;
  
  public IValueViewer<Integer> customerEvalCommitInterval;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UISystemParameter value = new UISystemParameter();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();applicationTitle = defaultObjectSelectorFactory.createAsPropertyItem("applicationTitle","应用系统标题");
    widgetsRegistory.put("applicationTitle",applicationTitle);
    orgName = defaultObjectSelectorFactory.createAsPropertyItem("orgName","用户名称");
    widgetsRegistory.put("orgName",orgName);
    refreshInterval = defaultObjectSelectorFactory.createAsPropertyItem("refreshInterval","客户端刷新间隔(秒)");
    widgetsRegistory.put("refreshInterval",refreshInterval);
    eboardRefreshInterval = defaultObjectSelectorFactory.createAsPropertyItem("eboardRefreshInterval","电子屏刷新间隔(秒)");
    widgetsRegistory.put("eboardRefreshInterval",eboardRefreshInterval);
    customerEvalCommitInterval = defaultObjectSelectorFactory.createAsPropertyItem("customerEvalCommitInterval","科室反馈超时(天)");
    widgetsRegistory.put("customerEvalCommitInterval",customerEvalCommitInterval);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UISystemParameter getValueAsNew() {
    UISystemParameter value = new UISystemParameter();
    return value;
  }
  
  public UISystemParameter doGetValue() {
    
    return value;
  }
  
  public UISystemParameter getValue(final UISystemParameter copyValue) {
    
    return copyValue;
  }
  
  protected SystemParameterDetailForm doSetValue(final UISystemParameter value) {
    this.value = value;
    applicationTitle.setValue(value.getApplicationTitle());
    orgName.setValue(value.getOrgName());
    refreshInterval.setValue(value.getRefreshInterval());
    eboardRefreshInterval.setValue(value.getEboardRefreshInterval());
    customerEvalCommitInterval.setValue(value.getCustomerEvalCommitInterval());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)applicationTitle,(ICanAsWidget)orgName,(ICanAsWidget)refreshInterval,(ICanAsWidget)eboardRefreshInterval,(ICanAsWidget)customerEvalCommitInterval
    					);
  }
}
