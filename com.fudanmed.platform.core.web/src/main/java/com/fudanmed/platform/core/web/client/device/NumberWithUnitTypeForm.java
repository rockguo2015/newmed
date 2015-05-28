package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UINumberWithUnitType;
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
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class NumberWithUnitTypeForm extends GXTFormComponent<UINumberWithUnitType> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem alias;
  
  public TextItem unit;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UINumberWithUnitType value = new UINumberWithUnitType();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();alias = stringValueProviderFactory.createAsTextItem("alias","别名");
    widgetsRegistory.put("alias",alias);
    unit = stringValueProviderFactory.createAsTextItem("unit","单位");
    widgetsRegistory.put("unit",unit);
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
  
  public UINumberWithUnitType getValueAsNew() {
    UINumberWithUnitType value = new UINumberWithUnitType();
    value.setAlias(alias.getValue());
    value.setUnit(unit.getValue());
    return value;
  }
  
  public UINumberWithUnitType doGetValue() {
    
    value.setAlias(alias.getValue());
    value.setUnit(unit.getValue());
    return value;
  }
  
  public UINumberWithUnitType getValue(final UINumberWithUnitType copyValue) {
    
    copyValue.setAlias(alias.getValue());
    copyValue.setUnit(unit.getValue());
    return copyValue;
  }
  
  protected NumberWithUnitTypeForm doSetValue(final UINumberWithUnitType value) {
    this.value = value;
    alias.setValue(value.getAlias());
    unit.setValue(value.getUnit());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)alias,(ICanAsWidget)unit
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = NumberWithUnitTypeForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldLabel _asWidget = NumberWithUnitTypeForm.this.alias.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
                FieldLabel _asWidget_1 = NumberWithUnitTypeForm.this.unit.asWidget();
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
