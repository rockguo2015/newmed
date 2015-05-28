package com.fudanmed.platform.core.web.shared.organization;

import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.web.shared.organization.UISupplierType;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UISupplier extends GWTEntity {
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public void setCode(final String code) {
    this.code = code;
  }
  
  public final static String P_Code = "code";
  
  public static IObjectFieldAccessor<UISupplier,String> CodeAccessor = new IObjectFieldAccessor<UISupplier,String>(){
    				public String getValue(UISupplier object){
    					return object.getCode();
    				}
    				public void setValue(UISupplier object,String value){
    					object.setCode(value);
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
  
  public static IObjectFieldAccessor<UISupplier,String> PhoneAccessor = new IObjectFieldAccessor<UISupplier,String>(){
    				public String getValue(UISupplier object){
    					return object.getPhone();
    				}
    				public void setValue(UISupplier object,String value){
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
  
  public static IObjectFieldAccessor<UISupplier,String> EmailAccessor = new IObjectFieldAccessor<UISupplier,String>(){
    				public String getValue(UISupplier object){
    					return object.getEmail();
    				}
    				public void setValue(UISupplier object,String value){
    					object.setEmail(value);
    				}
    			};
  
  private String address;
  
  public String getAddress() {
    return this.address;
  }
  
  public void setAddress(final String address) {
    this.address = address;
  }
  
  public final static String P_Address = "address";
  
  public static IObjectFieldAccessor<UISupplier,String> AddressAccessor = new IObjectFieldAccessor<UISupplier,String>(){
    				public String getValue(UISupplier object){
    					return object.getAddress();
    				}
    				public void setValue(UISupplier object,String value){
    					object.setAddress(value);
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
  
  public static IObjectFieldAccessor<UISupplier,String> NameAccessor = new IObjectFieldAccessor<UISupplier,String>(){
    				public String getValue(UISupplier object){
    					return object.getName();
    				}
    				public void setValue(UISupplier object,String value){
    					object.setName(value);
    				}
    			};
  
  private String shortName;
  
  public String getShortName() {
    return this.shortName;
  }
  
  public void setShortName(final String shortName) {
    this.shortName = shortName;
  }
  
  public final static String P_ShortName = "shortName";
  
  public static IObjectFieldAccessor<UISupplier,String> ShortNameAccessor = new IObjectFieldAccessor<UISupplier,String>(){
    				public String getValue(UISupplier object){
    					return object.getShortName();
    				}
    				public void setValue(UISupplier object,String value){
    					object.setShortName(value);
    				}
    			};
  
  private String ename;
  
  public String getEname() {
    return this.ename;
  }
  
  public void setEname(final String ename) {
    this.ename = ename;
  }
  
  public final static String P_Ename = "ename";
  
  public static IObjectFieldAccessor<UISupplier,String> EnameAccessor = new IObjectFieldAccessor<UISupplier,String>(){
    				public String getValue(UISupplier object){
    					return object.getEname();
    				}
    				public void setValue(UISupplier object,String value){
    					object.setEname(value);
    				}
    			};
  
  private String spell;
  
  public String getSpell() {
    return this.spell;
  }
  
  public void setSpell(final String spell) {
    this.spell = spell;
  }
  
  public final static String P_Spell = "spell";
  
  public static IObjectFieldAccessor<UISupplier,String> SpellAccessor = new IObjectFieldAccessor<UISupplier,String>(){
    				public String getValue(UISupplier object){
    					return object.getSpell();
    				}
    				public void setValue(UISupplier object,String value){
    					object.setSpell(value);
    				}
    			};
  
  private String helpCode;
  
  public String getHelpCode() {
    return this.helpCode;
  }
  
  public void setHelpCode(final String helpCode) {
    this.helpCode = helpCode;
  }
  
  public final static String P_HelpCode = "helpCode";
  
  public static IObjectFieldAccessor<UISupplier,String> HelpCodeAccessor = new IObjectFieldAccessor<UISupplier,String>(){
    				public String getValue(UISupplier object){
    					return object.getHelpCode();
    				}
    				public void setValue(UISupplier object,String value){
    					object.setHelpCode(value);
    				}
    			};
  
  private String enterpriseEnrolNum;
  
  public String getEnterpriseEnrolNum() {
    return this.enterpriseEnrolNum;
  }
  
  public void setEnterpriseEnrolNum(final String enterpriseEnrolNum) {
    this.enterpriseEnrolNum = enterpriseEnrolNum;
  }
  
  public final static String P_EnterpriseEnrolNum = "enterpriseEnrolNum";
  
  public static IObjectFieldAccessor<UISupplier,String> EnterpriseEnrolNumAccessor = new IObjectFieldAccessor<UISupplier,String>(){
    				public String getValue(UISupplier object){
    					return object.getEnterpriseEnrolNum();
    				}
    				public void setValue(UISupplier object,String value){
    					object.setEnterpriseEnrolNum(value);
    				}
    			};
  
  private String workNo;
  
  public String getWorkNo() {
    return this.workNo;
  }
  
  public void setWorkNo(final String workNo) {
    this.workNo = workNo;
  }
  
  public final static String P_WorkNo = "workNo";
  
  public static IObjectFieldAccessor<UISupplier,String> WorkNoAccessor = new IObjectFieldAccessor<UISupplier,String>(){
    				public String getValue(UISupplier object){
    					return object.getWorkNo();
    				}
    				public void setValue(UISupplier object,String value){
    					object.setWorkNo(value);
    				}
    			};
  
  private Double regCapital;
  
  public Double getRegCapital() {
    return this.regCapital;
  }
  
  public void setRegCapital(final Double regCapital) {
    this.regCapital = regCapital;
  }
  
  public final static String P_RegCapital = "regCapital";
  
  public static IObjectFieldAccessor<UISupplier,Double> RegCapitalAccessor = new IObjectFieldAccessor<UISupplier,Double>(){
    				public Double getValue(UISupplier object){
    					return object.getRegCapital();
    				}
    				public void setValue(UISupplier object,Double value){
    					object.setRegCapital(value);
    				}
    			};
  
  private String legalPerson;
  
  public String getLegalPerson() {
    return this.legalPerson;
  }
  
  public void setLegalPerson(final String legalPerson) {
    this.legalPerson = legalPerson;
  }
  
  public final static String P_LegalPerson = "legalPerson";
  
  public static IObjectFieldAccessor<UISupplier,String> LegalPersonAccessor = new IObjectFieldAccessor<UISupplier,String>(){
    				public String getValue(UISupplier object){
    					return object.getLegalPerson();
    				}
    				public void setValue(UISupplier object,String value){
    					object.setLegalPerson(value);
    				}
    			};
  
  private String aptitudeName;
  
  public String getAptitudeName() {
    return this.aptitudeName;
  }
  
  public void setAptitudeName(final String aptitudeName) {
    this.aptitudeName = aptitudeName;
  }
  
  public final static String P_AptitudeName = "aptitudeName";
  
  public static IObjectFieldAccessor<UISupplier,String> AptitudeNameAccessor = new IObjectFieldAccessor<UISupplier,String>(){
    				public String getValue(UISupplier object){
    					return object.getAptitudeName();
    				}
    				public void setValue(UISupplier object,String value){
    					object.setAptitudeName(value);
    				}
    			};
  
  private String aptitudeNo;
  
  public String getAptitudeNo() {
    return this.aptitudeNo;
  }
  
  public void setAptitudeNo(final String aptitudeNo) {
    this.aptitudeNo = aptitudeNo;
  }
  
  public final static String P_AptitudeNo = "aptitudeNo";
  
  public static IObjectFieldAccessor<UISupplier,String> AptitudeNoAccessor = new IObjectFieldAccessor<UISupplier,String>(){
    				public String getValue(UISupplier object){
    					return object.getAptitudeNo();
    				}
    				public void setValue(UISupplier object,String value){
    					object.setAptitudeNo(value);
    				}
    			};
  
  private UISupplierType type;
  
  public UISupplierType getType() {
    return this.type;
  }
  
  public void setType(final UISupplierType type) {
    this.type = type;
  }
  
  public final static String P_Type = "type";
  
  public static IObjectFieldAccessor<UISupplier,UISupplierType> TypeAccessor = new IObjectFieldAccessor<UISupplier,UISupplierType>(){
    				public com.fudanmed.platform.core.web.shared.organization.UISupplierType getValue(UISupplier object){
    					return object.getType();
    				}
    				public void setValue(UISupplier object,com.fudanmed.platform.core.web.shared.organization.UISupplierType value){
    					object.setType(value);
    				}
    			};
  
  private Boolean inputNext;
  
  public Boolean getInputNext() {
    return this.inputNext;
  }
  
  public void setInputNext(final Boolean inputNext) {
    this.inputNext = inputNext;
  }
  
  public final static String P_InputNext = "inputNext";
  
  public static IObjectFieldAccessor<UISupplier,Boolean> InputNextAccessor = new IObjectFieldAccessor<UISupplier,Boolean>(){
    				public Boolean getValue(UISupplier object){
    					return object.getInputNext();
    				}
    				public void setValue(UISupplier object,Boolean value){
    					object.setInputNext(value);
    				}
    			};
  
  public RCSupplierProxy toProxy() {
    return (RCSupplierProxy)super.toProxy();
    
  }
}
