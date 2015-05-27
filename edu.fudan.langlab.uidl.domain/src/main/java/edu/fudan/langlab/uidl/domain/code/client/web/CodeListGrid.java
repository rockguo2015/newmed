package edu.fudan.langlab.uidl.domain.code.client.web;

import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICode;
import java.util.Map;

public class CodeListGrid extends GXTGridComponent<UICode> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UICode> codeid;
  
  public StringColumn<UICode> name;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UICode value = new UICode();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();codeid = stringValueProviderFactory.createAsStringColumn("codeid","代码",UICode.CodeidAccessor);
    widgetsRegistory.put("codeid",codeid);
    name = stringValueProviderFactory.createAsStringColumn("name","名称",UICode.NameAccessor);
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
  
  public UICode getValueAsNew() {
    UICode value = new UICode();
    value.setCodeid(codeid.getValue());
    value.setName(name.getValue());
    return value;
  }
  
  public UICode doGetValue() {
    
    value.setCodeid(codeid.getValue());
    value.setName(name.getValue());
    return value;
  }
  
  public UICode getValue(final UICode copyValue) {
    
    copyValue.setCodeid(codeid.getValue());
    copyValue.setName(name.getValue());
    return copyValue;
  }
  
  protected CodeListGrid doSetValue(final UICode value) {
    this.value = value;
    codeid.setValue(value.getCodeid());
    name.setValue(value.getName());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)codeid,(ICanAsWidget)name
    					);
  }
}
