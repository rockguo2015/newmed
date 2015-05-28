package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.shared.measure.UIGasMeasureValue;
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

public class GasMeasureValueListGrid extends GXTGridComponent<UIGasMeasureValue> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DoubleColumn<UIGasMeasureValue> theValue;
  
  public DoubleColumn<UIGasMeasureValue> incrementalValue;
  
  public DateTimeColumn<UIGasMeasureValue> measureDate;
  
  public StringColumn<UIGasMeasureValue> measurePerson;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  private UIGasMeasureValue value = new UIGasMeasureValue();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();theValue = doubleValueProviderFactory.createAsDoubleColumn("theValue","读数",UIGasMeasureValue.TheValueAccessor);
    widgetsRegistory.put("theValue",theValue);
    incrementalValue = doubleValueProviderFactory.createAsDoubleColumn("incrementalValue","用量",UIGasMeasureValue.IncrementalValueAccessor);
    widgetsRegistory.put("incrementalValue",incrementalValue);
    measureDate = dateValueProviderFactory.createAsDateTimeColumn("measureDate","抄表日期",UIGasMeasureValue.MeasureDateAccessor);
    widgetsRegistory.put("measureDate",measureDate);
    measurePerson = stringValueProviderFactory.createAsStringColumn("measurePerson","抄表人",UIGasMeasureValue.MeasurePersonAccessor);
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
  
  public UIGasMeasureValue getValueAsNew() {
    UIGasMeasureValue value = new UIGasMeasureValue();
    value.setTheValue(theValue.getValue());
    value.setIncrementalValue(incrementalValue.getValue());
    value.setMeasureDate(measureDate.getValue());
    value.setMeasurePerson(measurePerson.getValue());
    return value;
  }
  
  public UIGasMeasureValue doGetValue() {
    
    value.setTheValue(theValue.getValue());
    value.setIncrementalValue(incrementalValue.getValue());
    value.setMeasureDate(measureDate.getValue());
    value.setMeasurePerson(measurePerson.getValue());
    return value;
  }
  
  public UIGasMeasureValue getValue(final UIGasMeasureValue copyValue) {
    
    copyValue.setTheValue(theValue.getValue());
    copyValue.setIncrementalValue(incrementalValue.getValue());
    copyValue.setMeasureDate(measureDate.getValue());
    copyValue.setMeasurePerson(measurePerson.getValue());
    return copyValue;
  }
  
  protected GasMeasureValueListGrid doSetValue(final UIGasMeasureValue value) {
    this.value = value;
    theValue.setValue(value.getTheValue());
    incrementalValue.setValue(value.getIncrementalValue());
    measureDate.setValue(value.getMeasureDate());
    measurePerson.setValue(value.getMeasurePerson());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)theValue,(ICanAsWidget)incrementalValue,(ICanAsWidget)measureDate,(ICanAsWidget)measurePerson
    					);
  }
}
