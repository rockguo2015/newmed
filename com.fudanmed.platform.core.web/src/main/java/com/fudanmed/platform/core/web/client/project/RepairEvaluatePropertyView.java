package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.shared.project.UIEvaluateState;
import com.fudanmed.platform.core.web.shared.project.UIRepairEvaluate;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import edu.fudan.langlab.gxt.client.component.propertyview.GXTPropertyView;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DateValueProviderFactory.DatePropertyItem;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class RepairEvaluatePropertyView extends GXTPropertyView<UIRepairEvaluate> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public IValueViewer<UIEvaluateState> evaluateState;
  
  public IValueViewer<RCEmployeeProxy> evaluator;
  
  public DatePropertyItem evaluateDate;
  
  public IValueViewer<Integer> arrivalTimeValue;
  
  public IValueViewer<Integer> serviceAttitudeValue;
  
  public IValueViewer<Integer> frequencyProblemValue;
  
  public IValueViewer<Integer> repairQualityValue;
  
  public IValueViewer<String> comment;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UIRepairEvaluate value = new UIRepairEvaluate();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();evaluateState = defaultObjectSelectorFactory.createAsPropertyItem("evaluateState","评价状态",Integer.valueOf(2));
    widgetsRegistory.put("evaluateState",evaluateState);
    evaluator = defaultObjectSelectorFactory.createAsPropertyItem("evaluator","评价人");
    widgetsRegistory.put("evaluator",evaluator);
    evaluateDate = dateValueProviderFactory.createAsDateItem("evaluateDate","评价日期");
    widgetsRegistory.put("evaluateDate",evaluateDate);
    arrivalTimeValue = defaultObjectSelectorFactory.createAsPropertyItem("arrivalTimeValue","到达及时性");
    widgetsRegistory.put("arrivalTimeValue",arrivalTimeValue);
    serviceAttitudeValue = defaultObjectSelectorFactory.createAsPropertyItem("serviceAttitudeValue","服务态度");
    widgetsRegistory.put("serviceAttitudeValue",serviceAttitudeValue);
    frequencyProblemValue = defaultObjectSelectorFactory.createAsPropertyItem("frequencyProblemValue","同一问题频率");
    widgetsRegistory.put("frequencyProblemValue",frequencyProblemValue);
    repairQualityValue = defaultObjectSelectorFactory.createAsPropertyItem("repairQualityValue","维修质量");
    widgetsRegistory.put("repairQualityValue",repairQualityValue);
    comment = defaultObjectSelectorFactory.createAsPropertyItem("comment","评语",Integer.valueOf(2));
    widgetsRegistory.put("comment",comment);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIRepairEvaluate getValueAsNew() {
    UIRepairEvaluate value = new UIRepairEvaluate();
    return value;
  }
  
  public UIRepairEvaluate doGetValue() {
    
    return value;
  }
  
  public UIRepairEvaluate getValue(final UIRepairEvaluate copyValue) {
    
    return copyValue;
  }
  
  protected RepairEvaluatePropertyView doSetValue(final UIRepairEvaluate value) {
    this.value = value;
    evaluateState.setValue(value.getEvaluateState());
    evaluator.setValue(value.getEvaluator());
    evaluateDate.setValue(value.getEvaluateDate());
    arrivalTimeValue.setValue(value.getArrivalTimeValue());
    serviceAttitudeValue.setValue(value.getServiceAttitudeValue());
    frequencyProblemValue.setValue(value.getFrequencyProblemValue());
    repairQualityValue.setValue(value.getRepairQualityValue());
    comment.setValue(value.getComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)evaluateState,(ICanAsWidget)evaluator,(ICanAsWidget)evaluateDate,(ICanAsWidget)arrivalTimeValue,(ICanAsWidget)serviceAttitudeValue,(ICanAsWidget)frequencyProblemValue,(ICanAsWidget)repairQualityValue,(ICanAsWidget)comment
    					);
  }
  
  public Integer getCols() {
    return Integer.valueOf(2);
  }
}
