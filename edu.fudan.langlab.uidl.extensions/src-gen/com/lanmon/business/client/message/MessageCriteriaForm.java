package com.lanmon.business.client.message;

import com.google.inject.Inject;
import com.lanmon.business.client.customer.CustomerContentProvider;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.message.GWTMessageCriteria;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CanvasItem;
import com.smartgwt.client.widgets.form.fields.DateRangeItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.FormComponent;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DateRangeValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DateRangeValueProviderFactory.DateRangeItemAdaptor;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DefaultObjectSelectorFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory.EscapedTextItemBasedStringValueProvider;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.SuggestionWindow1;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class MessageCriteriaForm extends FormComponent<GWTMessageCriteria> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public EscapedTextItemBasedStringValueProvider title;
  
  public DateRangeItemAdaptor triggerDate;
  
  public SuggestionWindow1<GWTNamedEntity> customer;
  
  @Inject
  public CustomerContentProvider customerContentProvider;
  
  @Inject
  private DateRangeValueProviderFactory dateRangeValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private GWTMessageCriteria value = new GWTMessageCriteria();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();title = stringValueProviderFactory.createAsEscapedTextItemAdaptor("title","消息");
    triggerDate = dateRangeValueProviderFactory.createAsDateRangeItem("triggerDate","提醒时间");
    customer = defaultObjectSelectorFactory.createAsSuggestWindow1("customer","客户");
    customer.setContentProvider(customerContentProvider);
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public GWTMessageCriteria getValueAsNew() {
    GWTMessageCriteria value = new GWTMessageCriteria();
    value.setTitle(title.getValue());
    value.setTriggerDate(triggerDate.getValue());
    value.setCustomer(customer.getValue());
    return value;
  }
  
  public GWTMessageCriteria doGetValue() {
    
    value.setTitle(title.getValue());
    value.setTriggerDate(triggerDate.getValue());
    value.setCustomer(customer.getValue());
    return value;
  }
  
  public GWTMessageCriteria getValue(final GWTMessageCriteria copyValue) {
    
    copyValue.setTitle(title.getValue());
    copyValue.setTriggerDate(triggerDate.getValue());
    copyValue.setCustomer(customer.getValue());
    return copyValue;
  }
  
  protected MessageCriteriaForm doSetValue(final GWTMessageCriteria value) {
    this.value = value;
    title.setValue(value.getTitle());
    triggerDate.setValue(value.getTriggerDate());
    customer.setValue(value.getCustomer());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)title,(ICanAsWidget)triggerDate,(ICanAsWidget)customer
    					);
  }
  
  public DynamicForm asWidget() {
    DynamicForm _DynamicForm = this.widgets.DynamicForm();
    final Procedure1<DynamicForm> _function = new Procedure1<DynamicForm>() {
        public void apply(final DynamicForm it) {
          it.setNumCols(6);
          TextItem _asWidget = MessageCriteriaForm.this.title.asWidget();
          DateRangeItem _asWidget_1 = MessageCriteriaForm.this.triggerDate.asWidget();
          CanvasItem _asWidget_2 = MessageCriteriaForm.this.customer.asWidget();
          it.setFields(_asWidget, _asWidget_1, _asWidget_2);
        }
      };
    DynamicForm _doubleArrow = ObjectExtensions.<DynamicForm>operator_doubleArrow(_DynamicForm, _function);
    DynamicForm _form = this.form = _doubleArrow;
    return _form;
  }
  
  private DynamicForm form;
}
