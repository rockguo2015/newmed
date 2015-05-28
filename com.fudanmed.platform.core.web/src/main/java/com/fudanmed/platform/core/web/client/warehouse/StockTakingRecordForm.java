package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.common.ServerSideTimeServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.AllWarehouseContentProvider;
import com.fudanmed.platform.core.web.client.warehouse.WarehouseProductSpecSummaryForm;
import com.fudanmed.platform.core.web.client.warehouse.WarehouseProductSpecSummaryListGrid;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIWarehouseProductSpecSummary;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.box.MessageBox;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;
import com.uniquesoft.gwt.shared.DateUtil;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory.CheckBoxItem;
import edu.fudan.langlab.gxt.client.component.form.factory.ComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateReadonlyItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectsSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectsSelectorFactory.ListGridBasedItemsProvider;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent.EditCompleteListener;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Date;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class StockTakingRecordForm extends GXTFormComponent<UIStockTakingRecord> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public ComboBoxSelector<RCWarehouseProxy> sourceStore;
  
  @Inject
  public AllWarehouseContentProvider sourceStoreContentProvider;
  
  public ListGridBasedItemsProvider<UIWarehouseProductSpecSummary> itemSummarys;
  
  public TextItem comment;
  
  public DateReadonlyItem date;
  
  public CheckBoxItem print;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  @Inject
  private DefaultObjectsSelectorFactory defaultObjectsSelectorFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIStockTakingRecord value = new UIStockTakingRecord();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sourceStore = defaultObjectSelectorFactory.createAsRequiredComboBoxItem("sourceStore","盘点仓库");
    _initializerSupports.add(sourceStoreContentProvider);
    sourceStore.setContentProvider(sourceStoreContentProvider);
    widgetsRegistory.put("sourceStore",sourceStore);
    itemSummarys = defaultObjectsSelectorFactory.createAsListGridBasedItem("itemSummarys","盘点明细",this.transferRecordItemListGrid);
    widgetsRegistory.put("itemSummarys",itemSummarys);
    comment = stringValueProviderFactory.createAsTextItem("comment","备注");
    widgetsRegistory.put("comment",comment);
    date = dateValueProviderFactory.createAsReadonlyItem("date","盘点日期");
    widgetsRegistory.put("date",date);
    print = booleanValueProviderFactory.createAsCheckBoxItem("print","打印盘点单");
    widgetsRegistory.put("print",print);
    if(transferRecordItemListGrid instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)transferRecordItemListGrid);
    						}if(transferRecordItemForm instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)transferRecordItemForm);
    						}if(timeService instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)timeService);
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
  
  public UIStockTakingRecord getValueAsNew() {
    UIStockTakingRecord value = new UIStockTakingRecord();
    value.setSourceStore(sourceStore.getValue());
    value.setItemSummarys(itemSummarys.getValue());
    value.setComment(comment.getValue());
    value.setDate(date.getValue());
    value.setPrint(print.getValue());
    return value;
  }
  
  public UIStockTakingRecord doGetValue() {
    
    value.setSourceStore(sourceStore.getValue());
    value.setItemSummarys(itemSummarys.getValue());
    value.setComment(comment.getValue());
    value.setDate(date.getValue());
    value.setPrint(print.getValue());
    return value;
  }
  
  public UIStockTakingRecord getValue(final UIStockTakingRecord copyValue) {
    
    copyValue.setSourceStore(sourceStore.getValue());
    copyValue.setItemSummarys(itemSummarys.getValue());
    copyValue.setComment(comment.getValue());
    copyValue.setDate(date.getValue());
    copyValue.setPrint(print.getValue());
    return copyValue;
  }
  
  protected StockTakingRecordForm doSetValue(final UIStockTakingRecord value) {
    this.value = value;
    sourceStore.setValue(value.getSourceStore());
    itemSummarys.setValue(value.getItemSummarys());
    comment.setValue(value.getComment());
    date.setValue(value.getDate());
    print.setValue(value.getPrint());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sourceStore,(ICanAsWidget)itemSummarys,(ICanAsWidget)comment,(ICanAsWidget)date,(ICanAsWidget)print
    					);
  }
  
  public void setSourceWarehouse(final RCWarehouseProxy store) {
    this.transferRecordItemForm.setSourceWarehouse(store);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = StockTakingRecordForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
                final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
                    public void apply(final PlainHTMLTable it) {
                      PlainHTMLTR _tr = HTMLTagsExt.tr(it);
                      final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
                          public void apply(final PlainHTMLTR it) {
                            PlainHTMLTD _td = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = StockTakingRecordForm.this.sourceStore.asWidget();
                                  final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                      public void apply(final FieldLabel it) {
                                        final Procedure1<RCWarehouseProxy> _function = new Procedure1<RCWarehouseProxy>() {
                                            public void apply(final RCWarehouseProxy it) {
                                              StockTakingRecordForm.this.transferRecordItemForm.setSourceWarehouse(it);
                                              StockTakingRecordForm.this.transferRecordItemForm.storageSummary.clear();
                                            }
                                          };
                                        StockTakingRecordForm.this.sourceStore.addValueChangedListener(new ValueChangedListener<RCWarehouseProxy>() {
                                            public void onValueChanged(RCWarehouseProxy value) {
                                              _function.apply(value);
                                            }
                                        });
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
                                  FieldLabel _asWidget = StockTakingRecordForm.this.date.asWidget();
                                  final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                      public void apply(final FieldLabel it) {
                                        final Procedure1<Date> _function = new Procedure1<Date>() {
                                            public void apply(final Date it) {
                                              StockTakingRecordForm.this.date.setValue(it);
                                            }
                                          };
                                        AsyncCallback<Date> _onSuccess = StockTakingRecordForm.this.<Date>onSuccess(_function);
                                        StockTakingRecordForm.this.timeService.getTime(_onSuccess);
                                      }
                                    };
                                  FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
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
                WidgetExtensions.<PlainHTMLTable>addFill(it, _doubleArrow);
                FieldSet _FieldSet = StockTakingRecordForm.this.widgets.FieldSet("\u76D8\u70B9\u660E\u7EC6");
                final Procedure1<FieldSet> _function_1 = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      VerticalLayoutContainer _VLayout = StockTakingRecordForm.this.widgets.VLayout();
                      final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                          public void apply(final VerticalLayoutContainer it) {
                            PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
                            final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
                                public void apply(final PlainHTMLTable it) {
                                  PlainHTMLTR _tr = HTMLTagsExt.tr(it);
                                  final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
                                      public void apply(final PlainHTMLTR it) {
                                        PlainHTMLTD _td = HTMLTagsExt.td(it);
                                        final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                            public void apply(final PlainHTMLTD it) {
                                              FieldLabel _asWidget = StockTakingRecordForm.this.transferRecordItemForm.storageSummary.asWidget();
                                              final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                                  public void apply(final FieldLabel it) {
                                                    it.setWidth(580);
                                                    final Procedure1<Iterable<UIProductWarehouseStorageSummary>> _function = new Procedure1<Iterable<UIProductWarehouseStorageSummary>>() {
                                                        public void apply(final Iterable<UIProductWarehouseStorageSummary> it) {
                                                          UIProductWarehouseStorageSummary _head = IterableExtensions.<UIProductWarehouseStorageSummary>head(it);
                                                          Integer _quantity = _head.getQuantity();
                                                          StockTakingRecordForm.this.transferRecordItemForm.sourceQuantity.setValue(_quantity);
                                                        }
                                                      };
                                                    StockTakingRecordForm.this.transferRecordItemForm.storageSummary.addSelectionChangedListener(new SelectionChangedListener<UIProductWarehouseStorageSummary>() {
                                                        public void selectionChanged(Iterable<UIProductWarehouseStorageSummary> selections) {
                                                          _function.apply(selections);
                                                        }
                                                    });
                                                  }
                                                };
                                              FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
                                              ClientUi.operator_add(it, _doubleArrow);
                                            }
                                          };
                                        ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                                      }
                                    };
                                  ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
                                }
                              };
                            PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
                            ClientUi.operator_add(it, _doubleArrow);
                            PlainHTMLTable _TABLE_1 = HTMLTagsExt.TABLE();
                            final Procedure1<PlainHTMLTable> _function_1 = new Procedure1<PlainHTMLTable>() {
                                public void apply(final PlainHTMLTable it) {
                                  PlainHTMLTR _tr = HTMLTagsExt.tr(it);
                                  final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
                                      public void apply(final PlainHTMLTR it) {
                                        PlainHTMLTD _td = HTMLTagsExt.td(it);
                                        final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                            public void apply(final PlainHTMLTD it) {
                                              it.setWidth("300");
                                              FieldLabel _asWidget = StockTakingRecordForm.this.transferRecordItemForm.sourceQuantity.asWidget();
                                              ClientUi.operator_add(it, _asWidget);
                                            }
                                          };
                                        ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                                        PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                                        final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                            public void apply(final PlainHTMLTD it) {
                                              FieldLabel _asWidget = StockTakingRecordForm.this.transferRecordItemForm.quantity.asWidget();
                                              ClientUi.operator_add(it, _asWidget);
                                            }
                                          };
                                        ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                                      }
                                    };
                                  ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
                                }
                              };
                            PlainHTMLTable _doubleArrow_1 = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE_1, _function_1);
                            ClientUi.operator_add(it, _doubleArrow_1);
                            FieldLabel _asWidget = StockTakingRecordForm.this.itemSummarys.asWidget();
                            final Procedure1<FieldLabel> _function_2 = new Procedure1<FieldLabel>() {
                                public void apply(final FieldLabel it) {
                                  it.setHeight(250);
                                }
                              };
                            FieldLabel _doubleArrow_2 = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function_2);
                            WidgetExtensions.<FieldLabel>addFill(it, _doubleArrow_2);
                            final Function1<Void,UIWarehouseProductSpecSummary> _function_3 = new Function1<Void,UIWarehouseProductSpecSummary>() {
                                public UIWarehouseProductSpecSummary apply(final Void it) {
                                  UIWarehouseProductSpecSummary _xifexpression = null;
                                  boolean _or = false;
                                  Integer _value = StockTakingRecordForm.this.transferRecordItemForm.quantity.getValue();
                                  boolean _equals = Objects.equal(_value, null);
                                  if (_equals) {
                                    _or = true;
                                  } else {
                                    UIProductWarehouseStorageSummary _value_1 = StockTakingRecordForm.this.transferRecordItemForm.storageSummary.getValue();
                                    boolean _equals_1 = Objects.equal(_value_1, null);
                                    _or = (_equals || _equals_1);
                                  }
                                  if (_or) {
                                    _xifexpression = null;
                                  } else {
                                    UIWarehouseProductSpecSummary _xifexpression_1 = null;
                                    Integer _value_2 = StockTakingRecordForm.this.transferRecordItemForm.quantity.getValue();
                                    UIProductWarehouseStorageSummary _value_3 = StockTakingRecordForm.this.transferRecordItemForm.storageSummary.getValue();
                                    Integer _quantity = _value_3.getQuantity();
                                    boolean _greaterThan = (_value_2.compareTo(_quantity) > 0);
                                    if (_greaterThan) {
                                      UIWarehouseProductSpecSummary _xblockexpression = null;
                                      {
                                        MessageBox _MessageBox = StockTakingRecordForm.this.widgets.MessageBox("\u65E0\u6548\u8F93\u5165", "\u5E93\u5B58\u6570\u91CF\u4E0D\u8DB3");
                                        _MessageBox.show();
                                        _xblockexpression = (null);
                                      }
                                      _xifexpression_1 = _xblockexpression;
                                    } else {
                                      UIWarehouseProductSpecSummary _valueAsNew = StockTakingRecordForm.this.transferRecordItemForm.getValueAsNew();
                                      final Procedure1<UIWarehouseProductSpecSummary> _function = new Procedure1<UIWarehouseProductSpecSummary>() {
                                          public void apply(final UIWarehouseProductSpecSummary it) {
                                            final UIProductWarehouseStorageSummary v = StockTakingRecordForm.this.transferRecordItemForm.storageSummary.getValue();
                                            String _name = v.getName();
                                            it.setProductName(_name);
                                            Integer _quantity = v.getQuantity();
                                            it.setSourceQuantity(_quantity);
                                            String _productSpecsSid = v.getProductSpecsSid();
                                            it.setProductSid(_productSpecsSid);
                                            String _typeDesc = v.getTypeDesc();
                                            it.setTypeDesc(_typeDesc);
                                            RCMaterialBrandProxy _brand = v.getBrand();
                                            it.setBrand(_brand);
                                            RCProduceSpecificationUnitProxy _unit = v.getUnit();
                                            it.setUnit(_unit);
                                            Date _now = DateUtil.now();
                                            long _time = _now.getTime();
                                            long _minus = (-_time);
                                            it.setId(Long.valueOf(_minus));
                                            StockTakingRecordForm.this.transferRecordItemForm.quantity.setValue(null);
                                            StockTakingRecordForm.this.transferRecordItemForm.sourceQuantity.setValue(null);
                                            StockTakingRecordForm.this.transferRecordItemForm.storageSummary.setValue(null);
                                          }
                                        };
                                      UIWarehouseProductSpecSummary _doubleArrow = ObjectExtensions.<UIWarehouseProductSpecSummary>operator_doubleArrow(_valueAsNew, _function);
                                      _xifexpression_1 = _doubleArrow;
                                    }
                                    _xifexpression = _xifexpression_1;
                                  }
                                  return _xifexpression;
                                }
                              };
                            StockTakingRecordForm.this.itemSummarys.setObjectCreater(new Function<Void,UIWarehouseProductSpecSummary>() {
                                public UIWarehouseProductSpecSummary apply(Void input) {
                                  return _function_3.apply(input);
                                }
                            });
                          }
                        };
                      VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                      it.setWidget(_doubleArrow);
                    }
                  };
                FieldSet _doubleArrow_1 = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet, _function_1);
                ClientUi.operator_add(it, _doubleArrow_1);
                final Procedure1<UIWarehouseProductSpecSummary> _function_2 = new Procedure1<UIWarehouseProductSpecSummary>() {
                    public void apply(final UIWarehouseProductSpecSummary it) {
                      final Procedure1<UIWarehouseProductSpecSummary> _function = new Procedure1<UIWarehouseProductSpecSummary>() {
                          public void apply(final UIWarehouseProductSpecSummary it) {
                            UIProductWarehouseStorageSummary _storageSummary = it.getStorageSummary();
                            Integer _quantity = _storageSummary.getQuantity();
                            it.setSourceQuantity(_quantity);
                          }
                        };
                      UIWarehouseProductSpecSummary _doubleArrow = ObjectExtensions.<UIWarehouseProductSpecSummary>operator_doubleArrow(it, _function);
                      StockTakingRecordForm.this.transferRecordItemListGrid.updateElement(_doubleArrow);
                    }
                  };
                StockTakingRecordForm.this.transferRecordItemListGrid.addEditCompleteListener(new EditCompleteListener<UIWarehouseProductSpecSummary>() {
                    public void onEditComplete(UIWarehouseProductSpecSummary value) {
                      _function_2.apply(value);
                    }
                });
                FieldLabel _asWidget = StockTakingRecordForm.this.print.asWidget();
                final Procedure1<FieldLabel> _function_3 = new Procedure1<FieldLabel>() {
                    public void apply(final FieldLabel it) {
                      it.setWidth(150);
                      StockTakingRecordForm.this.print.setValue(Boolean.valueOf(true));
                    }
                  };
                FieldLabel _doubleArrow_2 = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function_3);
                ClientUi.operator_add(it, _doubleArrow_2);
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
  private WarehouseProductSpecSummaryListGrid transferRecordItemListGrid;
  
  @Inject
  private WarehouseProductSpecSummaryForm transferRecordItemForm;
  
  @Inject
  private ServerSideTimeServiceAsync timeService;
  
  private Widget con;
}
