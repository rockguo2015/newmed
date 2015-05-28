package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.AllWarehouseContentProvider;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecordCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.ComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class TransferRecordCriteriaForm extends GXTFormComponent<UITransferRecordCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public ComboBoxSelector<RCWarehouseProxy> targetStore;
  
  @Inject
  public AllWarehouseContentProvider targetStoreContentProvider;
  
  public DateItem dateFrom;
  
  public DateItem dateTo;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UITransferRecordCriteria value = new UITransferRecordCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();targetStore = defaultObjectSelectorFactory.createAsComboBoxItem("targetStore","入库仓库");
    _initializerSupports.add(targetStoreContentProvider);
    targetStore.setContentProvider(targetStoreContentProvider);
    widgetsRegistory.put("targetStore",targetStore);
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
  
  public UITransferRecordCriteria getValueAsNew() {
    UITransferRecordCriteria value = new UITransferRecordCriteria();
    value.setTargetStore(targetStore.getValue());
    value.setDateFrom(dateFrom.getValue());
    value.setDateTo(dateTo.getValue());
    return value;
  }
  
  public UITransferRecordCriteria doGetValue() {
    
    value.setTargetStore(targetStore.getValue());
    value.setDateFrom(dateFrom.getValue());
    value.setDateTo(dateTo.getValue());
    return value;
  }
  
  public UITransferRecordCriteria getValue(final UITransferRecordCriteria copyValue) {
    
    copyValue.setTargetStore(targetStore.getValue());
    copyValue.setDateFrom(dateFrom.getValue());
    copyValue.setDateTo(dateTo.getValue());
    return copyValue;
  }
  
  protected TransferRecordCriteriaForm doSetValue(final UITransferRecordCriteria value) {
    this.value = value;
    targetStore.setValue(value.getTargetStore());
    dateFrom.setValue(value.getDateFrom());
    dateTo.setValue(value.getDateTo());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)targetStore,(ICanAsWidget)dateFrom,(ICanAsWidget)dateTo
    					);
  }
}
