package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.deliver.UICheckOrganization;
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

public class CheckOrganizationListGrid extends GXTGridComponent<UICheckOrganization> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UICheckOrganization> code;
  
  public StringColumn<UICheckOrganization> name;
  
  public StringValueColumn<UICheckOrganization,RCOrganizationProxy> organization;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UICheckOrganization value = new UICheckOrganization();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();code = stringValueProviderFactory.createAsStringColumn("code","科室代码",UICheckOrganization.CodeAccessor);
    widgetsRegistory.put("code",code);
    name = stringValueProviderFactory.createAsStringColumn("name","科室名称",UICheckOrganization.NameAccessor);
    widgetsRegistory.put("name",name);
    organization = defaultObjectSelectorFactory.createAsDefaultColumn("organization","关联组织机构",UICheckOrganization.OrganizationAccessor);
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
  
  public UICheckOrganization getValueAsNew() {
    UICheckOrganization value = new UICheckOrganization();
    value.setCode(code.getValue());
    value.setName(name.getValue());
    value.setOrganization(organization.getValue());
    return value;
  }
  
  public UICheckOrganization doGetValue() {
    
    value.setCode(code.getValue());
    value.setName(name.getValue());
    value.setOrganization(organization.getValue());
    return value;
  }
  
  public UICheckOrganization getValue(final UICheckOrganization copyValue) {
    
    copyValue.setCode(code.getValue());
    copyValue.setName(name.getValue());
    copyValue.setOrganization(organization.getValue());
    return copyValue;
  }
  
  protected CheckOrganizationListGrid doSetValue(final UICheckOrganization value) {
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
