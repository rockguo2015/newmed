package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignmentFinishData;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory.CheckBoxItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextAreaItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class WorkItemPlanAssignmentFinishDataForm extends GXTFormComponent<UIWorkItemPlanAssignmentFinishData> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public CheckBoxItem finished;
  
  public TextAreaItem comment;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIWorkItemPlanAssignmentFinishData value = new UIWorkItemPlanAssignmentFinishData();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();finished = booleanValueProviderFactory.createAsCheckBoxItem("finished","已完成");
    widgetsRegistory.put("finished",finished);
    comment = stringValueProviderFactory.createAsTextAreaItem("comment","维保记录");
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
  
  public UIWorkItemPlanAssignmentFinishData getValueAsNew() {
    UIWorkItemPlanAssignmentFinishData value = new UIWorkItemPlanAssignmentFinishData();
    value.setFinished(finished.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIWorkItemPlanAssignmentFinishData doGetValue() {
    
    value.setFinished(finished.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIWorkItemPlanAssignmentFinishData getValue(final UIWorkItemPlanAssignmentFinishData copyValue) {
    
    copyValue.setFinished(finished.getValue());
    copyValue.setComment(comment.getValue());
    return copyValue;
  }
  
  protected WorkItemPlanAssignmentFinishDataForm doSetValue(final UIWorkItemPlanAssignmentFinishData value) {
    this.value = value;
    finished.setValue(value.getFinished());
    comment.setValue(value.getComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)finished,(ICanAsWidget)comment
    					);
  }
}
