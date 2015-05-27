package com.uniquesoft.gwt.shared.datatype;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class File implements IsSerializable {
  private String fileName;
  
  public String getFileName() {
    return this.fileName;
  }
  
  public void setFileName(final String fileName) {
    this.fileName = fileName;
  }
  
  public final static String P_FileName = "fileName";
  
  public static IObjectFieldAccessor<File,String> FileNameAccessor = new IObjectFieldAccessor<File,String>(){
    				public String getValue(File object){
    					return object.getFileName();
    				}
    				public void setValue(File object,String value){
    					object.setFileName(value);
    				}
    			};
  
  private String fullPathName;
  
  public String getFullPathName() {
    return this.fullPathName;
  }
  
  public void setFullPathName(final String fullPathName) {
    this.fullPathName = fullPathName;
  }
  
  public final static String P_FullPathName = "fullPathName";
  
  public static IObjectFieldAccessor<File,String> FullPathNameAccessor = new IObjectFieldAccessor<File,String>(){
    				public String getValue(File object){
    					return object.getFullPathName();
    				}
    				public void setValue(File object,String value){
    					object.setFullPathName(value);
    				}
    			};
  
  private String contentType;
  
  public String getContentType() {
    return this.contentType;
  }
  
  public void setContentType(final String contentType) {
    this.contentType = contentType;
  }
  
  public final static String P_ContentType = "contentType";
  
  public static IObjectFieldAccessor<File,String> ContentTypeAccessor = new IObjectFieldAccessor<File,String>(){
    				public String getValue(File object){
    					return object.getContentType();
    				}
    				public void setValue(File object,String value){
    					object.setContentType(value);
    				}
    			};
}
