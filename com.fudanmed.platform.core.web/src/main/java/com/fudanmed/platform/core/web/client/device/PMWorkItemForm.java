package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.web.client.organization.AllMaintenanceTeamContentProvider;
import com.fudanmed.platform.core.web.client.organization.AllSupplierContentProvider;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory.CheckBoxItem;
import edu.fudan.langlab.gxt.client.component.form.factory.ComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.StringReadonlyItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextAreaItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.component.form.factory.SuggestionComboBoxSelector;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PMWorkItemForm extends GXTFormComponent<UIPMWorkItem> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem title;
  
  public TextAreaItem description;
  
  public CheckBoxItem dispatchTeam;
  
  public StringReadonlyItem sid;
  
  public DateItem assignDate;
  
  public SuggestionComboBoxSelector<RCSupplierProxy> supplier;
  
  @Inject
  public AllSupplierContentProvider supplierContentProvider;
  
  public ComboBoxSelector<RCMaintenanceTeamProxy> team;
  
  @Inject
  public AllMaintenanceTeamContentProvider teamContentProvider;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIPMWorkItem value = new UIPMWorkItem();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();title = stringValueProviderFactory.createAsTextItem("title","名称");
    widgetsRegistory.put("title",title);
    description = stringValueProviderFactory.createAsTextAreaItem("description","说明");
    widgetsRegistory.put("description",description);
    dispatchTeam = booleanValueProviderFactory.createAsCheckBoxItem("dispatchTeam","派发班组");
    widgetsRegistory.put("dispatchTeam",dispatchTeam);
    sid = stringValueProviderFactory.createAsReadonlyItem("sid","任务单号");
    widgetsRegistory.put("sid",sid);
    assignDate = dateValueProviderFactory.createAsDateItem("assignDate","安排执行日期");
    widgetsRegistory.put("assignDate",assignDate);
    supplier = defaultObjectSelectorFactory.createAsSuggestionItem("supplier","服务提供商");
    supplier.setContentProvider(supplierContentProvider);
    widgetsRegistory.put("supplier",supplier);
    team = defaultObjectSelectorFactory.createAsComboBoxItem("team","配合班组");
    _initializerSupports.add(teamContentProvider);
    team.setContentProvider(teamContentProvider);
    widgetsRegistory.put("team",team);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIPMWorkItem getValueAsNew() {
    UIPMWorkItem value = new UIPMWorkItem();
    value.setTitle(title.getValue());
    value.setDescription(description.getValue());
    value.setDispatchTeam(dispatchTeam.getValue());
    value.setSid(sid.getValue());
    value.setAssignDate(assignDate.getValue());
    value.setSupplier(supplier.getValue());
    value.setTeam(team.getValue());
    return value;
  }
  
  public UIPMWorkItem doGetValue() {
    
    value.setTitle(title.getValue());
    value.setDescription(description.getValue());
    value.setDispatchTeam(dispatchTeam.getValue());
    value.setSid(sid.getValue());
    value.setAssignDate(assignDate.getValue());
    value.setSupplier(supplier.getValue());
    value.setTeam(team.getValue());
    return value;
  }
  
  public UIPMWorkItem getValue(final UIPMWorkItem copyValue) {
    
    copyValue.setTitle(title.getValue());
    copyValue.setDescription(description.getValue());
    copyValue.setDispatchTeam(dispatchTeam.getValue());
    copyValue.setSid(sid.getValue());
    copyValue.setAssignDate(assignDate.getValue());
    copyValue.setSupplier(supplier.getValue());
    copyValue.setTeam(team.getValue());
    return copyValue;
  }
  
  protected PMWorkItemForm doSetValue(final UIPMWorkItem value) {
    this.value = value;
    title.setValue(value.getTitle());
    description.setValue(value.getDescription());
    dispatchTeam.setValue(value.getDispatchTeam());
    sid.setValue(value.getSid());
    assignDate.setValue(value.getAssignDate());
    supplier.setValue(value.getSupplier());
    team.setValue(value.getTeam());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)title,(ICanAsWidget)description,(ICanAsWidget)dispatchTeam,(ICanAsWidget)sid,(ICanAsWidget)assignDate,(ICanAsWidget)supplier,(ICanAsWidget)team
    					);
  }
  
  public Widget createWidget() {
    PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
    final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
        public void apply(final PlainHTMLTable it) {
          PlainHTMLTR _tr = HTMLTagsExt.tr(it);
          final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
              public void apply(final PlainHTMLTR it) {
                PlainHTMLTD _td = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = PMWorkItemForm.this.title.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = PMWorkItemForm.this.assignDate.asWidget();
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
                      FieldLabel _asWidget = PMWorkItemForm.this.supplier.asWidget();
                      ClientUi.operator_add(it, _asWidget);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
              }
            };
          ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_1, _function_1);
          PlainHTMLTR _tr_2 = HTMLTagsExt.tr(it);
          final Procedure1<PlainHTMLTR> _function_2 = new Procedure1<PlainHTMLTR>() {
              public void apply(final PlainHTMLTR it) {
                PlainHTMLTD _td = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      FieldLabel _asWidget = PMWorkItemForm.this.dispatchTeam.asWidget();
                      final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                          public void apply(final FieldLabel it) {
                            final Procedure1<Boolean> _function = new Procedure1<Boolean>() {
                                public void apply(final Boolean dispatchToo) {
                                  if ((dispatchToo).booleanValue()) {
                                    FieldLabel _asWidget = PMWorkItemForm.this.team.asWidget();
                                    _asWidget.enable();
                                  } else {
                                    FieldLabel _asWidget_1 = PMWorkItemForm.this.team.asWidget();
                                    _asWidget_1.disable();
                                    PMWorkItemForm.this.team.setValue(null);
                                  }
                                }
                              };
                            PMWorkItemForm.this.dispatchTeam.addValueChangedListener(new ValueChangedListener<Boolean>() {
                                public void onValueChanged(Boolean value) {
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
                      FieldLabel _asWidget = PMWorkItemForm.this.team.asWidget();
                      final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                          public void apply(final FieldLabel it) {
                            it.disable();
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
                      it.setColSpan(2);
                      FieldLabel _asWidget = PMWorkItemForm.this.description.asWidget();
                      final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                          public void apply(final FieldLabel it) {
                            it.setHeight(50);
                            it.setWidth(700);
                          }
                        };
                      FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
                      ClientUi.operator_add(it, _doubleArrow);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
              }
            };
          ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_3, _function_3);
        }
      };
    PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
    return _doubleArrow;
  }
}
