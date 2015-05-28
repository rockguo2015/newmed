package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.component.treegrid.GXTTreeGridComponent;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class OrganizationOutlineTreeGrid extends GXTTreeGridComponent<UIOrganization> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIOrganization> name;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIOrganization value = new UIOrganization();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsStringColumn("name","名称",UIOrganization.NameAccessor,Integer.valueOf(150));
    widgetsRegistory.put("name",name);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIOrganization getValueAsNew() {
    UIOrganization value = new UIOrganization();
    value.setName(name.getValue());
    return value;
  }
  
  public UIOrganization doGetValue() {
    
    value.setName(name.getValue());
    return value;
  }
  
  public UIOrganization getValue(final UIOrganization copyValue) {
    
    copyValue.setName(name.getValue());
    return copyValue;
  }
  
  protected OrganizationOutlineTreeGrid doSetValue(final UIOrganization value) {
    this.value = value;
    name.setValue(value.getName());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)name
    					);
  }
}
