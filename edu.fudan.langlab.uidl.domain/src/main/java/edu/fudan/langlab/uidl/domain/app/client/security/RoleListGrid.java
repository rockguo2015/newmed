package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIRole;
import java.util.Map;

public class RoleListGrid extends GXTGridComponent<UIRole> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIRole> roleId;
  
  public StringColumn<UIRole> name;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIRole value = new UIRole();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();roleId = stringValueProviderFactory.createAsStringColumn("roleId","角色代码",UIRole.RoleIdAccessor);
    widgetsRegistory.put("roleId",roleId);
    name = stringValueProviderFactory.createAsStringColumn("name","角色名称",UIRole.NameAccessor);
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
  
  public UIRole getValueAsNew() {
    UIRole value = new UIRole();
    value.setRoleId(roleId.getValue());
    value.setName(name.getValue());
    return value;
  }
  
  public UIRole doGetValue() {
    
    value.setRoleId(roleId.getValue());
    value.setName(name.getValue());
    return value;
  }
  
  public UIRole getValue(final UIRole copyValue) {
    
    copyValue.setRoleId(roleId.getValue());
    copyValue.setName(name.getValue());
    return copyValue;
  }
  
  protected RoleListGrid doSetValue(final UIRole value) {
    this.value = value;
    roleId.setValue(value.getRoleId());
    name.setValue(value.getName());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)roleId,(ICanAsWidget)name
    					);
  }
}
