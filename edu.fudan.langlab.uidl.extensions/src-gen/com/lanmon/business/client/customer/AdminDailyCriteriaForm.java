package com.lanmon.business.client.customer;

import com.google.inject.Inject;
import com.lanmon.business.client.customer.AllEmployees;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.customer.GWTDailyCriteria;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateRangeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.FormComponent;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.ComboBoxSingleEntitySelector;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DateRangeValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DateRangeValueProviderFactory.DateRangeItemAdaptor;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DefaultObjectSelectorFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory.TextItemBasedStringValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class AdminDailyCriteriaForm extends FormComponent<GWTDailyCriteria> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public ComboBoxSingleEntitySelector<GWTNamedEntity> employee;
  
  @Inject
  public AllEmployees employeeContentProvider;
  
  public DateRangeItemAdaptor dateRange;
  
  public TextItemBasedStringValueProvider note;
  
  @Inject
  private DateRangeValueProviderFactory dateRangeValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private GWTDailyCriteria value = new GWTDailyCriteria();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();employee = defaultObjectSelectorFactory.createAsSelectItemAdaptor("employee","员工");
    _initializerSupports.add(employeeContentProvider);
    employee.setContentProvider(employeeContentProvider);
    dateRange = dateRangeValueProviderFactory.createAsDateRangeItem("dateRange","日期范围");
    note = stringValueProviderFactory.createAsTextItemAdaptor("note","备注");
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public GWTDailyCriteria getValueAsNew() {
    GWTDailyCriteria value = new GWTDailyCriteria();
    value.setEmployee(employee.getValue());
    value.setDateRange(dateRange.getValue());
    value.setNote(note.getValue());
    return value;
  }
  
  public GWTDailyCriteria doGetValue() {
    
    value.setEmployee(employee.getValue());
    value.setDateRange(dateRange.getValue());
    value.setNote(note.getValue());
    return value;
  }
  
  public GWTDailyCriteria getValue(final GWTDailyCriteria copyValue) {
    
    copyValue.setEmployee(employee.getValue());
    copyValue.setDateRange(dateRange.getValue());
    copyValue.setNote(note.getValue());
    return copyValue;
  }
  
  protected AdminDailyCriteriaForm doSetValue(final GWTDailyCriteria value) {
    this.value = value;
    employee.setValue(value.getEmployee());
    dateRange.setValue(value.getDateRange());
    note.setValue(value.getNote());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)employee,(ICanAsWidget)dateRange,(ICanAsWidget)note
    					);
  }
  
  public DynamicForm asWidget() {
    final Function1<Void,DynamicForm> _function = new Function1<Void,DynamicForm>() {
        public DynamicForm apply(final Void it) {
          SelectItem _asWidget = AdminDailyCriteriaForm.this.employee.asWidget();
          DateRangeItem _asWidget_1 = AdminDailyCriteriaForm.this.dateRange.asWidget();
          TextItem _asWidget_2 = AdminDailyCriteriaForm.this.note.asWidget();
          DynamicForm _DynamicForm = AdminDailyCriteriaForm.this.widgets.DynamicForm(_asWidget, _asWidget_1, _asWidget_2);
          final Procedure1<DynamicForm> _function = new Procedure1<DynamicForm>() {
              public void apply(final DynamicForm it) {
                it.setNumCols(7);
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
