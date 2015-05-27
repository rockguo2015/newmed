package com.lanmon.business.shared.code;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.lanmon.business.shared.code.GWTCodeType;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class CodeCriteria implements IsSerializable {
  private GWTCodeType codeType;
  
  public GWTCodeType getCodeType() {
    return this.codeType;
  }
  
  public void setCodeType(final GWTCodeType codeType) {
    this.codeType = codeType;
  }
  
  public final static String P_CodeType = "codeType";
  
  public static IObjectFieldAccessor<CodeCriteria,GWTCodeType> CodeTypeAccessor = new IObjectFieldAccessor<CodeCriteria,GWTCodeType>(){
    				public GWTCodeType getValue(CodeCriteria object){
    					return object.getCodeType();
    				}
    				public void setValue(CodeCriteria object,GWTCodeType value){
    					object.setCodeType(value);
    				}
    			};
}
