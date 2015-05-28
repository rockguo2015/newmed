package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.AllWarehouseByManagerContentProvider;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingList;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.ComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextAreaItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class StockTakingListForm extends GXTFormComponent<UIStockTakingList> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public ComboBoxSelector<RCWarehouseProxy> warehouse;
  
  @Inject
  public AllWarehouseByManagerContentProvider warehouseContentProvider;
  
  public TextAreaItem comment;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIStockTakingList value = new UIStockTakingList();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();warehouse = defaultObjectSelectorFactory.createAsComboBoxItem("warehouse","盘点仓库");
    warehouse.setContentProvider(warehouseContentProvider);
    widgetsRegistory.put("warehouse",warehouse);
    comment = stringValueProviderFactory.createAsTextAreaItem("comment","备注");
    widgetsRegistory.put("comment",comment);
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
  
  public UIStockTakingList getValueAsNew() {
    UIStockTakingList value = new UIStockTakingList();
    value.setWarehouse(warehouse.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIStockTakingList doGetValue() {
    
    value.setWarehouse(warehouse.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIStockTakingList getValue(final UIStockTakingList copyValue) {
    
    copyValue.setWarehouse(warehouse.getValue());
    copyValue.setComment(comment.getValue());
    return copyValue;
  }
  
  protected StockTakingListForm doSetValue(final UIStockTakingList value) {
    this.value = value;
    warehouse.setValue(value.getWarehouse());
    comment.setValue(value.getComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)warehouse,(ICanAsWidget)comment
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
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = StockTakingListForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldLabel _asWidget = StockTakingListForm.this.warehouse.asWidget();
                int _minus = (-1);
                VerticalLayoutData _VLayoutData = StockTakingListForm.this.widgets.VLayoutData(1, _minus);
                it.add(_asWidget, _VLayoutData);
                FieldLabel _asWidget_1 = StockTakingListForm.this.comment.asWidget();
                VerticalLayoutData _VLayoutData_1 = StockTakingListForm.this.widgets.VLayoutData(525, 60);
                it.add(_asWidget_1, _VLayoutData_1);
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
