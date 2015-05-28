package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UICustomizableType;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class CustomizableTypeListGrid extends GXTGridComponent<UICustomizableType> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UICustomizableType> alias;
  
  public StringColumn<UICustomizableType> typeName;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UICustomizableType value = new UICustomizableType();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();alias = stringValueProviderFactory.createAsStringColumn("alias","别名",UICustomizableType.AliasAccessor);
    widgetsRegistory.put("alias",alias);
    typeName = stringValueProviderFactory.createAsStringColumn("typeName","单位/类型",UICustomizableType.TypeNameAccessor);
    widgetsRegistory.put("typeName",typeName);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UICustomizableType getValueAsNew() {
    UICustomizableType value = new UICustomizableType();
    value.setAlias(alias.getValue());
    value.setTypeName(typeName.getValue());
    return value;
  }
  
  public UICustomizableType doGetValue() {
    
    value.setAlias(alias.getValue());
    value.setTypeName(typeName.getValue());
    return value;
  }
  
  public UICustomizableType getValue(final UICustomizableType copyValue) {
    
    copyValue.setAlias(alias.getValue());
    copyValue.setTypeName(typeName.getValue());
    return copyValue;
  }
  
  protected CustomizableTypeListGrid doSetValue(final UICustomizableType value) {
    this.value = value;
    alias.setValue(value.getAlias());
    typeName.setValue(value.getTypeName());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)alias,(ICanAsWidget)typeName
    					);
  }
}
