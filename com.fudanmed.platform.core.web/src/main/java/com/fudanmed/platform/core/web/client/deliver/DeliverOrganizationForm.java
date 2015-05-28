package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.AllOrganizationAsyncContentProvider;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverOrganization;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.component.form.factory.SuggestionComboBoxSelector;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeliverOrganizationForm extends GXTFormComponent<UIDeliverOrganization> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem name;
  
  public TextItem code;
  
  public SuggestionComboBoxSelector<RCOrganizationProxy> organization;
  
  @Inject
  public AllOrganizationAsyncContentProvider organizationContentProvider;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIDeliverOrganization value = new UIDeliverOrganization();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsTextItem("name","名称");
    widgetsRegistory.put("name",name);
    code = stringValueProviderFactory.createAsTextItem("code","代码");
    widgetsRegistory.put("code",code);
    organization = defaultObjectSelectorFactory.createAsSuggestionItem("organization","父类别");
    organization.setContentProvider(organizationContentProvider);
    widgetsRegistory.put("organization",organization);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIDeliverOrganization getValueAsNew() {
    UIDeliverOrganization value = new UIDeliverOrganization();
    value.setName(name.getValue());
    value.setCode(code.getValue());
    value.setOrganization(organization.getValue());
    return value;
  }
  
  public UIDeliverOrganization doGetValue() {
    
    value.setName(name.getValue());
    value.setCode(code.getValue());
    value.setOrganization(organization.getValue());
    return value;
  }
  
  public UIDeliverOrganization getValue(final UIDeliverOrganization copyValue) {
    
    copyValue.setName(name.getValue());
    copyValue.setCode(code.getValue());
    copyValue.setOrganization(organization.getValue());
    return copyValue;
  }
  
  protected DeliverOrganizationForm doSetValue(final UIDeliverOrganization value) {
    this.value = value;
    name.setValue(value.getName());
    code.setValue(value.getCode());
    organization.setValue(value.getOrganization());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)name,(ICanAsWidget)code,(ICanAsWidget)organization
    					);
  }
  
  public Widget asWidget() {
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          FieldLabel _asWidget = DeliverOrganizationForm.this.code.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
          FieldLabel _asWidget_1 = DeliverOrganizationForm.this.name.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget_1);
          FieldLabel _asWidget_2 = DeliverOrganizationForm.this.organization.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget_2);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    return _doubleArrow;
  }
}
