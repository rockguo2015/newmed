package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialCategory;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.ReadonlyItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeliverMaterialCategoryForm extends GXTFormComponent<UIDeliverMaterialCategory> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem code;
  
  public TextItem name;
  
  public ReadonlyItem<DLDeliverMaterialCategoryProxy> parentCategory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIDeliverMaterialCategory value = new UIDeliverMaterialCategory();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();code = stringValueProviderFactory.createAsTextItem("code","代码");
    widgetsRegistory.put("code",code);
    name = stringValueProviderFactory.createAsTextItem("name","名称");
    widgetsRegistory.put("name",name);
    parentCategory = defaultObjectSelectorFactory.createAsReadonlyItem("parentCategory","父类别");
    widgetsRegistory.put("parentCategory",parentCategory);
    if(con instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)con);
    						}IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIDeliverMaterialCategory getValueAsNew() {
    UIDeliverMaterialCategory value = new UIDeliverMaterialCategory();
    value.setCode(code.getValue());
    value.setName(name.getValue());
    value.setParentCategory(parentCategory.getValue());
    return value;
  }
  
  public UIDeliverMaterialCategory doGetValue() {
    
    value.setCode(code.getValue());
    value.setName(name.getValue());
    value.setParentCategory(parentCategory.getValue());
    return value;
  }
  
  public UIDeliverMaterialCategory getValue(final UIDeliverMaterialCategory copyValue) {
    
    copyValue.setCode(code.getValue());
    copyValue.setName(name.getValue());
    copyValue.setParentCategory(parentCategory.getValue());
    return copyValue;
  }
  
  protected DeliverMaterialCategoryForm doSetValue(final UIDeliverMaterialCategory value) {
    this.value = value;
    code.setValue(value.getCode());
    name.setValue(value.getName());
    parentCategory.setValue(value.getParentCategory());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)code,(ICanAsWidget)name,(ICanAsWidget)parentCategory
    					);
  }
  
  public Widget createWidget() {
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          FieldLabel _asWidget = DeliverMaterialCategoryForm.this.parentCategory.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
          FieldLabel _asWidget_1 = DeliverMaterialCategoryForm.this.code.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget_1);
          FieldLabel _asWidget_2 = DeliverMaterialCategoryForm.this.name.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget_2);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    return _doubleArrow;
  }
  
  private Widget con;
}
