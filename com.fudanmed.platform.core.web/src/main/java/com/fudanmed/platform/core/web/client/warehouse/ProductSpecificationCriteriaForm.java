package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.fudanmed.platform.core.web.client.warehouse.TopLevelProductCategoryProvider;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecificationCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.ComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class ProductSpecificationCriteriaForm extends GXTFormComponent<UIProductSpecificationCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem info;
  
  public ComboBoxSelector<RCProductCategoryProxy> category;
  
  @Inject
  public TopLevelProductCategoryProvider categoryContentProvider;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIProductSpecificationCriteria value = new UIProductSpecificationCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();info = stringValueProviderFactory.createAsEscapedTextItem("info","物品信息");
    widgetsRegistory.put("info",info);
    category = defaultObjectSelectorFactory.createAsComboBoxItem("category","物品大类");
    _initializerSupports.add(categoryContentProvider);
    category.setContentProvider(categoryContentProvider);
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
  
  public UIProductSpecificationCriteria getValueAsNew() {
    UIProductSpecificationCriteria value = new UIProductSpecificationCriteria();
    value.setInfo(info.getValue());
    value.setCategory(category.getValue());
    return value;
  }
  
  public UIProductSpecificationCriteria doGetValue() {
    
    value.setInfo(info.getValue());
    value.setCategory(category.getValue());
    return value;
  }
  
  public UIProductSpecificationCriteria getValue(final UIProductSpecificationCriteria copyValue) {
    
    copyValue.setInfo(info.getValue());
    copyValue.setCategory(category.getValue());
    return copyValue;
  }
  
  protected ProductSpecificationCriteriaForm doSetValue(final UIProductSpecificationCriteria value) {
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
