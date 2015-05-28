package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UISettlement;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DoubleValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DoubleValueProviderFactory.DoubleColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class SettlementListGrid extends GXTGridComponent<UISettlement> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UISettlement> sid;
  
  public DateColumn<UISettlement> date;
  
  public DateColumn<UISettlement> fromDate;
  
  public DateColumn<UISettlement> toDate;
  
  public StringColumn<UISettlement> description;
  
  public DoubleColumn<UISettlement> totalAmount;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  private UISettlement value = new UISettlement();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsStringColumn("sid","结算单号",UISettlement.SidAccessor);
    widgetsRegistory.put("sid",sid);
    date = dateValueProviderFactory.createAsStringColumn("date","结算时间",UISettlement.DateAccessor);
    widgetsRegistory.put("date",date);
    fromDate = dateValueProviderFactory.createAsStringColumn("fromDate","起始时间",UISettlement.FromDateAccessor);
    widgetsRegistory.put("fromDate",fromDate);
    toDate = dateValueProviderFactory.createAsStringColumn("toDate","结束时间",UISettlement.ToDateAccessor);
    widgetsRegistory.put("toDate",toDate);
    description = stringValueProviderFactory.createAsStringColumn("description","说明",UISettlement.DescriptionAccessor,Integer.valueOf(100));
    widgetsRegistory.put("description",description);
    totalAmount = doubleValueProviderFactory.createAsDoubleColumn("totalAmount","结算金额",UISettlement.TotalAmountAccessor);
    widgetsRegistory.put("totalAmount",totalAmount);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UISettlement getValueAsNew() {
    UISettlement value = new UISettlement();
    value.setSid(sid.getValue());
    value.setDate(date.getValue());
    value.setFromDate(fromDate.getValue());
    value.setToDate(toDate.getValue());
    value.setDescription(description.getValue());
    value.setTotalAmount(totalAmount.getValue());
    return value;
  }
  
  public UISettlement doGetValue() {
    
    value.setSid(sid.getValue());
    value.setDate(date.getValue());
    value.setFromDate(fromDate.getValue());
    value.setToDate(toDate.getValue());
    value.setDescription(description.getValue());
    value.setTotalAmount(totalAmount.getValue());
    return value;
  }
  
  public UISettlement getValue(final UISettlement copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setDate(date.getValue());
    copyValue.setFromDate(fromDate.getValue());
    copyValue.setToDate(toDate.getValue());
    copyValue.setDescription(description.getValue());
    copyValue.setTotalAmount(totalAmount.getValue());
    return copyValue;
  }
  
  protected SettlementListGrid doSetValue(final UISettlement value) {
    this.value = value;
    sid.setValue(value.getSid());
    date.setValue(value.getDate());
    fromDate.setValue(value.getFromDate());
    toDate.setValue(value.getToDate());
    description.setValue(value.getDescription());
    totalAmount.setValue(value.getTotalAmount());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)date,(ICanAsWidget)fromDate,(ICanAsWidget)toDate,(ICanAsWidget)description,(ICanAsWidget)totalAmount
    					);
  }
}
