package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask4WorkersStatCriteriaData;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class WorkItemTask4WorkersStatCriteriaDataListGrid extends GXTGridComponent<UIWorkItemTask4WorkersStatCriteriaData> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UIWorkItemTask4WorkersStatCriteriaData,RCEmployeeProxy> worker;
  
  public StringValueColumn<UIWorkItemTask4WorkersStatCriteriaData,Long> cnt;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UIWorkItemTask4WorkersStatCriteriaData value = new UIWorkItemTask4WorkersStatCriteriaData();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();worker = defaultObjectSelectorFactory.createAsDefaultColumn("worker","工程师",UIWorkItemTask4WorkersStatCriteriaData.WorkerAccessor);
    widgetsRegistory.put("worker",worker);
    cnt = defaultObjectSelectorFactory.createAsDefaultColumn("cnt","数量",UIWorkItemTask4WorkersStatCriteriaData.CntAccessor);
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
  
  public UIWorkItemTask4WorkersStatCriteriaData getValueAsNew() {
    UIWorkItemTask4WorkersStatCriteriaData value = new UIWorkItemTask4WorkersStatCriteriaData();
    value.setWorker(worker.getValue());
    value.setCnt(cnt.getValue());
    return value;
  }
  
  public UIWorkItemTask4WorkersStatCriteriaData doGetValue() {
    
    value.setWorker(worker.getValue());
    value.setCnt(cnt.getValue());
    return value;
  }
  
  public UIWorkItemTask4WorkersStatCriteriaData getValue(final UIWorkItemTask4WorkersStatCriteriaData copyValue) {
    
    copyValue.setWorker(worker.getValue());
    copyValue.setCnt(cnt.getValue());
    return copyValue;
  }
  
  protected WorkItemTask4WorkersStatCriteriaDataListGrid doSetValue(final UIWorkItemTask4WorkersStatCriteriaData value) {
    this.value = value;
    worker.setValue(value.getWorker());
    cnt.setValue(value.getCnt());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)worker,(ICanAsWidget)cnt
    					);
  }
}
