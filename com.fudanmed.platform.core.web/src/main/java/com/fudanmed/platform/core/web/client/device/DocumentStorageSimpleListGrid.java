package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UIDocumentStorage;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class DocumentStorageSimpleListGrid extends GXTGridComponent<UIDocumentStorage> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIDocumentStorage> name;
  
  public DateColumn<UIDocumentStorage> uploadTime;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  private UIDocumentStorage value = new UIDocumentStorage();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsStringColumn("name","文档说明",UIDocumentStorage.NameAccessor);
    widgetsRegistory.put("name",name);
    uploadTime = dateValueProviderFactory.createAsStringColumn("uploadTime","更新时间",UIDocumentStorage.UploadTimeAccessor);
    widgetsRegistory.put("uploadTime",uploadTime);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIDocumentStorage getValueAsNew() {
    UIDocumentStorage value = new UIDocumentStorage();
    value.setName(name.getValue());
    value.setUploadTime(uploadTime.getValue());
    return value;
  }
  
  public UIDocumentStorage doGetValue() {
    
    value.setName(name.getValue());
    value.setUploadTime(uploadTime.getValue());
    return value;
  }
  
  public UIDocumentStorage getValue(final UIDocumentStorage copyValue) {
    
    copyValue.setName(name.getValue());
    copyValue.setUploadTime(uploadTime.getValue());
    return copyValue;
  }
  
  protected DocumentStorageSimpleListGrid doSetValue(final UIDocumentStorage value) {
    this.value = value;
    name.setValue(value.getName());
    uploadTime.setValue(value.getUploadTime());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)name,(ICanAsWidget)uploadTime
    					);
  }
}
