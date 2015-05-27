package com.lanmon.business.client.message;

import com.google.inject.Inject;
import com.lanmon.business.client.message.TriggerTypeContentProvider;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.message.TriggerType;
import com.lanmon.business.shared.message.TriggerTypeSelecter;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.FormComponent;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.ComboBoxSingleEntitySelector;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DefaultObjectSelectorFactory;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class TriggerTypeSelecterForm extends FormComponent<TriggerTypeSelecter> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public ComboBoxSingleEntitySelector<TriggerType> type;
  
  @Inject
  public TriggerTypeContentProvider typeContentProvider;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private TriggerTypeSelecter value = new TriggerTypeSelecter();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();type = defaultObjectSelectorFactory.createAsSelectItemAdaptor("type","type");
    type.setContentProvider(typeContentProvider);
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public TriggerTypeSelecter getValueAsNew() {
    TriggerTypeSelecter value = new TriggerTypeSelecter();
    value.setType(type.getValue());
    return value;
  }
  
  public TriggerTypeSelecter doGetValue() {
    
    value.setType(type.getValue());
    return value;
  }
  
  public TriggerTypeSelecter getValue(final TriggerTypeSelecter copyValue) {
    
    copyValue.setType(type.getValue());
    return copyValue;
  }
  
  protected TriggerTypeSelecterForm doSetValue(final TriggerTypeSelecter value) {
    this.value = value;
    type.setValue(value.getType());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)type
    					);
  }
  
  public DynamicForm asWidget() {
    DynamicForm _DynamicForm = this.widgets.DynamicForm();
    final Procedure1<DynamicForm> _function = new Procedure1<DynamicForm>() {
        public void apply(final DynamicForm it) {
          SelectItem _asWidget = TriggerTypeSelecterForm.this.type.asWidget();
          final Procedure1<SelectItem> _function = new Procedure1<SelectItem>() {
              public void apply(final SelectItem it) {
                it.setShowTitle(Boolean.valueOf(false));
                it.setWidth(80);
              }
            };
          SelectItem _doubleArrow = ObjectExtensions.<SelectItem>operator_doubleArrow(_asWidget, _function);
          it.setFields(_doubleArrow);
        }
      };
    DynamicForm _doubleArrow = ObjectExtensions.<DynamicForm>operator_doubleArrow(_DynamicForm, _function);
    return _doubleArrow;
  }
}
