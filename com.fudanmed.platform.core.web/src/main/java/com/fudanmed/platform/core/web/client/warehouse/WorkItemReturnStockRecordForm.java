package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.common.ServerSideTimeServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.AllWarehouseByManagerContentProvider;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemProductSpecSummaryForm;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemProductSpecSummaryListGrid;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecificationSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemProductSpecSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemReturnStockRecord;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
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
import edu.fudan.langlab.gxt.client.component.form.factory.ReadonlyItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.StringReadonlyItem;
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

public class WorkItemReturnStockRecordForm extends GXTFormComponent<UIWorkItemReturnStockRecord> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public ComboBoxSelector<RCWarehouseProxy> sourceStore;
  
  @Inject
  public AllWarehouseByManagerContentProvider sourceStoreContentProvider;
  
  public StringReadonlyItem reportSid;
  
  public ReadonlyItem<RCWorkItemTaskProxy> workItem;
  
  public ListGridBasedItemsProvider<UIWorkItemProductSpecSummary> itemSummarys;
  
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
  
  private UIWorkItemReturnStockRecord value = new UIWorkItemReturnStockRecord();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sourceStore = defaultObjectSelectorFactory.createAsRequiredComboBoxItem("sourceStore","入库仓库");
    sourceStore.setContentProvider(sourceStoreContentProvider);
    widgetsRegistory.put("sourceStore",sourceStore);
    reportSid = stringValueProviderFactory.createAsReadonlyItem("reportSid","报修单号");
    widgetsRegistory.put("reportSid",reportSid);
    workItem = defaultObjectSelectorFactory.createAsReadonlyItem("workItem","工单号");
    widgetsRegistory.put("workItem",workItem);
    itemSummarys = defaultObjectsSelectorFactory.createAsListGridBasedItem("itemSummarys","退料明细",this.transferRecordItemListGrid);
    widgetsRegistory.put("itemSummarys",itemSummarys);
    comment = stringValueProviderFactory.createAsTextItem("comment","备注");
    widgetsRegistory.put("comment",comment);
    date = dateValueProviderFactory.createAsReadonlyItem("date","退料日期");
    widgetsRegistory.put("date",date);
    print = booleanValueProviderFactory.createAsCheckBoxItem("print","打印退料单");
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
  
  public UIWorkItemReturnStockRecord getValueAsNew() {
    UIWorkItemReturnStockRecord value = new UIWorkItemReturnStockRecord();
    value.setSourceStore(sourceStore.getValue());
    value.setReportSid(reportSid.getValue());
    value.setWorkItem(workItem.getValue());
    value.setItemSummarys(itemSummarys.getValue());
    value.setComment(comment.getValue());
    value.setDate(date.getValue());
    value.setPrint(print.getValue());
    return value;
  }
  
  public UIWorkItemReturnStockRecord doGetValue() {
    
    value.setSourceStore(sourceStore.getValue());
    value.setReportSid(reportSid.getValue());
    value.setWorkItem(workItem.getValue());
    value.setItemSummarys(itemSummarys.getValue());
    value.setComment(comment.getValue());
    value.setDate(date.getValue());
    value.setPrint(print.getValue());
    return value;
  }
  
  public UIWorkItemReturnStockRecord getValue(final UIWorkItemReturnStockRecord copyValue) {
    
    copyValue.setSourceStore(sourceStore.getValue());
    copyValue.setReportSid(reportSid.getValue());
    copyValue.setWorkItem(workItem.getValue());
    copyValue.setItemSummarys(itemSummarys.getValue());
    copyValue.setComment(comment.getValue());
    copyValue.setDate(date.getValue());
    copyValue.setPrint(print.getValue());
    return copyValue;
  }
  
  protected WorkItemReturnStockRecordForm doSetValue(final UIWorkItemReturnStockRecord value) {
    this.value = value;
    sourceStore.setValue(value.getSourceStore());
    reportSid.setValue(value.getReportSid());
    workItem.setValue(value.getWorkItem());
    itemSummarys.setValue(value.getItemSummarys());
    comment.setValue(value.getComment());
    date.setValue(value.getDate());
    print.setValue(value.getPrint());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sourceStore,(ICanAsWidget)reportSid,(ICanAsWidget)workItem,(ICanAsWidget)itemSummarys,(ICanAsWidget)comment,(ICanAsWidget)date,(ICanAsWidget)print
    					);
  }
  
  public void setSourceWarehouseContext(final RCEmployeeProxy employee, final Procedure1<? super Void> notifier) {
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          notifier.apply(null);
        }
      };
    this.sourceStoreContentProvider.load(employee, _function);
  }
  
  public void setWorkItemTask(final RCWorkItemTaskProxy workItem) {
    this.transferRecordItemForm.setWorkItem(workItem);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = WorkItemReturnStockRecordForm.this.widgets.VLayout();
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
                                  FieldLabel _asWidget = WorkItemReturnStockRecordForm.this.date.asWidget();
                                  final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                      public void apply(final FieldLabel it) {
                                        final Procedure1<Date> _function = new Procedure1<Date>() {
                                            public void apply(final Date it) {
                                              WorkItemReturnStockRecordForm.this.date.setValue(it);
                                            }
                                          };
                                        AsyncCallback<Date> _onSuccess = WorkItemReturnStockRecordForm.this.<Date>onSuccess(_function);
                                        WorkItemReturnStockRecordForm.this.timeService.getTime(_onSuccess);
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
                                  FieldLabel _asWidget = WorkItemReturnStockRecordForm.this.sourceStore.asWidget();
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
                                  FieldLabel _asWidget = WorkItemReturnStockRecordForm.this.reportSid.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                            PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = WorkItemReturnStockRecordForm.this.workItem.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_1, _function_1);
                    }
                  };
                PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
                int _minus = (-1);
                VerticalLayoutData _VLayoutData = WorkItemReturnStockRecordForm.this.widgets.VLayoutData(1, _minus);
                it.add(_doubleArrow, _VLayoutData);
                FieldSet _FieldSet = WorkItemReturnStockRecordForm.this.widgets.FieldSet("\u9000\u6599\u660E\u7EC6");
                final Procedure1<FieldSet> _function_1 = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      VerticalLayoutContainer _VLayout = WorkItemReturnStockRecordForm.this.widgets.VLayout();
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
                                              FieldLabel _asWidget = WorkItemReturnStockRecordForm.this.transferRecordItemForm.productSpecSummary.asWidget();
                                              final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                                  public void apply(final FieldLabel it) {
                                                    it.setWidth(585);
                                                    final Procedure1<Iterable<UIProductSpecificationSummary>> _function = new Procedure1<Iterable<UIProductSpecificationSummary>>() {
                                                        public void apply(final Iterable<UIProductSpecificationSummary> it) {
                                                          UIProductSpecificationSummary _head = IterableExtensions.<UIProductSpecificationSummary>head(it);
                                                          Integer _quantity = _head.getQuantity();
                                                          WorkItemReturnStockRecordForm.this.transferRecordItemForm.sourceQuantity.setValue(_quantity);
                                                        }
                                                      };
                                                    WorkItemReturnStockRecordForm.this.transferRecordItemForm.productSpecSummary.addSelectionChangedListener(new SelectionChangedListener<UIProductSpecificationSummary>() {
                                                        public void selectionChanged(Iterable<UIProductSpecificationSummary> selections) {
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
                                              it.setWidth("330");
                                              FieldLabel _asWidget = WorkItemReturnStockRecordForm.this.transferRecordItemForm.sourceQuantity.asWidget();
                                              ClientUi.operator_add(it, _asWidget);
                                            }
                                          };
                                        ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                                        PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                                        final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                            public void apply(final PlainHTMLTD it) {
                                              FieldLabel _asWidget = WorkItemReturnStockRecordForm.this.transferRecordItemForm.quantity.asWidget();
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
                            FieldLabel _asWidget = WorkItemReturnStockRecordForm.this.itemSummarys.asWidget();
                            final Procedure1<FieldLabel> _function_2 = new Procedure1<FieldLabel>() {
                                public void apply(final FieldLabel it) {
                                  it.setHeight(250);
                                }
                              };
                            FieldLabel _doubleArrow_2 = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function_2);
                            WidgetExtensions.<FieldLabel>addFill(it, _doubleArrow_2);
                            final Function1<Void,UIWorkItemProductSpecSummary> _function_3 = new Function1<Void,UIWorkItemProductSpecSummary>() {
                                public UIWorkItemProductSpecSummary apply(final Void it) {
                                  UIWorkItemProductSpecSummary _xifexpression = null;
                                  boolean _or = false;
                                  Integer _value = WorkItemReturnStockRecordForm.this.transferRecordItemForm.quantity.getValue();
                                  boolean _equals = Objects.equal(_value, null);
                                  if (_equals) {
                                    _or = true;
                                  } else {
                                    UIProductSpecificationSummary _value_1 = WorkItemReturnStockRecordForm.this.transferRecordItemForm.productSpecSummary.getValue();
                                    boolean _equals_1 = Objects.equal(_value_1, null);
                                    _or = (_equals || _equals_1);
                                  }
                                  if (_or) {
                                    _xifexpression = null;
                                  } else {
                                    UIWorkItemProductSpecSummary _valueAsNew = WorkItemReturnStockRecordForm.this.transferRecordItemForm.getValueAsNew();
                                    final Procedure1<UIWorkItemProductSpecSummary> _function = new Procedure1<UIWorkItemProductSpecSummary>() {
                                        public void apply(final UIWorkItemProductSpecSummary it) {
                                          final UIProductSpecificationSummary v = WorkItemReturnStockRecordForm.this.transferRecordItemForm.productSpecSummary.getValue();
                                          RCProductSpecificationProxy _productSpec = v.getProductSpec();
                                          String _name = _productSpec.getName();
                                          it.setProductName(_name);
                                          Integer _quantity = v.getQuantity();
                                          it.setSourceQuantity(_quantity);
                                          String _sid = v.getSid();
                                          it.setProductSid(_sid);
                                          String _typeDesc = v.getTypeDesc();
                                          it.setTypeDesc(_typeDesc);
                                          RCProduceSpecificationUnitProxy _unit = v.getUnit();
                                          it.setUnit(_unit);
                                          Date _now = DateUtil.now();
                                          long _time = _now.getTime();
                                          long _minus = (-_time);
                                          it.setId(Long.valueOf(_minus));
                                          WorkItemReturnStockRecordForm.this.transferRecordItemForm.quantity.setValue(null);
                                          WorkItemReturnStockRecordForm.this.transferRecordItemForm.sourceQuantity.setValue(null);
                                          WorkItemReturnStockRecordForm.this.transferRecordItemForm.productSpecSummary.setValue(null);
                                        }
                                      };
                                    UIWorkItemProductSpecSummary _doubleArrow = ObjectExtensions.<UIWorkItemProductSpecSummary>operator_doubleArrow(_valueAsNew, _function);
                                    _xifexpression = _doubleArrow;
                                  }
                                  return _xifexpression;
                                }
                              };
                            WorkItemReturnStockRecordForm.this.itemSummarys.setObjectCreater(new Function<Void,UIWorkItemProductSpecSummary>() {
                                public UIWorkItemProductSpecSummary apply(Void input) {
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
                int _minus_1 = (-1);
                VerticalLayoutData _VLayoutData_1 = WorkItemReturnStockRecordForm.this.widgets.VLayoutData(1, _minus_1);
                it.add(_doubleArrow_1, _VLayoutData_1);
                final Procedure1<UIWorkItemProductSpecSummary> _function_2 = new Procedure1<UIWorkItemProductSpecSummary>() {
                    public void apply(final UIWorkItemProductSpecSummary it) {
                      final Procedure1<UIWorkItemProductSpecSummary> _function = new Procedure1<UIWorkItemProductSpecSummary>() {
                          public void apply(final UIWorkItemProductSpecSummary it) {
                          }
                        };
                      UIWorkItemProductSpecSummary _doubleArrow = ObjectExtensions.<UIWorkItemProductSpecSummary>operator_doubleArrow(it, _function);
                      WorkItemReturnStockRecordForm.this.transferRecordItemListGrid.updateElement(_doubleArrow);
                    }
                  };
                WorkItemReturnStockRecordForm.this.transferRecordItemListGrid.addEditCompleteListener(new EditCompleteListener<UIWorkItemProductSpecSummary>() {
                    public void onEditComplete(UIWorkItemProductSpecSummary value) {
                      _function_2.apply(value);
                    }
                });
                FieldLabel _asWidget = WorkItemReturnStockRecordForm.this.print.asWidget();
                int _minus_2 = (-1);
                VerticalLayoutData _VLayoutData_2 = WorkItemReturnStockRecordForm.this.widgets.VLayoutData(130, _minus_2, 2);
                it.add(_asWidget, _VLayoutData_2);
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
  private WorkItemProductSpecSummaryListGrid transferRecordItemListGrid;
  
  @Inject
  private WorkItemProductSpecSummaryForm transferRecordItemForm;
  
  @Inject
  private ServerSideTimeServiceAsync timeService;
  
  private Widget con;
}
