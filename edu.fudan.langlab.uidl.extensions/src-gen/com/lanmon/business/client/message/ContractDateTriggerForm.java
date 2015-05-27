package com.lanmon.business.client.message;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.lanmon.business.client.message.GWTContractDateTriggerTypeContentProvider;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.message.GWTContractDateTrigger;
import com.lanmon.business.shared.message.GWTContractDateTriggerType;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.FormComponent;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.ComboBoxSingleEntitySelector;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DateValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DateValueProviderFactory.DateItemBasedStringValueProvider;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DefaultObjectSelectorFactory;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ContractDateTriggerForm extends FormComponent<GWTContractDateTrigger> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public ComboBoxSingleEntitySelector<GWTContractDateTriggerType> type;
  
  @Inject
  public GWTContractDateTriggerTypeContentProvider typeContentProvider;
  
  public DateItemBasedStringValueProvider triggerDate;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  private GWTContractDateTrigger value = new GWTContractDateTrigger();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();type = defaultObjectSelectorFactory.createAsSelectItemAdaptor("type","提醒类型");
    type.setContentProvider(typeContentProvider);
    triggerDate = dateValueProviderFactory.createAsDateItem("triggerDate","提醒日期");
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public GWTContractDateTrigger getValueAsNew() {
    GWTContractDateTrigger value = new GWTContractDateTrigger();
    value.setType(type.getValue());
    value.setTriggerDate(triggerDate.getValue());
    return value;
  }
  
  public GWTContractDateTrigger doGetValue() {
    
    value.setType(type.getValue());
    value.setTriggerDate(triggerDate.getValue());
    return value;
  }
  
  public GWTContractDateTrigger getValue(final GWTContractDateTrigger copyValue) {
    
    copyValue.setType(type.getValue());
    copyValue.setTriggerDate(triggerDate.getValue());
    return copyValue;
  }
  
  protected ContractDateTriggerForm doSetValue(final GWTContractDateTrigger value) {
    this.value = value;
    type.setValue(value.getType());
    triggerDate.setValue(value.getTriggerDate());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)type,(ICanAsWidget)triggerDate
    					);
  }
  
  public DynamicForm asWidget() {
    DynamicForm _xifexpression = null;
    boolean _notEquals = (!Objects.equal(this.form, null));
    if (_notEquals) {
      _xifexpression = this.form;
    } else {
      DynamicForm _DynamicForm = this.widgets.DynamicForm();
      final Procedure1<DynamicForm> _function = new Procedure1<DynamicForm>() {
          public void apply(final DynamicForm it) {
            SelectItem _asWidget = ContractDateTriggerForm.this.type.asWidget();
            DateItem _asWidget_1 = ContractDateTriggerForm.this.triggerDate.asWidget();
            it.setFields(_asWidget, _asWidget_1);
          }
        };
      DynamicForm _doubleArrow = ObjectExtensions.<DynamicForm>operator_doubleArrow(_DynamicForm, _function);
      _xifexpression = _doubleArrow;
    }
    return _xifexpression;
  }
  
  private DynamicForm form;
}
