package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCAcquireTypeProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceIndicatorProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceUsageTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.web.client.device.AllAquireTypeContentProvider;
import com.fudanmed.platform.core.web.client.device.AllDeviceIndicatorContentProvider;
import com.fudanmed.platform.core.web.client.device.AllDeviceTypeContentProvider;
import com.fudanmed.platform.core.web.client.device.AllDeviceUsageTypeContentProvider;
import com.fudanmed.platform.core.web.client.organization.AllDeviceSupplierContentProvider;
import com.fudanmed.platform.core.web.client.organization.AllEmployeesContentProvider;
import com.fudanmed.platform.core.web.client.organization.AllOnsitePositionAyncContentProvider;
import com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenter;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenter;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.google.common.base.Objects;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.ComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DoubleValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DoubleValueProviderFactory.DoubleItem;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory.IntegerItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextAreaItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.component.form.factory.SuggestionComboBoxSelector;
import edu.fudan.langlab.gxt.client.selector.ObjectSelector;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeviceForm extends GXTFormComponent<UIDevice> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem sid;
  
  public TextItem name;
  
  public TextItem specification;
  
  public SuggestionComboBoxSelector<RCOnsitePositionProxy> location;
  
  @Inject
  public AllOnsitePositionAyncContentProvider locationContentProvider;
  
  public TextItem locationName;
  
  public TextItem serviceLocationName;
  
  public DateItem outStockTime;
  
  public TextAreaItem comment;
  
  public SuggestionComboBoxSelector<RCSupplierProxy> productor;
  
  @Inject
  public AllDeviceSupplierContentProvider productorContentProvider;
  
  public SuggestionComboBoxSelector<RCSupplierProxy> supplier;
  
  @Inject
  public AllDeviceSupplierContentProvider supplierContentProvider;
  
  public ComboBoxSelector<RCDeviceUsageTypeProxy> usageType;
  
  @Inject
  public AllDeviceUsageTypeContentProvider usageTypeContentProvider;
  
  public ComboBoxSelector<RCDeviceTypeProxy> deviceType;
  
  @Inject
  public AllDeviceTypeContentProvider deviceTypeContentProvider;
  
  public ComboBoxSelector<RCAcquireTypeProxy> acquireType;
  
  @Inject
  public AllAquireTypeContentProvider acquireTypeContentProvider;
  
  public ComboBoxSelector<RCDeviceIndicatorProxy> deviceIndicator;
  
  @Inject
  public AllDeviceIndicatorContentProvider deviceIndicatorContentProvider;
  
  public DateItem buyTime;
  
  public DoubleItem buyPrice;
  
  public DoubleItem netPrice;
  
  public ComboBoxSelector<RCEmployeeProxy> owner;
  
  @Inject
  public AllEmployeesContentProvider ownerContentProvider;
  
  public IntegerItem depreciationYears;
  
  public DoubleItem netLeaveRate;
  
  public TextItem ownerDepartmentName;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIDevice value = new UIDevice();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsTextItem("sid","设备编号");
    widgetsRegistory.put("sid",sid);
    name = stringValueProviderFactory.createAsTextItem("name","设备名称");
    widgetsRegistory.put("name",name);
    specification = stringValueProviderFactory.createAsTextItem("specification","规格型号");
    widgetsRegistory.put("specification",specification);
    location = defaultObjectSelectorFactory.createAsSuggestionItem("location","区域位置");
    location.setContentProvider(locationContentProvider);
    widgetsRegistory.put("location",location);
    locationName = stringValueProviderFactory.createAsTextItem("locationName","安装地点");
    widgetsRegistory.put("locationName",locationName);
    serviceLocationName = stringValueProviderFactory.createAsTextItem("serviceLocationName","服务区域");
    widgetsRegistory.put("serviceLocationName",serviceLocationName);
    outStockTime = dateValueProviderFactory.createAsDateItem("outStockTime","出厂时间");
    widgetsRegistory.put("outStockTime",outStockTime);
    comment = stringValueProviderFactory.createAsTextAreaItem("comment","备注");
    widgetsRegistory.put("comment",comment);
    productor = defaultObjectSelectorFactory.createAsSuggestionItem("productor","生产厂商");
    productor.setContentProvider(productorContentProvider);
    widgetsRegistory.put("productor",productor);
    supplier = defaultObjectSelectorFactory.createAsSuggestionItem("supplier","供应厂商");
    supplier.setContentProvider(supplierContentProvider);
    widgetsRegistory.put("supplier",supplier);
    usageType = defaultObjectSelectorFactory.createAsComboBoxItem("usageType","使用情况");
    _initializerSupports.add(usageTypeContentProvider);
    usageType.setContentProvider(usageTypeContentProvider);
    widgetsRegistory.put("usageType",usageType);
    deviceType = defaultObjectSelectorFactory.createAsComboBoxItem("deviceType","设备类型");
    _initializerSupports.add(deviceTypeContentProvider);
    deviceType.setContentProvider(deviceTypeContentProvider);
    widgetsRegistory.put("deviceType",deviceType);
    acquireType = defaultObjectSelectorFactory.createAsComboBoxItem("acquireType","增置方式");
    _initializerSupports.add(acquireTypeContentProvider);
    acquireType.setContentProvider(acquireTypeContentProvider);
    widgetsRegistory.put("acquireType",acquireType);
    deviceIndicator = defaultObjectSelectorFactory.createAsComboBoxItem("deviceIndicator","设备标识");
    _initializerSupports.add(deviceIndicatorContentProvider);
    deviceIndicator.setContentProvider(deviceIndicatorContentProvider);
    widgetsRegistory.put("deviceIndicator",deviceIndicator);
    buyTime = dateValueProviderFactory.createAsDateItem("buyTime","购买时间");
    widgetsRegistory.put("buyTime",buyTime);
    buyPrice = doubleValueProviderFactory.createAsDoubleItem("buyPrice","资产原值");
    widgetsRegistory.put("buyPrice",buyPrice);
    netPrice = doubleValueProviderFactory.createAsDoubleItem("netPrice","资产净值");
    widgetsRegistory.put("netPrice",netPrice);
    owner = defaultObjectSelectorFactory.createAsComboBoxItem("owner","资产负责人");
    _initializerSupports.add(ownerContentProvider);
    owner.setContentProvider(ownerContentProvider);
    widgetsRegistory.put("owner",owner);
    depreciationYears = integerValueProviderFactory.createAsIntegerItem("depreciationYears","折旧年限");
    widgetsRegistory.put("depreciationYears",depreciationYears);
    netLeaveRate = doubleValueProviderFactory.createAsDoubleItem("netLeaveRate","净残率");
    widgetsRegistory.put("netLeaveRate",netLeaveRate);
    ownerDepartmentName = stringValueProviderFactory.createAsTextItem("ownerDepartmentName","使用部门");
    widgetsRegistory.put("ownerDepartmentName",ownerDepartmentName);
    if(con instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)con);
    						}if(organizationOutlinePresenter instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)organizationOutlinePresenter);
    						}if(onsiteLocationOutlinePresenter instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)onsiteLocationOutlinePresenter);
    						}IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIDevice getValueAsNew() {
    UIDevice value = new UIDevice();
    value.setSid(sid.getValue());
    value.setName(name.getValue());
    value.setSpecification(specification.getValue());
    value.setLocation(location.getValue());
    value.setLocationName(locationName.getValue());
    value.setServiceLocationName(serviceLocationName.getValue());
    value.setOutStockTime(outStockTime.getValue());
    value.setComment(comment.getValue());
    value.setProductor(productor.getValue());
    value.setSupplier(supplier.getValue());
    value.setUsageType(usageType.getValue());
    value.setDeviceType(deviceType.getValue());
    value.setAcquireType(acquireType.getValue());
    value.setDeviceIndicator(deviceIndicator.getValue());
    value.setBuyTime(buyTime.getValue());
    value.setBuyPrice(buyPrice.getValue());
    value.setNetPrice(netPrice.getValue());
    value.setOwner(owner.getValue());
    value.setDepreciationYears(depreciationYears.getValue());
    value.setNetLeaveRate(netLeaveRate.getValue());
    value.setOwnerDepartmentName(ownerDepartmentName.getValue());
    return value;
  }
  
  public UIDevice doGetValue() {
    
    value.setSid(sid.getValue());
    value.setName(name.getValue());
    value.setSpecification(specification.getValue());
    value.setLocation(location.getValue());
    value.setLocationName(locationName.getValue());
    value.setServiceLocationName(serviceLocationName.getValue());
    value.setOutStockTime(outStockTime.getValue());
    value.setComment(comment.getValue());
    value.setProductor(productor.getValue());
    value.setSupplier(supplier.getValue());
    value.setUsageType(usageType.getValue());
    value.setDeviceType(deviceType.getValue());
    value.setAcquireType(acquireType.getValue());
    value.setDeviceIndicator(deviceIndicator.getValue());
    value.setBuyTime(buyTime.getValue());
    value.setBuyPrice(buyPrice.getValue());
    value.setNetPrice(netPrice.getValue());
    value.setOwner(owner.getValue());
    value.setDepreciationYears(depreciationYears.getValue());
    value.setNetLeaveRate(netLeaveRate.getValue());
    value.setOwnerDepartmentName(ownerDepartmentName.getValue());
    return value;
  }
  
  public UIDevice getValue(final UIDevice copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setName(name.getValue());
    copyValue.setSpecification(specification.getValue());
    copyValue.setLocation(location.getValue());
    copyValue.setLocationName(locationName.getValue());
    copyValue.setServiceLocationName(serviceLocationName.getValue());
    copyValue.setOutStockTime(outStockTime.getValue());
    copyValue.setComment(comment.getValue());
    copyValue.setProductor(productor.getValue());
    copyValue.setSupplier(supplier.getValue());
    copyValue.setUsageType(usageType.getValue());
    copyValue.setDeviceType(deviceType.getValue());
    copyValue.setAcquireType(acquireType.getValue());
    copyValue.setDeviceIndicator(deviceIndicator.getValue());
    copyValue.setBuyTime(buyTime.getValue());
    copyValue.setBuyPrice(buyPrice.getValue());
    copyValue.setNetPrice(netPrice.getValue());
    copyValue.setOwner(owner.getValue());
    copyValue.setDepreciationYears(depreciationYears.getValue());
    copyValue.setNetLeaveRate(netLeaveRate.getValue());
    copyValue.setOwnerDepartmentName(ownerDepartmentName.getValue());
    return copyValue;
  }
  
  protected DeviceForm doSetValue(final UIDevice value) {
    this.value = value;
    sid.setValue(value.getSid());
    name.setValue(value.getName());
    specification.setValue(value.getSpecification());
    location.setValue(value.getLocation());
    locationName.setValue(value.getLocationName());
    serviceLocationName.setValue(value.getServiceLocationName());
    outStockTime.setValue(value.getOutStockTime());
    comment.setValue(value.getComment());
    productor.setValue(value.getProductor());
    supplier.setValue(value.getSupplier());
    usageType.setValue(value.getUsageType());
    deviceType.setValue(value.getDeviceType());
    acquireType.setValue(value.getAcquireType());
    deviceIndicator.setValue(value.getDeviceIndicator());
    buyTime.setValue(value.getBuyTime());
    buyPrice.setValue(value.getBuyPrice());
    netPrice.setValue(value.getNetPrice());
    owner.setValue(value.getOwner());
    depreciationYears.setValue(value.getDepreciationYears());
    netLeaveRate.setValue(value.getNetLeaveRate());
    ownerDepartmentName.setValue(value.getOwnerDepartmentName());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)name,(ICanAsWidget)specification,(ICanAsWidget)location,(ICanAsWidget)locationName,(ICanAsWidget)serviceLocationName,(ICanAsWidget)outStockTime,(ICanAsWidget)comment,(ICanAsWidget)productor,(ICanAsWidget)supplier,(ICanAsWidget)usageType,(ICanAsWidget)deviceType,(ICanAsWidget)acquireType,(ICanAsWidget)deviceIndicator,(ICanAsWidget)buyTime,(ICanAsWidget)buyPrice,(ICanAsWidget)netPrice,(ICanAsWidget)owner,(ICanAsWidget)depreciationYears,(ICanAsWidget)netLeaveRate,(ICanAsWidget)ownerDepartmentName
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,PlainHTMLTable> _function = new Function1<Void,PlainHTMLTable>() {
        public PlainHTMLTable apply(final Void it) {
          PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
          final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
              public void apply(final PlainHTMLTable it) {
                PlainHTMLTR _tr = HTMLTagsExt.tr(it);
                final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
                    public void apply(final PlainHTMLTR it) {
                      PlainHTMLTD _td = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = DeviceForm.this.deviceType.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                      PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = DeviceForm.this.sid.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                      PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = DeviceForm.this.name.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_2, _function_2);
                    }
                  };
                ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
                PlainHTMLTR _tr_1 = HTMLTagsExt.tr(it);
                final Procedure1<PlainHTMLTR> _function_1 = new Procedure1<PlainHTMLTR>() {
                    public void apply(final PlainHTMLTR it) {
                      PlainHTMLTD _td = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = DeviceForm.this.specification.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                      PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                    }
                  };
                ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_1, _function_1);
                PlainHTMLTR _tr_2 = HTMLTagsExt.tr(it);
                final Procedure1<PlainHTMLTR> _function_2 = new Procedure1<PlainHTMLTR>() {
                    public void apply(final PlainHTMLTR it) {
                      PlainHTMLTD _td = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
                            final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
                                public void apply(final PlainHTMLTable it) {
                                  PlainHTMLTR _tr = HTMLTagsExt.tr(it);
                                  final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
                                      public void apply(final PlainHTMLTR it) {
                                        PlainHTMLTD _td = HTMLTagsExt.td(it);
                                        final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                            public void apply(final PlainHTMLTD it) {
                                              FieldLabel _asWidget = DeviceForm.this.location.asWidget();
                                              ClientUi.operator_add(it, _asWidget);
                                            }
                                          };
                                        ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                                        PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                                        final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                            public void apply(final PlainHTMLTD it) {
                                              TextButton _TextButton = DeviceForm.this.widgets.TextButton("\u9009\u62E9");
                                              final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                                  public void apply(final TextButton it) {
                                                    final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                                        public void apply(final SelectEvent it) {
                                                          OnsiteLocationOutlinePresenter _get = DeviceForm.this.onsiteLocationOutlinePresenter.get();
                                                          final Procedure1<OnsiteLocationOutlinePresenter> _function = new Procedure1<OnsiteLocationOutlinePresenter>() {
                                                              public void apply(final OnsiteLocationOutlinePresenter it) {
                                                                final Procedure1<OnsiteLocationOutlinePresenter> _function = new Procedure1<OnsiteLocationOutlinePresenter>() {
                                                                    public void apply(final OnsiteLocationOutlinePresenter it) {
                                                                      final Procedure1<UIOnsitePosition> _function = new Procedure1<UIOnsitePosition>() {
                                                                          public void apply(final UIOnsitePosition it) {
                                                                            DeviceForm.this.selectLocation(it);
                                                                          }
                                                                        };
                                                                      Dialog _asSelector = ObjectSelector.<UIOnsitePosition>asSelector(it, "\u9009\u62E9\u533A\u57DF\u4F4D\u7F6E", 300, 500, _function);
                                                                      _asSelector.show();
                                                                    }
                                                                  };
                                                                it.setupAsSimpleTree(_function);
                                                              }
                                                            };
                                                          ObjectExtensions.<OnsiteLocationOutlinePresenter>operator_doubleArrow(_get, _function);
                                                        }
                                                      };
                                                    it.addSelectHandler(new SelectHandler() {
                                                        public void onSelect(SelectEvent event) {
                                                          _function.apply(event);
                                                        }
                                                    });
                                                  }
                                                };
                                              TextButton _doubleArrow = ObjectExtensions.<TextButton>operator_doubleArrow(_TextButton, _function);
                                              ClientUi.operator_add(it, _doubleArrow);
                                            }
                                          };
                                        ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                                      }
                                    };
                                  ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
                                }
                              };
                            PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
                            ClientUi.operator_add(it, _doubleArrow);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                      PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            it.setColSpan(2);
                            FieldLabel _asWidget = DeviceForm.this.locationName.asWidget();
                            final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                public void apply(final FieldLabel it) {
                                  it.setWidth("550");
                                }
                              };
                            FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
                            ClientUi.operator_add(it, _doubleArrow);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                    }
                  };
                ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_2, _function_2);
                PlainHTMLTR _tr_3 = HTMLTagsExt.tr(it);
                final Procedure1<PlainHTMLTR> _function_3 = new Procedure1<PlainHTMLTR>() {
                    public void apply(final PlainHTMLTR it) {
                      PlainHTMLTD _td = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = DeviceForm.this.outStockTime.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                      PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            it.setColSpan(2);
                            FieldLabel _asWidget = DeviceForm.this.serviceLocationName.asWidget();
                            final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                public void apply(final FieldLabel it) {
                                  it.setWidth("550");
                                }
                              };
                            FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
                            ClientUi.operator_add(it, _doubleArrow);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                    }
                  };
                ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_3, _function_3);
                PlainHTMLTR _tr_4 = HTMLTagsExt.tr(it);
                final Procedure1<PlainHTMLTR> _function_4 = new Procedure1<PlainHTMLTR>() {
                    public void apply(final PlainHTMLTR it) {
                      PlainHTMLTD _td = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = DeviceForm.this.productor.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                      PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = DeviceForm.this.supplier.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                      PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = DeviceForm.this.deviceIndicator.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_2, _function_2);
                    }
                  };
                ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_4, _function_4);
                PlainHTMLTR _tr_5 = HTMLTagsExt.tr(it);
                final Procedure1<PlainHTMLTR> _function_5 = new Procedure1<PlainHTMLTR>() {
                    public void apply(final PlainHTMLTR it) {
                      PlainHTMLTD _td = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = DeviceForm.this.acquireType.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                      PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = DeviceForm.this.usageType.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                      PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = DeviceForm.this.buyTime.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_2, _function_2);
                    }
                  };
                ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_5, _function_5);
                PlainHTMLTR _tr_6 = HTMLTagsExt.tr(it);
                final Procedure1<PlainHTMLTR> _function_6 = new Procedure1<PlainHTMLTR>() {
                    public void apply(final PlainHTMLTR it) {
                      PlainHTMLTD _td = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = DeviceForm.this.buyPrice.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                      PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = DeviceForm.this.netPrice.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                      PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = DeviceForm.this.owner.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_2, _function_2);
                    }
                  };
                ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_6, _function_6);
                PlainHTMLTR _tr_7 = HTMLTagsExt.tr(it);
                final Procedure1<PlainHTMLTR> _function_7 = new Procedure1<PlainHTMLTR>() {
                    public void apply(final PlainHTMLTR it) {
                      PlainHTMLTD _td = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = DeviceForm.this.depreciationYears.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                      PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            it.setColSpan(2);
                            PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
                            final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
                                public void apply(final PlainHTMLTable it) {
                                  PlainHTMLTR _tr = HTMLTagsExt.tr(it);
                                  final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
                                      public void apply(final PlainHTMLTR it) {
                                        PlainHTMLTD _td = HTMLTagsExt.td(it);
                                        final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                            public void apply(final PlainHTMLTD it) {
                                              FieldLabel _asWidget = DeviceForm.this.ownerDepartmentName.asWidget();
                                              final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                                  public void apply(final FieldLabel it) {
                                                    it.setWidth("550");
                                                  }
                                                };
                                              FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
                                              ClientUi.operator_add(it, _doubleArrow);
                                            }
                                          };
                                        ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                                        PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                                        final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                            public void apply(final PlainHTMLTD it) {
                                              TextButton _TextButton = DeviceForm.this.widgets.TextButton("\u9009\u62E9");
                                              final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                                  public void apply(final TextButton it) {
                                                    final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                                        public void apply(final SelectEvent it) {
                                                          OrganizationOutlinePresenter _get = DeviceForm.this.organizationOutlinePresenter.get();
                                                          final Procedure1<OrganizationOutlinePresenter> _function = new Procedure1<OrganizationOutlinePresenter>() {
                                                              public void apply(final OrganizationOutlinePresenter it) {
                                                                final Procedure1<OrganizationOutlinePresenter> _function = new Procedure1<OrganizationOutlinePresenter>() {
                                                                    public void apply(final OrganizationOutlinePresenter it) {
                                                                      final Procedure1<UIOrganization> _function = new Procedure1<UIOrganization>() {
                                                                          public void apply(final UIOrganization it) {
                                                                            String _fullPath = it.getFullPath();
                                                                            DeviceForm.this.ownerDepartmentName.setValue(_fullPath);
                                                                          }
                                                                        };
                                                                      Dialog _asSelector = ObjectSelector.<UIOrganization>asSelector(it, "\u9009\u62E9\u7EC4\u7EC7\u673A\u6784", 300, 500, _function);
                                                                      _asSelector.show();
                                                                    }
                                                                  };
                                                                it.setupAsSimpleTree(_function);
                                                              }
                                                            };
                                                          ObjectExtensions.<OrganizationOutlinePresenter>operator_doubleArrow(_get, _function);
                                                        }
                                                      };
                                                    it.addSelectHandler(new SelectHandler() {
                                                        public void onSelect(SelectEvent event) {
                                                          _function.apply(event);
                                                        }
                                                    });
                                                  }
                                                };
                                              TextButton _doubleArrow = ObjectExtensions.<TextButton>operator_doubleArrow(_TextButton, _function);
                                              ClientUi.operator_add(it, _doubleArrow);
                                            }
                                          };
                                        ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                                      }
                                    };
                                  ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
                                }
                              };
                            PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
                            ClientUi.operator_add(it, _doubleArrow);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                    }
                  };
                ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_7, _function_7);
                PlainHTMLTR _tr_8 = HTMLTagsExt.tr(it);
                final Procedure1<PlainHTMLTR> _function_8 = new Procedure1<PlainHTMLTR>() {
                    public void apply(final PlainHTMLTR it) {
                      PlainHTMLTD _td = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = DeviceForm.this.netLeaveRate.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                    }
                  };
                ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_8, _function_8);
                PlainHTMLTR _tr_9 = HTMLTagsExt.tr(it);
                final Procedure1<PlainHTMLTR> _function_9 = new Procedure1<PlainHTMLTR>() {
                    public void apply(final PlainHTMLTR it) {
                      PlainHTMLTD _td = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            it.setColSpan(3);
                            FieldLabel _asWidget = DeviceForm.this.comment.asWidget();
                            final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                public void apply(final FieldLabel it) {
                                  it.setHeight(50);
                                  it.setWidth(750);
                                }
                              };
                            FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
                            ClientUi.operator_add(it, _doubleArrow);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                    }
                  };
                ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_9, _function_9);
              }
            };
          PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
          return _doubleArrow;
        }
      };
    Widget _lazy = ClientUi.<Widget>lazy(this.con, _function);
    Widget _con = this.con = _lazy;
    return _con;
  }
  
  public void selectLocation(final UIOnsitePosition selectedLocation) {
    boolean _equals = Objects.equal(selectedLocation, null);
    if (_equals) {
      return;
    }
    RCOnsitePositionProxy _proxy = selectedLocation.toProxy();
    this.location.setValue(_proxy);
    String _fullPath = selectedLocation.getFullPath();
    this.locationName.setValue(_fullPath);
    String _fullPath_1 = selectedLocation.getFullPath();
    this.serviceLocationName.setValue(_fullPath_1);
  }
  
  private Widget con;
  
  @Inject
  private Provider<OrganizationOutlinePresenter> organizationOutlinePresenter;
  
  @Inject
  private Provider<OnsiteLocationOutlinePresenter> onsiteLocationOutlinePresenter;
}
