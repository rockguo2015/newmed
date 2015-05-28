package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCInStoreTypeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.common.ServerSideTimeServiceAsync;
import com.fudanmed.platform.core.web.client.organization.AllSupplierContentProvider;
import com.fudanmed.platform.core.web.client.warehouse.AllInStoreTypeContentProvider;
import com.fudanmed.platform.core.web.client.warehouse.AllWarehouseByManagerContentProvider;
import com.fudanmed.platform.core.web.client.warehouse.InStockRecordItemForm;
import com.fudanmed.platform.core.web.client.warehouse.InStockRecordItemListGrid;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecordItem;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.BlurEvent;
import com.sencha.gxt.widget.core.client.event.BlurEvent.BlurHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.sencha.gxt.widget.core.client.info.Info;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
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
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextAreaItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.component.form.factory.SuggestionComboBoxSelector;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import java.util.Date;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class InStockRecordForm extends GXTFormComponent<UIInStockRecord> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DateReadonlyItem date;
  
  public ListGridBasedItemsProvider<UIInStockRecordItem> items;
  
  public ComboBoxSelector<RCWarehouseProxy> store;
  
  @Inject
  public AllWarehouseByManagerContentProvider storeContentProvider;
  
  public ComboBoxSelector<RCInStoreTypeProxy> inStoreType;
  
  @Inject
  public AllInStoreTypeContentProvider inStoreTypeContentProvider;
  
  public TextItem invoiceNumber;
  
  public TextItem deliverNumber;
  
  public TextAreaItem comment;
  
  public SuggestionComboBoxSelector<RCSupplierProxy> supplier;
  
  @Inject
  public AllSupplierContentProvider supplierContentProvider;
  
  public CheckBoxItem saveOnly;
  
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
  
  private UIInStockRecord value = new UIInStockRecord();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();date = dateValueProviderFactory.createAsReadonlyItem("date","入库日期");
    widgetsRegistory.put("date",date);
    items = defaultObjectsSelectorFactory.createAsListGridBasedItem("items","入库明细",this.detailsListGrid);
    widgetsRegistory.put("items",items);
    store = defaultObjectSelectorFactory.createAsComboBoxItem("store","入库仓库");
    store.setContentProvider(storeContentProvider);
    widgetsRegistory.put("store",store);
    inStoreType = defaultObjectSelectorFactory.createAsComboBoxItem("inStoreType","入库类型");
    _initializerSupports.add(inStoreTypeContentProvider);
    inStoreType.setContentProvider(inStoreTypeContentProvider);
    widgetsRegistory.put("inStoreType",inStoreType);
    invoiceNumber = stringValueProviderFactory.createAsTextItem("invoiceNumber","发票号码");
    widgetsRegistory.put("invoiceNumber",invoiceNumber);
    deliverNumber = stringValueProviderFactory.createAsTextItem("deliverNumber","送货单号");
    widgetsRegistory.put("deliverNumber",deliverNumber);
    comment = stringValueProviderFactory.createAsTextAreaItem("comment","备注");
    widgetsRegistory.put("comment",comment);
    supplier = defaultObjectSelectorFactory.createAsSuggestionItem("supplier","供应商");
    supplier.setContentProvider(supplierContentProvider);
    widgetsRegistory.put("supplier",supplier);
    saveOnly = booleanValueProviderFactory.createAsCheckBoxItem("saveOnly","仅保存");
    widgetsRegistory.put("saveOnly",saveOnly);
    print = booleanValueProviderFactory.createAsCheckBoxItem("print","打印入库单");
    widgetsRegistory.put("print",print);
    if(detailsListGrid instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)detailsListGrid);
    						}if(inStockRecordItemForm instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)inStockRecordItemForm);
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
  
  public UIInStockRecord getValueAsNew() {
    UIInStockRecord value = new UIInStockRecord();
    value.setDate(date.getValue());
    value.setItems(items.getValue());
    value.setStore(store.getValue());
    value.setInStoreType(inStoreType.getValue());
    value.setInvoiceNumber(invoiceNumber.getValue());
    value.setDeliverNumber(deliverNumber.getValue());
    value.setComment(comment.getValue());
    value.setSupplier(supplier.getValue());
    value.setSaveOnly(saveOnly.getValue());
    value.setPrint(print.getValue());
    return value;
  }
  
  public UIInStockRecord doGetValue() {
    
    value.setDate(date.getValue());
    value.setItems(items.getValue());
    value.setStore(store.getValue());
    value.setInStoreType(inStoreType.getValue());
    value.setInvoiceNumber(invoiceNumber.getValue());
    value.setDeliverNumber(deliverNumber.getValue());
    value.setComment(comment.getValue());
    value.setSupplier(supplier.getValue());
    value.setSaveOnly(saveOnly.getValue());
    value.setPrint(print.getValue());
    return value;
  }
  
  public UIInStockRecord getValue(final UIInStockRecord copyValue) {
    
    copyValue.setDate(date.getValue());
    copyValue.setItems(items.getValue());
    copyValue.setStore(store.getValue());
    copyValue.setInStoreType(inStoreType.getValue());
    copyValue.setInvoiceNumber(invoiceNumber.getValue());
    copyValue.setDeliverNumber(deliverNumber.getValue());
    copyValue.setComment(comment.getValue());
    copyValue.setSupplier(supplier.getValue());
    copyValue.setSaveOnly(saveOnly.getValue());
    copyValue.setPrint(print.getValue());
    return copyValue;
  }
  
  protected InStockRecordForm doSetValue(final UIInStockRecord value) {
    this.value = value;
    date.setValue(value.getDate());
    items.setValue(value.getItems());
    store.setValue(value.getStore());
    inStoreType.setValue(value.getInStoreType());
    invoiceNumber.setValue(value.getInvoiceNumber());
    deliverNumber.setValue(value.getDeliverNumber());
    comment.setValue(value.getComment());
    supplier.setValue(value.getSupplier());
    saveOnly.setValue(value.getSaveOnly());
    print.setValue(value.getPrint());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)date,(ICanAsWidget)items,(ICanAsWidget)store,(ICanAsWidget)inStoreType,(ICanAsWidget)invoiceNumber,(ICanAsWidget)deliverNumber,(ICanAsWidget)comment,(ICanAsWidget)supplier,(ICanAsWidget)saveOnly,(ICanAsWidget)print
    					);
  }
  
  public void setSourceWarehouseContext(final RCEmployeeProxy employee, final Procedure1<? super Void> notifier) {
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          notifier.apply(null);
        }
      };
    this.storeContentProvider.load(employee, _function);
  }
  
  public void setSelectedProductSpec(final UIProductSpecification productSpec) {
    this.inStockRecordItemForm.uiProductSpec.setValue(productSpec);
    Double _referencePrice = productSpec==null?(Double)null:productSpec.getReferencePrice();
    Double _nullsafe = NumberExtensions.nullsafe(_referencePrice);
    this.inStockRecordItemForm.price.setValue(_nullsafe);
  }
  
  public void setProductSidSelectedHandler(final Procedure1<? super String> callback) {
    this.productSidSelectedHandler = callback;
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = InStockRecordForm.this.widgets.VLayout();
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
                                  FieldLabel _asWidget = InStockRecordForm.this.date.asWidget();
                                  final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                      public void apply(final FieldLabel it) {
                                        final Procedure1<Date> _function = new Procedure1<Date>() {
                                            public void apply(final Date it) {
                                              InStockRecordForm.this.date.setValue(it);
                                            }
                                          };
                                        AsyncCallback<Date> _onSuccess = InStockRecordForm.this.<Date>onSuccess(_function);
                                        InStockRecordForm.this.timeService.getTime(_onSuccess);
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
                      PlainHTMLTR _tr_1 = HTMLTagsExt.tr(it);
                      final Procedure1<PlainHTMLTR> _function_1 = new Procedure1<PlainHTMLTR>() {
                          public void apply(final PlainHTMLTR it) {
                            PlainHTMLTD _td = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = InStockRecordForm.this.store.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                            PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = InStockRecordForm.this.supplier.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                            PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = InStockRecordForm.this.inStoreType.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_2, _function_2);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_1, _function_1);
                      PlainHTMLTR _tr_2 = HTMLTagsExt.tr(it);
                      final Procedure1<PlainHTMLTR> _function_2 = new Procedure1<PlainHTMLTR>() {
                          public void apply(final PlainHTMLTR it) {
                            PlainHTMLTD _td = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = InStockRecordForm.this.deliverNumber.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                            PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = InStockRecordForm.this.invoiceNumber.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_2, _function_2);
                    }
                  };
                PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
                int _minus = (-1);
                VerticalLayoutData _VLayoutData = InStockRecordForm.this.widgets.VLayoutData(1, _minus);
                it.add(_doubleArrow, _VLayoutData);
                FieldLabel _asWidget = InStockRecordForm.this.comment.asWidget();
                VerticalLayoutData _VLayoutData_1 = InStockRecordForm.this.widgets.VLayoutData(882, 60);
                it.add(_asWidget, _VLayoutData_1);
                FieldSet _FieldSet = InStockRecordForm.this.widgets.FieldSet("\u5165\u5E93\u9879\u76EE");
                final Procedure1<FieldSet> _function_1 = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      VerticalLayoutContainer _VLayout = InStockRecordForm.this.widgets.VLayout();
                      final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                          public void apply(final VerticalLayoutContainer it) {
                            PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
                            final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
                                public void apply(final PlainHTMLTable it) {
                                  Component _field = InStockRecordForm.this.inStockRecordItemForm.uiProductSpec.getField();
                                  InStockRecordForm.this.lastInputComponent = _field;
                                  PlainHTMLTR _tr = HTMLTagsExt.tr(it);
                                  final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
                                      public void apply(final PlainHTMLTR it) {
                                        PlainHTMLTD _td = HTMLTagsExt.td(it);
                                        final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                            public void apply(final PlainHTMLTD it) {
                                              FieldLabel _asWidget = InStockRecordForm.this.inStockRecordItemForm.sid.asWidget();
                                              ClientUi.operator_add(it, _asWidget);
                                            }
                                          };
                                        ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                                        PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                                        final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                            public void apply(final PlainHTMLTD it) {
                                              FieldLabel _asWidget = InStockRecordForm.this.inStockRecordItemForm.uiProductSpec.asWidget();
                                              ClientUi.operator_add(it, _asWidget);
                                              final Procedure1<Iterable<UIProductSpecification>> _function = new Procedure1<Iterable<UIProductSpecification>>() {
                                                  public void apply(final Iterable<UIProductSpecification> it) {
                                                    UIProductSpecification _head = IterableExtensions.<UIProductSpecification>head(it);
                                                    Double _referencePrice = _head.getReferencePrice();
                                                    Double _nullsafe = NumberExtensions.nullsafe(_referencePrice);
                                                    InStockRecordForm.this.inStockRecordItemForm.price.setValue(_nullsafe);
                                                  }
                                                };
                                              InStockRecordForm.this.inStockRecordItemForm.uiProductSpec.addSelectionChangedListener(new SelectionChangedListener<UIProductSpecification>() {
                                                  public void selectionChanged(Iterable<UIProductSpecification> selections) {
                                                    _function.apply(selections);
                                                  }
                                              });
                                              Component _field = InStockRecordForm.this.inStockRecordItemForm.uiProductSpec.getField();
                                              final Procedure1<BlurEvent> _function_1 = new Procedure1<BlurEvent>() {
                                                  public void apply(final BlurEvent it) {
                                                    UIProductSpecification _value = InStockRecordForm.this.inStockRecordItemForm.uiProductSpec.getValue();
                                                    final String selectedSid = _value==null?(String)null:_value.getSid();
                                                    InStockRecordForm.this.inStockRecordItemForm.productSid.setValue(selectedSid);
                                                  }
                                                };
                                              _field.addBlurHandler(new BlurHandler() {
                                                  public void onBlur(BlurEvent event) {
                                                    _function_1.apply(event);
                                                  }
                                              });
                                              final Procedure1<Void> _function_2 = new Procedure1<Void>() {
                                                  public void apply(final Void it) {
                                                    Component _field = InStockRecordForm.this.inStockRecordItemForm.uiProductSpec.getField();
                                                    InStockRecordForm.this.lastInputComponent = _field;
                                                    InStockRecordForm.this.inStockRecordItemForm.quantity.focus();
                                                  }
                                                };
                                              KeyboardNav.OnEnter(it, _function_2);
                                            }
                                          };
                                        ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                                        PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                                        final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                                            public void apply(final PlainHTMLTD it) {
                                              FieldLabel _asWidget = InStockRecordForm.this.inStockRecordItemForm.productSid.asWidget();
                                              final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                                  public void apply(final FieldLabel it) {
                                                    final Procedure1<Void> _function = new Procedure1<Void>() {
                                                        public void apply(final Void it) {
                                                          Component _field = InStockRecordForm.this.inStockRecordItemForm.productSid.getField();
                                                          InStockRecordForm.this.lastInputComponent = _field;
                                                          InStockRecordForm.this.inStockRecordItemForm.quantity.focus();
                                                        }
                                                      };
                                                    KeyboardNav.OnEnter(it, _function);
                                                    Component _field = InStockRecordForm.this.inStockRecordItemForm.productSid.getField();
                                                    final Procedure1<BlurEvent> _function_1 = new Procedure1<BlurEvent>() {
                                                        public void apply(final BlurEvent it) {
                                                          String _value = InStockRecordForm.this.inStockRecordItemForm.productSid.getValue();
                                                          if (InStockRecordForm.this.productSidSelectedHandler!=null) InStockRecordForm.this.productSidSelectedHandler.apply(_value);
                                                        }
                                                      };
                                                    _field.addBlurHandler(new BlurHandler() {
                                                        public void onBlur(BlurEvent event) {
                                                          _function_1.apply(event);
                                                        }
                                                    });
                                                  }
                                                };
                                              FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
                                              ClientUi.operator_add(it, _doubleArrow);
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
                                              FieldLabel _asWidget = InStockRecordForm.this.inStockRecordItemForm.quantity.asWidget();
                                              final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                                  public void apply(final FieldLabel it) {
                                                    final Procedure1<Void> _function = new Procedure1<Void>() {
                                                        public void apply(final Void it) {
                                                          InStockRecordForm.this.inStockRecordItemForm.price.focus();
                                                        }
                                                      };
                                                    KeyboardNav.OnEnter(it, _function);
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
                                              FieldLabel _asWidget = InStockRecordForm.this.inStockRecordItemForm.price.asWidget();
                                              final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                                  public void apply(final FieldLabel it) {
                                                    final Procedure1<Void> _function = new Procedure1<Void>() {
                                                        public void apply(final Void it) {
                                                          final UIInStockRecordItem newItem = InStockRecordForm.this.createItem();
                                                          boolean _notEquals = (!Objects.equal(newItem, null));
                                                          if (_notEquals) {
                                                            InStockRecordForm.this.lastInputComponent.focus();
                                                            InStockRecordForm.this.detailsListGrid.addElement(newItem);
                                                          }
                                                        }
                                                      };
                                                    KeyboardNav.OnEnter(it, _function);
                                                  }
                                                };
                                              FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
                                              ClientUi.operator_add(it, _doubleArrow);
                                            }
                                          };
                                        ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                                      }
                                    };
                                  ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_1, _function_1);
                                }
                              };
                            PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
                            it.add(_doubleArrow);
                            FieldLabel _asWidget = InStockRecordForm.this.items.asWidget();
                            VerticalLayoutData _VLayoutData = InStockRecordForm.this.widgets.VLayoutData(1, 225);
                            it.add(_asWidget, _VLayoutData);
                            PlainHTMLTable _TABLE_1 = HTMLTagsExt.TABLE();
                            final Procedure1<PlainHTMLTable> _function_1 = new Procedure1<PlainHTMLTable>() {
                                public void apply(final PlainHTMLTable it) {
                                  PlainHTMLTR _tr = HTMLTagsExt.tr(it);
                                  final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
                                      public void apply(final PlainHTMLTR it) {
                                        PlainHTMLTD _td = HTMLTagsExt.td(it);
                                        final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                            public void apply(final PlainHTMLTD it) {
                                              FieldLabel _asWidget = InStockRecordForm.this.saveOnly.asWidget();
                                              final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                                  public void apply(final FieldLabel it) {
                                                    InStockRecordForm.this.saveOnly.setValue(Boolean.valueOf(false));
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
                                              FieldLabel _asWidget = InStockRecordForm.this.print.asWidget();
                                              final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                                  public void apply(final FieldLabel it) {
                                                    InStockRecordForm.this.saveOnly.setValue(Boolean.valueOf(false));
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
                            PlainHTMLTable _doubleArrow_1 = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE_1, _function_1);
                            it.add(_doubleArrow_1);
                          }
                        };
                      VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                      it.setWidget(_doubleArrow);
                    }
                  };
                FieldSet _doubleArrow_1 = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet, _function_1);
                int _minus_1 = (-1);
                VerticalLayoutData _VLayoutData_2 = InStockRecordForm.this.widgets.VLayoutData(1, _minus_1);
                it.add(_doubleArrow_1, _VLayoutData_2);
                final Function1<Void,UIInStockRecordItem> _function_2 = new Function1<Void,UIInStockRecordItem>() {
                    public UIInStockRecordItem apply(final Void it) {
                      UIInStockRecordItem _createItem = InStockRecordForm.this.createItem();
                      return _createItem;
                    }
                  };
                InStockRecordForm.this.items.setObjectCreater(new Function<Void,UIInStockRecordItem>() {
                    public UIInStockRecordItem apply(Void input) {
                      return _function_2.apply(input);
                    }
                });
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
  
  public UIInStockRecordItem createItem() {
    UIInStockRecordItem _xifexpression = null;
    boolean _or = false;
    boolean _or_1 = false;
    UIProductSpecification _value = this.inStockRecordItemForm.uiProductSpec.getValue();
    boolean _equals = Objects.equal(_value, null);
    if (_equals) {
      _or_1 = true;
    } else {
      Double _value_1 = this.inStockRecordItemForm.price.getValue();
      boolean _equals_1 = Objects.equal(_value_1, null);
      _or_1 = (_equals || _equals_1);
    }
    if (_or_1) {
      _or = true;
    } else {
      Integer _value_2 = this.inStockRecordItemForm.quantity.getValue();
      boolean _equals_2 = Objects.equal(_value_2, null);
      _or = (_or_1 || _equals_2);
    }
    if (_or) {
      _xifexpression = null;
    } else {
      UIInStockRecordItem _xifexpression_1 = null;
      Iterable<UIInStockRecordItem> _objects = this.detailsListGrid.getObjects();
      final Function1<UIInStockRecordItem,Boolean> _function = new Function1<UIInStockRecordItem,Boolean>() {
          public Boolean apply(final UIInStockRecordItem it) {
            UIProductSpecification _uiProductSpec = it.getUiProductSpec();
            Long _id = _uiProductSpec.getId();
            UIProductSpecification _value = InStockRecordForm.this.inStockRecordItemForm.uiProductSpec.getValue();
            Long _id_1 = _value.getId();
            boolean _equals = Objects.equal(_id, _id_1);
            return Boolean.valueOf(_equals);
          }
        };
      boolean _exists = IterableExtensions.<UIInStockRecordItem>exists(_objects, _function);
      if (_exists) {
        UIInStockRecordItem _xblockexpression = null;
        {
          Info.display("\u8B66\u544A", "\u540C\u79CD\u7269\u54C1\u4E0D\u80FD\u5206\u522B\u5165\u5E93");
          _xblockexpression = (null);
        }
        _xifexpression_1 = _xblockexpression;
      } else {
        UIInStockRecordItem _valueAsNew = this.inStockRecordItemForm.getValueAsNew();
        final Procedure1<UIInStockRecordItem> _function_1 = new Procedure1<UIInStockRecordItem>() {
            public void apply(final UIInStockRecordItem it) {
              final UIProductSpecification v = InStockRecordForm.this.inStockRecordItemForm.uiProductSpec.getValue();
              boolean _notEquals = (!Objects.equal(v, null));
              if (_notEquals) {
                String _sid = v.getSid();
                it.setProductSid(_sid);
                String _typeDesc = v.getTypeDesc();
                it.setTypeDesc(_typeDesc);
                RCProduceSpecificationUnitProxy _unit = v.getUnit();
                it.setUnit(_unit);
                RCMaterialBrandProxy _brandType = v.getBrandType();
                it.setBrand(_brandType);
                String _materialId = v.getMaterialId();
                it.setMaterialId(_materialId);
                String _name = v.getName();
                it.setProductSpecName(_name);
                Date _now = DateUtil.now();
                long _time = _now.getTime();
                long _minus = (-_time);
                it.setId(Long.valueOf(_minus));
              }
              InStockRecordForm.this.inStockRecordItemForm.sid.setValue(null);
              InStockRecordForm.this.inStockRecordItemForm.uiProductSpec.setValue(null);
              InStockRecordForm.this.inStockRecordItemForm.price.setValue(null);
              InStockRecordForm.this.inStockRecordItemForm.productSid.setValue(null);
              InStockRecordForm.this.inStockRecordItemForm.quantity.setValue(null);
            }
          };
        UIInStockRecordItem _doubleArrow = ObjectExtensions.<UIInStockRecordItem>operator_doubleArrow(_valueAsNew, _function_1);
        _xifexpression_1 = _doubleArrow;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  @Inject
  private InStockRecordItemListGrid detailsListGrid;
  
  @Inject
  private InStockRecordItemForm inStockRecordItemForm;
  
  @Inject
  private ServerSideTimeServiceAsync timeService;
  
  private Widget con;
  
  private Procedure1<? super String> productSidSelectedHandler;
  
  private Component lastInputComponent;
}
