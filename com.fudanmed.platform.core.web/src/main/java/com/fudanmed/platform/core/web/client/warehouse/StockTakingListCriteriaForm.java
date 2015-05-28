package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.AllWarehouseByManagerContentProvider;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingListCriteria;
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
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class StockTakingListCriteriaForm extends GXTFormComponent<UIStockTakingListCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public ComboBoxSelector<RCWarehouseProxy> warehouse;
  
  @Inject
  public AllWarehouseByManagerContentProvider warehouseContentProvider;
  
  public DateItem dateFrom;
  
  public DateItem dateTo;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UIStockTakingListCriteria value = new UIStockTakingListCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();warehouse = defaultObjectSelectorFactory.createAsComboBoxItem("warehouse","仓库");
    warehouse.setContentProvider(warehouseContentProvider);
    widgetsRegistory.put("warehouse",warehouse);
    dateFrom = dateValueProviderFactory.createAsDateItem("dateFrom","起始时间");
    widgetsRegistory.put("dateFrom",dateFrom);
    dateTo = dateValueProviderFactory.createAsDateItem("dateTo","结束时间");
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
  
  public UIStockTakingListCriteria getValueAsNew() {
    UIStockTakingListCriteria value = new UIStockTakingListCriteria();
    value.setWarehouse(warehouse.getValue());
    value.setDateFrom(dateFrom.getValue());
    value.setDateTo(dateTo.getValue());
    return value;
  }
  
  public UIStockTakingListCriteria doGetValue() {
    
    value.setWarehouse(warehouse.getValue());
    value.setDateFrom(dateFrom.getValue());
    value.setDateTo(dateTo.getValue());
    return value;
  }
  
  public UIStockTakingListCriteria getValue(final UIStockTakingListCriteria copyValue) {
    
    copyValue.setWarehouse(warehouse.getValue());
    copyValue.setDateFrom(dateFrom.getValue());
    copyValue.setDateTo(dateTo.getValue());
    return copyValue;
  }
  
  protected StockTakingListCriteriaForm doSetValue(final UIStockTakingListCriteria value) {
    this.value = value;
    warehouse.setValue(value.getWarehouse());
    dateFrom.setValue(value.getDateFrom());
    dateTo.setValue(value.getDateTo());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)warehouse,(ICanAsWidget)dateFrom,(ICanAsWidget)dateTo
    					);
  }
  
  public void setSourceWarehouseContext(final RCEmployeeProxy employee, final Procedure1<? super Void> notifier) {
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          notifier.apply(null);
        }
      };
    this.warehouseContentProvider.load(employee, _function);
  }
}
