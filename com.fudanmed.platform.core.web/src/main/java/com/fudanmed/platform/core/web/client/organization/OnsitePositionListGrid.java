package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
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

public class OnsitePositionListGrid extends GXTTreeGridComponent<UIOnsitePosition> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIOnsitePosition> name;
  
  public StringColumn<UIOnsitePosition> code;
  
  public StringColumn<UIOnsitePosition> phone;
  
  public StringValueColumn<UIOnsitePosition,RCOnsitePositionProxy> parent;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIOnsitePosition value = new UIOnsitePosition();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsStringColumn("name","位置名称",UIOnsitePosition.NameAccessor);
    widgetsRegistory.put("name",name);
    code = stringValueProviderFactory.createAsStringColumn("code","位置代码",UIOnsitePosition.CodeAccessor);
    widgetsRegistory.put("code",code);
    phone = stringValueProviderFactory.createAsStringColumn("phone","联系电话",UIOnsitePosition.PhoneAccessor);
    widgetsRegistory.put("phone",phone);
    parent = defaultObjectSelectorFactory.createAsDefaultColumn("parent","所属位置",UIOnsitePosition.ParentAccessor);
    widgetsRegistory.put("parent",parent);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIOnsitePosition getValueAsNew() {
    UIOnsitePosition value = new UIOnsitePosition();
    value.setName(name.getValue());
    value.setCode(code.getValue());
    value.setPhone(phone.getValue());
    value.setParent(parent.getValue());
    return value;
  }
  
  public UIOnsitePosition doGetValue() {
    
    value.setName(name.getValue());
    value.setCode(code.getValue());
    value.setPhone(phone.getValue());
    value.setParent(parent.getValue());
    return value;
  }
  
  public UIOnsitePosition getValue(final UIOnsitePosition copyValue) {
    
    copyValue.setName(name.getValue());
    copyValue.setCode(code.getValue());
    copyValue.setPhone(phone.getValue());
    copyValue.setParent(parent.getValue());
    return copyValue;
  }
  
  protected OnsitePositionListGrid doSetValue(final UIOnsitePosition value) {
    this.value = value;
    name.setValue(value.getName());
    code.setValue(value.getCode());
    phone.setValue(value.getPhone());
    parent.setValue(value.getParent());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)name,(ICanAsWidget)code,(ICanAsWidget)phone,(ICanAsWidget)parent
    					);
  }
}
