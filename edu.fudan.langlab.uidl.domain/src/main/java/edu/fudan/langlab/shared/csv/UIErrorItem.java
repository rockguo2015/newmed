package edu.fudan.langlab.shared.csv;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIErrorItem implements IsSerializable {
  private String errorTitle;
  
  public String getErrorTitle() {
    return this.errorTitle;
  }
  
  public void setErrorTitle(final String errorTitle) {
    this.errorTitle = errorTitle;
  }
  
  public final static String P_ErrorTitle = "errorTitle";
  
  public static IObjectFieldAccessor<UIErrorItem,String> ErrorTitleAccessor = new IObjectFieldAccessor<UIErrorItem,String>(){
    				public String getValue(UIErrorItem object){
    					return object.getErrorTitle();
    				}
    				public void setValue(UIErrorItem object,String value){
    					object.setErrorTitle(value);
    				}
    			};
  
  private String errorMessage;
  
  public String getErrorMessage() {
    return this.errorMessage;
  }
  
  public void setErrorMessage(final String errorMessage) {
    this.errorMessage = errorMessage;
  }
  
  public final static String P_ErrorMessage = "errorMessage";
  
  public static IObjectFieldAccessor<UIErrorItem,String> ErrorMessageAccessor = new IObjectFieldAccessor<UIErrorItem,String>(){
    				public String getValue(UIErrorItem object){
    					return object.getErrorMessage();
    				}
    				public void setValue(UIErrorItem object,String value){
    					object.setErrorMessage(value);
    				}
    			};
}
