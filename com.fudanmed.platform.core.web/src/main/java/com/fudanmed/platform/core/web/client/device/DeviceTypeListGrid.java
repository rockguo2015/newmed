package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UIDeviceType;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.IntegerValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.IntegerValueProviderFactory.IntegerColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class DeviceTypeListGrid extends GXTGridComponent<UIDeviceType> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIDeviceType> code;
  
  public StringColumn<UIDeviceType> name;
  
  public IntegerColumn<UIDeviceType> depreciationYears;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  private UIDeviceType value = new UIDeviceType();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();code = stringValueProviderFactory.createAsStringColumn("code","类型编码",UIDeviceType.CodeAccessor);
    widgetsRegistory.put("code",code);
    name = stringValueProviderFactory.createAsStringColumn("name","名称",UIDeviceType.NameAccessor);
    widgetsRegistory.put("name",name);
    depreciationYears = integerValueProviderFactory.createAsIntegerColumn("depreciationYears","折旧年限",UIDeviceType.DepreciationYearsAccessor);
    widgetsRegistory.put("depreciationYears",depreciationYears);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIDeviceType getValueAsNew() {
    UIDeviceType value = new UIDeviceType();
    value.setCode(code.getValue());
    value.setName(name.getValue());
    value.setDepreciationYears(depreciationYears.getValue());
    return value;
  }
  
  public UIDeviceType doGetValue() {
    
    value.setCode(code.getValue());
    value.setName(name.getValue());
    value.setDepreciationYears(depreciationYears.getValue());
    return value;
  }
  
  public UIDeviceType getValue(final UIDeviceType copyValue) {
    
    copyValue.setCode(code.getValue());
    copyValue.setName(name.getValue());
    copyValue.setDepreciationYears(depreciationYears.getValue());
    return copyValue;
  }
  
  protected DeviceTypeListGrid doSetValue(final UIDeviceType value) {
    this.value = value;
    code.setValue(value.getCode());
    name.setValue(value.getName());
    depreciationYears.setValue(value.getDepreciationYears());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)code,(ICanAsWidget)name,(ICanAsWidget)depreciationYears
    					);
  }
}
