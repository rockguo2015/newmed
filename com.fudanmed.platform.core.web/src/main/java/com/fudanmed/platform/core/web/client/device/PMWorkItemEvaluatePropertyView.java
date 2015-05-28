package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemEvaluate;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import edu.fudan.langlab.gxt.client.component.propertyview.GXTPropertyView;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DateValueProviderFactory.DatePropertyItem;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DoubleValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DoubleValueProviderFactory.DoublePropertyItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class PMWorkItemEvaluatePropertyView extends GXTPropertyView<UIPMWorkItemEvaluate> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public IValueViewer<String> worker;
  
  public DatePropertyItem notifyDate;
  
  public DatePropertyItem arriveDate;
  
  public DoublePropertyItem price;
  
  public IValueViewer<String> materials;
  
  public IValueViewer<Integer> arrivalOnTime;
  
  public IValueViewer<Integer> attitude;
  
  public IValueViewer<Integer> frequency;
  
  public IValueViewer<Integer> quality;
  
  public IValueViewer<String> problemsRemains;
  
  public IValueViewer<String> comment;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  private UIPMWorkItemEvaluate value = new UIPMWorkItemEvaluate();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();worker = defaultObjectSelectorFactory.createAsPropertyItem("worker","维保人员");
    widgetsRegistory.put("worker",worker);
    notifyDate = dateValueProviderFactory.createAsDateItem("notifyDate","通知日期");
    widgetsRegistory.put("notifyDate",notifyDate);
    arriveDate = dateValueProviderFactory.createAsDateItem("arriveDate","维保日期");
    widgetsRegistory.put("arriveDate",arriveDate);
    price = doubleValueProviderFactory.createAsDoubleItem("price","维保价格");
    widgetsRegistory.put("price",price);
    materials = defaultObjectSelectorFactory.createAsPropertyItem("materials","更换材料");
    widgetsRegistory.put("materials",materials);
    arrivalOnTime = defaultObjectSelectorFactory.createAsPropertyItem("arrivalOnTime","到达及时性");
    widgetsRegistory.put("arrivalOnTime",arrivalOnTime);
    attitude = defaultObjectSelectorFactory.createAsPropertyItem("attitude","服务态度");
    widgetsRegistory.put("attitude",attitude);
    frequency = defaultObjectSelectorFactory.createAsPropertyItem("frequency","同一问题频度");
    widgetsRegistory.put("frequency",frequency);
    quality = defaultObjectSelectorFactory.createAsPropertyItem("quality","维保质量");
    widgetsRegistory.put("quality",quality);
    problemsRemains = defaultObjectSelectorFactory.createAsPropertyItem("problemsRemains","需要解决问题",Integer.valueOf(3));
    widgetsRegistory.put("problemsRemains",problemsRemains);
    comment = defaultObjectSelectorFactory.createAsPropertyItem("comment","意见与建议",Integer.valueOf(3));
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
  
  public UIPMWorkItemEvaluate getValueAsNew() {
    UIPMWorkItemEvaluate value = new UIPMWorkItemEvaluate();
    return value;
  }
  
  public UIPMWorkItemEvaluate doGetValue() {
    
    return value;
  }
  
  public UIPMWorkItemEvaluate getValue(final UIPMWorkItemEvaluate copyValue) {
    
    return copyValue;
  }
  
  protected PMWorkItemEvaluatePropertyView doSetValue(final UIPMWorkItemEvaluate value) {
    this.value = value;
    worker.setValue(value.getWorker());
    notifyDate.setValue(value.getNotifyDate());
    arriveDate.setValue(value.getArriveDate());
    price.setValue(value.getPrice());
    materials.setValue(value.getMaterials());
    arrivalOnTime.setValue(value.getArrivalOnTime());
    attitude.setValue(value.getAttitude());
    frequency.setValue(value.getFrequency());
    quality.setValue(value.getQuality());
    problemsRemains.setValue(value.getProblemsRemains());
    comment.setValue(value.getComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)worker,(ICanAsWidget)notifyDate,(ICanAsWidget)arriveDate,(ICanAsWidget)price,(ICanAsWidget)materials,(ICanAsWidget)arrivalOnTime,(ICanAsWidget)attitude,(ICanAsWidget)frequency,(ICanAsWidget)quality,(ICanAsWidget)problemsRemains,(ICanAsWidget)comment
    					);
  }
  
  public Integer getCols() {
    return Integer.valueOf(3);
  }
}
