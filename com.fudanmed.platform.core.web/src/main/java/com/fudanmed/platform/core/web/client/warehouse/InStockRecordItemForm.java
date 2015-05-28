package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.AllProductSpecificationContentProvider;
import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationListView;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecordItem;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DoubleValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DoubleValueProviderFactory.DoubleItem;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory.IntegerItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.component.form.factory.SuggestionComboBoxSelector;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class InStockRecordItemForm extends GXTFormComponent<UIInStockRecordItem> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem sid;
  
  public SuggestionComboBoxSelector<UIProductSpecification> uiProductSpec;
  
  @Inject
  public AllProductSpecificationContentProvider uiProductSpecContentProvider;
  
  public TextItem productSid;
  
  public DoubleItem price;
  
  public IntegerItem quantity;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIInStockRecordItem value = new UIInStockRecordItem();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsTextItem("sid","入库批号");
    widgetsRegistory.put("sid",sid);
    uiProductSpec = defaultObjectSelectorFactory.createAsRequiredSuggestionItem("uiProductSpec","物品名称",this.productSpecificationListView);
    uiProductSpec.setContentProvider(uiProductSpecContentProvider);
    widgetsRegistory.put("uiProductSpec",uiProductSpec);
    productSid = stringValueProviderFactory.createAsTextItem("productSid","条码");
    widgetsRegistory.put("productSid",productSid);
    price = doubleValueProviderFactory.createAsRequiredDoubleItem("price","单价");
    widgetsRegistory.put("price",price);
    quantity = integerValueProviderFactory.createAsRequiredIntegerItem("quantity","数量");
    widgetsRegistory.put("quantity",quantity);
    if(productSpecificationListView instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)productSpecificationListView);
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
  
  public UIInStockRecordItem getValueAsNew() {
    UIInStockRecordItem value = new UIInStockRecordItem();
    value.setSid(sid.getValue());
    value.setUiProductSpec(uiProductSpec.getValue());
    value.setProductSid(productSid.getValue());
    value.setPrice(price.getValue());
    value.setQuantity(quantity.getValue());
    return value;
  }
  
  public UIInStockRecordItem doGetValue() {
    
    value.setSid(sid.getValue());
    value.setUiProductSpec(uiProductSpec.getValue());
    value.setProductSid(productSid.getValue());
    value.setPrice(price.getValue());
    value.setQuantity(quantity.getValue());
    return value;
  }
  
  public UIInStockRecordItem getValue(final UIInStockRecordItem copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setUiProductSpec(uiProductSpec.getValue());
    copyValue.setProductSid(productSid.getValue());
    copyValue.setPrice(price.getValue());
    copyValue.setQuantity(quantity.getValue());
    return copyValue;
  }
  
  protected InStockRecordItemForm doSetValue(final UIInStockRecordItem value) {
    this.value = value;
    sid.setValue(value.getSid());
    uiProductSpec.setValue(value.getUiProductSpec());
    productSid.setValue(value.getProductSid());
    price.setValue(value.getPrice());
    quantity.setValue(value.getQuantity());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)uiProductSpec,(ICanAsWidget)productSid,(ICanAsWidget)price,(ICanAsWidget)quantity
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = InStockRecordItemForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldLabel _asWidget = InStockRecordItemForm.this.sid.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
                FieldLabel _asWidget_1 = InStockRecordItemForm.this.uiProductSpec.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_1);
                FieldLabel _asWidget_2 = InStockRecordItemForm.this.productSid.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_2);
                FieldLabel _asWidget_3 = InStockRecordItemForm.this.price.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_3);
                FieldLabel _asWidget_4 = InStockRecordItemForm.this.quantity.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_4);
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
  private ProductSpecificationListView productSpecificationListView;
  
  private Widget con;
}
