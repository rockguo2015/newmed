package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingItem;
import com.google.common.base.Objects;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.inject.Inject;
import com.sencha.gxt.data.shared.ListStore;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.ICellRender;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.IntegerValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.IntegerValueProviderFactory.IntegerColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;

public class StockTakingItemListGrid extends GXTGridComponent<UIStockTakingItem> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIStockTakingItem> productSpecsSid;
  
  public StringColumn<UIStockTakingItem> materialId;
  
  public StringColumn<UIStockTakingItem> name;
  
  public StringColumn<UIStockTakingItem> typeDesc;
  
  public StringValueColumn<UIStockTakingItem,RCMaterialBrandProxy> brand;
  
  public IntegerColumn<UIStockTakingItem> realQuantity;
  
  public StringValueColumn<UIStockTakingItem,RCProduceSpecificationUnitProxy> unit;
  
  public IntegerColumn<UIStockTakingItem> quantity;
  
  public IntegerColumn<UIStockTakingItem> balance;
  
  public StringColumn<UIStockTakingItem> comment;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIStockTakingItem value = new UIStockTakingItem();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();productSpecsSid = stringValueProviderFactory.createAsStringColumn("productSpecsSid","条码",UIStockTakingItem.ProductSpecsSidAccessor);
    widgetsRegistory.put("productSpecsSid",productSpecsSid);
    materialId = stringValueProviderFactory.createAsStringColumn("materialId","物品编号",UIStockTakingItem.MaterialIdAccessor);
    widgetsRegistory.put("materialId",materialId);
    name = stringValueProviderFactory.createAsStringColumn("name","物品名称",UIStockTakingItem.NameAccessor);
    widgetsRegistory.put("name",name);
    typeDesc = stringValueProviderFactory.createAsStringColumn("typeDesc","规格型号",UIStockTakingItem.TypeDescAccessor);
    widgetsRegistory.put("typeDesc",typeDesc);
    brand = defaultObjectSelectorFactory.createAsDefaultColumn("brand","品牌",UIStockTakingItem.BrandAccessor);
    widgetsRegistory.put("brand",brand);
    realQuantity = integerValueProviderFactory.createAsIntegerColumn("realQuantity","库存数量",UIStockTakingItem.RealQuantityAccessor);
    widgetsRegistory.put("realQuantity",realQuantity);
    unit = defaultObjectSelectorFactory.createAsDefaultColumn("unit","计量单位",UIStockTakingItem.UnitAccessor);
    widgetsRegistory.put("unit",unit);
    quantity = integerValueProviderFactory.createAsIntegerColumn("quantity","实盘数量",UIStockTakingItem.QuantityAccessor);
    widgetsRegistory.put("quantity",quantity);
    balance = integerValueProviderFactory.createAsIntegerColumn("balance","盈亏差异",UIStockTakingItem.BalanceAccessor);
    widgetsRegistory.put("balance",balance);
    comment = stringValueProviderFactory.createAsStringColumn("comment","异动原因",UIStockTakingItem.CommentAccessor);
    widgetsRegistory.put("comment",comment);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIStockTakingItem getValueAsNew() {
    UIStockTakingItem value = new UIStockTakingItem();
    value.setProductSpecsSid(productSpecsSid.getValue());
    value.setMaterialId(materialId.getValue());
    value.setName(name.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setBrand(brand.getValue());
    value.setRealQuantity(realQuantity.getValue());
    value.setUnit(unit.getValue());
    value.setQuantity(quantity.getValue());
    value.setBalance(balance.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIStockTakingItem doGetValue() {
    
    value.setProductSpecsSid(productSpecsSid.getValue());
    value.setMaterialId(materialId.getValue());
    value.setName(name.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setBrand(brand.getValue());
    value.setRealQuantity(realQuantity.getValue());
    value.setUnit(unit.getValue());
    value.setQuantity(quantity.getValue());
    value.setBalance(balance.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIStockTakingItem getValue(final UIStockTakingItem copyValue) {
    
    copyValue.setProductSpecsSid(productSpecsSid.getValue());
    copyValue.setMaterialId(materialId.getValue());
    copyValue.setName(name.getValue());
    copyValue.setTypeDesc(typeDesc.getValue());
    copyValue.setBrand(brand.getValue());
    copyValue.setRealQuantity(realQuantity.getValue());
    copyValue.setUnit(unit.getValue());
    copyValue.setQuantity(quantity.getValue());
    copyValue.setBalance(balance.getValue());
    copyValue.setComment(comment.getValue());
    return copyValue;
  }
  
  protected StockTakingItemListGrid doSetValue(final UIStockTakingItem value) {
    this.value = value;
    productSpecsSid.setValue(value.getProductSpecsSid());
    materialId.setValue(value.getMaterialId());
    name.setValue(value.getName());
    typeDesc.setValue(value.getTypeDesc());
    brand.setValue(value.getBrand());
    realQuantity.setValue(value.getRealQuantity());
    unit.setValue(value.getUnit());
    quantity.setValue(value.getQuantity());
    balance.setValue(value.getBalance());
    comment.setValue(value.getComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)productSpecsSid,(ICanAsWidget)materialId,(ICanAsWidget)name,(ICanAsWidget)typeDesc,(ICanAsWidget)brand,(ICanAsWidget)realQuantity,(ICanAsWidget)unit,(ICanAsWidget)quantity,(ICanAsWidget)balance,(ICanAsWidget)comment
    					);
  }
  
  public void initializeComponent() {
    final Procedure3<Context,Integer,SafeHtmlBuilder> _function = new Procedure3<Context,Integer,SafeHtmlBuilder>() {
        public void apply(final Context context, final Integer value, final SafeHtmlBuilder sb) {
          boolean _equals = Objects.equal(value, null);
          if (_equals) {
            sb.appendHtmlConstant("\u672A\u76D8\u70B9");
          } else {
            sb.append((value).intValue());
          }
        }
      };
    this.quantity.setRender(new ICellRender<Integer>() {
        public void render(Context context,Integer value,SafeHtmlBuilder sb) {
          _function.apply(context,value,sb);
        }
    });
    final Procedure3<Context,Integer,SafeHtmlBuilder> _function_1 = new Procedure3<Context,Integer,SafeHtmlBuilder>() {
        public void apply(final Context context, final Integer value, final SafeHtmlBuilder sb) {
          ListStore<UIStockTakingItem> _store = StockTakingItemListGrid.this.grid.getStore();
          int _index = context.getIndex();
          final UIStockTakingItem m = _store.get(_index);
          Integer _xifexpression = null;
          Integer _quantity = m.getQuantity();
          boolean _equals = Objects.equal(_quantity, null);
          if (_equals) {
            _xifexpression = null;
          } else {
            Integer _quantity_1 = m.getQuantity();
            Integer _realQuantity = m.getRealQuantity();
            int _minus = ((_quantity_1).intValue() - (_realQuantity).intValue());
            _xifexpression = _minus;
          }
          final Integer b = _xifexpression;
          boolean _or = false;
          boolean _equals_1 = Objects.equal(b, null);
          if (_equals_1) {
            _or = true;
          } else {
            boolean _equals_2 = ((b).intValue() == 0);
            _or = (_equals_1 || _equals_2);
          }
          if (_or) {
            sb.appendHtmlConstant("--");
          } else {
            boolean _lessThan = ((b).intValue() < 0);
            if (_lessThan) {
              String _string = b.toString();
              String _plus = ("<font color=\'red\'>" + _string);
              String _plus_1 = (_plus + "</font>");
              sb.appendHtmlConstant(_plus_1);
            } else {
              String _string_1 = b.toString();
              String _plus_2 = ("<font color=\'green\'>" + _string_1);
              String _plus_3 = (_plus_2 + "</font>");
              sb.appendHtmlConstant(_plus_3);
            }
          }
        }
      };
    this.balance.setRender(new ICellRender<Integer>() {
        public void render(Context context,Integer value,SafeHtmlBuilder sb) {
          _function_1.apply(context,value,sb);
        }
    });
  }
}
