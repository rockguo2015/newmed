package com.lanmon.business.shared.customer;

import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class GWTDaily extends GWTEntity {
  private GWTNamedEntity employee;
  
  public GWTNamedEntity getEmployee() {
    return this.employee;
  }
  
  public void setEmployee(final GWTNamedEntity employee) {
    this.employee = employee;
  }
  
  public final static String P_Employee = "employee";
  
  public static IObjectFieldAccessor<GWTDaily,GWTNamedEntity> EmployeeAccessor = new IObjectFieldAccessor<GWTDaily,GWTNamedEntity>(){
    				public GWTNamedEntity getValue(GWTDaily object){
    					return object.getEmployee();
    				}
    				public void setValue(GWTDaily object,GWTNamedEntity value){
    					object.setEmployee(value);
    				}
    			};
  
  private Date date;
  
  public Date getDate() {
    return this.date;
  }
  
  public void setDate(final Date date) {
    this.date = date;
  }
  
  public final static String P_Date = "date";
  
  public static IObjectFieldAccessor<GWTDaily,Date> DateAccessor = new IObjectFieldAccessor<GWTDaily,Date>(){
    				public Date getValue(GWTDaily object){
    					return object.getDate();
    				}
    				public void setValue(GWTDaily object,Date value){
    					object.setDate(value);
    				}
    			};
  
  private String note;
  
  public String getNote() {
    return this.note;
  }
  
  public void setNote(final String note) {
    this.note = note;
  }
  
  public final static String P_Note = "note";
  
  public static IObjectFieldAccessor<GWTDaily,String> NoteAccessor = new IObjectFieldAccessor<GWTDaily,String>(){
    				public String getValue(GWTDaily object){
    					return object.getNote();
    				}
    				public void setValue(GWTDaily object,String value){
    					object.setNote(value);
    				}
    			};
  
  private Integer phoneCount;
  
  public Integer getPhoneCount() {
    return this.phoneCount;
  }
  
  public void setPhoneCount(final Integer phoneCount) {
    this.phoneCount = phoneCount;
  }
  
  public final static String P_PhoneCount = "phoneCount";
  
  public static IObjectFieldAccessor<GWTDaily,Integer> PhoneCountAccessor = new IObjectFieldAccessor<GWTDaily,Integer>(){
    				public Integer getValue(GWTDaily object){
    					return object.getPhoneCount();
    				}
    				public void setValue(GWTDaily object,Integer value){
    					object.setPhoneCount(value);
    				}
    			};
  
  private Integer createCustomerCount;
  
  public Integer getCreateCustomerCount() {
    return this.createCustomerCount;
  }
  
  public void setCreateCustomerCount(final Integer createCustomerCount) {
    this.createCustomerCount = createCustomerCount;
  }
  
  public final static String P_CreateCustomerCount = "createCustomerCount";
  
  public static IObjectFieldAccessor<GWTDaily,Integer> CreateCustomerCountAccessor = new IObjectFieldAccessor<GWTDaily,Integer>(){
    				public Integer getValue(GWTDaily object){
    					return object.getCreateCustomerCount();
    				}
    				public void setValue(GWTDaily object,Integer value){
    					object.setCreateCustomerCount(value);
    				}
    			};
  
  private Integer onsiteCount;
  
  public Integer getOnsiteCount() {
    return this.onsiteCount;
  }
  
  public void setOnsiteCount(final Integer onsiteCount) {
    this.onsiteCount = onsiteCount;
  }
  
  public final static String P_OnsiteCount = "onsiteCount";
  
  public static IObjectFieldAccessor<GWTDaily,Integer> OnsiteCountAccessor = new IObjectFieldAccessor<GWTDaily,Integer>(){
    				public Integer getValue(GWTDaily object){
    					return object.getOnsiteCount();
    				}
    				public void setValue(GWTDaily object,Integer value){
    					object.setOnsiteCount(value);
    				}
    			};
}
