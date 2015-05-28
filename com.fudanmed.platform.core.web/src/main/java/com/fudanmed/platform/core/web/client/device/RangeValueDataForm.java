package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.RangeValueData;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.DoubleValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DoubleValueProviderFactory.DoubleItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class RangeValueDataForm extends GXTFormComponent<RangeValueData> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DoubleItem lower;
  
  public DoubleItem upper;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  private RangeValueData value = new RangeValueData();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();lower = doubleValueProviderFactory.createAsDoubleItem("lower","上限");
    widgetsRegistory.put("lower",lower);
    upper = doubleValueProviderFactory.createAsDoubleItem("upper","下限");
    widgetsRegistory.put("upper",upper);
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
  
  public RangeValueData getValueAsNew() {
    RangeValueData value = new RangeValueData();
    value.setLower(lower.getValue());
    value.setUpper(upper.getValue());
    return value;
  }
  
  public RangeValueData doGetValue() {
    
    value.setLower(lower.getValue());
    value.setUpper(upper.getValue());
    return value;
  }
  
  public RangeValueData getValue(final RangeValueData copyValue) {
    
    copyValue.setLower(lower.getValue());
    copyValue.setUpper(upper.getValue());
    return copyValue;
  }
  
  protected RangeValueDataForm doSetValue(final RangeValueData value) {
    this.value = value;
    lower.setValue(value.getLower());
    upper.setValue(value.getUpper());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)lower,(ICanAsWidget)upper
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = RangeValueDataForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldLabel _asWidget = RangeValueDataForm.this.lower.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
                FieldLabel _asWidget_1 = RangeValueDataForm.this.upper.asWidget();
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
