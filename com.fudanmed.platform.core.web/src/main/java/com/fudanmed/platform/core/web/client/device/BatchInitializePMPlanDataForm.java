package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.BatchInitializePMPlanData;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateItem;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory.IntegerItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class BatchInitializePMPlanDataForm extends GXTFormComponent<BatchInitializePMPlanData> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public IntegerItem year;
  
  public DateItem fromDate;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  private BatchInitializePMPlanData value = new BatchInitializePMPlanData();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();year = integerValueProviderFactory.createAsIntegerItem("year","截止年份");
    widgetsRegistory.put("year",year);
    fromDate = dateValueProviderFactory.createAsDateItem("fromDate","开始日期");
    widgetsRegistory.put("fromDate",fromDate);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public BatchInitializePMPlanData getValueAsNew() {
    BatchInitializePMPlanData value = new BatchInitializePMPlanData();
    value.setYear(year.getValue());
    value.setFromDate(fromDate.getValue());
    return value;
  }
  
  public BatchInitializePMPlanData doGetValue() {
    
    value.setYear(year.getValue());
    value.setFromDate(fromDate.getValue());
    return value;
  }
  
  public BatchInitializePMPlanData getValue(final BatchInitializePMPlanData copyValue) {
    
    copyValue.setYear(year.getValue());
    copyValue.setFromDate(fromDate.getValue());
    return copyValue;
  }
  
  protected BatchInitializePMPlanDataForm doSetValue(final BatchInitializePMPlanData value) {
    this.value = value;
    year.setValue(value.getYear());
    fromDate.setValue(value.getFromDate());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)year,(ICanAsWidget)fromDate
    					);
  }
}
