package com.lanmon.business.shared.customer;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.lanmon.business.shared.customer.GWTCustomerCriteria4Sales;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class EmailExportCriteria implements IsSerializable {
  private GWTNamedEntity contactType;
  
  public GWTNamedEntity getContactType() {
    return this.contactType;
  }
  
  public void setContactType(final GWTNamedEntity contactType) {
    this.contactType = contactType;
  }
  
  public final static String P_ContactType = "contactType";
  
  public static IObjectFieldAccessor<EmailExportCriteria,GWTNamedEntity> ContactTypeAccessor = new IObjectFieldAccessor<EmailExportCriteria,GWTNamedEntity>(){
    				public GWTNamedEntity getValue(EmailExportCriteria object){
    					return object.getContactType();
    				}
    				public void setValue(EmailExportCriteria object,GWTNamedEntity value){
    					object.setContactType(value);
    				}
    			};
  
  private Date startDate;
  
  public Date getStartDate() {
    return this.startDate;
  }
  
  public void setStartDate(final Date startDate) {
    this.startDate = startDate;
  }
  
  public final static String P_StartDate = "startDate";
  
  public static IObjectFieldAccessor<EmailExportCriteria,Date> StartDateAccessor = new IObjectFieldAccessor<EmailExportCriteria,Date>(){
    				public Date getValue(EmailExportCriteria object){
    					return object.getStartDate();
    				}
    				public void setValue(EmailExportCriteria object,Date value){
    					object.setStartDate(value);
    				}
    			};
  
  private GWTCustomerCriteria4Sales customerCriteria;
  
  public GWTCustomerCriteria4Sales getCustomerCriteria() {
    return this.customerCriteria;
  }
  
  public void setCustomerCriteria(final GWTCustomerCriteria4Sales customerCriteria) {
    this.customerCriteria = customerCriteria;
  }
  
  public final static String P_CustomerCriteria = "customerCriteria";
  
  public static IObjectFieldAccessor<EmailExportCriteria,GWTCustomerCriteria4Sales> CustomerCriteriaAccessor = new IObjectFieldAccessor<EmailExportCriteria,GWTCustomerCriteria4Sales>(){
    				public GWTCustomerCriteria4Sales getValue(EmailExportCriteria object){
    					return object.getCustomerCriteria();
    				}
    				public void setValue(EmailExportCriteria object,GWTCustomerCriteria4Sales value){
    					object.setCustomerCriteria(value);
    				}
    			};
}
