package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialType;
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

public class DeliverMaterialTypeListGrid extends GXTGridComponent<UIDeliverMaterialType> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UIDeliverMaterialType,DLDeliverMaterialCategoryProxy> category;
  
  public StringColumn<UIDeliverMaterialType> code;
  
  public StringColumn<UIDeliverMaterialType> name;
  
  public StringColumn<UIDeliverMaterialType> unit;
  
  public StringColumn<UIDeliverMaterialType> comment;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIDeliverMaterialType value = new UIDeliverMaterialType();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();category = defaultObjectSelectorFactory.createAsDefaultColumn("category","类别",UIDeliverMaterialType.CategoryAccessor);
    widgetsRegistory.put("category",category);
    code = stringValueProviderFactory.createAsStringColumn("code","代码",UIDeliverMaterialType.CodeAccessor);
    widgetsRegistory.put("code",code);
    name = stringValueProviderFactory.createAsStringColumn("name","名称",UIDeliverMaterialType.NameAccessor);
    widgetsRegistory.put("name",name);
    unit = stringValueProviderFactory.createAsStringColumn("unit","单位",UIDeliverMaterialType.UnitAccessor);
    widgetsRegistory.put("unit",unit);
    comment = stringValueProviderFactory.createAsStringColumn("comment","特殊要求",UIDeliverMaterialType.CommentAccessor);
    widgetsRegistory.put("comment",comment);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIDeliverMaterialType getValueAsNew() {
    UIDeliverMaterialType value = new UIDeliverMaterialType();
    value.setCategory(category.getValue());
    value.setCode(code.getValue());
    value.setName(name.getValue());
    value.setUnit(unit.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIDeliverMaterialType doGetValue() {
    
    value.setCategory(category.getValue());
    value.setCode(code.getValue());
    value.setName(name.getValue());
    value.setUnit(unit.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIDeliverMaterialType getValue(final UIDeliverMaterialType copyValue) {
    
    copyValue.setCategory(category.getValue());
    copyValue.setCode(code.getValue());
    copyValue.setName(name.getValue());
    copyValue.setUnit(unit.getValue());
    copyValue.setComment(comment.getValue());
    return copyValue;
  }
  
  protected DeliverMaterialTypeListGrid doSetValue(final UIDeliverMaterialType value) {
    this.value = value;
    category.setValue(value.getCategory());
    code.setValue(value.getCode());
    name.setValue(value.getName());
    unit.setValue(value.getUnit());
    comment.setValue(value.getComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)category,(ICanAsWidget)code,(ICanAsWidget)name,(ICanAsWidget)unit,(ICanAsWidget)comment
    					);
  }
}
