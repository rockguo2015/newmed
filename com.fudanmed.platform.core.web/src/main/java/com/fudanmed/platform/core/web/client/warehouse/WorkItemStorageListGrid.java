package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStorage;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.grid.AggregationRowConfig;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.shared.extensions.NumberExtensions;
import edu.fudan.langlab.gxt.client.component.grid.AggregationExtensions;
import edu.fudan.langlab.gxt.client.component.grid.ColumnRenderPair;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DoubleValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DoubleValueProviderFactory.DoubleColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.IntegerValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.IntegerValueProviderFactory.IntegerColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

public class WorkItemStorageListGrid extends GXTGridComponent<UIWorkItemStorage> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UIWorkItemStorage,RCWorkItemTaskProxy> workItem;
  
  public StringColumn<UIWorkItemStorage> sid;
  
  public StringColumn<UIWorkItemStorage> productSid;
  
  public StringColumn<UIWorkItemStorage> materialId;
  
  public StringValueColumn<UIWorkItemStorage,RCProductSpecificationProxy> productSpec;
  
  public StringColumn<UIWorkItemStorage> typeDesc;
  
  public StringValueColumn<UIWorkItemStorage,RCMaterialBrandProxy> brand;
  
  public DoubleColumn<UIWorkItemStorage> price;
  
  public IntegerColumn<UIWorkItemStorage> quantity;
  
  public StringValueColumn<UIWorkItemStorage,RCProduceSpecificationUnitProxy> unit;
  
  public DoubleColumn<UIWorkItemStorage> amount;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIWorkItemStorage value = new UIWorkItemStorage();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();workItem = defaultObjectSelectorFactory.createAsStringColumn("workItem","工单编号",UIWorkItemStorage.WorkItemAccessor,Integer.valueOf(130));
    widgetsRegistory.put("workItem",workItem);
    sid = stringValueProviderFactory.createAsStringColumn("sid","入库批号",UIWorkItemStorage.SidAccessor,Integer.valueOf(130));
    widgetsRegistory.put("sid",sid);
    productSid = stringValueProviderFactory.createAsStringColumn("productSid","条码",UIWorkItemStorage.ProductSidAccessor,Integer.valueOf(130));
    widgetsRegistory.put("productSid",productSid);
    materialId = stringValueProviderFactory.createAsStringColumn("materialId","物品编号",UIWorkItemStorage.MaterialIdAccessor);
    widgetsRegistory.put("materialId",materialId);
    productSpec = defaultObjectSelectorFactory.createAsStringColumn("productSpec","物品名称",UIWorkItemStorage.ProductSpecAccessor,Integer.valueOf(150));
    widgetsRegistory.put("productSpec",productSpec);
    typeDesc = stringValueProviderFactory.createAsStringColumn("typeDesc","规格型号",UIWorkItemStorage.TypeDescAccessor,Integer.valueOf(130));
    widgetsRegistory.put("typeDesc",typeDesc);
    brand = defaultObjectSelectorFactory.createAsDefaultColumn("brand","品牌",UIWorkItemStorage.BrandAccessor);
    widgetsRegistory.put("brand",brand);
    price = doubleValueProviderFactory.createAsDoubleColumn("price","单价",UIWorkItemStorage.PriceAccessor);
    widgetsRegistory.put("price",price);
    quantity = integerValueProviderFactory.createAsIntegerColumn("quantity","数量",UIWorkItemStorage.QuantityAccessor);
    widgetsRegistory.put("quantity",quantity);
    unit = defaultObjectSelectorFactory.createAsStringColumn("unit","计量单位",UIWorkItemStorage.UnitAccessor,Integer.valueOf(87));
    widgetsRegistory.put("unit",unit);
    amount = doubleValueProviderFactory.createAsDoubleColumn("amount","金额",UIWorkItemStorage.AmountAccessor);
    widgetsRegistory.put("amount",amount);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIWorkItemStorage getValueAsNew() {
    UIWorkItemStorage value = new UIWorkItemStorage();
    value.setWorkItem(workItem.getValue());
    value.setSid(sid.getValue());
    value.setProductSid(productSid.getValue());
    value.setMaterialId(materialId.getValue());
    value.setProductSpec(productSpec.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setBrand(brand.getValue());
    value.setPrice(price.getValue());
    value.setQuantity(quantity.getValue());
    value.setUnit(unit.getValue());
    value.setAmount(amount.getValue());
    return value;
  }
  
  public UIWorkItemStorage doGetValue() {
    
    value.setWorkItem(workItem.getValue());
    value.setSid(sid.getValue());
    value.setProductSid(productSid.getValue());
    value.setMaterialId(materialId.getValue());
    value.setProductSpec(productSpec.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setBrand(brand.getValue());
    value.setPrice(price.getValue());
    value.setQuantity(quantity.getValue());
    value.setUnit(unit.getValue());
    value.setAmount(amount.getValue());
    return value;
  }
  
  public UIWorkItemStorage getValue(final UIWorkItemStorage copyValue) {
    
    copyValue.setWorkItem(workItem.getValue());
    copyValue.setSid(sid.getValue());
    copyValue.setProductSid(productSid.getValue());
    copyValue.setMaterialId(materialId.getValue());
    copyValue.setProductSpec(productSpec.getValue());
    copyValue.setTypeDesc(typeDesc.getValue());
    copyValue.setBrand(brand.getValue());
    copyValue.setPrice(price.getValue());
    copyValue.setQuantity(quantity.getValue());
    copyValue.setUnit(unit.getValue());
    copyValue.setAmount(amount.getValue());
    return copyValue;
  }
  
  protected WorkItemStorageListGrid doSetValue(final UIWorkItemStorage value) {
    this.value = value;
    workItem.setValue(value.getWorkItem());
    sid.setValue(value.getSid());
    productSid.setValue(value.getProductSid());
    materialId.setValue(value.getMaterialId());
    productSpec.setValue(value.getProductSpec());
    typeDesc.setValue(value.getTypeDesc());
    brand.setValue(value.getBrand());
    price.setValue(value.getPrice());
    quantity.setValue(value.getQuantity());
    unit.setValue(value.getUnit());
    amount.setValue(value.getAmount());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)workItem,(ICanAsWidget)sid,(ICanAsWidget)productSid,(ICanAsWidget)materialId,(ICanAsWidget)productSpec,(ICanAsWidget)typeDesc,(ICanAsWidget)brand,(ICanAsWidget)price,(ICanAsWidget)quantity,(ICanAsWidget)unit,(ICanAsWidget)amount
    					);
  }
  
  public void initializeComponent() {
    this.asWidget();
    this.unForceFit();
    AggregationRowConfig<UIWorkItemStorage> _createSummaryRow = AggregationExtensions.createSummaryRow(this);
    final Procedure1<AggregationRowConfig<UIWorkItemStorage>> _function = new Procedure1<AggregationRowConfig<UIWorkItemStorage>>() {
        public void apply(final AggregationRowConfig<UIWorkItemStorage> it) {
          final Procedure2<SafeHtmlBuilder,Object> _function = new Procedure2<SafeHtmlBuilder,Object>() {
              public void apply(final SafeHtmlBuilder sb, final Object state) {
                sb.appendHtmlConstant("\u5408\u8BA1");
              }
            };
          ColumnRenderPair<UIWorkItemStorage> _renderSummaryColumn = AggregationExtensions.<UIWorkItemStorage>renderSummaryColumn(WorkItemStorageListGrid.this.workItem, _function);
          AggregationExtensions.<UIWorkItemStorage>operator_add(it, _renderSummaryColumn);
          final Procedure2<SafeHtmlBuilder,Object> _function_1 = new Procedure2<SafeHtmlBuilder,Object>() {
              public void apply(final SafeHtmlBuilder sb, final Object state) {
                Iterable<UIWorkItemStorage> _objects = WorkItemStorageListGrid.this.getObjects();
                final Function1<UIWorkItemStorage,Double> _function = new Function1<UIWorkItemStorage,Double>() {
                    public Double apply(final UIWorkItemStorage it) {
                      Double _amount = it.getAmount();
                      return _amount;
                    }
                  };
                Iterable<Double> _map = IterableExtensions.<UIWorkItemStorage, Double>map(_objects, _function);
                final Function2<Double,Double,Double> _function_1 = new Function2<Double,Double,Double>() {
                    public Double apply(final Double d1, final Double d2) {
                      double _plus = DoubleExtensions.operator_plus(d1, d2);
                      return Double.valueOf(_plus);
                    }
                  };
                Double _reduce = IterableExtensions.<Double>reduce(_map, _function_1);
                Double _nullsafe = NumberExtensions.nullsafe(_reduce);
                String _string = _nullsafe.toString();
                sb.appendHtmlConstant(_string);
              }
            };
          ColumnRenderPair<UIWorkItemStorage> _renderSummaryColumn_1 = AggregationExtensions.<UIWorkItemStorage>renderSummaryColumn(WorkItemStorageListGrid.this.amount, _function_1);
          AggregationExtensions.<UIWorkItemStorage>operator_add(it, _renderSummaryColumn_1);
        }
      };
    ObjectExtensions.<AggregationRowConfig<UIWorkItemStorage>>operator_doubleArrow(_createSummaryRow, _function);
  }
}
