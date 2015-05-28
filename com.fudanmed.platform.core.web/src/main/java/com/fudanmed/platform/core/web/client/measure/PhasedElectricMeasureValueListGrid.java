package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureValue;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateTimeColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DoubleValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DoubleValueProviderFactory.DoubleColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class PhasedElectricMeasureValueListGrid extends GXTGridComponent<UIPhasedElectricMeasureValue> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DoubleColumn<UIPhasedElectricMeasureValue> totalEfficentPower;
  
  public DoubleColumn<UIPhasedElectricMeasureValue> consumedPower;
  
  public DoubleColumn<UIPhasedElectricMeasureValue> highValue;
  
  public DoubleColumn<UIPhasedElectricMeasureValue> averageValue;
  
  public DoubleColumn<UIPhasedElectricMeasureValue> peekValue;
  
  public DoubleColumn<UIPhasedElectricMeasureValue> lowValue;
  
  public DoubleColumn<UIPhasedElectricMeasureValue> maxRequiredValue;
  
  public DoubleColumn<UIPhasedElectricMeasureValue> noPowerValue;
  
  public DateTimeColumn<UIPhasedElectricMeasureValue> measureDate;
  
  public StringColumn<UIPhasedElectricMeasureValue> measurePerson;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  private UIPhasedElectricMeasureValue value = new UIPhasedElectricMeasureValue();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();totalEfficentPower = doubleValueProviderFactory.createAsDoubleColumn("totalEfficentPower","总有功电量",UIPhasedElectricMeasureValue.TotalEfficentPowerAccessor);
    widgetsRegistory.put("totalEfficentPower",totalEfficentPower);
    consumedPower = doubleValueProviderFactory.createAsDoubleColumn("consumedPower","本次耗电量",UIPhasedElectricMeasureValue.ConsumedPowerAccessor);
    widgetsRegistory.put("consumedPower",consumedPower);
    highValue = doubleValueProviderFactory.createAsDoubleColumn("highValue","峰电量",UIPhasedElectricMeasureValue.HighValueAccessor);
    widgetsRegistory.put("highValue",highValue);
    averageValue = doubleValueProviderFactory.createAsDoubleColumn("averageValue","平电量",UIPhasedElectricMeasureValue.AverageValueAccessor);
    widgetsRegistory.put("averageValue",averageValue);
    peekValue = doubleValueProviderFactory.createAsDoubleColumn("peekValue","尖电量",UIPhasedElectricMeasureValue.PeekValueAccessor);
    widgetsRegistory.put("peekValue",peekValue);
    lowValue = doubleValueProviderFactory.createAsDoubleColumn("lowValue","谷电量",UIPhasedElectricMeasureValue.LowValueAccessor);
    widgetsRegistory.put("lowValue",lowValue);
    maxRequiredValue = doubleValueProviderFactory.createAsDoubleColumn("maxRequiredValue","最大需量",UIPhasedElectricMeasureValue.MaxRequiredValueAccessor);
    widgetsRegistory.put("maxRequiredValue",maxRequiredValue);
    noPowerValue = doubleValueProviderFactory.createAsDoubleColumn("noPowerValue","无功电量",UIPhasedElectricMeasureValue.NoPowerValueAccessor);
    widgetsRegistory.put("noPowerValue",noPowerValue);
    measureDate = dateValueProviderFactory.createAsDateTimeColumn("measureDate","抄表日期",UIPhasedElectricMeasureValue.MeasureDateAccessor);
    widgetsRegistory.put("measureDate",measureDate);
    measurePerson = stringValueProviderFactory.createAsStringColumn("measurePerson","抄表人",UIPhasedElectricMeasureValue.MeasurePersonAccessor);
    widgetsRegistory.put("measurePerson",measurePerson);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
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
    value.setTotalEfficentPower(totalEfficentPower.getValue());
    value.setConsumedPower(consumedPower.getValue());
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
    
    value.setTotalEfficentPower(totalEfficentPower.getValue());
    value.setConsumedPower(consumedPower.getValue());
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
    
    copyValue.setTotalEfficentPower(totalEfficentPower.getValue());
    copyValue.setConsumedPower(consumedPower.getValue());
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
  
  protected PhasedElectricMeasureValueListGrid doSetValue(final UIPhasedElectricMeasureValue value) {
    this.value = value;
    totalEfficentPower.setValue(value.getTotalEfficentPower());
    consumedPower.setValue(value.getConsumedPower());
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
    					(ICanAsWidget)totalEfficentPower,(ICanAsWidget)consumedPower,(ICanAsWidget)highValue,(ICanAsWidget)averageValue,(ICanAsWidget)peekValue,(ICanAsWidget)lowValue,(ICanAsWidget)maxRequiredValue,(ICanAsWidget)noPowerValue,(ICanAsWidget)measureDate,(ICanAsWidget)measurePerson
    					);
  }
}
