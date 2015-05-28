package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.shared.measure.UIGasMeasureValue;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DoubleValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DoubleValueProviderFactory.DoubleItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class GasMeasureValueForm extends GXTFormComponent<UIGasMeasureValue> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DoubleItem theValue;
  
  public DateItem measureDate;
  
  public TextItem measurePerson;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIGasMeasureValue value = new UIGasMeasureValue();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();theValue = doubleValueProviderFactory.createAsDoubleItem("theValue","读数");
    widgetsRegistory.put("theValue",theValue);
    measureDate = dateValueProviderFactory.createAsDateItem("measureDate","抄表日期");
    widgetsRegistory.put("measureDate",measureDate);
    measurePerson = stringValueProviderFactory.createAsTextItem("measurePerson","抄表人");
    widgetsRegistory.put("measurePerson",measurePerson);
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
  
  public UIGasMeasureValue getValueAsNew() {
    UIGasMeasureValue value = new UIGasMeasureValue();
    value.setTheValue(theValue.getValue());
    value.setMeasureDate(measureDate.getValue());
    value.setMeasurePerson(measurePerson.getValue());
    return value;
  }
  
  public UIGasMeasureValue doGetValue() {
    
    value.setTheValue(theValue.getValue());
    value.setMeasureDate(measureDate.getValue());
    value.setMeasurePerson(measurePerson.getValue());
    return value;
  }
  
  public UIGasMeasureValue getValue(final UIGasMeasureValue copyValue) {
    
    copyValue.setTheValue(theValue.getValue());
    copyValue.setMeasureDate(measureDate.getValue());
    copyValue.setMeasurePerson(measurePerson.getValue());
    return copyValue;
  }
  
  protected GasMeasureValueForm doSetValue(final UIGasMeasureValue value) {
    this.value = value;
    theValue.setValue(value.getTheValue());
    measureDate.setValue(value.getMeasureDate());
    measurePerson.setValue(value.getMeasurePerson());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)theValue,(ICanAsWidget)measureDate,(ICanAsWidget)measurePerson
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = GasMeasureValueForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldLabel _asWidget = GasMeasureValueForm.this.theValue.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
                FieldLabel _asWidget_1 = GasMeasureValueForm.this.measureDate.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_1);
                FieldLabel _asWidget_2 = GasMeasureValueForm.this.measurePerson.asWidget();
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
  
  private Widget con;
}
