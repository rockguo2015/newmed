package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UICompositeAttribute;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.StringReadonlyItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CompositeAttributeForm extends GXTFormComponent<UICompositeAttribute> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringReadonlyItem parentCompositeAttribute;
  
  public TextItem attributeName;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UICompositeAttribute value = new UICompositeAttribute();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();parentCompositeAttribute = stringValueProviderFactory.createAsReadonlyItem("parentCompositeAttribute","所属复合参数");
    widgetsRegistory.put("parentCompositeAttribute",parentCompositeAttribute);
    attributeName = stringValueProviderFactory.createAsTextItem("attributeName","复合参数名称");
    widgetsRegistory.put("attributeName",attributeName);
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
  
  public UICompositeAttribute getValueAsNew() {
    UICompositeAttribute value = new UICompositeAttribute();
    value.setParentCompositeAttribute(parentCompositeAttribute.getValue());
    value.setAttributeName(attributeName.getValue());
    return value;
  }
  
  public UICompositeAttribute doGetValue() {
    
    value.setParentCompositeAttribute(parentCompositeAttribute.getValue());
    value.setAttributeName(attributeName.getValue());
    return value;
  }
  
  public UICompositeAttribute getValue(final UICompositeAttribute copyValue) {
    
    copyValue.setParentCompositeAttribute(parentCompositeAttribute.getValue());
    copyValue.setAttributeName(attributeName.getValue());
    return copyValue;
  }
  
  protected CompositeAttributeForm doSetValue(final UICompositeAttribute value) {
    this.value = value;
    parentCompositeAttribute.setValue(value.getParentCompositeAttribute());
    attributeName.setValue(value.getAttributeName());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)parentCompositeAttribute,(ICanAsWidget)attributeName
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = CompositeAttributeForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldLabel _asWidget = CompositeAttributeForm.this.parentCompositeAttribute.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
                FieldLabel _asWidget_1 = CompositeAttributeForm.this.attributeName.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_1);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          return _doubleArrow;
        }
      };
    Widget _lazy = ClientUi.<Widget>lazy(this.con, _function);
    Widget _con = this.con = _lazy;
    return _con;
  }
  
  private Widget con;
}
