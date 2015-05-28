package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemStatue;
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

public class PMWorkItemProperty extends GXTPropertyView<UIPMWorkItem> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public IValueViewer<String> sid;
  
  public IValueViewer<String> title;
  
  public IValueViewer<String> description;
  
  public DatePropertyItem assignDate;
  
  public IValueViewer<RCSupplierProxy> supplier;
  
  public DatePropertyItem dispatchDate;
  
  public IValueViewer<RCMaintenanceTeamProxy> team;
  
  public IValueViewer<UIPMWorkItemStatue> status;
  
  public DatePropertyItem finishDate;
  
  public IValueViewer<String> teamComment;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UIPMWorkItem value = new UIPMWorkItem();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = defaultObjectSelectorFactory.createAsPropertyItem("sid","任务单号");
    widgetsRegistory.put("sid",sid);
    title = defaultObjectSelectorFactory.createAsPropertyItem("title","名称");
    widgetsRegistory.put("title",title);
    description = defaultObjectSelectorFactory.createAsPropertyItem("description","说明",Integer.valueOf(2));
    widgetsRegistory.put("description",description);
    assignDate = dateValueProviderFactory.createAsDateItem("assignDate","安排执行日期");
    widgetsRegistory.put("assignDate",assignDate);
    supplier = defaultObjectSelectorFactory.createAsPropertyItem("supplier","服务提供商");
    widgetsRegistory.put("supplier",supplier);
    dispatchDate = dateValueProviderFactory.createAsDateItem("dispatchDate","派发日期");
    widgetsRegistory.put("dispatchDate",dispatchDate);
    team = defaultObjectSelectorFactory.createAsPropertyItem("team","配合班组");
    widgetsRegistory.put("team",team);
    status = defaultObjectSelectorFactory.createAsPropertyItem("status","状态");
    widgetsRegistory.put("status",status);
    finishDate = dateValueProviderFactory.createAsDateItem("finishDate","完工日期");
    widgetsRegistory.put("finishDate",finishDate);
    teamComment = defaultObjectSelectorFactory.createAsPropertyItem("teamComment","班组上报信息",Integer.valueOf(2));
    widgetsRegistory.put("teamComment",teamComment);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIPMWorkItem getValueAsNew() {
    UIPMWorkItem value = new UIPMWorkItem();
    return value;
  }
  
  public UIPMWorkItem doGetValue() {
    
    return value;
  }
  
  public UIPMWorkItem getValue(final UIPMWorkItem copyValue) {
    
    return copyValue;
  }
  
  protected PMWorkItemProperty doSetValue(final UIPMWorkItem value) {
    this.value = value;
    sid.setValue(value.getSid());
    title.setValue(value.getTitle());
    description.setValue(value.getDescription());
    assignDate.setValue(value.getAssignDate());
    supplier.setValue(value.getSupplier());
    dispatchDate.setValue(value.getDispatchDate());
    team.setValue(value.getTeam());
    status.setValue(value.getStatus());
    finishDate.setValue(value.getFinishDate());
    teamComment.setValue(value.getTeamComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)title,(ICanAsWidget)description,(ICanAsWidget)assignDate,(ICanAsWidget)supplier,(ICanAsWidget)dispatchDate,(ICanAsWidget)team,(ICanAsWidget)status,(ICanAsWidget)finishDate,(ICanAsWidget)teamComment
    					);
  }
  
  public Integer getCols() {
    return Integer.valueOf(2);
  }
}
