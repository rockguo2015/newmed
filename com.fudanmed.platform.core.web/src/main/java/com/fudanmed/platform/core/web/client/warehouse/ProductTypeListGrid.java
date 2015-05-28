package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductType;
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

public class ProductTypeListGrid extends GXTGridComponent<UIProductType> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIProductType> code;
  
  public StringColumn<UIProductType> name;
  
  public StringValueColumn<UIProductType,RCProductCategoryProxy> category;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIProductType value = new UIProductType();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();code = stringValueProviderFactory.createAsStringColumn("code","物品类别代码",UIProductType.CodeAccessor);
    widgetsRegistory.put("code",code);
    name = stringValueProviderFactory.createAsStringColumn("name","物品类别名称",UIProductType.NameAccessor);
    widgetsRegistory.put("name",name);
    category = defaultObjectSelectorFactory.createAsDefaultColumn("category","物品大类",UIProductType.CategoryAccessor);
    widgetsRegistory.put("category",category);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIProductType getValueAsNew() {
    UIProductType value = new UIProductType();
    value.setCode(code.getValue());
    value.setName(name.getValue());
    value.setCategory(category.getValue());
    return value;
  }
  
  public UIProductType doGetValue() {
    
    value.setCode(code.getValue());
    value.setName(name.getValue());
    value.setCategory(category.getValue());
    return value;
  }
  
  public UIProductType getValue(final UIProductType copyValue) {
    
    copyValue.setCode(code.getValue());
    copyValue.setName(name.getValue());
    copyValue.setCategory(category.getValue());
    return copyValue;
  }
  
  protected ProductTypeListGrid doSetValue(final UIProductType value) {
    this.value = value;
    code.setValue(value.getCode());
    name.setValue(value.getName());
    category.setValue(value.getCategory());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)code,(ICanAsWidget)name,(ICanAsWidget)category
    					);
  }
}
