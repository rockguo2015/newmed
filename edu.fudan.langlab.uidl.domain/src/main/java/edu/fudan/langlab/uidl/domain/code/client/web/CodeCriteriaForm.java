package edu.fudan.langlab.uidl.domain.code.client.web;

import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.ComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.uidl.domain.code.client.web.UICodeTypeContentProvider;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICodeCriteria;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICodeType;
import java.util.Map;

public class CodeCriteriaForm extends GXTFormComponent<UICodeCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public ComboBoxSelector<UICodeType> codeType;
  
  @Inject
  public UICodeTypeContentProvider codeTypeContentProvider;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UICodeCriteria value = new UICodeCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();codeType = defaultObjectSelectorFactory.createAsComboBoxItem("codeType","代码类型");
    _initializerSupports.add(codeTypeContentProvider);
    codeType.setContentProvider(codeTypeContentProvider);
    widgetsRegistory.put("codeType",codeType);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UICodeCriteria getValueAsNew() {
    UICodeCriteria value = new UICodeCriteria();
    value.setCodeType(codeType.getValue());
    return value;
  }
  
  public UICodeCriteria doGetValue() {
    
    value.setCodeType(codeType.getValue());
    return value;
  }
  
  public UICodeCriteria getValue(final UICodeCriteria copyValue) {
    
    copyValue.setCodeType(codeType.getValue());
    return copyValue;
  }
  
  protected CodeCriteriaForm doSetValue(final UICodeCriteria value) {
    this.value = value;
    codeType.setValue(value.getCodeType());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)codeType
    					);
  }
}
