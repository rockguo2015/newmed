package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverOrganization;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class DeliverOrganizationListGrid extends GXTGridComponent<UIDeliverOrganization> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIDeliverOrganization> code;
  
  public StringColumn<UIDeliverOrganization> name;
  
  public StringValueColumn<UIDeliverOrganization,RCOrganizationProxy> organization;
  
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
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();code = stringValueProviderFactory.createAsStringColumn("code","代码",UIDeliverOrganization.CodeAccessor);
    widgetsRegistory.put("code",code);
    name = stringValueProviderFactory.createAsStringColumn("name","名称",UIDeliverOrganization.NameAccessor);
    widgetsRegistory.put("name",name);
    organization = defaultObjectSelectorFactory.createAsDefaultColumn("organization","父类别",UIDeliverOrganization.OrganizationAccessor);
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
    value.setCode(code.getValue());
    value.setName(name.getValue());
    value.setOrganization(organization.getValue());
    return value;
  }
  
  public UIDeliverOrganization doGetValue() {
    
    value.setCode(code.getValue());
    value.setName(name.getValue());
    value.setOrganization(organization.getValue());
    return value;
  }
  
  public UIDeliverOrganization getValue(final UIDeliverOrganization copyValue) {
    
    copyValue.setCode(code.getValue());
    copyValue.setName(name.getValue());
    copyValue.setOrganization(organization.getValue());
    return copyValue;
  }
  
  protected DeliverOrganizationListGrid doSetValue(final UIDeliverOrganization value) {
    this.value = value;
    code.setValue(value.getCode());
    name.setValue(value.getName());
    organization.setValue(value.getOrganization());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)code,(ICanAsWidget)name,(ICanAsWidget)organization
    					);
  }
}
