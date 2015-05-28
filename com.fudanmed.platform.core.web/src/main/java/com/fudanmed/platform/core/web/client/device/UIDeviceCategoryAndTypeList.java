package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UIDeviceCategoryAndType;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.component.treegrid.GXTTreeGridComponent;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class UIDeviceCategoryAndTypeList extends GXTTreeGridComponent<UIDeviceCategoryAndType> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIDeviceCategoryAndType> name;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIDeviceCategoryAndType value = new UIDeviceCategoryAndType();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsStringColumn("name","名称",UIDeviceCategoryAndType.NameAccessor);
    widgetsRegistory.put("name",name);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIDeviceCategoryAndType getValueAsNew() {
    UIDeviceCategoryAndType value = new UIDeviceCategoryAndType();
    value.setName(name.getValue());
    return value;
  }
  
  public UIDeviceCategoryAndType doGetValue() {
    
    value.setName(name.getValue());
    return value;
  }
  
  public UIDeviceCategoryAndType getValue(final UIDeviceCategoryAndType copyValue) {
    
    copyValue.setName(name.getValue());
    return copyValue;
  }
  
  protected UIDeviceCategoryAndTypeList doSetValue(final UIDeviceCategoryAndType value) {
    this.value = value;
    name.setValue(value.getName());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)name
    					);
  }
}
