package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateTimeColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class RepairTaskSimpleListGrid extends GXTGridComponent<UIRepairTask> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UIRepairTask,UIRepairTaskStatus> status;
  
  public DateTimeColumn<UIRepairTask> reportDateTime;
  
  public StringColumn<UIRepairTask> location;
  
  public StringColumn<UIRepairTask> comment;
  
  public StringColumn<UIRepairTask> reporterName;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  private UIRepairTask value = new UIRepairTask();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();status = defaultObjectSelectorFactory.createAsDefaultColumn("status","状态",UIRepairTask.StatusAccessor,Integer.valueOf(80));
    widgetsRegistory.put("status",status);
    reportDateTime = dateValueProviderFactory.createAsDateTimeColumn("reportDateTime","接报时间",UIRepairTask.ReportDateTimeAccessor,Integer.valueOf(120));
    widgetsRegistory.put("reportDateTime",reportDateTime);
    location = stringValueProviderFactory.createAsStringColumn("location","报修地点",UIRepairTask.LocationAccessor,Integer.valueOf(150));
    widgetsRegistory.put("location",location);
    comment = stringValueProviderFactory.createAsStringColumn("comment","报修内容",UIRepairTask.CommentAccessor,Integer.valueOf(150));
    widgetsRegistory.put("comment",comment);
    reporterName = stringValueProviderFactory.createAsStringColumn("reporterName","报修人",UIRepairTask.ReporterNameAccessor);
    widgetsRegistory.put("reporterName",reporterName);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIRepairTask getValueAsNew() {
    UIRepairTask value = new UIRepairTask();
    value.setStatus(status.getValue());
    value.setReportDateTime(reportDateTime.getValue());
    value.setLocation(location.getValue());
    value.setComment(comment.getValue());
    value.setReporterName(reporterName.getValue());
    return value;
  }
  
  public UIRepairTask doGetValue() {
    
    value.setStatus(status.getValue());
    value.setReportDateTime(reportDateTime.getValue());
    value.setLocation(location.getValue());
    value.setComment(comment.getValue());
    value.setReporterName(reporterName.getValue());
    return value;
  }
  
  public UIRepairTask getValue(final UIRepairTask copyValue) {
    
    copyValue.setStatus(status.getValue());
    copyValue.setReportDateTime(reportDateTime.getValue());
    copyValue.setLocation(location.getValue());
    copyValue.setComment(comment.getValue());
    copyValue.setReporterName(reporterName.getValue());
    return copyValue;
  }
  
  protected RepairTaskSimpleListGrid doSetValue(final UIRepairTask value) {
    this.value = value;
    status.setValue(value.getStatus());
    reportDateTime.setValue(value.getReportDateTime());
    location.setValue(value.getLocation());
    comment.setValue(value.getComment());
    reporterName.setValue(value.getReporterName());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)status,(ICanAsWidget)reportDateTime,(ICanAsWidget)location,(ICanAsWidget)comment,(ICanAsWidget)reporterName
    					);
  }
  
  public void initializeComponent() {
    this.asWidget();
    this.unForceFit();
  }
}
