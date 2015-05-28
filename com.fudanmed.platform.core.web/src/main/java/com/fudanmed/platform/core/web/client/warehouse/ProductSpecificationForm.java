package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy;
import com.fudanmed.platform.core.web.client.organization.AllSupplierContentProvider;
import com.fudanmed.platform.core.web.client.warehouse.AllProduceSpecificationUnitContentProvider;
import com.fudanmed.platform.core.web.client.warehouse.AllProductTypeContentProvider;
import com.fudanmed.platform.core.web.client.warehouse.ProductCategoryManagementPresenter;
import com.fudanmed.platform.core.web.client.warehouse.RCMaterialBrandContentProvider;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductType;
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
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DoubleValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DoubleValueProviderFactory.DoubleItem;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory.IntegerItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
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

public class ProductSpecificationForm extends GXTFormComponent<UIProductSpecification> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem sid;
  
  public TextItem name;
  
  public TextItem typeDesc;
  
  public ComboBoxSelector<RCProduceSpecificationUnitProxy> unit;
  
  @Inject
  public AllProduceSpecificationUnitContentProvider unitContentProvider;
  
  public SuggestionComboBoxSelector<RCProductTypeProxy> productType;
  
  @Inject
  public AllProductTypeContentProvider productTypeContentProvider;
  
  public SuggestionComboBoxSelector<RCSupplierProxy> defaultSupplier;
  
  @Inject
  public AllSupplierContentProvider defaultSupplierContentProvider;
  
  public TextItem materialId;
  
  public DoubleItem referencePrice;
  
  public IntegerItem shelfLife;
  
  public IntegerItem lowerStorage;
  
  public IntegerItem upperStorage;
  
  public ComboBoxSelector<RCMaterialBrandProxy> brandType;
  
  @Inject
  public RCMaterialBrandContentProvider brandTypeContentProvider;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIProductSpecification value = new UIProductSpecification();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsTextItem("sid","条码");
    widgetsRegistory.put("sid",sid);
    name = stringValueProviderFactory.createAsTextItem("name","物品名称");
    widgetsRegistory.put("name",name);
    typeDesc = stringValueProviderFactory.createAsTextItem("typeDesc","规格型号");
    widgetsRegistory.put("typeDesc",typeDesc);
    unit = defaultObjectSelectorFactory.createAsComboBoxItem("unit","单位");
    _initializerSupports.add(unitContentProvider);
    unit.setContentProvider(unitContentProvider);
    widgetsRegistory.put("unit",unit);
    productType = defaultObjectSelectorFactory.createAsSuggestionItem("productType","物品类别");
    productType.setContentProvider(productTypeContentProvider);
    widgetsRegistory.put("productType",productType);
    defaultSupplier = defaultObjectSelectorFactory.createAsSuggestionItem("defaultSupplier","默认供应商");
    defaultSupplier.setContentProvider(defaultSupplierContentProvider);
    widgetsRegistory.put("defaultSupplier",defaultSupplier);
    materialId = stringValueProviderFactory.createAsTextItem("materialId","物品编号");
    widgetsRegistory.put("materialId",materialId);
    referencePrice = doubleValueProviderFactory.createAsDoubleItem("referencePrice","参考单价");
    widgetsRegistory.put("referencePrice",referencePrice);
    shelfLife = integerValueProviderFactory.createAsIntegerItem("shelfLife","保质期(天)");
    widgetsRegistory.put("shelfLife",shelfLife);
    lowerStorage = integerValueProviderFactory.createAsIntegerItem("lowerStorage","最小库存");
    widgetsRegistory.put("lowerStorage",lowerStorage);
    upperStorage = integerValueProviderFactory.createAsIntegerItem("upperStorage","最大库存");
    widgetsRegistory.put("upperStorage",upperStorage);
    brandType = defaultObjectSelectorFactory.createAsComboBoxItem("brandType","品牌");
    _initializerSupports.add(brandTypeContentProvider);
    brandType.setContentProvider(brandTypeContentProvider);
    widgetsRegistory.put("brandType",brandType);
    if(con instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)con);
    						}if(maintenamceTypeManagementPresenter instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)maintenamceTypeManagementPresenter);
    						}IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIProductSpecification getValueAsNew() {
    UIProductSpecification value = new UIProductSpecification();
    value.setSid(sid.getValue());
    value.setName(name.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setUnit(unit.getValue());
    value.setProductType(productType.getValue());
    value.setDefaultSupplier(defaultSupplier.getValue());
    value.setMaterialId(materialId.getValue());
    value.setReferencePrice(referencePrice.getValue());
    value.setShelfLife(shelfLife.getValue());
    value.setLowerStorage(lowerStorage.getValue());
    value.setUpperStorage(upperStorage.getValue());
    value.setBrandType(brandType.getValue());
    return value;
  }
  
  public UIProductSpecification doGetValue() {
    
    value.setSid(sid.getValue());
    value.setName(name.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setUnit(unit.getValue());
    value.setProductType(productType.getValue());
    value.setDefaultSupplier(defaultSupplier.getValue());
    value.setMaterialId(materialId.getValue());
    value.setReferencePrice(referencePrice.getValue());
    value.setShelfLife(shelfLife.getValue());
    value.setLowerStorage(lowerStorage.getValue());
    value.setUpperStorage(upperStorage.getValue());
    value.setBrandType(brandType.getValue());
    return value;
  }
  
  public UIProductSpecification getValue(final UIProductSpecification copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setName(name.getValue());
    copyValue.setTypeDesc(typeDesc.getValue());
    copyValue.setUnit(unit.getValue());
    copyValue.setProductType(productType.getValue());
    copyValue.setDefaultSupplier(defaultSupplier.getValue());
    copyValue.setMaterialId(materialId.getValue());
    copyValue.setReferencePrice(referencePrice.getValue());
    copyValue.setShelfLife(shelfLife.getValue());
    copyValue.setLowerStorage(lowerStorage.getValue());
    copyValue.setUpperStorage(upperStorage.getValue());
    copyValue.setBrandType(brandType.getValue());
    return copyValue;
  }
  
  protected ProductSpecificationForm doSetValue(final UIProductSpecification value) {
    this.value = value;
    sid.setValue(value.getSid());
    name.setValue(value.getName());
    typeDesc.setValue(value.getTypeDesc());
    unit.setValue(value.getUnit());
    productType.setValue(value.getProductType());
    defaultSupplier.setValue(value.getDefaultSupplier());
    materialId.setValue(value.getMaterialId());
    referencePrice.setValue(value.getReferencePrice());
    shelfLife.setValue(value.getShelfLife());
    lowerStorage.setValue(value.getLowerStorage());
    upperStorage.setValue(value.getUpperStorage());
    brandType.setValue(value.getBrandType());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)name,(ICanAsWidget)typeDesc,(ICanAsWidget)unit,(ICanAsWidget)productType,(ICanAsWidget)defaultSupplier,(ICanAsWidget)materialId,(ICanAsWidget)referencePrice,(ICanAsWidget)shelfLife,(ICanAsWidget)lowerStorage,(ICanAsWidget)upperStorage,(ICanAsWidget)brandType
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
                            FieldLabel _asWidget = ProductSpecificationForm.this.sid.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                      PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = ProductSpecificationForm.this.materialId.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                    }
                  };
                ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
                PlainHTMLTR _tr_1 = HTMLTagsExt.tr(it);
                final Procedure1<PlainHTMLTR> _function_1 = new Procedure1<PlainHTMLTR>() {
                    public void apply(final PlainHTMLTR it) {
                      PlainHTMLTD _td = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = ProductSpecificationForm.this.name.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                      PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = ProductSpecificationForm.this.typeDesc.asWidget();
                            ClientUi.operator_add(it, _asWidget);
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
                            FieldLabel _asWidget = ProductSpecificationForm.this.unit.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                      PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
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
                                              FieldLabel _asWidget = ProductSpecificationForm.this.productType.asWidget();
                                              ClientUi.operator_add(it, _asWidget);
                                            }
                                          };
                                        ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                                        PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                                        final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                            public void apply(final PlainHTMLTD it) {
                                              TextButton _TextButton = ProductSpecificationForm.this.widgets.TextButton("\u9009\u62E9");
                                              final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                                  public void apply(final TextButton it) {
                                                    final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                                        public void apply(final SelectEvent it) {
                                                          ProductCategoryManagementPresenter _get = ProductSpecificationForm.this.maintenamceTypeManagementPresenter.get();
                                                          final Procedure1<ProductCategoryManagementPresenter> _function = new Procedure1<ProductCategoryManagementPresenter>() {
                                                              public void apply(final ProductCategoryManagementPresenter it) {
                                                                final Procedure1<UIProductType> _function = new Procedure1<UIProductType>() {
                                                                    public void apply(final UIProductType selected) {
                                                                      RCProductTypeProxy _proxy = selected.toProxy();
                                                                      ProductSpecificationForm.this.productType.setValue(_proxy);
                                                                    }
                                                                  };
                                                                Dialog _asSelector = ObjectSelector.<UIProductType>asSelector(it, "\u9009\u62E9\u6750\u6599\u7C7B\u522B", 800, 400, _function);
                                                                _asSelector.show();
                                                              }
                                                            };
                                                          _get.setup4Readonly(_function);
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
                ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_2, _function_2);
                PlainHTMLTR _tr_3 = HTMLTagsExt.tr(it);
                final Procedure1<PlainHTMLTR> _function_3 = new Procedure1<PlainHTMLTR>() {
                    public void apply(final PlainHTMLTR it) {
                      PlainHTMLTD _td = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = ProductSpecificationForm.this.defaultSupplier.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                      PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = ProductSpecificationForm.this.brandType.asWidget();
                            ClientUi.operator_add(it, _asWidget);
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
                            FieldLabel _asWidget = ProductSpecificationForm.this.referencePrice.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                      PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = ProductSpecificationForm.this.shelfLife.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                    }
                  };
                ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_4, _function_4);
                PlainHTMLTR _tr_5 = HTMLTagsExt.tr(it);
                final Procedure1<PlainHTMLTR> _function_5 = new Procedure1<PlainHTMLTR>() {
                    public void apply(final PlainHTMLTR it) {
                      PlainHTMLTD _td = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = ProductSpecificationForm.this.lowerStorage.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                      PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = ProductSpecificationForm.this.upperStorage.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                    }
                  };
                ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_5, _function_5);
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
  
  private Widget con;
  
  @Inject
  private Provider<ProductCategoryManagementPresenter> maintenamceTypeManagementPresenter;
}
