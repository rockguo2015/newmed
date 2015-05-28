package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.HistoryReportContent;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class HistoryReportContentListGrid extends GXTGridComponent<HistoryReportContent> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<HistoryReportContent> comment;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private HistoryReportContent value = new HistoryReportContent();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();comment = stringValueProviderFactory.createAsStringColumn("comment","comment",HistoryReportContent.CommentAccessor);
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
  
  public HistoryReportContent getValueAsNew() {
    HistoryReportContent value = new HistoryReportContent();
    value.setComment(comment.getValue());
    return value;
  }
  
  public HistoryReportContent doGetValue() {
    
    value.setComment(comment.getValue());
    return value;
  }
  
  public HistoryReportContent getValue(final HistoryReportContent copyValue) {
    
    copyValue.setComment(comment.getValue());
    return copyValue;
  }
  
  protected HistoryReportContentListGrid doSetValue(final HistoryReportContent value) {
    this.value = value;
    comment.setValue(value.getComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)comment
    					);
  }
}
