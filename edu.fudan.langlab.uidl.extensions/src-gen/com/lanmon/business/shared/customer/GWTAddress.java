package com.lanmon.business.shared.customer;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class GWTAddress implements IsSerializable {
  private String addrinfo;
  
  public String getAddrinfo() {
    return this.addrinfo;
  }
  
  public void setAddrinfo(final String addrinfo) {
    this.addrinfo = addrinfo;
  }
  
  public final static String P_Addrinfo = "addrinfo";
  
  public static IObjectFieldAccessor<GWTAddress,String> AddrinfoAccessor = new IObjectFieldAccessor<GWTAddress,String>(){
    				public String getValue(GWTAddress object){
    					return object.getAddrinfo();
    				}
    				public void setValue(GWTAddress object,String value){
    					object.setAddrinfo(value);
    				}
    			};
  
  private String zipcode;
  
  public String getZipcode() {
    return this.zipcode;
  }
  
  public void setZipcode(final String zipcode) {
    this.zipcode = zipcode;
  }
  
  public final static String P_Zipcode = "zipcode";
  
  public static IObjectFieldAccessor<GWTAddress,String> ZipcodeAccessor = new IObjectFieldAccessor<GWTAddress,String>(){
    				public String getValue(GWTAddress object){
    					return object.getZipcode();
    				}
    				public void setValue(GWTAddress object,String value){
    					object.setZipcode(value);
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
  
  public static IObjectFieldAccessor<GWTAddress,String> EmailAccessor = new IObjectFieldAccessor<GWTAddress,String>(){
    				public String getValue(GWTAddress object){
    					return object.getEmail();
    				}
    				public void setValue(GWTAddress object,String value){
    					object.setEmail(value);
    				}
    			};
  
  private String homepage;
  
  public String getHomepage() {
    return this.homepage;
  }
  
  public void setHomepage(final String homepage) {
    this.homepage = homepage;
  }
  
  public final static String P_Homepage = "homepage";
  
  public static IObjectFieldAccessor<GWTAddress,String> HomepageAccessor = new IObjectFieldAccessor<GWTAddress,String>(){
    				public String getValue(GWTAddress object){
    					return object.getHomepage();
    				}
    				public void setValue(GWTAddress object,String value){
    					object.setHomepage(value);
    				}
    			};
}
