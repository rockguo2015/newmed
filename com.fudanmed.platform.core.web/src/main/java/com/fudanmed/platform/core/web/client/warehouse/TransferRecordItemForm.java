package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.AllProductWarehouseStorageContentProvider;
import com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageList;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorage;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecordItem;
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
import edu.fudan.langlab.gxt.client.component.form.factory.SuggestionComboBoxSelector;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class TransferRecordItemForm extends GXTFormComponent<UITransferRecordItem> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public SuggestionComboBoxSelector<UIProductWarehouseStorage> storage;
  
  @Inject
  public AllProductWarehouseStorageContentProvider storageContentProvider;
  
  public IntegerItem quantity;
  
  public IntegerReadonlyItem sourceQuantity;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  private UITransferRecordItem value = new UITransferRecordItem();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();storage = defaultObjectSelectorFactory.createAsRequiredSuggestionItem("storage","物品名称",this.productWarehouseStorageList);
    storage.setContentProvider(storageContentProvider);
    widgetsRegistory.put("storage",storage);
    quantity = integerValueProviderFactory.createAsRequiredIntegerItem("quantity","数量");
    widgetsRegistory.put("quantity",quantity);
    sourceQuantity = integerValueProviderFactory.createAsReadonlyItem("sourceQuantity","库存");
    widgetsRegistory.put("sourceQuantity",sourceQuantity);
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
  
  public UITransferRecordItem getValueAsNew() {
    UITransferRecordItem value = new UITransferRecordItem();
    value.setStorage(storage.getValue());
    value.setQuantity(quantity.getValue());
    value.setSourceQuantity(sourceQuantity.getValue());
    return value;
  }
  
  public UITransferRecordItem doGetValue() {
    
    value.setStorage(storage.getValue());
    value.setQuantity(quantity.getValue());
    value.setSourceQuantity(sourceQuantity.getValue());
    return value;
  }
  
  public UITransferRecordItem getValue(final UITransferRecordItem copyValue) {
    
    copyValue.setStorage(storage.getValue());
    copyValue.setQuantity(quantity.getValue());
    copyValue.setSourceQuantity(sourceQuantity.getValue());
    return copyValue;
  }
  
  protected TransferRecordItemForm doSetValue(final UITransferRecordItem value) {
    this.value = value;
    storage.setValue(value.getStorage());
    quantity.setValue(value.getQuantity());
    sourceQuantity.setValue(value.getSourceQuantity());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)storage,(ICanAsWidget)quantity,(ICanAsWidget)sourceQuantity
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = TransferRecordItemForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldLabel _asWidget = TransferRecordItemForm.this.storage.asWidget();
                final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                    public void apply(final FieldLabel it) {
                      final Procedure1<Iterable<UIProductWarehouseStorage>> _function = new Procedure1<Iterable<UIProductWarehouseStorage>>() {
                          public void apply(final Iterable<UIProductWarehouseStorage> it) {
                            UIProductWarehouseStorage _head = IterableExtensions.<UIProductWarehouseStorage>head(it);
                            Integer _quantity = _head.getQuantity();
                            TransferRecordItemForm.this.sourceQuantity.setValue(_quantity);
                          }
                        };
                      TransferRecordItemForm.this.storage.addSelectionChangedListener(new SelectionChangedListener<UIProductWarehouseStorage>() {
                          public void selectionChanged(Iterable<UIProductWarehouseStorage> selections) {
                            _function.apply(selections);
                          }
                      });
                    }
                  };
                FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
                WidgetExtensions.<FieldLabel>addFill(it, _doubleArrow);
                FieldLabel _asWidget_1 = TransferRecordItemForm.this.sourceQuantity.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_1);
                FieldLabel _asWidget_2 = TransferRecordItemForm.this.quantity.asWidget();
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
  
  @Inject
  private ProductWarehouseStorageList productWarehouseStorageList;
  
  private Widget con;
}
