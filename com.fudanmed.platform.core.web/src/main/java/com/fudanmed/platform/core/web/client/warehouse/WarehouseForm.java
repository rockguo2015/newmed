package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.web.client.organization.AllEmployeesContentProvider;
import com.fudanmed.platform.core.web.client.organization.AllMaintenanceTeamContentProvider;
import com.fudanmed.platform.core.web.shared.warehouse.UIWarehouse;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FormPanel.LabelAlign;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory.CheckBoxItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectsSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DualListMultiSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WarehouseForm extends GXTFormComponent<UIWarehouse> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem name;
  
  public TextItem location;
  
  public DualListMultiSelector<RCEmployeeProxy> storeManager;
  
  @Inject
  public AllEmployeesContentProvider storeManagerContentProvider;
  
  public CheckBoxItem isMajor;
  
  public DualListMultiSelector<RCMaintenanceTeamProxy> relatedTeams;
  
  @Inject
  public AllMaintenanceTeamContentProvider relatedTeamsContentProvider;
  
  @Inject
  private DefaultObjectsSelectorFactory defaultObjectsSelectorFactory;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIWarehouse value = new UIWarehouse();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsTextItem("name","名称");
    widgetsRegistory.put("name",name);
    location = stringValueProviderFactory.createAsTextItem("location","位置");
    widgetsRegistory.put("location",location);
    storeManager = defaultObjectsSelectorFactory.createAsDualListItem("storeManager","仓库管理员");
    _initializerSupports.add(storeManagerContentProvider);
    storeManager.setContentProvider(storeManagerContentProvider);
    widgetsRegistory.put("storeManager",storeManager);
    isMajor = booleanValueProviderFactory.createAsCheckBoxItem("isMajor","主仓库");
    widgetsRegistory.put("isMajor",isMajor);
    relatedTeams = defaultObjectsSelectorFactory.createAsDualListItem("relatedTeams","关联班组");
    _initializerSupports.add(relatedTeamsContentProvider);
    relatedTeams.setContentProvider(relatedTeamsContentProvider);
    widgetsRegistory.put("relatedTeams",relatedTeams);
    if(con instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
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
  
  public UIWarehouse getValueAsNew() {
    UIWarehouse value = new UIWarehouse();
    value.setName(name.getValue());
    value.setLocation(location.getValue());
    value.setStoreManager(storeManager.getValue());
    value.setIsMajor(isMajor.getValue());
    value.setRelatedTeams(relatedTeams.getValue());
    return value;
  }
  
  public UIWarehouse doGetValue() {
    
    value.setName(name.getValue());
    value.setLocation(location.getValue());
    value.setStoreManager(storeManager.getValue());
    value.setIsMajor(isMajor.getValue());
    value.setRelatedTeams(relatedTeams.getValue());
    return value;
  }
  
  public UIWarehouse getValue(final UIWarehouse copyValue) {
    
    copyValue.setName(name.getValue());
    copyValue.setLocation(location.getValue());
    copyValue.setStoreManager(storeManager.getValue());
    copyValue.setIsMajor(isMajor.getValue());
    copyValue.setRelatedTeams(relatedTeams.getValue());
    return copyValue;
  }
  
  protected WarehouseForm doSetValue(final UIWarehouse value) {
    this.value = value;
    name.setValue(value.getName());
    location.setValue(value.getLocation());
    storeManager.setValue(value.getStoreManager());
    isMajor.setValue(value.getIsMajor());
    relatedTeams.setValue(value.getRelatedTeams());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)name,(ICanAsWidget)location,(ICanAsWidget)storeManager,(ICanAsWidget)isMajor,(ICanAsWidget)relatedTeams
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
                            FieldLabel _asWidget = WarehouseForm.this.name.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                      PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = WarehouseForm.this.location.asWidget();
                            final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                public void apply(final FieldLabel it) {
                                  it.setWidth(350);
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
                            FieldLabel _asWidget = WarehouseForm.this.isMajor.asWidget();
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
                            FieldLabel _asWidget = WarehouseForm.this.storeManager.asWidget();
                            final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                public void apply(final FieldLabel it) {
                                  it.setHeight(150);
                                  it.setWidth(250);
                                  it.setLabelAlign(LabelAlign.TOP);
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
                            FieldLabel _asWidget = WarehouseForm.this.relatedTeams.asWidget();
                            final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                public void apply(final FieldLabel it) {
                                  it.setHeight(150);
                                  it.setWidth(350);
                                  it.setLabelAlign(LabelAlign.TOP);
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
}
