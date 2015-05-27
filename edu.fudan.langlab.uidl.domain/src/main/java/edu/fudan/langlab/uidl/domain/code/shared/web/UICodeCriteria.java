package edu.fudan.langlab.uidl.domain.code.shared.web;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICodeType;

public class UICodeCriteria implements IsSerializable {
  private UICodeType codeType = new UICodeType();
  
  public UICodeType getCodeType() {
    return this.codeType;
  }
  
  public void setCodeType(final UICodeType codeType) {
    this.codeType = codeType;
  }
  
  public final static String P_CodeType = "codeType";
  
  public static IObjectFieldAccessor<UICodeCriteria,UICodeType> CodeTypeAccessor = new IObjectFieldAccessor<UICodeCriteria,UICodeType>(){
    				public edu.fudan.langlab.uidl.domain.code.shared.web.UICodeType getValue(UICodeCriteria object){
    					return object.getCodeType();
    				}
    				public void setValue(UICodeCriteria object,edu.fudan.langlab.uidl.domain.code.shared.web.UICodeType value){
    					object.setCodeType(value);
    				}
    			};
}
