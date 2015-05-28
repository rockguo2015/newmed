package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCTypeProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCValueProxy;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.component.treegrid.GXTTreeGridComponent;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class AttributeSlotListGrid extends GXTTreeGridComponent<UIAttributeSlot> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIAttributeSlot> slotName;
  
  public StringValueColumn<UIAttributeSlot,RCTypeProxy> type;
  
  public StringValueColumn<UIAttributeSlot,RCValueProxy> slotValue;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIAttributeSlot value = new UIAttributeSlot();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();slotName = stringValueProviderFactory.createAsStringColumn("slotName","参数名",UIAttributeSlot.SlotNameAccessor,Integer.valueOf(100));
    widgetsRegistory.put("slotName",slotName);
    type = defaultObjectSelectorFactory.createAsDefaultColumn("type","参数类型",UIAttributeSlot.TypeAccessor,Integer.valueOf(60));
    widgetsRegistory.put("type",type);
    slotValue = defaultObjectSelectorFactory.createAsAutoExpandColumn("slotValue","值",UIAttributeSlot.SlotValueAccessor);
    widgetsRegistory.put("slotValue",slotValue);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIAttributeSlot getValueAsNew() {
    UIAttributeSlot value = new UIAttributeSlot();
    value.setSlotName(slotName.getValue());
    value.setType(type.getValue());
    value.setSlotValue(slotValue.getValue());
    return value;
  }
  
  public UIAttributeSlot doGetValue() {
    
    value.setSlotName(slotName.getValue());
    value.setType(type.getValue());
    value.setSlotValue(slotValue.getValue());
    return value;
  }
  
  public UIAttributeSlot getValue(final UIAttributeSlot copyValue) {
    
    copyValue.setSlotName(slotName.getValue());
    copyValue.setType(type.getValue());
    copyValue.setSlotValue(slotValue.getValue());
    return copyValue;
  }
  
  protected AttributeSlotListGrid doSetValue(final UIAttributeSlot value) {
    this.value = value;
    slotName.setValue(value.getSlotName());
    type.setValue(value.getType());
    slotValue.setValue(value.getSlotValue());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)slotName,(ICanAsWidget)type,(ICanAsWidget)slotValue
    					);
  }
}
