package com.lanmon.business.shared.contact;

import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class GWTContact extends GWTEntity {
  private GWTNamedEntity customer;
  
  public GWTNamedEntity getCustomer() {
    return this.customer;
  }
  
  public void setCustomer(final GWTNamedEntity customer) {
    this.customer = customer;
  }
  
  public final static String P_Customer = "customer";
  
  public static IObjectFieldAccessor<GWTContact,GWTNamedEntity> CustomerAccessor = new IObjectFieldAccessor<GWTContact,GWTNamedEntity>(){
    				public GWTNamedEntity getValue(GWTContact object){
    					return object.getCustomer();
    				}
    				public void setValue(GWTContact object,GWTNamedEntity value){
    					object.setCustomer(value);
    				}
    			};
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  public final static String P_Name = "name";
  
  public static IObjectFieldAccessor<GWTContact,String> NameAccessor = new IObjectFieldAccessor<GWTContact,String>(){
    				public String getValue(GWTContact object){
    					return object.getName();
    				}
    				public void setValue(GWTContact object,String value){
    					object.setName(value);
    				}
    			};
  
  private GWTNamedEntity type;
  
  public GWTNamedEntity getType() {
    return this.type;
  }
  
  public void setType(final GWTNamedEntity type) {
    this.type = type;
  }
  
  public final static String P_Type = "type";
  
  public static IObjectFieldAccessor<GWTContact,GWTNamedEntity> TypeAccessor = new IObjectFieldAccessor<GWTContact,GWTNamedEntity>(){
    				public GWTNamedEntity getValue(GWTContact object){
    					return object.getType();
    				}
    				public void setValue(GWTContact object,GWTNamedEntity value){
    					object.setType(value);
    				}
    			};
  
  private String phone;
  
  public String getPhone() {
    return this.phone;
  }
  
  public void setPhone(final String phone) {
    this.phone = phone;
  }
  
  public final static String P_Phone = "phone";
  
  public static IObjectFieldAccessor<GWTContact,String> PhoneAccessor = new IObjectFieldAccessor<GWTContact,String>(){
    				public String getValue(GWTContact object){
    					return object.getPhone();
    				}
    				public void setValue(GWTContact object,String value){
    					object.setPhone(value);
    				}
    			};
  
  private String email;
  
  public String getEmail() {
    return this.email;
  }
  
  public void setEmail(final String email) {
    this.email = email;
  }
  
  public final static String P_Email = "email";
  
  public static IObjectFieldAccessor<GWTContact,String> EmailAccessor = new IObjectFieldAccessor<GWTContact,String>(){
    				public String getValue(GWTContact object){
    					return object.getEmail();
    				}
    				public void setValue(GWTContact object,String value){
    					object.setEmail(value);
    				}
    			};
}
