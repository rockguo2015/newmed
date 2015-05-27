package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppRole;
import java.util.Map;

public class AppRoleListGrid extends GXTGridComponent<UIAppRole> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIAppRole> name;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIAppRole value = new UIAppRole();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsStringColumn("name","角色名",UIAppRole.NameAccessor);
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
  
  public UIAppRole getValueAsNew() {
    UIAppRole value = new UIAppRole();
    value.setName(name.getValue());
    return value;
  }
  
  public UIAppRole doGetValue() {
    
    value.setName(name.getValue());
    return value;
  }
  
  public UIAppRole getValue(final UIAppRole copyValue) {
    
    copyValue.setName(name.getValue());
    return copyValue;
  }
  
  protected AppRoleListGrid doSetValue(final UIAppRole value) {
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
