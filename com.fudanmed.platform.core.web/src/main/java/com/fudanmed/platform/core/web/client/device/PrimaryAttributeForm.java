package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCPrimaryTypeProxy;
import com.fudanmed.platform.core.web.client.device.PrimaryTypeContentProvider;
import com.fudanmed.platform.core.web.client.device.PrimaryTypeList;
import com.fudanmed.platform.core.web.shared.device.UIPrimaryAttribute;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.ComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.StringReadonlyItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PrimaryAttributeForm extends GXTFormComponent<UIPrimaryAttribute> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringReadonlyItem parentCompositeAttribute;
  
  public ComboBoxSelector<RCPrimaryTypeProxy> type;
  
  @Inject
  public PrimaryTypeContentProvider typeContentProvider;
  
  public TextItem attributeName;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIPrimaryAttribute value = new UIPrimaryAttribute();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();parentCompositeAttribute = stringValueProviderFactory.createAsReadonlyItem("parentCompositeAttribute","所属复合参数");
    widgetsRegistory.put("parentCompositeAttribute",parentCompositeAttribute);
    type = defaultObjectSelectorFactory.createAsComboBoxItem("type","参数类型");
    _initializerSupports.add(typeContentProvider);
    type.setContentProvider(typeContentProvider);
    widgetsRegistory.put("type",type);
    attributeName = stringValueProviderFactory.createAsTextItem("attributeName","参数名");
    widgetsRegistory.put("attributeName",attributeName);
    if(primaryTypeList instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)primaryTypeList);
    						}if(con instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
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
  
  public UIPrimaryAttribute getValueAsNew() {
    UIPrimaryAttribute value = new UIPrimaryAttribute();
    value.setParentCompositeAttribute(parentCompositeAttribute.getValue());
    value.setType(type.getValue());
    value.setAttributeName(attributeName.getValue());
    return value;
  }
  
  public UIPrimaryAttribute doGetValue() {
    
    value.setParentCompositeAttribute(parentCompositeAttribute.getValue());
    value.setType(type.getValue());
    value.setAttributeName(attributeName.getValue());
    return value;
  }
  
  public UIPrimaryAttribute getValue(final UIPrimaryAttribute copyValue) {
    
    copyValue.setParentCompositeAttribute(parentCompositeAttribute.getValue());
    copyValue.setType(type.getValue());
    copyValue.setAttributeName(attributeName.getValue());
    return copyValue;
  }
  
  protected PrimaryAttributeForm doSetValue(final UIPrimaryAttribute value) {
    this.value = value;
    parentCompositeAttribute.setValue(value.getParentCompositeAttribute());
    type.setValue(value.getType());
    attributeName.setValue(value.getAttributeName());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)parentCompositeAttribute,(ICanAsWidget)type,(ICanAsWidget)attributeName
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = PrimaryAttributeForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldLabel _asWidget = PrimaryAttributeForm.this.parentCompositeAttribute.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
                FieldLabel _asWidget_1 = PrimaryAttributeForm.this.attributeName.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_1);
                FieldLabel _asWidget_2 = PrimaryAttributeForm.this.type.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_2);
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
  
  @Inject
  private PrimaryTypeList primaryTypeList;
  
  private Widget con;
}
