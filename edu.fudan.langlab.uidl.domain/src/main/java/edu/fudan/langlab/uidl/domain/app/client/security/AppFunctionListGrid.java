package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.component.treegrid.GXTTreeGridComponent;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeContentProvider;
import edu.fudan.langlab.uidl.domain.app.client.tree.UIAppFunctionTreeContentProvider;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunction;
import java.util.Map;

public class AppFunctionListGrid extends GXTTreeGridComponent<UIAppFunction> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIAppFunction> name;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIAppFunction value = new UIAppFunction();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsStringColumn("name","功能名",UIAppFunction.NameAccessor);
    widgetsRegistory.put("name",name);
    if(functionTreeContentProvider instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)functionTreeContentProvider);
    						}IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIAppFunction getValueAsNew() {
    UIAppFunction value = new UIAppFunction();
    value.setName(name.getValue());
    return value;
  }
  
  public UIAppFunction doGetValue() {
    
    value.setName(name.getValue());
    return value;
  }
  
  public UIAppFunction getValue(final UIAppFunction copyValue) {
    
    copyValue.setName(name.getValue());
    return copyValue;
  }
  
  protected AppFunctionListGrid doSetValue(final UIAppFunction value) {
    this.value = value;
    name.setValue(value.getName());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)name
    					);
  }
  
  public ITreeContentProvider<UIAppFunction> getTreeContentProvider() {
    return this.functionTreeContentProvider;
  }
  
  @Inject
  private UIAppFunctionTreeContentProvider functionTreeContentProvider;
}
