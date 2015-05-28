package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.shared.warehouse.UIProductCategory;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.component.treegrid.GXTTreeGridComponent;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class ProductCategoryListGrid extends GXTTreeGridComponent<UIProductCategory> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIProductCategory> name;
  
  public StringColumn<UIProductCategory> code;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIProductCategory value = new UIProductCategory();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsStringColumn("name","物品大类名称",UIProductCategory.NameAccessor);
    widgetsRegistory.put("name",name);
    code = stringValueProviderFactory.createAsStringColumn("code","物品大类代码",UIProductCategory.CodeAccessor);
    widgetsRegistory.put("code",code);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIProductCategory getValueAsNew() {
    UIProductCategory value = new UIProductCategory();
    value.setName(name.getValue());
    value.setCode(code.getValue());
    return value;
  }
  
  public UIProductCategory doGetValue() {
    
    value.setName(name.getValue());
    value.setCode(code.getValue());
    return value;
  }
  
  public UIProductCategory getValue(final UIProductCategory copyValue) {
    
    copyValue.setName(name.getValue());
    copyValue.setCode(code.getValue());
    return copyValue;
  }
  
  protected ProductCategoryListGrid doSetValue(final UIProductCategory value) {
    this.value = value;
    name.setValue(value.getName());
    code.setValue(value.getCode());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)name,(ICanAsWidget)code
    					);
  }
}
