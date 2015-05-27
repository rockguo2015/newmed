package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectsSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DualListMultiSelector;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.uidl.domain.app.client.security.AllRolesContentProvider;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIUserRoles;
import java.util.Map;

public class UserRolesForm extends GXTFormComponent<UIUserRoles> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DualListMultiSelector<RoleProxy> roles;
  
  @Inject
  public AllRolesContentProvider rolesContentProvider;
  
  @Inject
  private DefaultObjectsSelectorFactory defaultObjectsSelectorFactory;
  
  private UIUserRoles value = new UIUserRoles();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();roles = defaultObjectsSelectorFactory.createAsDualListItem("roles","用户角色");
    _initializerSupports.add(rolesContentProvider);
    roles.setContentProvider(rolesContentProvider);
    widgetsRegistory.put("roles",roles);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIUserRoles getValueAsNew() {
    UIUserRoles value = new UIUserRoles();
    value.setRoles(roles.getValue());
    return value;
  }
  
  public UIUserRoles doGetValue() {
    
    value.setRoles(roles.getValue());
    return value;
  }
  
  public UIUserRoles getValue(final UIUserRoles copyValue) {
    
    copyValue.setRoles(roles.getValue());
    return copyValue;
  }
  
  protected UserRolesForm doSetValue(final UIUserRoles value) {
    this.value = value;
    roles.setValue(value.getRoles());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)roles
    					);
  }
}
