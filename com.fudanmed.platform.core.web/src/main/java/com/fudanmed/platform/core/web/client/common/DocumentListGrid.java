package com.fudanmed.platform.core.web.client.common;

import com.fudanmed.platform.core.web.shared.common.UIDocument;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class DocumentListGrid extends GXTGridComponent<UIDocument> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIDocument> description;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIDocument value = new UIDocument();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();description = stringValueProviderFactory.createAsStringColumn("description","文件描述",UIDocument.DescriptionAccessor);
    widgetsRegistory.put("description",description);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIDocument getValueAsNew() {
    UIDocument value = new UIDocument();
    value.setDescription(description.getValue());
    return value;
  }
  
  public UIDocument doGetValue() {
    
    value.setDescription(description.getValue());
    return value;
  }
  
  public UIDocument getValue(final UIDocument copyValue) {
    
    copyValue.setDescription(description.getValue());
    return copyValue;
  }
  
  protected DocumentListGrid doSetValue(final UIDocument value) {
    this.value = value;
    description.setValue(value.getDescription());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)description
    					);
  }
}
