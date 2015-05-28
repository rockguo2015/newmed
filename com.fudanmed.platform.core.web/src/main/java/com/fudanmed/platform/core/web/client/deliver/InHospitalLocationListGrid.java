package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalLocation;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class InHospitalLocationListGrid extends GXTGridComponent<UIInHospitalLocation> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIInHospitalLocation> code;
  
  public StringColumn<UIInHospitalLocation> name;
  
  public StringValueColumn<UIInHospitalLocation,RCOnsitePositionProxy> location;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIInHospitalLocation value = new UIInHospitalLocation();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();code = stringValueProviderFactory.createAsStringColumn("code","病区代码",UIInHospitalLocation.CodeAccessor);
    widgetsRegistory.put("code",code);
    name = stringValueProviderFactory.createAsStringColumn("name","病区名称",UIInHospitalLocation.NameAccessor);
    widgetsRegistory.put("name",name);
    location = defaultObjectSelectorFactory.createAsDefaultColumn("location","位置",UIInHospitalLocation.LocationAccessor);
    widgetsRegistory.put("location",location);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIInHospitalLocation getValueAsNew() {
    UIInHospitalLocation value = new UIInHospitalLocation();
    value.setCode(code.getValue());
    value.setName(name.getValue());
    value.setLocation(location.getValue());
    return value;
  }
  
  public UIInHospitalLocation doGetValue() {
    
    value.setCode(code.getValue());
    value.setName(name.getValue());
    value.setLocation(location.getValue());
    return value;
  }
  
  public UIInHospitalLocation getValue(final UIInHospitalLocation copyValue) {
    
    copyValue.setCode(code.getValue());
    copyValue.setName(name.getValue());
    copyValue.setLocation(location.getValue());
    return copyValue;
  }
  
  protected InHospitalLocationListGrid doSetValue(final UIInHospitalLocation value) {
    this.value = value;
    code.setValue(value.getCode());
    name.setValue(value.getName());
    location.setValue(value.getLocation());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)code,(ICanAsWidget)name,(ICanAsWidget)location
    					);
  }
}
