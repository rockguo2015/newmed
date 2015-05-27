package com.uniquesoft.gwt.shared.datatype;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIPicture implements IsSerializable {
  private String classType;
  
  public String getClassType() {
    return this.classType;
  }
  
  public void setClassType(final String classType) {
    this.classType = classType;
  }
  
  public final static String P_ClassType = "classType";
  
  public static IObjectFieldAccessor<UIPicture,String> ClassTypeAccessor = new IObjectFieldAccessor<UIPicture,String>(){
    				public String getValue(UIPicture object){
    					return object.getClassType();
    				}
    				public void setValue(UIPicture object,String value){
    					object.setClassType(value);
    				}
    			};
  
  private Long objectId;
  
  public Long getObjectId() {
    return this.objectId;
  }
  
  public void setObjectId(final Long objectId) {
    this.objectId = objectId;
  }
  
  public final static String P_ObjectId = "objectId";
  
  public static IObjectFieldAccessor<UIPicture,Long> ObjectIdAccessor = new IObjectFieldAccessor<UIPicture,Long>(){
    				public Long getValue(UIPicture object){
    					return object.getObjectId();
    				}
    				public void setValue(UIPicture object,Long value){
    					object.setObjectId(value);
    				}
    			};
  
  private String objectField;
  
  public String getObjectField() {
    return this.objectField;
  }
  
  public void setObjectField(final String objectField) {
    this.objectField = objectField;
  }
  
  public final static String P_ObjectField = "objectField";
  
  public static IObjectFieldAccessor<UIPicture,String> ObjectFieldAccessor = new IObjectFieldAccessor<UIPicture,String>(){
    				public String getValue(UIPicture object){
    					return object.getObjectField();
    				}
    				public void setValue(UIPicture object,String value){
    					object.setObjectField(value);
    				}
    			};
}
