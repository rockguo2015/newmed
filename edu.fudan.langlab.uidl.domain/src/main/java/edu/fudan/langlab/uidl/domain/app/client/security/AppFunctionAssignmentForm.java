package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectsSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.tree.CheckboxTreeMultiSelector;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.uidl.domain.app.client.security.AllAppFunctionContentProvider;
import edu.fudan.langlab.uidl.domain.app.client.tree.UIAppFunctionTreeContentProvider;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunction;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunctionAssignment;
import java.util.Map;

public class AppFunctionAssignmentForm extends GXTFormComponent<UIAppFunctionAssignment> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public CheckboxTreeMultiSelector<UIAppFunction> functions;
  
  @Inject
  public AllAppFunctionContentProvider functionsContentProvider;
  
  @Inject
  private DefaultObjectsSelectorFactory defaultObjectsSelectorFactory;
  
  private UIAppFunctionAssignment value = new UIAppFunctionAssignment();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();functions = defaultObjectsSelectorFactory.createAsCheckboxTreeItem("functions","系统功能",this.treeContentProvider);
    _initializerSupports.add(functionsContentProvider);
    functions.setContentProvider(functionsContentProvider);
    widgetsRegistory.put("functions",functions);
    if(treeContentProvider instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)treeContentProvider);
    						}IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIAppFunctionAssignment getValueAsNew() {
    UIAppFunctionAssignment value = new UIAppFunctionAssignment();
    value.setFunctions(functions.getValue());
    return value;
  }
  
  public UIAppFunctionAssignment doGetValue() {
    
    value.setFunctions(functions.getValue());
    return value;
  }
  
  public UIAppFunctionAssignment getValue(final UIAppFunctionAssignment copyValue) {
    
    copyValue.setFunctions(functions.getValue());
    return copyValue;
  }
  
  protected AppFunctionAssignmentForm doSetValue(final UIAppFunctionAssignment value) {
    this.value = value;
    functions.setValue(value.getFunctions());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)functions
    					);
  }
  
  @Inject
  private UIAppFunctionTreeContentProvider treeContentProvider;
}
