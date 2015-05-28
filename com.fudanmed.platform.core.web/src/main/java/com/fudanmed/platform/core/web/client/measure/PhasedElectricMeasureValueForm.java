package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureValue;
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

public class PhasedElectricMeasureValueForm extends GXTFormComponent<UIPhasedElectricMeasureValue> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DoubleItem highValue;
  
  public DoubleItem averageValue;
  
  public DoubleItem peekValue;
  
  public DoubleItem lowValue;
  
  public DoubleItem maxRequiredValue;
  
  public DoubleItem noPowerValue;
  
  public DateItem measureDate;
  
  public TextItem measurePerson;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIPhasedElectricMeasureValue value = new UIPhasedElectricMeasureValue();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();highValue = doubleValueProviderFactory.createAsDoubleItem("highValue","峰电量");
    widgetsRegistory.put("highValue",highValue);
    averageValue = doubleValueProviderFactory.createAsDoubleItem("averageValue","平电量");
    widgetsRegistory.put("averageValue",averageValue);
    peekValue = doubleValueProviderFactory.createAsDoubleItem("peekValue","尖电量");
    widgetsRegistory.put("peekValue",peekValue);
    lowValue = doubleValueProviderFactory.createAsDoubleItem("lowValue","谷电量");
    widgetsRegistory.put("lowValue",lowValue);
    maxRequiredValue = doubleValueProviderFactory.createAsDoubleItem("maxRequiredValue","最大需量");
    widgetsRegistory.put("maxRequiredValue",maxRequiredValue);
    noPowerValue = doubleValueProviderFactory.createAsDoubleItem("noPowerValue","无功电量");
    widgetsRegistory.put("noPowerValue",noPowerValue);
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
  
  public UIPhasedElectricMeasureValue getValueAsNew() {
    UIPhasedElectricMeasureValue value = new UIPhasedElectricMeasureValue();
    value.setHighValue(highValue.getValue());
    value.setAverageValue(averageValue.getValue());
    value.setPeekValue(peekValue.getValue());
    value.setLowValue(lowValue.getValue());
    value.setMaxRequiredValue(maxRequiredValue.getValue());
    value.setNoPowerValue(noPowerValue.getValue());
    value.setMeasureDate(measureDate.getValue());
    value.setMeasurePerson(measurePerson.getValue());
    return value;
  }
  
  public UIPhasedElectricMeasureValue doGetValue() {
    
    value.setHighValue(highValue.getValue());
    value.setAverageValue(averageValue.getValue());
    value.setPeekValue(peekValue.getValue());
    value.setLowValue(lowValue.getValue());
    value.setMaxRequiredValue(maxRequiredValue.getValue());
    value.setNoPowerValue(noPowerValue.getValue());
    value.setMeasureDate(measureDate.getValue());
    value.setMeasurePerson(measurePerson.getValue());
    return value;
  }
  
  public UIPhasedElectricMeasureValue getValue(final UIPhasedElectricMeasureValue copyValue) {
    
    copyValue.setHighValue(highValue.getValue());
    copyValue.setAverageValue(averageValue.getValue());
    copyValue.setPeekValue(peekValue.getValue());
    copyValue.setLowValue(lowValue.getValue());
    copyValue.setMaxRequiredValue(maxRequiredValue.getValue());
    copyValue.setNoPowerValue(noPowerValue.getValue());
    copyValue.setMeasureDate(measureDate.getValue());
    copyValue.setMeasurePerson(measurePerson.getValue());
    return copyValue;
  }
  
  protected PhasedElectricMeasureValueForm doSetValue(final UIPhasedElectricMeasureValue value) {
    this.value = value;
    highValue.setValue(value.getHighValue());
    averageValue.setValue(value.getAverageValue());
    peekValue.setValue(value.getPeekValue());
    lowValue.setValue(value.getLowValue());
    maxRequiredValue.setValue(value.getMaxRequiredValue());
    noPowerValue.setValue(value.getNoPowerValue());
    measureDate.setValue(value.getMeasureDate());
    measurePerson.setValue(value.getMeasurePerson());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)highValue,(ICanAsWidget)averageValue,(ICanAsWidget)peekValue,(ICanAsWidget)lowValue,(ICanAsWidget)maxRequiredValue,(ICanAsWidget)noPowerValue,(ICanAsWidget)measureDate,(ICanAsWidget)measurePerson
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = PhasedElectricMeasureValueForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldLabel _asWidget = PhasedElectricMeasureValueForm.this.highValue.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
                FieldLabel _asWidget_1 = PhasedElectricMeasureValueForm.this.averageValue.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_1);
                FieldLabel _asWidget_2 = PhasedElectricMeasureValueForm.this.peekValue.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_2);
                FieldLabel _asWidget_3 = PhasedElectricMeasureValueForm.this.lowValue.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_3);
                FieldLabel _asWidget_4 = PhasedElectricMeasureValueForm.this.maxRequiredValue.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_4);
                FieldLabel _asWidget_5 = PhasedElectricMeasureValueForm.this.noPowerValue.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_5);
                FieldLabel _asWidget_6 = PhasedElectricMeasureValueForm.this.measureDate.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_6);
                FieldLabel _asWidget_7 = PhasedElectricMeasureValueForm.this.measurePerson.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_7);
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
