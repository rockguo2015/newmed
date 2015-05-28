package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UINumberWithUnitType;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class NumberWithUnitTypeListGrid extends GXTGridComponent<UINumberWithUnitType> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UINumberWithUnitType> alias;
  
  public StringColumn<UINumberWithUnitType> unit;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UINumberWithUnitType value = new UINumberWithUnitType();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();alias = stringValueProviderFactory.createAsStringColumn("alias","别名",UINumberWithUnitType.AliasAccessor);
    widgetsRegistory.put("alias",alias);
    unit = stringValueProviderFactory.createAsStringColumn("unit","单位",UINumberWithUnitType.UnitAccessor);
    widgetsRegistory.put("unit",unit);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UINumberWithUnitType getValueAsNew() {
    UINumberWithUnitType value = new UINumberWithUnitType();
    value.setAlias(alias.getValue());
    value.setUnit(unit.getValue());
    return value;
  }
  
  public UINumberWithUnitType doGetValue() {
    
    value.setAlias(alias.getValue());
    value.setUnit(unit.getValue());
    return value;
  }
  
  public UINumberWithUnitType getValue(final UINumberWithUnitType copyValue) {
    
    copyValue.setAlias(alias.getValue());
    copyValue.setUnit(unit.getValue());
    return copyValue;
  }
  
  protected NumberWithUnitTypeListGrid doSetValue(final UINumberWithUnitType value) {
    this.value = value;
    alias.setValue(value.getAlias());
    unit.setValue(value.getUnit());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)alias,(ICanAsWidget)unit
    					);
  }
}
