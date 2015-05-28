package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.project.UIMaintenanceTeam;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class MaintenanceTeamListGrid extends GXTGridComponent<UIMaintenanceTeam> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UIMaintenanceTeam,RCOrganizationProxy> organization;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UIMaintenanceTeam value = new UIMaintenanceTeam();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();organization = defaultObjectSelectorFactory.createAsDefaultColumn("organization","维修班组",UIMaintenanceTeam.OrganizationAccessor);
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
  
  public UIMaintenanceTeam getValueAsNew() {
    UIMaintenanceTeam value = new UIMaintenanceTeam();
    value.setOrganization(organization.getValue());
    return value;
  }
  
  public UIMaintenanceTeam doGetValue() {
    
    value.setOrganization(organization.getValue());
    return value;
  }
  
  public UIMaintenanceTeam getValue(final UIMaintenanceTeam copyValue) {
    
    copyValue.setOrganization(organization.getValue());
    return copyValue;
  }
  
  protected MaintenanceTeamListGrid doSetValue(final UIMaintenanceTeam value) {
    this.value = value;
    organization.setValue(value.getOrganization());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)organization
    					);
  }
}
