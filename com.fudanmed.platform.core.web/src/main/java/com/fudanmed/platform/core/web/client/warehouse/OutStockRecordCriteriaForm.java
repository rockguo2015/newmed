package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecordCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class OutStockRecordCriteriaForm extends GXTFormComponent<UIOutStockRecordCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem sid;
  
  public DateItem dateFrom;
  
  public DateItem dateTo;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIOutStockRecordCriteria value = new UIOutStockRecordCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsTextItem("sid","出库单号");
    widgetsRegistory.put("sid",sid);
    dateFrom = dateValueProviderFactory.createAsDateItem("dateFrom","起始日期");
    widgetsRegistory.put("dateFrom",dateFrom);
    dateTo = dateValueProviderFactory.createAsDateItem("dateTo","结束日期");
    widgetsRegistory.put("dateTo",dateTo);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIOutStockRecordCriteria getValueAsNew() {
    UIOutStockRecordCriteria value = new UIOutStockRecordCriteria();
    value.setSid(sid.getValue());
    value.setDateFrom(dateFrom.getValue());
    value.setDateTo(dateTo.getValue());
    return value;
  }
  
  public UIOutStockRecordCriteria doGetValue() {
    
    value.setSid(sid.getValue());
    value.setDateFrom(dateFrom.getValue());
    value.setDateTo(dateTo.getValue());
    return value;
  }
  
  public UIOutStockRecordCriteria getValue(final UIOutStockRecordCriteria copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setDateFrom(dateFrom.getValue());
    copyValue.setDateTo(dateTo.getValue());
    return copyValue;
  }
  
  protected OutStockRecordCriteriaForm doSetValue(final UIOutStockRecordCriteria value) {
    this.value = value;
    sid.setValue(value.getSid());
    dateFrom.setValue(value.getDateFrom());
    dateTo.setValue(value.getDateTo());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)dateFrom,(ICanAsWidget)dateTo
    					);
  }
}
