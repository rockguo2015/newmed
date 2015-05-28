package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialType;
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
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextAreaItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeliverMaterialTypeForm extends GXTFormComponent<UIDeliverMaterialType> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public ReadonlyItem<DLDeliverMaterialCategoryProxy> category;
  
  public TextItem code;
  
  public TextItem name;
  
  public TextItem unit;
  
  public TextAreaItem comment;
  
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
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();category = defaultObjectSelectorFactory.createAsReadonlyItem("category","类别");
    widgetsRegistory.put("category",category);
    code = stringValueProviderFactory.createAsTextItem("code","代码");
    widgetsRegistory.put("code",code);
    name = stringValueProviderFactory.createAsTextItem("name","名称");
    widgetsRegistory.put("name",name);
    unit = stringValueProviderFactory.createAsTextItem("unit","单位");
    widgetsRegistory.put("unit",unit);
    comment = stringValueProviderFactory.createAsTextAreaItem("comment","特殊要求");
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
  
  protected DeliverMaterialTypeForm doSetValue(final UIDeliverMaterialType value) {
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
  
  public Widget createWidget() {
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          FieldLabel _asWidget = DeliverMaterialTypeForm.this.category.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
          FieldLabel _asWidget_1 = DeliverMaterialTypeForm.this.code.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget_1);
          FieldLabel _asWidget_2 = DeliverMaterialTypeForm.this.name.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget_2);
          FieldLabel _asWidget_3 = DeliverMaterialTypeForm.this.unit.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget_3);
          FieldLabel _asWidget_4 = DeliverMaterialTypeForm.this.comment.asWidget();
          final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
              public void apply(final FieldLabel it) {
                it.setHeight(80);
              }
            };
          FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget_4, _function);
          WidgetExtensions.<FieldLabel>addFill(it, _doubleArrow);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    return _doubleArrow;
  }
}
