package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialTypeCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.ReadonlyItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class DeliverMaterialTypeCriteriaForm extends GXTFormComponent<UIDeliverMaterialTypeCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem info;
  
  public ReadonlyItem<DLDeliverMaterialCategoryProxy> category;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIDeliverMaterialTypeCriteria value = new UIDeliverMaterialTypeCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();info = stringValueProviderFactory.createAsEscapedTextItem("info","运送材料信息");
    widgetsRegistory.put("info",info);
    category = defaultObjectSelectorFactory.createAsReadonlyItem("category","运送材料大类");
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
  
  public UIDeliverMaterialTypeCriteria getValueAsNew() {
    UIDeliverMaterialTypeCriteria value = new UIDeliverMaterialTypeCriteria();
    value.setInfo(info.getValue());
    value.setCategory(category.getValue());
    return value;
  }
  
  public UIDeliverMaterialTypeCriteria doGetValue() {
    
    value.setInfo(info.getValue());
    value.setCategory(category.getValue());
    return value;
  }
  
  public UIDeliverMaterialTypeCriteria getValue(final UIDeliverMaterialTypeCriteria copyValue) {
    
    copyValue.setInfo(info.getValue());
    copyValue.setCategory(category.getValue());
    return copyValue;
  }
  
  protected DeliverMaterialTypeCriteriaForm doSetValue(final UIDeliverMaterialTypeCriteria value) {
    this.value = value;
    info.setValue(value.getInfo());
    category.setValue(value.getCategory());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)info,(ICanAsWidget)category
    					);
  }
}
