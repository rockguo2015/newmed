package com.fudanmed.platform.core.web.shared.common;

import com.fudanmed.platform.core.common.proxy.RCDocumentProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.datatype.File;

public class UIDocument extends GWTEntity {
  private String description;
  
  public String getDescription() {
    return this.description;
  }
  
  public void setDescription(final String description) {
    this.description = description;
  }
  
  public final static String P_Description = "description";
  
  public static IObjectFieldAccessor<UIDocument,String> DescriptionAccessor = new IObjectFieldAccessor<UIDocument,String>(){
    				public String getValue(UIDocument object){
    					return object.getDescription();
    				}
    				public void setValue(UIDocument object,String value){
    					object.setDescription(value);
    				}
    			};
  
  private File file;
  
  public File getFile() {
    return this.file;
  }
  
  public void setFile(final File file) {
    this.file = file;
  }
  
  public final static String P_File = "file";
  
  public static IObjectFieldAccessor<UIDocument,File> FileAccessor = new IObjectFieldAccessor<UIDocument,File>(){
    				public com.uniquesoft.gwt.shared.datatype.File getValue(UIDocument object){
    					return object.getFile();
    				}
    				public void setValue(UIDocument object,com.uniquesoft.gwt.shared.datatype.File value){
    					object.setFile(value);
    				}
    			};
  
  public RCDocumentProxy toProxy() {
    return (RCDocumentProxy)super.toProxy();
    
  }
}
