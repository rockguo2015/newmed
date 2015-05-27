package com.lanmon.business.client.message;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.message.GWTOutsourceDateTrigger;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.FormComponent;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DateValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DateValueProviderFactory.DateItemBasedStringValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class OutsourceDateTriggerForm extends FormComponent<GWTOutsourceDateTrigger> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public DateItemBasedStringValueProvider nextTriggleDate;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  private GWTOutsourceDateTrigger value = new GWTOutsourceDateTrigger();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();nextTriggleDate = dateValueProviderFactory.createAsDateItem("nextTriggleDate","提醒日期");
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public GWTOutsourceDateTrigger getValueAsNew() {
    GWTOutsourceDateTrigger value = new GWTOutsourceDateTrigger();
    value.setNextTriggleDate(nextTriggleDate.getValue());
    return value;
  }
  
  public GWTOutsourceDateTrigger doGetValue() {
    
    value.setNextTriggleDate(nextTriggleDate.getValue());
    return value;
  }
  
  public GWTOutsourceDateTrigger getValue(final GWTOutsourceDateTrigger copyValue) {
    
    copyValue.setNextTriggleDate(nextTriggleDate.getValue());
    return copyValue;
  }
  
  protected OutsourceDateTriggerForm doSetValue(final GWTOutsourceDateTrigger value) {
    this.value = value;
    nextTriggleDate.setValue(value.getNextTriggleDate());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)nextTriggleDate
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
            DateItem _asWidget = OutsourceDateTriggerForm.this.nextTriggleDate.asWidget();
            it.setFields(_asWidget);
          }
        };
      DynamicForm _doubleArrow = ObjectExtensions.<DynamicForm>operator_doubleArrow(_DynamicForm, _function);
      _xifexpression = _doubleArrow;
    }
    return _xifexpression;
  }
  
  private DynamicForm form;
}
