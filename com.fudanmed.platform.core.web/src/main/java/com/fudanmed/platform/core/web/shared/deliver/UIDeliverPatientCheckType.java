package com.fudanmed.platform.core.web.shared.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Collection;

public class UIDeliverPatientCheckType extends GWTEntity {
  private DLDeliverPatientCheckCategoryProxy category;
  
  public DLDeliverPatientCheckCategoryProxy getCategory() {
    return this.category;
  }
  
  public void setCategory(final DLDeliverPatientCheckCategoryProxy category) {
    this.category = category;
  }
  
  public final static String P_Category = "category";
  
  public static IObjectFieldAccessor<UIDeliverPatientCheckType,DLDeliverPatientCheckCategoryProxy> CategoryAccessor = new IObjectFieldAccessor<UIDeliverPatientCheckType,DLDeliverPatientCheckCategoryProxy>(){
    				public com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy getValue(UIDeliverPatientCheckType object){
    					return object.getCategory();
    				}
    				public void setValue(UIDeliverPatientCheckType object,com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy value){
    					object.setCategory(value);
    				}
    			};
  
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public void setCode(final String code) {
    this.code = code;
  }
  
  public final static String P_Code = "code";
  
  public static IObjectFieldAccessor<UIDeliverPatientCheckType,String> CodeAccessor = new IObjectFieldAccessor<UIDeliverPatientCheckType,String>(){
    				public String getValue(UIDeliverPatientCheckType object){
    					return object.getCode();
    				}
    				public void setValue(UIDeliverPatientCheckType object,String value){
    					object.setCode(value);
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
  
  public static IObjectFieldAccessor<UIDeliverPatientCheckType,String> NameAccessor = new IObjectFieldAccessor<UIDeliverPatientCheckType,String>(){
    				public String getValue(UIDeliverPatientCheckType object){
    					return object.getName();
    				}
    				public void setValue(UIDeliverPatientCheckType object,String value){
    					object.setName(value);
    				}
    			};
  
  private Integer performence;
  
  public Integer getPerformence() {
    return this.performence;
  }
  
  public void setPerformence(final Integer performence) {
    this.performence = performence;
  }
  
  public final static String P_Performence = "performence";
  
  public static IObjectFieldAccessor<UIDeliverPatientCheckType,Integer> PerformenceAccessor = new IObjectFieldAccessor<UIDeliverPatientCheckType,Integer>(){
    				public Integer getValue(UIDeliverPatientCheckType object){
    					return object.getPerformence();
    				}
    				public void setValue(UIDeliverPatientCheckType object,Integer value){
    					object.setPerformence(value);
    				}
    			};
  
  private Integer timeLimitation;
  
  public Integer getTimeLimitation() {
    return this.timeLimitation;
  }
  
  public void setTimeLimitation(final Integer timeLimitation) {
    this.timeLimitation = timeLimitation;
  }
  
  public final static String P_TimeLimitation = "timeLimitation";
  
  public static IObjectFieldAccessor<UIDeliverPatientCheckType,Integer> TimeLimitationAccessor = new IObjectFieldAccessor<UIDeliverPatientCheckType,Integer>(){
    				public Integer getValue(UIDeliverPatientCheckType object){
    					return object.getTimeLimitation();
    				}
    				public void setValue(UIDeliverPatientCheckType object,Integer value){
    					object.setTimeLimitation(value);
    				}
    			};
  
  private Collection<DLCheckOrganizationProxy> checkOrganization = com.google.common.collect.Lists.newArrayList();
  
  public Collection<DLCheckOrganizationProxy> getCheckOrganization() {
    return this.checkOrganization;
  }
  
  public void setCheckOrganization(final Collection<DLCheckOrganizationProxy> checkOrganization) {
    this.checkOrganization = checkOrganization;
  }
  
  public final static String P_CheckOrganization = "checkOrganization";
  
  public static IObjectFieldAccessor<UIDeliverPatientCheckType,Collection<DLCheckOrganizationProxy>> CheckOrganizationAccessor = new IObjectFieldAccessor<UIDeliverPatientCheckType,Collection<DLCheckOrganizationProxy>>(){
    				public java.util.Collection<com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy> getValue(UIDeliverPatientCheckType object){
    					return object.getCheckOrganization();
    				}
    				public void setValue(UIDeliverPatientCheckType object,java.util.Collection<com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy> value){
    					object.setCheckOrganization(value);
    				}
    			};
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public void setComment(final String comment) {
    this.comment = comment;
  }
  
  public final static String P_Comment = "comment";
  
  public static IObjectFieldAccessor<UIDeliverPatientCheckType,String> CommentAccessor = new IObjectFieldAccessor<UIDeliverPatientCheckType,String>(){
    				public String getValue(UIDeliverPatientCheckType object){
    					return object.getComment();
    				}
    				public void setValue(UIDeliverPatientCheckType object,String value){
    					object.setComment(value);
    				}
    			};
  
  public DLDeliverPatientCheckTypeProxy toProxy() {
    return (DLDeliverPatientCheckTypeProxy)super.toProxy();
    
  }
}
