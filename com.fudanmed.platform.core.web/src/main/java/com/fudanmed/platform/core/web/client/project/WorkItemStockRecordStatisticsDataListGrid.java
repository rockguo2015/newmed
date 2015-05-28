package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordStatisticsData;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.grid.AggregationRowConfig;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.shared.extensions.NumberExtensions;
import edu.fudan.langlab.gxt.client.component.grid.AggregationExtensions;
import edu.fudan.langlab.gxt.client.component.grid.ColumnRenderPair;
import edu.fudan.langlab.gxt.client.component.grid.GXTGrid4LargeDataComponent;
import edu.fudan.langlab.gxt.client.component.grid.IGroupRender;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateColumn;
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

public class WorkItemStockRecordStatisticsDataListGrid extends GXTGrid4LargeDataComponent<UIWorkItemStockRecordStatisticsData> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UIWorkItemStockRecordStatisticsData,RCMaintenanceTeamProxy> team;
  
  public StringColumn<UIWorkItemStockRecordStatisticsData> materialId;
  
  public StringColumn<UIWorkItemStockRecordStatisticsData> name;
  
  public StringColumn<UIWorkItemStockRecordStatisticsData> typeDesc;
  
  public StringValueColumn<UIWorkItemStockRecordStatisticsData,RCProduceSpecificationUnitProxy> unit;
  
  public DoubleColumn<UIWorkItemStockRecordStatisticsData> price;
  
  public IntegerColumn<UIWorkItemStockRecordStatisticsData> quantity;
  
  public DoubleColumn<UIWorkItemStockRecordStatisticsData> amount;
  
  public StringValueColumn<UIWorkItemStockRecordStatisticsData,RCOrganizationProxy> reportOrg;
  
  public DateColumn<UIWorkItemStockRecordStatisticsData> date;
  
  public StringColumn<UIWorkItemStockRecordStatisticsData> reportSid;
  
  public StringColumn<UIWorkItemStockRecordStatisticsData> workItemSid;
  
  public StringColumn<UIWorkItemStockRecordStatisticsData> inoutStockSid;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIWorkItemStockRecordStatisticsData value = new UIWorkItemStockRecordStatisticsData();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();team = defaultObjectSelectorFactory.createAsDefaultColumn("team","维修班组",UIWorkItemStockRecordStatisticsData.TeamAccessor,Integer.valueOf(160));
    widgetsRegistory.put("team",team);
    materialId = stringValueProviderFactory.createAsStringColumn("materialId","物品编号",UIWorkItemStockRecordStatisticsData.MaterialIdAccessor);
    widgetsRegistory.put("materialId",materialId);
    name = stringValueProviderFactory.createAsStringColumn("name","物品名称",UIWorkItemStockRecordStatisticsData.NameAccessor);
    widgetsRegistory.put("name",name);
    typeDesc = stringValueProviderFactory.createAsStringColumn("typeDesc","规格型号",UIWorkItemStockRecordStatisticsData.TypeDescAccessor);
    widgetsRegistory.put("typeDesc",typeDesc);
    unit = defaultObjectSelectorFactory.createAsDefaultColumn("unit","计量单位",UIWorkItemStockRecordStatisticsData.UnitAccessor,Integer.valueOf(80));
    widgetsRegistory.put("unit",unit);
    price = doubleValueProviderFactory.createAsDoubleColumn("price","单价",UIWorkItemStockRecordStatisticsData.PriceAccessor,Integer.valueOf(50));
    widgetsRegistory.put("price",price);
    quantity = integerValueProviderFactory.createAsIntegerColumn("quantity","数量",UIWorkItemStockRecordStatisticsData.QuantityAccessor,Integer.valueOf(50));
    widgetsRegistory.put("quantity",quantity);
    amount = doubleValueProviderFactory.createAsDoubleColumn("amount","金额",UIWorkItemStockRecordStatisticsData.AmountAccessor,Integer.valueOf(50));
    widgetsRegistory.put("amount",amount);
    reportOrg = defaultObjectSelectorFactory.createAsDefaultColumn("reportOrg","报修科室",UIWorkItemStockRecordStatisticsData.ReportOrgAccessor);
    widgetsRegistory.put("reportOrg",reportOrg);
    date = dateValueProviderFactory.createAsStringColumn("date","领料时间",UIWorkItemStockRecordStatisticsData.DateAccessor);
    widgetsRegistory.put("date",date);
    reportSid = stringValueProviderFactory.createAsStringColumn("reportSid","报修单号",UIWorkItemStockRecordStatisticsData.ReportSidAccessor);
    widgetsRegistory.put("reportSid",reportSid);
    workItemSid = stringValueProviderFactory.createAsStringColumn("workItemSid","工单编号",UIWorkItemStockRecordStatisticsData.WorkItemSidAccessor);
    widgetsRegistory.put("workItemSid",workItemSid);
    inoutStockSid = stringValueProviderFactory.createAsStringColumn("inoutStockSid","领退料单号",UIWorkItemStockRecordStatisticsData.InoutStockSidAccessor);
    widgetsRegistory.put("inoutStockSid",inoutStockSid);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIWorkItemStockRecordStatisticsData getValueAsNew() {
    UIWorkItemStockRecordStatisticsData value = new UIWorkItemStockRecordStatisticsData();
    value.setTeam(team.getValue());
    value.setMaterialId(materialId.getValue());
    value.setName(name.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setUnit(unit.getValue());
    value.setPrice(price.getValue());
    value.setQuantity(quantity.getValue());
    value.setAmount(amount.getValue());
    value.setReportOrg(reportOrg.getValue());
    value.setDate(date.getValue());
    value.setReportSid(reportSid.getValue());
    value.setWorkItemSid(workItemSid.getValue());
    value.setInoutStockSid(inoutStockSid.getValue());
    return value;
  }
  
  public UIWorkItemStockRecordStatisticsData doGetValue() {
    
    value.setTeam(team.getValue());
    value.setMaterialId(materialId.getValue());
    value.setName(name.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setUnit(unit.getValue());
    value.setPrice(price.getValue());
    value.setQuantity(quantity.getValue());
    value.setAmount(amount.getValue());
    value.setReportOrg(reportOrg.getValue());
    value.setDate(date.getValue());
    value.setReportSid(reportSid.getValue());
    value.setWorkItemSid(workItemSid.getValue());
    value.setInoutStockSid(inoutStockSid.getValue());
    return value;
  }
  
  public UIWorkItemStockRecordStatisticsData getValue(final UIWorkItemStockRecordStatisticsData copyValue) {
    
    copyValue.setTeam(team.getValue());
    copyValue.setMaterialId(materialId.getValue());
    copyValue.setName(name.getValue());
    copyValue.setTypeDesc(typeDesc.getValue());
    copyValue.setUnit(unit.getValue());
    copyValue.setPrice(price.getValue());
    copyValue.setQuantity(quantity.getValue());
    copyValue.setAmount(amount.getValue());
    copyValue.setReportOrg(reportOrg.getValue());
    copyValue.setDate(date.getValue());
    copyValue.setReportSid(reportSid.getValue());
    copyValue.setWorkItemSid(workItemSid.getValue());
    copyValue.setInoutStockSid(inoutStockSid.getValue());
    return copyValue;
  }
  
  protected WorkItemStockRecordStatisticsDataListGrid doSetValue(final UIWorkItemStockRecordStatisticsData value) {
    this.value = value;
    team.setValue(value.getTeam());
    materialId.setValue(value.getMaterialId());
    name.setValue(value.getName());
    typeDesc.setValue(value.getTypeDesc());
    unit.setValue(value.getUnit());
    price.setValue(value.getPrice());
    quantity.setValue(value.getQuantity());
    amount.setValue(value.getAmount());
    reportOrg.setValue(value.getReportOrg());
    date.setValue(value.getDate());
    reportSid.setValue(value.getReportSid());
    workItemSid.setValue(value.getWorkItemSid());
    inoutStockSid.setValue(value.getInoutStockSid());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)team,(ICanAsWidget)materialId,(ICanAsWidget)name,(ICanAsWidget)typeDesc,(ICanAsWidget)unit,(ICanAsWidget)price,(ICanAsWidget)quantity,(ICanAsWidget)amount,(ICanAsWidget)reportOrg,(ICanAsWidget)date,(ICanAsWidget)reportSid,(ICanAsWidget)workItemSid,(ICanAsWidget)inoutStockSid
    					);
  }
  
  public void initializeComponent() {
    AggregationRowConfig<UIWorkItemStockRecordStatisticsData> _createSummaryRow = AggregationExtensions.createSummaryRow(this);
    final Procedure1<AggregationRowConfig<UIWorkItemStockRecordStatisticsData>> _function = new Procedure1<AggregationRowConfig<UIWorkItemStockRecordStatisticsData>>() {
        public void apply(final AggregationRowConfig<UIWorkItemStockRecordStatisticsData> it) {
          final Procedure2<SafeHtmlBuilder,Object> _function = new Procedure2<SafeHtmlBuilder,Object>() {
              public void apply(final SafeHtmlBuilder sb, final Object state) {
                Iterable<UIWorkItemStockRecordStatisticsData> _objects = WorkItemStockRecordStatisticsDataListGrid.this.getObjects();
                int _size = IterableExtensions.size(_objects);
                String _string = Integer.valueOf(_size).toString();
                String _plus = ("\u5408\u8BA1" + _string);
                String _plus_1 = (_plus + "\u6761");
                sb.appendHtmlConstant(_plus_1);
              }
            };
          ColumnRenderPair<UIWorkItemStockRecordStatisticsData> _renderSummaryColumn = AggregationExtensions.<UIWorkItemStockRecordStatisticsData>renderSummaryColumn(WorkItemStockRecordStatisticsDataListGrid.this.team, _function);
          AggregationExtensions.<UIWorkItemStockRecordStatisticsData>operator_add(it, _renderSummaryColumn);
          final Procedure2<SafeHtmlBuilder,Object> _function_1 = new Procedure2<SafeHtmlBuilder,Object>() {
              public void apply(final SafeHtmlBuilder sb, final Object state) {
                Iterable<UIWorkItemStockRecordStatisticsData> _objects = WorkItemStockRecordStatisticsDataListGrid.this.getObjects();
                final Function1<UIWorkItemStockRecordStatisticsData,Double> _function = new Function1<UIWorkItemStockRecordStatisticsData,Double>() {
                    public Double apply(final UIWorkItemStockRecordStatisticsData it) {
                      Double _amount = it.getAmount();
                      return _amount;
                    }
                  };
                Iterable<Double> _map = IterableExtensions.<UIWorkItemStockRecordStatisticsData, Double>map(_objects, _function);
                final Function2<Double,Double,Double> _function_1 = new Function2<Double,Double,Double>() {
                    public Double apply(final Double d1, final Double d2) {
                      double _plus = DoubleExtensions.operator_plus(d1, d2);
                      return Double.valueOf(_plus);
                    }
                  };
                Double _reduce = IterableExtensions.<Double>reduce(_map, _function_1);
                Double _nullsafe = NumberExtensions.nullsafe(_reduce);
                String _plus = (_nullsafe + "\u5143");
                sb.appendHtmlConstant(_plus);
              }
            };
          ColumnRenderPair<UIWorkItemStockRecordStatisticsData> _renderSummaryColumn_1 = AggregationExtensions.<UIWorkItemStockRecordStatisticsData>renderSummaryColumn(WorkItemStockRecordStatisticsDataListGrid.this.amount, _function_1);
          AggregationExtensions.<UIWorkItemStockRecordStatisticsData>operator_add(it, _renderSummaryColumn_1);
        }
      };
    ObjectExtensions.<AggregationRowConfig<UIWorkItemStockRecordStatisticsData>>operator_doubleArrow(_createSummaryRow, _function);
    SGroupingGrid<UIWorkItemStockRecordStatisticsData> _asWidget = this.asWidget();
    _asWidget.groupBy(this.team, true);
    final Procedure2<Number,SafeHtmlBuilder> _function_1 = new Procedure2<Number,SafeHtmlBuilder>() {
        public void apply(final Number number, final SafeHtmlBuilder sb) {
          String _string = number.toString();
          String _plus = (_string + "\u5143");
          sb.appendHtmlConstant(_plus);
        }
      };
    this.amount.setGroupRender(new IGroupRender() {
        public void render(Number value,SafeHtmlBuilder sb) {
          _function_1.apply(value,sb);
        }
    });
    final Procedure2<Number,SafeHtmlBuilder> _function_2 = new Procedure2<Number,SafeHtmlBuilder>() {
        public void apply(final Number number, final SafeHtmlBuilder sb) {
          String _string = number.toString();
          String _plus = ("\u5C0F\u8BA1" + _string);
          String _plus_1 = (_plus + "\u6761");
          sb.appendHtmlConstant(_plus_1);
        }
      };
    this.team.setGroupRender(new IGroupRender() {
        public void render(Number value,SafeHtmlBuilder sb) {
          _function_2.apply(value,sb);
        }
    });
    this.asWidget();
    this.unForceFit();
  }
}
