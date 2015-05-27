package com.lanmon.business.client.message;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.message.GWTOneTimeTrigger;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.FormComponent;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DateValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DateValueProviderFactory.DateItemBasedStringValueProvider;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory.TextAreaBasedStringValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class OneTimeTriggerForm extends FormComponent<GWTOneTimeTrigger> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public TextAreaBasedStringValueProvider message;
  
  public DateItemBasedStringValueProvider triggerDate;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  private GWTOneTimeTrigger value = new GWTOneTimeTrigger();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();message = stringValueProviderFactory.createAsTextAreaAdaptor("message","提醒消息");
    triggerDate = dateValueProviderFactory.createAsDateItem("triggerDate","提醒时间");
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public GWTOneTimeTrigger getValueAsNew() {
    GWTOneTimeTrigger value = new GWTOneTimeTrigger();
    value.setMessage(message.getValue());
    value.setTriggerDate(triggerDate.getValue());
    return value;
  }
  
  public GWTOneTimeTrigger doGetValue() {
    
    value.setMessage(message.getValue());
    value.setTriggerDate(triggerDate.getValue());
    return value;
  }
  
  public GWTOneTimeTrigger getValue(final GWTOneTimeTrigger copyValue) {
    
    copyValue.setMessage(message.getValue());
    copyValue.setTriggerDate(triggerDate.getValue());
    return copyValue;
  }
  
  protected OneTimeTriggerForm doSetValue(final GWTOneTimeTrigger value) {
    this.value = value;
    message.setValue(value.getMessage());
    triggerDate.setValue(value.getTriggerDate());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)message,(ICanAsWidget)triggerDate
    					);
  }
  
  public DynamicForm asWidget() {
    DynamicForm _xblockexpression = null;
    {
      boolean _notEquals = (!Objects.equal(this.form, null));
      if (_notEquals) {
        /*this.form;*/
      }
      DynamicForm _DynamicForm = this.widgets.DynamicForm();
      final Procedure1<DynamicForm> _function = new Procedure1<DynamicForm>() {
          public void apply(final DynamicForm it) {
            TextAreaItem _asWidget = OneTimeTriggerForm.this.message.asWidget();
            DateItem _asWidget_1 = OneTimeTriggerForm.this.triggerDate.asWidget();
            it.setFields(_asWidget, _asWidget_1);
          }
        };
      DynamicForm _doubleArrow = ObjectExtensions.<DynamicForm>operator_doubleArrow(_DynamicForm, _function);
      DynamicForm _form = this.form = _doubleArrow;
      _xblockexpression = (_form);
    }
    return _xblockexpression;
  }
  
  private DynamicForm form;
}
