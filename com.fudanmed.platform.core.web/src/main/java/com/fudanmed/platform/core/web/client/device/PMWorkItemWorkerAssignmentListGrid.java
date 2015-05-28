package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignmentStatus;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectsSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectsSelectorFactory.CollectionListColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class PMWorkItemWorkerAssignmentListGrid extends GXTGridComponent<UIPMWorkItemWorkerAssignment> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DateColumn<UIPMWorkItemWorkerAssignment> assignDate;
  
  public CollectionListColumn<UIPMWorkItemWorkerAssignment,RCEmployeeProxy> workers;
  
  public StringColumn<UIPMWorkItemWorkerAssignment> comment;
  
  public DateColumn<UIPMWorkItemWorkerAssignment> finishDate;
  
  public StringColumn<UIPMWorkItemWorkerAssignment> finalComment;
  
  public StringValueColumn<UIPMWorkItemWorkerAssignment,UIPMWorkItemWorkerAssignmentStatus> status;
  
  @Inject
  private DefaultObjectsSelectorFactory defaultObjectsSelectorFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIPMWorkItemWorkerAssignment value = new UIPMWorkItemWorkerAssignment();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();assignDate = dateValueProviderFactory.createAsStringColumn("assignDate","派工日期",UIPMWorkItemWorkerAssignment.AssignDateAccessor);
    widgetsRegistory.put("assignDate",assignDate);
    workers = defaultObjectsSelectorFactory.createAsStringColumn("workers","工程师",UIPMWorkItemWorkerAssignment.WorkersAccessor);
    widgetsRegistory.put("workers",workers);
    comment = stringValueProviderFactory.createAsStringColumn("comment","派工说明",UIPMWorkItemWorkerAssignment.CommentAccessor);
    widgetsRegistory.put("comment",comment);
    finishDate = dateValueProviderFactory.createAsStringColumn("finishDate","完工日期",UIPMWorkItemWorkerAssignment.FinishDateAccessor);
    widgetsRegistory.put("finishDate",finishDate);
    finalComment = stringValueProviderFactory.createAsStringColumn("finalComment","完工说明",UIPMWorkItemWorkerAssignment.FinalCommentAccessor);
    widgetsRegistory.put("finalComment",finalComment);
    status = defaultObjectSelectorFactory.createAsDefaultColumn("status","状态",UIPMWorkItemWorkerAssignment.StatusAccessor);
    widgetsRegistory.put("status",status);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIPMWorkItemWorkerAssignment getValueAsNew() {
    UIPMWorkItemWorkerAssignment value = new UIPMWorkItemWorkerAssignment();
    value.setAssignDate(assignDate.getValue());
    value.setWorkers(workers.getValue());
    value.setComment(comment.getValue());
    value.setFinishDate(finishDate.getValue());
    value.setFinalComment(finalComment.getValue());
    value.setStatus(status.getValue());
    return value;
  }
  
  public UIPMWorkItemWorkerAssignment doGetValue() {
    
    value.setAssignDate(assignDate.getValue());
    value.setWorkers(workers.getValue());
    value.setComment(comment.getValue());
    value.setFinishDate(finishDate.getValue());
    value.setFinalComment(finalComment.getValue());
    value.setStatus(status.getValue());
    return value;
  }
  
  public UIPMWorkItemWorkerAssignment getValue(final UIPMWorkItemWorkerAssignment copyValue) {
    
    copyValue.setAssignDate(assignDate.getValue());
    copyValue.setWorkers(workers.getValue());
    copyValue.setComment(comment.getValue());
    copyValue.setFinishDate(finishDate.getValue());
    copyValue.setFinalComment(finalComment.getValue());
    copyValue.setStatus(status.getValue());
    return copyValue;
  }
  
  protected PMWorkItemWorkerAssignmentListGrid doSetValue(final UIPMWorkItemWorkerAssignment value) {
    this.value = value;
    assignDate.setValue(value.getAssignDate());
    workers.setValue(value.getWorkers());
    comment.setValue(value.getComment());
    finishDate.setValue(value.getFinishDate());
    finalComment.setValue(value.getFinalComment());
    status.setValue(value.getStatus());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)assignDate,(ICanAsWidget)workers,(ICanAsWidget)comment,(ICanAsWidget)finishDate,(ICanAsWidget)finalComment,(ICanAsWidget)status
    					);
  }
}
