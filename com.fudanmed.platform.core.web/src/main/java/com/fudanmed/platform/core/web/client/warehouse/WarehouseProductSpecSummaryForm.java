package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.AllProductWarehouseStorageSummaryContentProvider;
import com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageSummaryListView;
import com.fudanmed.platform.core.web.shared.warehouse.AllProductWarehouseStorageSummaryContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIWarehouseProductSpecSummary;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory.IntegerItem;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory.IntegerReadonlyItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.component.form.factory.SuggestionComboBoxSelector;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WarehouseProductSpecSummaryForm extends GXTFormComponent<UIWarehouseProductSpecSummary> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public SuggestionComboBoxSelector<UIProductWarehouseStorageSummary> storageSummary;
  
  @Inject
  public AllProductWarehouseStorageSummaryContentProvider storageSummaryContentProvider;
  
  public IntegerItem quantity;
  
  public IntegerReadonlyItem sourceQuantity;
  
  public TextItem productSid;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIWarehouseProductSpecSummary value = new UIWarehouseProductSpecSummary();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();storageSummary = defaultObjectSelectorFactory.createAsRequiredSuggestionItem("storageSummary","物品",this.productWarehouseStorageList);
    storageSummary.setContentProvider(storageSummaryContentProvider);
    widgetsRegistory.put("storageSummary",storageSummary);
    quantity = integerValueProviderFactory.createAsRequiredIntegerItem("quantity","数量");
    widgetsRegistory.put("quantity",quantity);
    sourceQuantity = integerValueProviderFactory.createAsReadonlyItem("sourceQuantity","库存数量");
    widgetsRegistory.put("sourceQuantity",sourceQuantity);
    productSid = stringValueProviderFactory.createAsTextItem("productSid","条码");
    widgetsRegistory.put("productSid",productSid);
    if(productWarehouseStorageList instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)productWarehouseStorageList);
    						}if(con instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
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
  
  public UIWarehouseProductSpecSummary getValueAsNew() {
    UIWarehouseProductSpecSummary value = new UIWarehouseProductSpecSummary();
    value.setStorageSummary(storageSummary.getValue());
    value.setQuantity(quantity.getValue());
    value.setSourceQuantity(sourceQuantity.getValue());
    value.setProductSid(productSid.getValue());
    return value;
  }
  
  public UIWarehouseProductSpecSummary doGetValue() {
    
    value.setStorageSummary(storageSummary.getValue());
    value.setQuantity(quantity.getValue());
    value.setSourceQuantity(sourceQuantity.getValue());
    value.setProductSid(productSid.getValue());
    return value;
  }
  
  public UIWarehouseProductSpecSummary getValue(final UIWarehouseProductSpecSummary copyValue) {
    
    copyValue.setStorageSummary(storageSummary.getValue());
    copyValue.setQuantity(quantity.getValue());
    copyValue.setSourceQuantity(sourceQuantity.getValue());
    copyValue.setProductSid(productSid.getValue());
    return copyValue;
  }
  
  protected WarehouseProductSpecSummaryForm doSetValue(final UIWarehouseProductSpecSummary value) {
    this.value = value;
    storageSummary.setValue(value.getStorageSummary());
    quantity.setValue(value.getQuantity());
    sourceQuantity.setValue(value.getSourceQuantity());
    productSid.setValue(value.getProductSid());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)storageSummary,(ICanAsWidget)quantity,(ICanAsWidget)sourceQuantity,(ICanAsWidget)productSid
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = WarehouseProductSpecSummaryForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldLabel _asWidget = WarehouseProductSpecSummaryForm.this.storageSummary.asWidget();
                final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                    public void apply(final FieldLabel it) {
                      final Procedure1<Iterable<UIProductWarehouseStorageSummary>> _function = new Procedure1<Iterable<UIProductWarehouseStorageSummary>>() {
                          public void apply(final Iterable<UIProductWarehouseStorageSummary> it) {
                            UIProductWarehouseStorageSummary _head = IterableExtensions.<UIProductWarehouseStorageSummary>head(it);
                            Integer _quantity = _head.getQuantity();
                            WarehouseProductSpecSummaryForm.this.sourceQuantity.setValue(_quantity);
                          }
                        };
                      WarehouseProductSpecSummaryForm.this.storageSummary.addSelectionChangedListener(new SelectionChangedListener<UIProductWarehouseStorageSummary>() {
                          public void selectionChanged(Iterable<UIProductWarehouseStorageSummary> selections) {
                            _function.apply(selections);
                          }
                      });
                    }
                  };
                FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
                WidgetExtensions.<FieldLabel>addFill(it, _doubleArrow);
                FieldLabel _asWidget_1 = WarehouseProductSpecSummaryForm.this.sourceQuantity.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_1);
                FieldLabel _asWidget_2 = WarehouseProductSpecSummaryForm.this.quantity.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_2);
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
  
  public void setSourceWarehouse(final RCWarehouseProxy store) {
    AllProductWarehouseStorageSummaryContentProviderCriteria _createCriteria = this.storageSummaryContentProvider.createCriteria();
    final Procedure1<AllProductWarehouseStorageSummaryContentProviderCriteria> _function = new Procedure1<AllProductWarehouseStorageSummaryContentProviderCriteria>() {
        public void apply(final AllProductWarehouseStorageSummaryContentProviderCriteria it) {
          it.setStore(store);
        }
      };
    ObjectExtensions.<AllProductWarehouseStorageSummaryContentProviderCriteria>operator_doubleArrow(_createCriteria, _function);
  }
  
  @Inject
  private ProductWarehouseStorageSummaryListView productWarehouseStorageList;
  
  private Widget con;
}
