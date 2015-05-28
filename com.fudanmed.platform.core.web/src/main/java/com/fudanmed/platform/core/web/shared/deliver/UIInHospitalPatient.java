package com.fudanmed.platform.core.web.shared.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIGender;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIInHospitalPatient extends GWTEntity {
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  public final static String P_Name = "name";
  
  public static IObjectFieldAccessor<UIInHospitalPatient,String> NameAccessor = new IObjectFieldAccessor<UIInHospitalPatient,String>(){
    				public String getValue(UIInHospitalPatient object){
    					return object.getName();
    				}
    				public void setValue(UIInHospitalPatient object,String value){
    					object.setName(value);
    				}
    			};
  
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public void setSid(final String sid) {
    this.sid = sid;
  }
  
  public final static String P_Sid = "sid";
  
  public static IObjectFieldAccessor<UIInHospitalPatient,String> SidAccessor = new IObjectFieldAccessor<UIInHospitalPatient,String>(){
    				public String getValue(UIInHospitalPatient object){
    					return object.getSid();
    				}
    				public void setValue(UIInHospitalPatient object,String value){
    					object.setSid(value);
    				}
    			};
  
  private Integer age;
  
  public Integer getAge() {
    return this.age;
  }
  
  public void setAge(final Integer age) {
    this.age = age;
  }
  
  public final static String P_Age = "age";
  
  public static IObjectFieldAccessor<UIInHospitalPatient,Integer> AgeAccessor = new IObjectFieldAccessor<UIInHospitalPatient,Integer>(){
    				public Integer getValue(UIInHospitalPatient object){
    					return object.getAge();
    				}
    				public void setValue(UIInHospitalPatient object,Integer value){
    					object.setAge(value);
    				}
    			};
  
  private UIGender gender;
  
  public UIGender getGender() {
    return this.gender;
  }
  
  public void setGender(final UIGender gender) {
    this.gender = gender;
  }
  
  public final static String P_Gender = "gender";
  
  public static IObjectFieldAccessor<UIInHospitalPatient,UIGender> GenderAccessor = new IObjectFieldAccessor<UIInHospitalPatient,UIGender>(){
    				public com.fudanmed.platform.core.web.shared.deliver.UIGender getValue(UIInHospitalPatient object){
    					return object.getGender();
    				}
    				public void setValue(UIInHospitalPatient object,com.fudanmed.platform.core.web.shared.deliver.UIGender value){
    					object.setGender(value);
    				}
    			};
  
  private DLInHospitalLocationProxy location;
  
  public DLInHospitalLocationProxy getLocation() {
    return this.location;
  }
  
  public void setLocation(final DLInHospitalLocationProxy location) {
    this.location = location;
  }
  
  public final static String P_Location = "location";
  
  public static IObjectFieldAccessor<UIInHospitalPatient,DLInHospitalLocationProxy> LocationAccessor = new IObjectFieldAccessor<UIInHospitalPatient,DLInHospitalLocationProxy>(){
    				public com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy getValue(UIInHospitalPatient object){
    					return object.getLocation();
    				}
    				public void setValue(UIInHospitalPatient object,com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy value){
    					object.setLocation(value);
    				}
    			};
  
  private String bedNumber;
  
  public String getBedNumber() {
    return this.bedNumber;
  }
  
  public void setBedNumber(final String bedNumber) {
    this.bedNumber = bedNumber;
  }
  
  public final static String P_BedNumber = "bedNumber";
  
  public static IObjectFieldAccessor<UIInHospitalPatient,String> BedNumberAccessor = new IObjectFieldAccessor<UIInHospitalPatient,String>(){
    				public String getValue(UIInHospitalPatient object){
    					return object.getBedNumber();
    				}
    				public void setValue(UIInHospitalPatient object,String value){
    					object.setBedNumber(value);
    				}
    			};
  
  public DLInHospitalPatientProxy toProxy() {
    return (DLInHospitalPatientProxy)super.toProxy();
    
  }
}
