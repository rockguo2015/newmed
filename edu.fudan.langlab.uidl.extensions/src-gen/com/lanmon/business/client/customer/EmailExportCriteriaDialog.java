package com.lanmon.business.client.customer;

import com.google.inject.Inject;
import com.lanmon.business.client.contact.ContactCodeProvider;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.customer.EmailExportCriteria;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.FormComponent;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.ComboBoxSingleEntitySelector;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DateValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DateValueProviderFactory.DateItemBasedStringValueProvider;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DefaultObjectSelectorFactory;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.shared.GWTNamedEntity;

public class EmailExportCriteriaDialog extends FormComponent<EmailExportCriteria> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public ComboBoxSingleEntitySelector<GWTNamedEntity> contactType;
  
  @Inject
  public ContactCodeProvider contactTypeContentProvider;
  
  public DateItemBasedStringValueProvider startDate;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  private EmailExportCriteria value = new EmailExportCriteria();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();contactType = defaultObjectSelectorFactory.createAsSelectItemAdaptor("contactType","联系人类型");
    _initializerSupports.add(contactTypeContentProvider);
    contactType.setContentProvider(contactTypeContentProvider);
    startDate = dateValueProviderFactory.createAsDateItem("startDate","邮件更新时间");
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public EmailExportCriteria getValueAsNew() {
    EmailExportCriteria value = new EmailExportCriteria();
    value.setContactType(contactType.getValue());
    value.setStartDate(startDate.getValue());
    return value;
  }
  
  public EmailExportCriteria doGetValue() {
    
    value.setContactType(contactType.getValue());
    value.setStartDate(startDate.getValue());
    return value;
  }
  
  public EmailExportCriteria getValue(final EmailExportCriteria copyValue) {
    
    copyValue.setContactType(contactType.getValue());
    copyValue.setStartDate(startDate.getValue());
    return copyValue;
  }
  
  protected EmailExportCriteriaDialog doSetValue(final EmailExportCriteria value) {
    this.value = value;
    contactType.setValue(value.getContactType());
    startDate.setValue(value.getStartDate());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)contactType,(ICanAsWidget)startDate
    					);
  }
}
