package com.lanmon.business.client.code;

import com.google.inject.Inject;
import com.lanmon.business.client.code.GWTCodeTypeContentProvider;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.code.CodeCriteria;
import com.lanmon.business.shared.code.GWTCodeType;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.FormComponent;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.ComboBoxSingleEntitySelector;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DefaultObjectSelectorFactory;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;

public class CodeCriteriaForm extends FormComponent<CodeCriteria> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public ComboBoxSingleEntitySelector<GWTCodeType> codeType;
  
  @Inject
  public GWTCodeTypeContentProvider codeTypeContentProvider;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private CodeCriteria value = new CodeCriteria();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();codeType = defaultObjectSelectorFactory.createAsSelectItemAdaptor("codeType","分类代码名称");
    codeType.setContentProvider(codeTypeContentProvider);
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public CodeCriteria getValueAsNew() {
    CodeCriteria value = new CodeCriteria();
    value.setCodeType(codeType.getValue());
    return value;
  }
  
  public CodeCriteria doGetValue() {
    
    value.setCodeType(codeType.getValue());
    return value;
  }
  
  public CodeCriteria getValue(final CodeCriteria copyValue) {
    
    copyValue.setCodeType(codeType.getValue());
    return copyValue;
  }
  
  protected CodeCriteriaForm doSetValue(final CodeCriteria value) {
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
