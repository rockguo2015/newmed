package com.fudanmed.platform.core.web.shared.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCategoryOrTypeType;
import com.google.common.base.Objects;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIDeviceCategoryAndType extends GWTEntity {
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  public final static String P_Name = "name";
  
  public static IObjectFieldAccessor<UIDeviceCategoryAndType,String> NameAccessor = new IObjectFieldAccessor<UIDeviceCategoryAndType,String>(){
    				public String getValue(UIDeviceCategoryAndType object){
    					return object.getName();
    				}
    				public void setValue(UIDeviceCategoryAndType object,String value){
    					object.setName(value);
    				}
    			};
  
  private UIDeviceCategoryOrTypeType type;
  
  public UIDeviceCategoryOrTypeType getType() {
    return this.type;
  }
  
  public void setType(final UIDeviceCategoryOrTypeType type) {
    this.type = type;
  }
  
  public final static String P_Type = "type";
  
  public static IObjectFieldAccessor<UIDeviceCategoryAndType,UIDeviceCategoryOrTypeType> TypeAccessor = new IObjectFieldAccessor<UIDeviceCategoryAndType,UIDeviceCategoryOrTypeType>(){
    				public com.fudanmed.platform.core.web.shared.device.UIDeviceCategoryOrTypeType getValue(UIDeviceCategoryAndType object){
    					return object.getType();
    				}
    				public void setValue(UIDeviceCategoryAndType object,com.fudanmed.platform.core.web.shared.device.UIDeviceCategoryOrTypeType value){
    					object.setType(value);
    				}
    			};
  
  private UIDeviceCategoryAndType parent;
  
  public UIDeviceCategoryAndType getParent() {
    return this.parent;
  }
  
  public void setParent(final UIDeviceCategoryAndType parent) {
    this.parent = parent;
  }
  
  public final static String P_Parent = "parent";
  
  public static IObjectFieldAccessor<UIDeviceCategoryAndType,UIDeviceCategoryAndType> ParentAccessor = new IObjectFieldAccessor<UIDeviceCategoryAndType,UIDeviceCategoryAndType>(){
    				public com.fudanmed.platform.core.web.shared.device.UIDeviceCategoryAndType getValue(UIDeviceCategoryAndType object){
    					return object.getParent();
    				}
    				public void setValue(UIDeviceCategoryAndType object,com.fudanmed.platform.core.web.shared.device.UIDeviceCategoryAndType value){
    					object.setParent(value);
    				}
    			};
  
  public int hashCode() {
    String _name = this.type.name();
    Long _id = this.getId();
    String _plus = (_name + _id);
    int _hashCode = _plus.hashCode();
    return _hashCode;
  }
  
  public boolean equals(final Object o) {
    boolean _xblockexpression = false;
    {
      boolean _equals = Objects.equal(o, null);
      if (_equals) {
        return false;
      }
      final UIDeviceCategoryAndType other = ((UIDeviceCategoryAndType) o);
      boolean _and = false;
      boolean _equals_1 = Objects.equal(other.name, this.name);
      if (!_equals_1) {
        _and = false;
      } else {
        Long _id = other.getId();
        Long _id_1 = this.getId();
        boolean _equals_2 = Objects.equal(_id, _id_1);
        _and = (_equals_1 && _equals_2);
      }
      _xblockexpression = (_and);
    }
    return _xblockexpression;
  }
  
  public RCDeviceTypeCategoryProxy toProxy() {
    return (RCDeviceTypeCategoryProxy)super.toProxy();
    
  }
}
