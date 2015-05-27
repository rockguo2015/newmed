package com.lanmon.business.client.event;

import com.google.inject.Inject;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.event.GWTEventCriteria;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateRangeItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.FormComponent;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DateRangeValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DateRangeValueProviderFactory.DateRangeItemAdaptor;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory.EscapedTextItemBasedStringValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class EventCriteriaForm extends FormComponent<GWTEventCriteria> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public EscapedTextItemBasedStringValueProvider message;
  
  public DateRangeItemAdaptor dateRange;
  
  @Inject
  private DateRangeValueProviderFactory dateRangeValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private GWTEventCriteria value = new GWTEventCriteria();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();message = stringValueProviderFactory.createAsEscapedTextItemAdaptor("message","事件内容");
    dateRange = dateRangeValueProviderFactory.createAsDateRangeItem("dateRange","记录时间");
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public GWTEventCriteria getValueAsNew() {
    GWTEventCriteria value = new GWTEventCriteria();
    value.setMessage(message.getValue());
    value.setDateRange(dateRange.getValue());
    return value;
  }
  
  public GWTEventCriteria doGetValue() {
    
    value.setMessage(message.getValue());
    value.setDateRange(dateRange.getValue());
    return value;
  }
  
  public GWTEventCriteria getValue(final GWTEventCriteria copyValue) {
    
    copyValue.setMessage(message.getValue());
    copyValue.setDateRange(dateRange.getValue());
    return copyValue;
  }
  
  protected EventCriteriaForm doSetValue(final GWTEventCriteria value) {
    this.value = value;
    message.setValue(value.getMessage());
    dateRange.setValue(value.getDateRange());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)message,(ICanAsWidget)dateRange
    					);
  }
  
  public DynamicForm asWidget() {
    final Function1<Void,DynamicForm> _function = new Function1<Void,DynamicForm>() {
        public DynamicForm apply(final Void it) {
          TextItem _asWidget = EventCriteriaForm.this.message.asWidget();
          DateRangeItem _asWidget_1 = EventCriteriaForm.this.dateRange.asWidget();
          DynamicForm _DynamicForm = EventCriteriaForm.this.widgets.DynamicForm(_asWidget, _asWidget_1);
          final Procedure1<DynamicForm> _function = new Procedure1<DynamicForm>() {
              public void apply(final DynamicForm it) {
                it.setNumCols(4);
              }
            };
          DynamicForm _doubleArrow = ObjectExtensions.<DynamicForm>operator_doubleArrow(_DynamicForm, _function);
          return _doubleArrow;
        }
      };
    DynamicForm _lazy = ClientUi.<DynamicForm>lazy(this.form, _function);
    DynamicForm _form = this.form = _lazy;
    return _form;
  }
  
  private DynamicForm form;
}
