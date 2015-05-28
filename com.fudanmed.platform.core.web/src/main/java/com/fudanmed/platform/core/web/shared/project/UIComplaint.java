package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.domain.proxy.RCComplaintProxy;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class UIComplaint extends GWTEntity {
  private Date date;
  
  public Date getDate() {
    return this.date;
  }
  
  public void setDate(final Date date) {
    this.date = date;
  }
  
  public final static String P_Date = "date";
  
  public static IObjectFieldAccessor<UIComplaint,Date> DateAccessor = new IObjectFieldAccessor<UIComplaint,Date>(){
    				public java.util.Date getValue(UIComplaint object){
    					return object.getDate();
    				}
    				public void setValue(UIComplaint object,java.util.Date value){
    					object.setDate(value);
    				}
    			};
  
  private String contents;
  
  public String getContents() {
    return this.contents;
  }
  
  public void setContents(final String contents) {
    this.contents = contents;
  }
  
  public final static String P_Contents = "contents";
  
  public static IObjectFieldAccessor<UIComplaint,String> ContentsAccessor = new IObjectFieldAccessor<UIComplaint,String>(){
    				public String getValue(UIComplaint object){
    					return object.getContents();
    				}
    				public void setValue(UIComplaint object,String value){
    					object.setContents(value);
    				}
    			};
  
  private RCEmployeeProxy owner;
  
  public RCEmployeeProxy getOwner() {
    return this.owner;
  }
  
  public void setOwner(final RCEmployeeProxy owner) {
    this.owner = owner;
  }
  
  public final static String P_Owner = "owner";
  
  public static IObjectFieldAccessor<UIComplaint,RCEmployeeProxy> OwnerAccessor = new IObjectFieldAccessor<UIComplaint,RCEmployeeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy getValue(UIComplaint object){
    					return object.getOwner();
    				}
    				public void setValue(UIComplaint object,com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy value){
    					object.setOwner(value);
    				}
    			};
  
  public RCComplaintProxy toProxy() {
    return (RCComplaintProxy)super.toProxy();
    
  }
}
