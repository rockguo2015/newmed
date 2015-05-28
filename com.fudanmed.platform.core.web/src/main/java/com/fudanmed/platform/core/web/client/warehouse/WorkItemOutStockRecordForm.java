package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.common.ServerSideTimeServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.AllWarehouseByManagerContentProvider;
import com.fudanmed.platform.core.web.client.warehouse.WarehouseProductSpecSummaryForm;
import com.fudanmed.platform.core.web.client.warehouse.WarehouseProductSpecSummaryListGrid;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIWarehouseProductSpecSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemOutStockRecord;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.box.MessageBox;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.BlurEvent;
import com.sencha.gxt.widget.core.client.event.BlurEvent.BlurHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;
import com.uniquesoft.gwt.shared.DateUtil;
import com.uniquesoft.gwt.shared.extensions.NumberExtensions;
import edu.fudan.langlab.gxt.client.component.KeyboardNav;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

public class WorkItemOutStockRecordForm extends GXTFormComponent<UIWorkItemOutStockRecord> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public ComboBoxSelector<RCWarehouseProxy> sourceStore;
  
  @Inject
  public AllWarehouseByManagerContentProvider sourceStoreContentProvider;
  
  public StringReadonlyItem reportSid;
  
  public ReadonlyItem<RCWorkItemTaskProxy> workItem;
  
  public ListGridBasedItemsProvider<UIWarehouseProductSpecSummary> itemSummarys;
  
  public TextItem comment;
  
  public DateReadonlyItem date;
  
  public CheckBoxItem print;
  
  public CheckBoxItem fitPrint;
  
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
  
  private UIWorkItemOutStockRecord value = new UIWorkItemOutStockRecord();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sourceStore = defaultObjectSelectorFactory.createAsRequiredComboBoxItem("sourceStore","出库仓库");
    sourceStore.setContentProvider(sourceStoreContentProvider);
    widgetsRegistory.put("sourceStore",sourceStore);
    reportSid = stringValueProviderFactory.createAsReadonlyItem("reportSid","报修单号");
    widgetsRegistory.put("reportSid",reportSid);
    workItem = defaultObjectSelectorFactory.createAsReadonlyItem("workItem","工单号");
    widgetsRegistory.put("workItem",workItem);
    itemSummarys = defaultObjectsSelectorFactory.createAsListGridBasedItem("itemSummarys","领料明细",this.transferRecordItemListGrid);
    widgetsRegistory.put("itemSummarys",itemSummarys);
    comment = stringValueProviderFactory.createAsTextItem("comment","备注");
    widgetsRegistory.put("comment",comment);
    date = dateValueProviderFactory.createAsReadonlyItem("date","领料日期");
    widgetsRegistory.put("date",date);
    print = booleanValueProviderFactory.createAsCheckBoxItem("print","打印领料单");
    widgetsRegistory.put("print",print);
    fitPrint = booleanValueProviderFactory.createAsCheckBoxItem("fitPrint","套打");
    widgetsRegistory.put("fitPrint",fitPrint);
    if(transferRecordItemListGrid instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)transferRecordItemListGrid);
    						}if(transferRecordItemForm instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)transferRecordItemForm);
    						}if(timeService instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)timeService);
    						}if(con instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)con);
    						}if(productSidSelectedHandler instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)productSidSelectedHandler);
    						}if(lastInputComponent instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)lastInputComponent);
    						}IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIWorkItemOutStockRecord getValueAsNew() {
    UIWorkItemOutStockRecord value = new UIWorkItemOutStockRecord();
    value.setSourceStore(sourceStore.getValue());
    value.setReportSid(reportSid.getValue());
    value.setWorkItem(workItem.getValue());
    value.setItemSummarys(itemSummarys.getValue());
    value.setComment(comment.getValue());
    value.setDate(date.getValue());
    value.setPrint(print.getValue());
    value.setFitPrint(fitPrint.getValue());
    return value;
  }
  
  public UIWorkItemOutStockRecord doGetValue() {
    
    value.setSourceStore(sourceStore.getValue());
    value.setReportSid(reportSid.getValue());
    value.setWorkItem(workItem.getValue());
    value.setItemSummarys(itemSummarys.getValue());
    value.setComment(comment.getValue());
    value.setDate(date.getValue());
    value.setPrint(print.getValue());
    value.setFitPrint(fitPrint.getValue());
    return value;
  }
  
  public UIWorkItemOutStockRecord getValue(final UIWorkItemOutStockRecord copyValue) {
    
    copyValue.setSourceStore(sourceStore.getValue());
    copyValue.setReportSid(reportSid.getValue());
    copyValue.setWorkItem(workItem.getValue());
    copyValue.setItemSummarys(itemSummarys.getValue());
    copyValue.setComment(comment.getValue());
    copyValue.setDate(date.getValue());
    copyValue.setPrint(print.getValue());
    copyValue.setFitPrint(fitPrint.getValue());
    return copyValue;
  }
  
  protected WorkItemOutStockRecordForm doSetValue(final UIWorkItemOutStockRecord value) {
    this.value = value;
    sourceStore.setValue(value.getSourceStore());
    reportSid.setValue(value.getReportSid());
    workItem.setValue(value.getWorkItem());
    itemSummarys.setValue(value.getItemSummarys());
    comment.setValue(value.getComment());
    date.setValue(value.getDate());
    print.setValue(value.getPrint());
    fitPrint.setValue(value.getFitPrint());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sourceStore,(ICanAsWidget)reportSid,(ICanAsWidget)workItem,(ICanAsWidget)itemSummarys,(ICanAsWidget)comment,(ICanAsWidget)date,(ICanAsWidget)print,(ICanAsWidget)fitPrint
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
  
  public void setSourceWarehouse(final RCWarehouseProxy store) {
    this.transferRecordItemForm.setSourceWarehouse(store);
  }
  
  public void setProductSummary(final UIProductWarehouseStorageSummary productSummary) {
    this.transferRecordItemForm.storageSummary.setValue(productSummary);
    Integer _quantity = productSummary==null?(Integer)null:productSummary.getQuantity();
    Integer _nullsafe = NumberExtensions.nullsafe(_quantity);
    this.transferRecordItemForm.sourceQuantity.setValue(_nullsafe);
  }
  
  public void setProductSidSelectedHandler(final Procedure2<? super String,? super RCWarehouseProxy> callback) {
    this.productSidSelectedHandler = callback;
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = WorkItemOutStockRecordForm.this.widgets.VLayout();
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
                                  FieldLabel _asWidget = WorkItemOutStockRecordForm.this.date.asWidget();
                                  final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                      public void apply(final FieldLabel it) {
                                        final Procedure1<Date> _function = new Procedure1<Date>() {
                                            public void apply(final Date it) {
                                              WorkItemOutStockRecordForm.this.date.setValue(it);
                                            }
                                          };
                                        AsyncCallback<Date> _onSuccess = WorkItemOutStockRecordForm.this.<Date>onSuccess(_function);
                                        WorkItemOutStockRecordForm.this.timeService.getTime(_onSuccess);
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
                                  FieldLabel _asWidget = WorkItemOutStockRecordForm.this.sourceStore.asWidget();
                                  final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                      public void apply(final FieldLabel it) {
                                        final Procedure1<RCWarehouseProxy> _function = new Procedure1<RCWarehouseProxy>() {
                                            public void apply(final RCWarehouseProxy it) {
                                              WorkItemOutStockRecordForm.this.transferRecordItemForm.setSourceWarehouse(it);
                                              WorkItemOutStockRecordForm.this.transferRecordItemForm.storageSummary.clear();
                                              ArrayList<UIWarehouseProductSpecSummary> _newArrayList = CollectionLiterals.<UIWarehouseProductSpecSummary>newArrayList();
                                              WorkItemOutStockRecordForm.this.itemSummarys.setValue(_newArrayList);
                                            }
                                          };
                                        WorkItemOutStockRecordForm.this.sourceStore.addValueChangedListener(new ValueChangedListener<RCWarehouseProxy>() {
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
                                  FieldLabel _asWidget = WorkItemOutStockRecordForm.this.reportSid.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                            PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = WorkItemOutStockRecordForm.this.workItem.asWidget();
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
                VerticalLayoutData _VLayoutData = WorkItemOutStockRecordForm.this.widgets.VLayoutData(1, _minus);
                it.add(_doubleArrow, _VLayoutData);
                FieldSet _FieldSet = WorkItemOutStockRecordForm.this.widgets.FieldSet("\u9886\u6599\u660E\u7EC6");
                final Procedure1<FieldSet> _function_1 = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      VerticalLayoutContainer _VLayout = WorkItemOutStockRecordForm.this.widgets.VLayout();
                      final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                          public void apply(final VerticalLayoutContainer it) {
                            PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
                            final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
                                public void apply(final PlainHTMLTable it) {
                                  Component _field = WorkItemOutStockRecordForm.this.transferRecordItemForm.storageSummary.getField();
                                  WorkItemOutStockRecordForm.this.lastInputComponent = _field;
                                  PlainHTMLTR _tr = HTMLTagsExt.tr(it);
                                  final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
                                      public void apply(final PlainHTMLTR it) {
                                        PlainHTMLTD _td = HTMLTagsExt.td(it);
                                        final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                            public void apply(final PlainHTMLTD it) {
                                              FieldLabel _asWidget = WorkItemOutStockRecordForm.this.transferRecordItemForm.storageSummary.asWidget();
                                              final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                                  public void apply(final FieldLabel it) {
                                                    it.setWidth(485);
                                                    final Procedure1<Iterable<UIProductWarehouseStorageSummary>> _function = new Procedure1<Iterable<UIProductWarehouseStorageSummary>>() {
                                                        public void apply(final Iterable<UIProductWarehouseStorageSummary> it) {
                                                          UIProductWarehouseStorageSummary _head = IterableExtensions.<UIProductWarehouseStorageSummary>head(it);
                                                          Integer _quantity = _head.getQuantity();
                                                          WorkItemOutStockRecordForm.this.transferRecordItemForm.sourceQuantity.setValue(_quantity);
                                                        }
                                                      };
                                                    WorkItemOutStockRecordForm.this.transferRecordItemForm.storageSummary.addSelectionChangedListener(new SelectionChangedListener<UIProductWarehouseStorageSummary>() {
                                                        public void selectionChanged(Iterable<UIProductWarehouseStorageSummary> selections) {
                                                          _function.apply(selections);
                                                        }
                                                    });
                                                    Component _field = WorkItemOutStockRecordForm.this.transferRecordItemForm.storageSummary.getField();
                                                    final Procedure1<BlurEvent> _function_1 = new Procedure1<BlurEvent>() {
                                                        public void apply(final BlurEvent it) {
                                                          UIProductWarehouseStorageSummary _value = WorkItemOutStockRecordForm.this.transferRecordItemForm.storageSummary.getValue();
                                                          String _productSpecsSid = _value==null?(String)null:_value.getProductSpecsSid();
                                                          WorkItemOutStockRecordForm.this.transferRecordItemForm.productSid.setValue(_productSpecsSid);
                                                        }
                                                      };
                                                    _field.addBlurHandler(new BlurHandler() {
                                                        public void onBlur(BlurEvent event) {
                                                          _function_1.apply(event);
                                                        }
                                                    });
                                                    final Procedure1<Void> _function_2 = new Procedure1<Void>() {
                                                        public void apply(final Void it) {
                                                          Component _field = WorkItemOutStockRecordForm.this.transferRecordItemForm.storageSummary.getField();
                                                          WorkItemOutStockRecordForm.this.lastInputComponent = _field;
                                                          WorkItemOutStockRecordForm.this.transferRecordItemForm.quantity.focus();
                                                        }
                                                      };
                                                    KeyboardNav.OnEnter(it, _function_2);
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
                                              FieldLabel _asWidget = WorkItemOutStockRecordForm.this.transferRecordItemForm.productSid.asWidget();
                                              final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                                  public void apply(final FieldLabel it) {
                                                    Component _field = WorkItemOutStockRecordForm.this.transferRecordItemForm.productSid.getField();
                                                    final Procedure1<BlurEvent> _function = new Procedure1<BlurEvent>() {
                                                        public void apply(final BlurEvent it) {
                                                          String _value = WorkItemOutStockRecordForm.this.transferRecordItemForm.productSid.getValue();
                                                          RCWarehouseProxy _value_1 = WorkItemOutStockRecordForm.this.sourceStore.getValue();
                                                          if (WorkItemOutStockRecordForm.this.productSidSelectedHandler!=null) WorkItemOutStockRecordForm.this.productSidSelectedHandler.apply(_value, _value_1);
                                                        }
                                                      };
                                                    _field.addBlurHandler(new BlurHandler() {
                                                        public void onBlur(BlurEvent event) {
                                                          _function.apply(event);
                                                        }
                                                    });
                                                    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
                                                        public void apply(final Void it) {
                                                          Component _field = WorkItemOutStockRecordForm.this.transferRecordItemForm.productSid.getField();
                                                          WorkItemOutStockRecordForm.this.lastInputComponent = _field;
                                                          WorkItemOutStockRecordForm.this.transferRecordItemForm.quantity.focus();
                                                        }
                                                      };
                                                    KeyboardNav.OnEnter(it, _function_1);
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
                                              FieldLabel _asWidget = WorkItemOutStockRecordForm.this.transferRecordItemForm.sourceQuantity.asWidget();
                                              ClientUi.operator_add(it, _asWidget);
                                            }
                                          };
                                        ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                                        PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                                        final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                            public void apply(final PlainHTMLTD it) {
                                              FieldLabel _asWidget = WorkItemOutStockRecordForm.this.transferRecordItemForm.quantity.asWidget();
                                              ClientUi.operator_add(it, _asWidget);
                                              final Procedure1<Void> _function = new Procedure1<Void>() {
                                                  public void apply(final Void it) {
                                                    UIWarehouseProductSpecSummary _createItem = WorkItemOutStockRecordForm.this.createItem();
                                                    final Procedure1<UIWarehouseProductSpecSummary> _function = new Procedure1<UIWarehouseProductSpecSummary>() {
                                                        public void apply(final UIWarehouseProductSpecSummary it) {
                                                          boolean _notEquals = (!Objects.equal(it, null));
                                                          if (_notEquals) {
                                                            WorkItemOutStockRecordForm.this.transferRecordItemListGrid.addElement(it);
                                                            WorkItemOutStockRecordForm.this.lastInputComponent.focus();
                                                          }
                                                        }
                                                      };
                                                    ObjectExtensions.<UIWarehouseProductSpecSummary>operator_doubleArrow(_createItem, _function);
                                                  }
                                                };
                                              KeyboardNav.OnEnter(it, _function);
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
                            FieldLabel _asWidget = WorkItemOutStockRecordForm.this.itemSummarys.asWidget();
                            final Procedure1<FieldLabel> _function_2 = new Procedure1<FieldLabel>() {
                                public void apply(final FieldLabel it) {
                                  it.setHeight(250);
                                }
                              };
                            FieldLabel _doubleArrow_2 = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function_2);
                            WidgetExtensions.<FieldLabel>addFill(it, _doubleArrow_2);
                            final Function1<Void,UIWarehouseProductSpecSummary> _function_3 = new Function1<Void,UIWarehouseProductSpecSummary>() {
                                public UIWarehouseProductSpecSummary apply(final Void it) {
                                  UIWarehouseProductSpecSummary _createItem = WorkItemOutStockRecordForm.this.createItem();
                                  return _createItem;
                                }
                              };
                            WorkItemOutStockRecordForm.this.itemSummarys.setObjectCreater(new Function<Void,UIWarehouseProductSpecSummary>() {
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
                int _minus_1 = (-1);
                VerticalLayoutData _VLayoutData_1 = WorkItemOutStockRecordForm.this.widgets.VLayoutData(1, _minus_1);
                it.add(_doubleArrow_1, _VLayoutData_1);
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
                      WorkItemOutStockRecordForm.this.transferRecordItemListGrid.updateElement(_doubleArrow);
                    }
                  };
                WorkItemOutStockRecordForm.this.transferRecordItemListGrid.addEditCompleteListener(new EditCompleteListener<UIWarehouseProductSpecSummary>() {
                    public void onEditComplete(UIWarehouseProductSpecSummary value) {
                      _function_2.apply(value);
                    }
                });
                PlainHTMLTable _TABLE_1 = HTMLTagsExt.TABLE();
                final Procedure1<PlainHTMLTable> _function_3 = new Procedure1<PlainHTMLTable>() {
                    public void apply(final PlainHTMLTable it) {
                      PlainHTMLTR _tr = HTMLTagsExt.tr(it);
                      final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
                          public void apply(final PlainHTMLTR it) {
                            PlainHTMLTD _td = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = WorkItemOutStockRecordForm.this.print.asWidget();
                                  final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                      public void apply(final FieldLabel it) {
                                        it.setWidth(130);
                                        WorkItemOutStockRecordForm.this.print.setValue(Boolean.valueOf(true));
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
                                  FieldLabel _asWidget = WorkItemOutStockRecordForm.this.fitPrint.asWidget();
                                  final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                      public void apply(final FieldLabel it) {
                                        it.setWidth(130);
                                        WorkItemOutStockRecordForm.this.fitPrint.setValue(Boolean.valueOf(true));
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
                PlainHTMLTable _doubleArrow_2 = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE_1, _function_3);
                int _minus_2 = (-1);
                VerticalLayoutData _VLayoutData_2 = WorkItemOutStockRecordForm.this.widgets.VLayoutData(1, _minus_2, 2);
                it.add(_doubleArrow_2, _VLayoutData_2);
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
  
  public UIWarehouseProductSpecSummary createItem() {
    UIWarehouseProductSpecSummary _xifexpression = null;
    boolean _or = false;
    Integer _value = this.transferRecordItemForm.quantity.getValue();
    boolean _equals = Objects.equal(_value, null);
    if (_equals) {
      _or = true;
    } else {
      UIProductWarehouseStorageSummary _value_1 = this.transferRecordItemForm.storageSummary.getValue();
      boolean _equals_1 = Objects.equal(_value_1, null);
      _or = (_equals || _equals_1);
    }
    if (_or) {
      _xifexpression = null;
    } else {
      UIWarehouseProductSpecSummary _xifexpression_1 = null;
      Integer _value_2 = this.transferRecordItemForm.quantity.getValue();
      UIProductWarehouseStorageSummary _value_3 = this.transferRecordItemForm.storageSummary.getValue();
      Integer _quantity = _value_3.getQuantity();
      boolean _greaterThan = (_value_2.compareTo(_quantity) > 0);
      if (_greaterThan) {
        UIWarehouseProductSpecSummary _xblockexpression = null;
        {
          MessageBox _MessageBox = this.widgets.MessageBox("\u65E0\u6548\u8F93\u5165", "\u5E93\u5B58\u6570\u91CF\u4E0D\u8DB3");
          _MessageBox.show();
          _xblockexpression = (null);
        }
        _xifexpression_1 = _xblockexpression;
      } else {
        UIWarehouseProductSpecSummary _valueAsNew = this.transferRecordItemForm.getValueAsNew();
        final Procedure1<UIWarehouseProductSpecSummary> _function = new Procedure1<UIWarehouseProductSpecSummary>() {
            public void apply(final UIWarehouseProductSpecSummary it) {
              final UIProductWarehouseStorageSummary v = WorkItemOutStockRecordForm.this.transferRecordItemForm.storageSummary.getValue();
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
              WorkItemOutStockRecordForm.this.transferRecordItemForm.quantity.setValue(null);
              WorkItemOutStockRecordForm.this.transferRecordItemForm.sourceQuantity.setValue(null);
              WorkItemOutStockRecordForm.this.transferRecordItemForm.productSid.setValue(null);
              WorkItemOutStockRecordForm.this.transferRecordItemForm.storageSummary.setValue(null);
            }
          };
        UIWarehouseProductSpecSummary _doubleArrow = ObjectExtensions.<UIWarehouseProductSpecSummary>operator_doubleArrow(_valueAsNew, _function);
        _xifexpression_1 = _doubleArrow;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  @Inject
  private WarehouseProductSpecSummaryListGrid transferRecordItemListGrid;
  
  @Inject
  private WarehouseProductSpecSummaryForm transferRecordItemForm;
  
  @Inject
  private ServerSideTimeServiceAsync timeService;
  
  private Widget con;
  
  private Procedure2<? super String,? super RCWarehouseProxy> productSidSelectedHandler;
  
  private Component lastInputComponent;
}
