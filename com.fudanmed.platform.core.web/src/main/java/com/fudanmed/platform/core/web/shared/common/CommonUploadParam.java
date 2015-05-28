package com.fudanmed.platform.core.web.shared.common;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.datatype.File;

public class CommonUploadParam implements IsSerializable {
  private File file;
  
  public File getFile() {
    return this.file;
  }
  
  public void setFile(final File file) {
    this.file = file;
  }
  
  public final static String P_File = "file";
  
  public static IObjectFieldAccessor<CommonUploadParam,File> FileAccessor = new IObjectFieldAccessor<CommonUploadParam,File>(){
    				public com.uniquesoft.gwt.shared.datatype.File getValue(CommonUploadParam object){
    					return object.getFile();
    				}
    				public void setValue(CommonUploadParam object,com.uniquesoft.gwt.shared.datatype.File value){
    					object.setFile(value);
    				}
    			};
}
