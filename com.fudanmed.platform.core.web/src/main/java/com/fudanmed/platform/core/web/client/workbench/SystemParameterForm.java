package com.fudanmed.platform.core.web.client.workbench;

import com.fudanmed.platform.core.web.shared.workbench.UISystemParameter;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory.IntegerItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class SystemParameterForm extends GXTFormComponent<UISystemParameter> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem applicationTitle;
  
  public TextItem orgName;
  
  public IntegerItem refreshInterval;
  
  public IntegerItem customerEvalCommitInterval;
  
  public IntegerItem eboardRefreshInterval;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UISystemParameter value = new UISystemParameter();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();applicationTitle = stringValueProviderFactory.createAsTextItem("applicationTitle","应用系统标题");
    widgetsRegistory.put("applicationTitle",applicationTitle);
    orgName = stringValueProviderFactory.createAsTextItem("orgName","用户名称");
    widgetsRegistory.put("orgName",orgName);
    refreshInterval = integerValueProviderFactory.createAsIntegerItem("refreshInterval","客户端刷新间隔(秒)");
    widgetsRegistory.put("refreshInterval",refreshInterval);
    customerEvalCommitInterval = integerValueProviderFactory.createAsIntegerItem("customerEvalCommitInterval","科室反馈超时(天)");
    widgetsRegistory.put("customerEvalCommitInterval",customerEvalCommitInterval);
    eboardRefreshInterval = integerValueProviderFactory.createAsIntegerItem("eboardRefreshInterval","电子屏刷新间隔(秒)");
    widgetsRegistory.put("eboardRefreshInterval",eboardRefreshInterval);
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
  
  public UISystemParameter getValueAsNew() {
    UISystemParameter value = new UISystemParameter();
    value.setApplicationTitle(applicationTitle.getValue());
    value.setOrgName(orgName.getValue());
    value.setRefreshInterval(refreshInterval.getValue());
    value.setCustomerEvalCommitInterval(customerEvalCommitInterval.getValue());
    value.setEboardRefreshInterval(eboardRefreshInterval.getValue());
    return value;
  }
  
  public UISystemParameter doGetValue() {
    
    value.setApplicationTitle(applicationTitle.getValue());
    value.setOrgName(orgName.getValue());
    value.setRefreshInterval(refreshInterval.getValue());
    value.setCustomerEvalCommitInterval(customerEvalCommitInterval.getValue());
    value.setEboardRefreshInterval(eboardRefreshInterval.getValue());
    return value;
  }
  
  public UISystemParameter getValue(final UISystemParameter copyValue) {
    
    copyValue.setApplicationTitle(applicationTitle.getValue());
    copyValue.setOrgName(orgName.getValue());
    copyValue.setRefreshInterval(refreshInterval.getValue());
    copyValue.setCustomerEvalCommitInterval(customerEvalCommitInterval.getValue());
    copyValue.setEboardRefreshInterval(eboardRefreshInterval.getValue());
    return copyValue;
  }
  
  protected SystemParameterForm doSetValue(final UISystemParameter value) {
    this.value = value;
    applicationTitle.setValue(value.getApplicationTitle());
    orgName.setValue(value.getOrgName());
    refreshInterval.setValue(value.getRefreshInterval());
    customerEvalCommitInterval.setValue(value.getCustomerEvalCommitInterval());
    eboardRefreshInterval.setValue(value.getEboardRefreshInterval());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)applicationTitle,(ICanAsWidget)orgName,(ICanAsWidget)refreshInterval,(ICanAsWidget)customerEvalCommitInterval,(ICanAsWidget)eboardRefreshInterval
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = SystemParameterForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldLabel _asWidget = SystemParameterForm.this.applicationTitle.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
                FieldLabel _asWidget_1 = SystemParameterForm.this.orgName.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_1);
                FieldLabel _asWidget_2 = SystemParameterForm.this.refreshInterval.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_2);
                FieldLabel _asWidget_3 = SystemParameterForm.this.eboardRefreshInterval.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_3);
                FieldLabel _asWidget_4 = SystemParameterForm.this.customerEvalCommitInterval.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_4);
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
  
  private Widget con;
}
