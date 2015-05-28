package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStorage4Settlement;
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
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
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

public class WorkItemStorage4SettlementListGrid extends GXTGridComponent<UIWorkItemStorage4Settlement> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIWorkItemStorage4Settlement> repairTaskInfo;
  
  public StringColumn<UIWorkItemStorage4Settlement> sid;
  
  public StringColumn<UIWorkItemStorage4Settlement> productSid;
  
  public StringColumn<UIWorkItemStorage4Settlement> materialId;
  
  public StringValueColumn<UIWorkItemStorage4Settlement,RCProductSpecificationProxy> productSpec;
  
  public StringColumn<UIWorkItemStorage4Settlement> typeDesc;
  
  public StringValueColumn<UIWorkItemStorage4Settlement,RCMaterialBrandProxy> brand;
  
  public DoubleColumn<UIWorkItemStorage4Settlement> price;
  
  public IntegerColumn<UIWorkItemStorage4Settlement> quantity;
  
  public StringValueColumn<UIWorkItemStorage4Settlement,RCProduceSpecificationUnitProxy> unit;
  
  public DoubleColumn<UIWorkItemStorage4Settlement> amount;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIWorkItemStorage4Settlement value = new UIWorkItemStorage4Settlement();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();repairTaskInfo = stringValueProviderFactory.createAsStringColumn("repairTaskInfo","repairTaskInfo",UIWorkItemStorage4Settlement.RepairTaskInfoAccessor);
    widgetsRegistory.put("repairTaskInfo",repairTaskInfo);
    sid = stringValueProviderFactory.createAsStringColumn("sid","入库批号",UIWorkItemStorage4Settlement.SidAccessor);
    widgetsRegistory.put("sid",sid);
    productSid = stringValueProviderFactory.createAsStringColumn("productSid","条码",UIWorkItemStorage4Settlement.ProductSidAccessor);
    widgetsRegistory.put("productSid",productSid);
    materialId = stringValueProviderFactory.createAsStringColumn("materialId","物品编号",UIWorkItemStorage4Settlement.MaterialIdAccessor);
    widgetsRegistory.put("materialId",materialId);
    productSpec = defaultObjectSelectorFactory.createAsDefaultColumn("productSpec","物品名称",UIWorkItemStorage4Settlement.ProductSpecAccessor);
    widgetsRegistory.put("productSpec",productSpec);
    typeDesc = stringValueProviderFactory.createAsStringColumn("typeDesc","规格型号",UIWorkItemStorage4Settlement.TypeDescAccessor);
    widgetsRegistory.put("typeDesc",typeDesc);
    brand = defaultObjectSelectorFactory.createAsDefaultColumn("brand","品牌",UIWorkItemStorage4Settlement.BrandAccessor);
    widgetsRegistory.put("brand",brand);
    price = doubleValueProviderFactory.createAsDoubleColumn("price","单价",UIWorkItemStorage4Settlement.PriceAccessor);
    widgetsRegistory.put("price",price);
    quantity = integerValueProviderFactory.createAsIntegerColumn("quantity","数量",UIWorkItemStorage4Settlement.QuantityAccessor);
    widgetsRegistory.put("quantity",quantity);
    unit = defaultObjectSelectorFactory.createAsDefaultColumn("unit","计量单位",UIWorkItemStorage4Settlement.UnitAccessor);
    widgetsRegistory.put("unit",unit);
    amount = doubleValueProviderFactory.createAsDoubleColumn("amount","金额",UIWorkItemStorage4Settlement.AmountAccessor);
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
  
  public UIWorkItemStorage4Settlement getValueAsNew() {
    UIWorkItemStorage4Settlement value = new UIWorkItemStorage4Settlement();
    value.setRepairTaskInfo(repairTaskInfo.getValue());
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
  
  public UIWorkItemStorage4Settlement doGetValue() {
    
    value.setRepairTaskInfo(repairTaskInfo.getValue());
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
  
  public UIWorkItemStorage4Settlement getValue(final UIWorkItemStorage4Settlement copyValue) {
    
    copyValue.setRepairTaskInfo(repairTaskInfo.getValue());
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
  
  protected WorkItemStorage4SettlementListGrid doSetValue(final UIWorkItemStorage4Settlement value) {
    this.value = value;
    repairTaskInfo.setValue(value.getRepairTaskInfo());
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
    					(ICanAsWidget)repairTaskInfo,(ICanAsWidget)sid,(ICanAsWidget)productSid,(ICanAsWidget)materialId,(ICanAsWidget)productSpec,(ICanAsWidget)typeDesc,(ICanAsWidget)brand,(ICanAsWidget)price,(ICanAsWidget)quantity,(ICanAsWidget)unit,(ICanAsWidget)amount
    					);
  }
  
  public void initializeComponent() {
    AggregationRowConfig<UIWorkItemStorage4Settlement> _createSummaryRow = AggregationExtensions.createSummaryRow(this);
    final Procedure1<AggregationRowConfig<UIWorkItemStorage4Settlement>> _function = new Procedure1<AggregationRowConfig<UIWorkItemStorage4Settlement>>() {
        public void apply(final AggregationRowConfig<UIWorkItemStorage4Settlement> it) {
          final Procedure2<SafeHtmlBuilder,Object> _function = new Procedure2<SafeHtmlBuilder,Object>() {
              public void apply(final SafeHtmlBuilder sb, final Object state) {
                sb.appendHtmlConstant("\u5408\u8BA1");
              }
            };
          ColumnRenderPair<UIWorkItemStorage4Settlement> _renderSummaryColumn = AggregationExtensions.<UIWorkItemStorage4Settlement>renderSummaryColumn(WorkItemStorage4SettlementListGrid.this.productSpec, _function);
          AggregationExtensions.<UIWorkItemStorage4Settlement>operator_add(it, _renderSummaryColumn);
          final Procedure2<SafeHtmlBuilder,Object> _function_1 = new Procedure2<SafeHtmlBuilder,Object>() {
              public void apply(final SafeHtmlBuilder sb, final Object state) {
                Iterable<UIWorkItemStorage4Settlement> _objects = WorkItemStorage4SettlementListGrid.this.getObjects();
                final Function1<UIWorkItemStorage4Settlement,Double> _function = new Function1<UIWorkItemStorage4Settlement,Double>() {
                    public Double apply(final UIWorkItemStorage4Settlement it) {
                      Double _amount = it.getAmount();
                      return _amount;
                    }
                  };
                Iterable<Double> _map = IterableExtensions.<UIWorkItemStorage4Settlement, Double>map(_objects, _function);
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
          ColumnRenderPair<UIWorkItemStorage4Settlement> _renderSummaryColumn_1 = AggregationExtensions.<UIWorkItemStorage4Settlement>renderSummaryColumn(WorkItemStorage4SettlementListGrid.this.amount, _function_1);
          AggregationExtensions.<UIWorkItemStorage4Settlement>operator_add(it, _renderSummaryColumn_1);
        }
      };
    ObjectExtensions.<AggregationRowConfig<UIWorkItemStorage4Settlement>>operator_doubleArrow(_createSummaryRow, _function);
    SGroupingGrid<UIWorkItemStorage4Settlement> _asWidget = this.asWidget();
    _asWidget.groupBy(this.repairTaskInfo, false);
  }
}
