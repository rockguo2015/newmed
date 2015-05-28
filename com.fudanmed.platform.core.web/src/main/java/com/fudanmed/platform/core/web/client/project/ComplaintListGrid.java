package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.shared.project.UIComplaint;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class ComplaintListGrid extends GXTGridComponent<UIComplaint> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DateColumn<UIComplaint> date;
  
  public StringValueColumn<UIComplaint,RCEmployeeProxy> owner;
  
  public StringColumn<UIComplaint> contents;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  private UIComplaint value = new UIComplaint();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();date = dateValueProviderFactory.createAsStringColumn("date","投诉日期",UIComplaint.DateAccessor,Integer.valueOf(130));
    widgetsRegistory.put("date",date);
    owner = defaultObjectSelectorFactory.createAsStringColumn("owner","投诉人",UIComplaint.OwnerAccessor,Integer.valueOf(130));
    widgetsRegistory.put("owner",owner);
    contents = stringValueProviderFactory.createAsStringColumn("contents","投诉内容",UIComplaint.ContentsAccessor,Integer.valueOf(897));
    widgetsRegistory.put("contents",contents);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIComplaint getValueAsNew() {
    UIComplaint value = new UIComplaint();
    value.setDate(date.getValue());
    value.setOwner(owner.getValue());
    value.setContents(contents.getValue());
    return value;
  }
  
  public UIComplaint doGetValue() {
    
    value.setDate(date.getValue());
    value.setOwner(owner.getValue());
    value.setContents(contents.getValue());
    return value;
  }
  
  public UIComplaint getValue(final UIComplaint copyValue) {
    
    copyValue.setDate(date.getValue());
    copyValue.setOwner(owner.getValue());
    copyValue.setContents(contents.getValue());
    return copyValue;
  }
  
  protected ComplaintListGrid doSetValue(final UIComplaint value) {
    this.value = value;
    date.setValue(value.getDate());
    owner.setValue(value.getOwner());
    contents.setValue(value.getContents());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)date,(ICanAsWidget)owner,(ICanAsWidget)contents
    					);
  }
  
  public void initializeComponent() {
    this.asWidget();
    this.unForceFit();
  }
}
