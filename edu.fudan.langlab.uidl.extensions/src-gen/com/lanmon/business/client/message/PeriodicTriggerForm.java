package com.lanmon.business.client.message;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.lanmon.business.client.message.GWTPeriodicUnitContentProvider;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.message.GWTPeriodicTrigger;
import com.lanmon.business.shared.message.GWTPeriodicUnit;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.FormComponent;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.ComboBoxSingleEntitySelector;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DateValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DateValueProviderFactory.DateItemBasedStringValueProvider;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DefaultObjectSelectorFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.IntegerValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.IntegerValueProviderFactory.IntegerItemBasedIntegerValueProvider;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory.TextItemBasedStringValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;

public class PeriodicTriggerForm extends FormComponent<GWTPeriodicTrigger> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public TextItemBasedStringValueProvider message;
  
  public DateItemBasedStringValueProvider triggerDate;
  
  public IntegerItemBasedIntegerValueProvider timeInterval;
  
  public ComboBoxSingleEntitySelector<GWTPeriodicUnit> unit;
  
  @Inject
  public GWTPeriodicUnitContentProvider unitContentProvider;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  private GWTPeriodicTrigger value = new GWTPeriodicTrigger();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();message = stringValueProviderFactory.createAsTextItemAdaptor("message","提醒消息");
    triggerDate = dateValueProviderFactory.createAsDateItem("triggerDate","提醒时间");
    timeInterval = integerValueProviderFactory.createAsIntegerItemAdaptor("timeInterval","间隔");
    unit = defaultObjectSelectorFactory.createAsSelectItemAdaptor("unit","间隔单位");
    unit.setContentProvider(unitContentProvider);
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public GWTPeriodicTrigger getValueAsNew() {
    GWTPeriodicTrigger value = new GWTPeriodicTrigger();
    value.setMessage(message.getValue());
    value.setTriggerDate(triggerDate.getValue());
    value.setTimeInterval(timeInterval.getValue());
    value.setUnit(unit.getValue());
    return value;
  }
  
  public GWTPeriodicTrigger doGetValue() {
    
    value.setMessage(message.getValue());
    value.setTriggerDate(triggerDate.getValue());
    value.setTimeInterval(timeInterval.getValue());
    value.setUnit(unit.getValue());
    return value;
  }
  
  public GWTPeriodicTrigger getValue(final GWTPeriodicTrigger copyValue) {
    
    copyValue.setMessage(message.getValue());
    copyValue.setTriggerDate(triggerDate.getValue());
    copyValue.setTimeInterval(timeInterval.getValue());
    copyValue.setUnit(unit.getValue());
    return copyValue;
  }
  
  protected PeriodicTriggerForm doSetValue(final GWTPeriodicTrigger value) {
    this.value = value;
    message.setValue(value.getMessage());
    triggerDate.setValue(value.getTriggerDate());
    timeInterval.setValue(value.getTimeInterval());
    unit.setValue(value.getUnit());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)message,(ICanAsWidget)triggerDate,(ICanAsWidget)timeInterval,(ICanAsWidget)unit
    					);
  }
  
  public DynamicForm asWidget() {
    DynamicForm _xblockexpression = null;
    {
      boolean _notEquals = (!Objects.equal(this.form, null));
      if (_notEquals) {
        /*this.form;*/
      }
      TextItem _asWidget = this.message.asWidget();
      DateItem _asWidget_1 = this.triggerDate.asWidget();
      IntegerItem _asWidget_2 = this.timeInterval.asWidget();
      SelectItem _asWidget_3 = this.unit.asWidget();
      DynamicForm _DynamicForm = this.widgets.DynamicForm(_asWidget, _asWidget_1, _asWidget_2, _asWidget_3);
      DynamicForm _form = this.form = _DynamicForm;
      _xblockexpression = (_form);
    }
    return _xblockexpression;
  }
  
  private DynamicForm form;
}
