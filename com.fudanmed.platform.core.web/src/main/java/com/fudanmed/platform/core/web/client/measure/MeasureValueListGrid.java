package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.shared.measure.UIMeasureValue;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateTimeColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class MeasureValueListGrid extends GXTGridComponent<UIMeasureValue> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIMeasureValue> valueString;
  
  public StringColumn<UIMeasureValue> increamentValueString;
  
  public DateTimeColumn<UIMeasureValue> measureDate;
  
  public StringColumn<UIMeasureValue> measurePerson;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  private UIMeasureValue value = new UIMeasureValue();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();valueString = stringValueProviderFactory.createAsStringColumn("valueString","抄表数",UIMeasureValue.ValueStringAccessor);
    widgetsRegistory.put("valueString",valueString);
    increamentValueString = stringValueProviderFactory.createAsStringColumn("increamentValueString","用量",UIMeasureValue.IncreamentValueStringAccessor);
    widgetsRegistory.put("increamentValueString",increamentValueString);
    measureDate = dateValueProviderFactory.createAsDateTimeColumn("measureDate","抄表日期",UIMeasureValue.MeasureDateAccessor);
    widgetsRegistory.put("measureDate",measureDate);
    measurePerson = stringValueProviderFactory.createAsStringColumn("measurePerson","抄表人",UIMeasureValue.MeasurePersonAccessor);
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
  
  public UIMeasureValue getValueAsNew() {
    UIMeasureValue value = new UIMeasureValue();
    value.setValueString(valueString.getValue());
    value.setIncreamentValueString(increamentValueString.getValue());
    value.setMeasureDate(measureDate.getValue());
    value.setMeasurePerson(measurePerson.getValue());
    return value;
  }
  
  public UIMeasureValue doGetValue() {
    
    value.setValueString(valueString.getValue());
    value.setIncreamentValueString(increamentValueString.getValue());
    value.setMeasureDate(measureDate.getValue());
    value.setMeasurePerson(measurePerson.getValue());
    return value;
  }
  
  public UIMeasureValue getValue(final UIMeasureValue copyValue) {
    
    copyValue.setValueString(valueString.getValue());
    copyValue.setIncreamentValueString(increamentValueString.getValue());
    copyValue.setMeasureDate(measureDate.getValue());
    copyValue.setMeasurePerson(measurePerson.getValue());
    return copyValue;
  }
  
  protected MeasureValueListGrid doSetValue(final UIMeasureValue value) {
    this.value = value;
    valueString.setValue(value.getValueString());
    increamentValueString.setValue(value.getIncreamentValueString());
    measureDate.setValue(value.getMeasureDate());
    measurePerson.setValue(value.getMeasurePerson());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)valueString,(ICanAsWidget)increamentValueString,(ICanAsWidget)measureDate,(ICanAsWidget)measurePerson
    					);
  }
}
